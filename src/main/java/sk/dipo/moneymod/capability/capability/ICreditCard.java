package sk.dipo.moneymod.capability.capability;

import java.util.UUID;

public interface ICreditCard {

    UUID getOwner();

    void setOwner(UUID owner);
}
