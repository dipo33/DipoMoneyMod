package sk.dipo.moneymod.container.factory;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import org.apache.logging.log4j.LogManager;
import sk.dipo.moneymod.init.ModContainerTypes;

public class WalletContainer extends Container {

    public ItemStack wallet;

    public WalletContainer(final int windowId, final PlayerInventory playerInventory, PlayerEntity playerEntity, Hand handIn) {
        super(ModContainerTypes.WALLET_CONTAINER, windowId);
        wallet = playerEntity.getHeldItem(handIn);
        LogManager.getLogger().debug("player is " + playerEntity.getDisplayNameAndUUID().getFormattedText() + " and item is " + playerEntity.getHeldItem(handIn).getItem().getTranslationKey());
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return true;
    }
}
