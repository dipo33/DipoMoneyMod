package sk.dipo.moneymod.capability.storage;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import sk.dipo.moneymod.capability.capability.IBankAccount;

import javax.annotation.Nullable;

public class BankAccountStorage implements IStorage<IBankAccount> {

    @Nullable
    @Override
    public INBT writeNBT(Capability<IBankAccount> capability, IBankAccount instance, Direction side) {
        CompoundNBT nbt = new CompoundNBT();
        nbt.putInt("Balance", instance.getBalance());
        return nbt;
    }

    @Override
    public void readNBT(Capability<IBankAccount> capability, IBankAccount instance, Direction side, INBT nbt) {
        instance.setBalance(((CompoundNBT) nbt).getInt("Balance"));
    }
}
