package sk.dipo.moneymod.capability.storage;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import sk.dipo.moneymod.capability.capability.ICreditCard;

import javax.annotation.Nullable;

public class CreditCardStorage implements IStorage<ICreditCard> {

    @Nullable
    @Override
    public INBT writeNBT(Capability<ICreditCard> capability, ICreditCard instance, Direction side) {
        CompoundNBT nbt = new CompoundNBT();
        nbt.putBoolean("HasOwner", instance.hasOwner());
        nbt.putUniqueId("Owner", instance.getOwner());
        nbt.putString("PIN", instance.getPin());
        return nbt;
    }

    @Override
    public void readNBT(Capability<ICreditCard> capability, ICreditCard instance, Direction side, INBT nbt) {
        CompoundNBT compoundNBT = (CompoundNBT) nbt;
        instance.setHasOwner(compoundNBT.getBoolean("HasOwner"));
        instance.setOwner(compoundNBT.getUniqueId("Owner"));
        instance.setPin(compoundNBT.getString("PIN"));
    }
}
