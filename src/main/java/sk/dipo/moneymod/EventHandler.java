package sk.dipo.moneymod;

import net.minecraft.entity.merchant.villager.VillagerTrades;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Tuple;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import sk.dipo.moneymod.config.DipoConfig;
import sk.dipo.moneymod.entity.villager.ModVillagerTrades;
import sk.dipo.moneymod.init.ModItems;
import sk.dipo.moneymod.init.ModVillagerProfessions;
import sk.dipo.moneymod.items.MoneyItem;
import sk.dipo.moneymod.world.AccountWorldSavedData;

import java.util.List;

@Mod.EventBusSubscriber(modid = MoneyMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EventHandler {

    @SubscribeEvent
    public static void onItemPickup(EntityItemPickupEvent event) {
        ItemStack remainder = event.getItem().getItem().copy();
        if (!(remainder.getItem() instanceof MoneyItem))
            return;

        PlayerInventory inv = event.getPlayer().inventory;
        for (int i = 0; i < 36 && remainder != ItemStack.EMPTY; i++) {
            if (inv.mainInventory.get(i).getItem() == ModItems.WALLET.get()) {
                IItemHandler walletInventory = inv.mainInventory.get(i).getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).orElseThrow(
                        () -> new NullPointerException("Null WALLET capability")
                );
                for (int j = 0; j < 27 && remainder != ItemStack.EMPTY; j++) {
                    remainder = walletInventory.insertItem(j, remainder, false);
                }
            }
        }
        if (remainder.isEmpty())
            event.setResult(Event.Result.ALLOW);
        if (remainder.getCount() != event.getItem().getItem().getCount())
            event.getItem().setItem(remainder);
    }

    @SubscribeEvent
    public static void onEntityDropEvent(LivingDropsEvent event) {
        if (!DipoConfig.doMobsDropMoney)
            return;
        if (DipoConfig.ENTITIES.containsKey(event.getEntity().getType())) {
            Tuple<Integer, Integer> values = DipoConfig.ENTITIES.get(event.getEntity().getType());
            MoneyItem.addRandomMoneyDrop(event, values.getA(), values.getB());
        } else if (event.getEntity() instanceof SlimeEntity && DipoConfig.SLIMES.containsKey(event.getEntity().getType())) {
            final SlimeEntity slime = (SlimeEntity) event.getEntity();
            Tuple<Integer, Integer> values = DipoConfig.SLIMES.get(event.getEntity().getType()).get(slime.getSlimeSize());
            MoneyItem.addRandomMoneyDrop(event, values.getA(), values.getB());
        }
    }

    @SubscribeEvent
    public static void onVillagerAddTrades(VillagerTradesEvent event) {
        if (event.getType() == ModVillagerProfessions.EXCHANGER.get()) {
            for (int i = 1; i < 6; i++) {
                List<VillagerTrades.ITrade> trades = ModVillagerTrades.EXCHANGER_TRADES.get(i);
                if (trades != null)
                    event.getTrades().put(i, trades);
            }
        }
    }/*
     */

    @SubscribeEvent
    public static void onPlayerJoin(EntityJoinWorldEvent event) {
        if (event.getWorld().isRemote)
            return;
        if (!(event.getEntity() instanceof PlayerEntity))
            return;

        final PlayerEntity player = (PlayerEntity) event.getEntity();
        AccountWorldSavedData.get(event.getWorld()).createAccount(player.getUniqueID(), player.getGameProfile().getName());
    }
}
