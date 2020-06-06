package sk.dipo.moneymod.capability.storage;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import sk.dipo.moneymod.capability.capability.ICreditCard;

import javax.annotation.Nullable;
import java.util.UUID;

public class CreditCardStorage implements IStorage<ICreditCard> {

    @Nullable
    @Override
    public INBT writeNBT(Capability<ICreditCard> capability, ICreditCard instance, Direction side) {
        CompoundNBT nbt = new CompoundNBT();
        nbt.putString("Owner", instance.getOwner().toString());
        return nbt;
    }

    @Override
    public void readNBT(Capability<ICreditCard> capability, ICreditCard instance, Direction side, INBT nbt) {
        instance.setOwner(UUID.fromString(((CompoundNBT) nbt).getString("Owner")));
    }
}
