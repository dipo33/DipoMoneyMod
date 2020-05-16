package sk.dipo.moneymod.container;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import sk.dipo.moneymod.init.ModContainerTypes;

public class WalletContainer extends Container {

    public ItemStack wallet;

    public WalletContainer(final int windowId, final PlayerInventory playerInventory, PlayerEntity playerEntity, Hand handIn) {
        super(ModContainerTypes.WALLET.get(), windowId);
        wallet = playerEntity.getHeldItem(handIn);
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return true;
    }
}
