package sk.dipo.moneymod.capability.capability;

import java.util.UUID;

public class CreditCardCap implements ICreditCard {

    private UUID owner = UUID.randomUUID();

    @Override
    public UUID getOwner() {
        return this.owner;
    }

    @Override
    public void setOwner(UUID owner) {
        this.owner = owner;
    }
}
