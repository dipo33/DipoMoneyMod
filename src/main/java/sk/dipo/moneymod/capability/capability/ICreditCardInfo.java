package sk.dipo.moneymod.capability.capability;

import net.minecraft.world.World;

import java.util.UUID;

public interface ICreditCardInfo {

    void init(UUID owner, World world);

    boolean hasOwner();

    void setHasOwner(boolean hasOwner);

    UUID getOwner();

    void setOwner(UUID owner);

    int getCardNumber();

    void setCardNumber(int number);
}
