package sk.dipo.moneymod;

import com.google.common.collect.ImmutableMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.merchant.villager.VillagerTrades;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MerchantOffer;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.Tuple;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import sk.dipo.moneymod.config.DipoConfig;
import sk.dipo.moneymod.init.ModItems;
import sk.dipo.moneymod.init.ModVillagerProfessions;
import sk.dipo.moneymod.items.MoneyItem;

import java.util.Arrays;
import java.util.Random;

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
                IItemHandler walletInventory = inv.mainInventory.get(i).getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).orElse(null);
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
        if (event.getEntity().world.isRemote)
            return;
        if (DipoConfig.ENTITIES.containsKey(event.getEntity().getType())) {
            Tuple<Integer, Integer> values = DipoConfig.ENTITIES.get(event.getEntity().getType());
            MoneyItem.addRandomMoneyDrop(event, values.getA(), values.getB());
        }
    }

    @SubscribeEvent
    public static void onVillagerAddTrades(VillagerTradesEvent event) {
        if (event.getType() == ModVillagerProfessions.EXCHANGER.get()) {
            event.getTrades().put(1, Arrays.asList(new VillagerTrades.ITrade[]{new EmeraldForItemsTrade(Items.WHEAT, 20, 16, 2)}));
        }
    }

    private static Int2ObjectMap<VillagerTrades.ITrade[]> gatAsIntMap(ImmutableMap<Integer, VillagerTrades.ITrade[]> p_221238_0_) {
        return new Int2ObjectOpenHashMap<>(p_221238_0_);
    }

    static class EmeraldForItemsTrade implements VillagerTrades.ITrade {
        private final Item tradeItem;
        private final int count;
        private final int maxUses;
        private final int xpValue;
        private final float priceMultiplier;

        public EmeraldForItemsTrade(IItemProvider tradeItemIn, int countIn, int maxUsesIn, int xpValueIn) {
            this.tradeItem = tradeItemIn.asItem();
            this.count = countIn;
            this.maxUses = maxUsesIn;
            this.xpValue = xpValueIn;
            this.priceMultiplier = 0.05F;
        }

        public MerchantOffer getOffer(Entity trader, Random rand) {
            ItemStack itemstack = new ItemStack(this.tradeItem, this.count);
            return new MerchantOffer(itemstack, new ItemStack(Items.EMERALD), this.maxUses, this.xpValue, this.priceMultiplier);
        }
    }
}
