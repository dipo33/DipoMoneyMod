package sk.dipo.moneymod.capability.storage;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import sk.dipo.moneymod.capability.capability.ICreditCardInfo;

import javax.annotation.Nullable;

public class CreditCardStorage implements IStorage<ICreditCardInfo> {

    @Nullable
    @Override
    public INBT writeNBT(Capability<ICreditCardInfo> capability, ICreditCardInfo instance, Direction side) {
        CompoundNBT nbt = new CompoundNBT();
        nbt.putBoolean("HasOwner", instance.hasOwner());
        nbt.putUniqueId("Owner", instance.getOwner());
        nbt.putInt("Number", instance.getCardNumber());
        return nbt;
    }

    @Override
    public void readNBT(Capability<ICreditCardInfo> capability, ICreditCardInfo instance, Direction side, INBT nbt) {
        CompoundNBT compoundNBT = (CompoundNBT) nbt;
        instance.setHasOwner(compoundNBT.getBoolean("HasOwner"));
        instance.setOwner(compoundNBT.getUniqueId("Owner"));
        instance.setCardNumber(compoundNBT.getInt("Number"));
    }
}
