package sk.dipo.moneymod.capabilities;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import sk.dipo.moneymod.MoneyMod;
import sk.dipo.moneymod.capabilities.providers.WalletProvider;
import sk.dipo.moneymod.init.ModItems;

public class CapabilityHandler {
    public static final ResourceLocation WALLET_CAP = new ResourceLocation(MoneyMod.MODID, "wallet");

    @SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent<ItemStack> event) {
        if (event.getObject().getItem() == ModItems.WALLET.get())
            event.addCapability(WALLET_CAP, new WalletProvider());
    }
}
