package sk.dipo.moneymod;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import sk.dipo.moneymod.init.ModItems;
import sk.dipo.moneymod.items.MoneyItem;

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
        if (remainder.getCount() != event.getItem().getItem().getCount()) {
            event.getItem().setItem(remainder);
            event.setResult(Event.Result.ALLOW);
        }
    }
}
