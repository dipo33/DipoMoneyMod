package sk.dipo.moneymod.capability.provider;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import sk.dipo.moneymod.datagen.tag.ModItemTags;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class WalletProvider implements ICapabilitySerializable<INBT> {

    private final ItemStackHandler inventory = new ItemStackHandler(27) {
        @Override
        public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
            return ModItemTags.MONEY.contains(stack.getItem());
        }
    };

    private final LazyOptional<IItemHandler> lazyOptional = LazyOptional.of(() -> inventory);

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY ? lazyOptional.cast() : LazyOptional.empty();
    }

    @Override
    public INBT serializeNBT() {
        return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.getStorage().writeNBT(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, inventory, null);
    }

    @Override
    public void deserializeNBT(INBT nbt) {
        CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.getStorage().readNBT(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, inventory, null, nbt);
    }
}
