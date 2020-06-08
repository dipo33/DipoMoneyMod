package sk.dipo.moneymod.capability.capability;

import java.util.UUID;

public interface ICreditCard {

    boolean hasOwner();

    void setHasOwner(boolean hasOwner);

    void addOwner(UUID owner);

    UUID getOwner();

    void setOwner(UUID owner);

    String getPin();

    void setPin(String PIN);
}
