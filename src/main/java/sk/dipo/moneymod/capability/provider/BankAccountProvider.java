package sk.dipo.moneymod.capability.provider;

import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import sk.dipo.moneymod.capability.capability.BankAccountCap;
import sk.dipo.moneymod.capability.capability.IBankAccount;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class BankAccountProvider implements ICapabilitySerializable<INBT> {

    @CapabilityInject(IBankAccount.class)
    public static final Capability<IBankAccount> BANK_ACCOUNT_CAPABILITY = null;

    private final IBankAccount instance = new BankAccountCap();
    private final LazyOptional<IBankAccount> lazyOptional = LazyOptional.of(() -> instance);

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return cap == BANK_ACCOUNT_CAPABILITY ? lazyOptional.cast() : LazyOptional.empty();
    }

    @Override
    public INBT serializeNBT() {
        return BANK_ACCOUNT_CAPABILITY.getStorage().writeNBT(BANK_ACCOUNT_CAPABILITY, this.instance, null);
    }

    @Override
    public void deserializeNBT(INBT nbt) {
        BANK_ACCOUNT_CAPABILITY.getStorage().readNBT(BANK_ACCOUNT_CAPABILITY, this.instance, null, nbt);
    }
}
