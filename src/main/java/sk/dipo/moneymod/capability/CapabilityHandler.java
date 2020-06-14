package sk.dipo.moneymod.capability;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import sk.dipo.moneymod.MoneyMod;
import sk.dipo.moneymod.capability.provider.CreditCardProvider;
import sk.dipo.moneymod.capability.provider.WalletProvider;
import sk.dipo.moneymod.init.ModItems;

public class CapabilityHandler {
    public static final ResourceLocation WALLET_CAP = new ResourceLocation(MoneyMod.MODID, "wallet");
    public static final ResourceLocation CREDIT_CARD_CAP = new ResourceLocation(MoneyMod.MODID, "credit_card");
    public static final ResourceLocation BANK_ACCOUNT_CAP = new ResourceLocation(MoneyMod.MODID, "bank_account");

    @SubscribeEvent
    public void attachCapabilityStack(AttachCapabilitiesEvent<ItemStack> event) {
        if (event.getObject().getItem() == ModItems.WALLET.get())
            event.addCapability(WALLET_CAP, new WalletProvider());
        else if (event.getObject().getItem() == ModItems.CREDIT_CARD.get())
            event.addCapability(CREDIT_CARD_CAP, new CreditCardProvider());
    }
}
