package sk.dipo.moneymod.capability.capability;

import java.util.UUID;

public class CreditCardCap implements ICreditCard {

    private UUID owner = UUID.randomUUID();
    private boolean hasOwner = false;
    private String PIN = "";

    @Override
    public boolean hasOwner() {
        return hasOwner;
    }

    @Override
    public void setHasOwner(boolean hasOwner) {
        this.hasOwner = hasOwner;
    }

    @Override
    public void newOwner(UUID owner) {
        setOwner(owner);
        hasOwner = true;
    }

    @Override
    public UUID getOwner() {
        return this.owner;
    }

    @Override
    public void setOwner(UUID owner) {
        this.owner = owner;
    }

    @Override
    public String getPin() {
        return this.PIN;
    }

    @Override
    public void setPin(String PIN) {
        this.PIN = PIN;
    }
}
