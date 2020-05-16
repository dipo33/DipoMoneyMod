package sk.dipo.moneymod.container.factory;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.util.Hand;
import sk.dipo.moneymod.init.ModContainerTypes;

public class WalletContainer extends Container {

    public WalletContainer(final int windowId, final PlayerInventory playerInventory, PlayerEntity playerEntity) {
        super(ModContainerTypes.WALLET_CONTAINER, windowId);
    }

    public WalletContainer(final int windowId, final PlayerInventory playerInventory, Hand handIn) {
        super(ModContainerTypes.WALLET_CONTAINER, windowId);
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return false;
    }
}
