package sk.dipo.moneymod.tileentity;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.items.ItemStackHandler;
import sk.dipo.moneymod.container.AtmContainer;
import sk.dipo.moneymod.init.ModBlocks;
import sk.dipo.moneymod.init.ModTileEntityTypes;
import sk.dipo.moneymod.items.MoneyItem;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class AtmTileEntity extends TileEntity implements INamedContainerProvider {

    public final ItemStackHandler inventory = new ItemStackHandler(36) {
        @Override
        public boolean isItemValid(final int slot, @Nonnull final ItemStack stack) {
            if (slot >= 0 && slot < 18)
                return stack.getItem() instanceof MoneyItem; // TODO: Change the way of checking bills and coins
            else
                return false;
        }

        @Override
        protected void onContentsChanged(final int slot) {
            super.onContentsChanged(slot);
            markDirty();
        }
    };

    public AtmTileEntity() {
        super(ModTileEntityTypes.ATM.get());
    }

    @Override
    public ITextComponent getDisplayName() {
        return new TranslationTextComponent(ModBlocks.ATM_BLOCK.get().getTranslationKey());
    }

    @Nullable
    @Override
    public Container createMenu(int windowId, PlayerInventory playerInventory, PlayerEntity playerEntity) {
        return new AtmContainer(windowId, playerInventory, this);
    }
}
