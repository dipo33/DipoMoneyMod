package sk.dipo.moneymod.container;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ClickType;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import sk.dipo.moneymod.init.ModContainerTypes;

import javax.annotation.Nonnull;

public class WalletContainer extends Container {

    private ItemStack wallet;

    public WalletContainer(final int windowId, final PlayerInventory playerInventory, ItemStack wallet) {
        super(ModContainerTypes.WALLET.get(), windowId);
        this.wallet = wallet;

        IItemHandler walletInventory = this.wallet.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).orElse(null);
        for (int j = 0; j < 3; ++j) {
            for (int k = 0; k < 9; ++k) {
                this.addSlot(new SlotItemHandler(walletInventory, k + j * 9, 8 + k * 18, 18 + j * 18));
            }
        }

        for (int l = 0; l < 3; ++l) {
            for (int j1 = 0; j1 < 9; ++j1) {
                this.addSlot(new Slot(playerInventory, j1 + l * 9 + 9, 8 + j1 * 18, 103 + l * 18 - 18));
            }
        }

        for (int i1 = 0; i1 < 9; ++i1) {
            this.addSlot(new Slot(playerInventory, i1, 8 + i1 * 18, 161 - 18));
        }
    }

    /**
     * Generic & dynamic version of {@link Container#transferStackInSlot(PlayerEntity, int)}.
     * Handle when the stack in slot {@code index} is shift-clicked.
     * Normally this moves the stack between the player inventory and the other inventory(s).
     *
     * @param player the player passed in
     * @param index  the index passed in
     * @return the {@link ItemStack}
     */
    @Nonnull
    @Override
    public ItemStack transferStackInSlot(final PlayerEntity player, final int index) {
        ItemStack returnStack = ItemStack.EMPTY;
        final Slot slot = this.inventorySlots.get(index);
        if (slot != null && slot.getHasStack()) {
            final ItemStack slotStack = slot.getStack();
            returnStack = slotStack.copy();

            final int containerSlots = this.inventorySlots.size() - player.inventory.mainInventory.size();
            if (index < containerSlots) {
                if (!mergeItemStack(slotStack, containerSlots, this.inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!mergeItemStack(slotStack, 0, containerSlots, false)) {
                return ItemStack.EMPTY;
            }
            if (slotStack.getCount() == 0) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }
            if (slotStack.getCount() == returnStack.getCount()) {
                return ItemStack.EMPTY;
            }
            slot.onTake(player, slotStack);
        }
        return returnStack;
    }

    @Override
    public ItemStack slotClick(int slotId, int dragType, ClickType clickTypeIn, PlayerEntity player) {
        boolean isSlotOpenedWallet = isSlotOpenedWallet(slotId);
        ItemStack returnStack;

        switch (clickTypeIn) {
            case PICKUP:
            case THROW:
                returnStack = super.slotClick(slotId, dragType, clickTypeIn, player);
                if (isSlotOpenedWallet)
                    player.closeScreen();
                return returnStack;
            case QUICK_CRAFT:
                if (isSlotOpenedWallet)
                    return ItemStack.EMPTY;
                return super.slotClick(slotId, dragType, clickTypeIn, player);
            case QUICK_MOVE:
            case SWAP:
                if (isSlotOpenedWallet || isSlotOpenedWallet(dragType + 54)) {
                    returnStack = super.slotClick(slotId, dragType, clickTypeIn, player);
                    player.closeScreen();
                    return returnStack;
                }
            default:
                return super.slotClick(slotId, dragType, clickTypeIn, player);
        }
    }


    private boolean isSlotOpenedWallet(int slotId) {
        return slotId >= 0 && getSlot(slotId).getStack() == this.wallet;
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return true;
    }
}
