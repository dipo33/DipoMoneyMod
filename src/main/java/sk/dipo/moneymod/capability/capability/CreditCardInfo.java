package sk.dipo.moneymod.capability.capability;

import net.minecraft.world.World;
import sk.dipo.moneymod.world.AccountWorldSavedData;

import java.util.UUID;

public class CreditCardInfo implements ICreditCardInfo {

    private UUID owner = UUID.randomUUID();
    private boolean hasOwner = false;
    private int cardNumber = -1;

    @Override
    public void init(UUID owner, World world) {
        this.owner = owner;
        this.hasOwner = true;
        this.cardNumber = AccountWorldSavedData.get(world).getNextCardID();
    }

    @Override
    public boolean hasOwner() {
        return hasOwner;
    }

    @Override
    public void setHasOwner(boolean hasOwner) {
        this.hasOwner = hasOwner;
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
    public int getCardNumber() {
        return this.cardNumber;
    }

    @Override
    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }
}
