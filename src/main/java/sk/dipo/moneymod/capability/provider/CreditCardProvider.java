package sk.dipo.moneymod.capability.provider;

import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import sk.dipo.moneymod.capability.capability.CreditCardInfo;
import sk.dipo.moneymod.capability.capability.ICreditCardInfo;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class CreditCardProvider implements ICapabilitySerializable<INBT> {

    @CapabilityInject(ICreditCardInfo.class)
    public static final Capability<ICreditCardInfo> CREDIT_CARD_CAPABILITY = null;

    private final ICreditCardInfo instance = new CreditCardInfo();
    private final LazyOptional<ICreditCardInfo> lazyOptional = LazyOptional.of(() -> instance);

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return cap == CREDIT_CARD_CAPABILITY ? lazyOptional.cast() : LazyOptional.empty();
    }

    @Override
    public INBT serializeNBT() {
        return CREDIT_CARD_CAPABILITY.getStorage().writeNBT(CREDIT_CARD_CAPABILITY, this.instance, null);
    }

    @Override
    public void deserializeNBT(INBT nbt) {
        CREDIT_CARD_CAPABILITY.getStorage().readNBT(CREDIT_CARD_CAPABILITY, this.instance, null, nbt);
    }
}
