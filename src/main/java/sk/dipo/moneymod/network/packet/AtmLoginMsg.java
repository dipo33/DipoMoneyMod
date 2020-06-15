package sk.dipo.moneymod.network.packet;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.Hand;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.network.PacketDistributor;
import sk.dipo.moneymod.capability.capability.ICreditCardInfo;
import sk.dipo.moneymod.capability.provider.CreditCardProvider;
import sk.dipo.moneymod.network.ModPacketHandler;
import sk.dipo.moneymod.world.AccountWorldSavedData;

import java.util.Objects;
import java.util.function.Supplier;

public class AtmLoginMsg {

    private final Hand hand;
    private final String pinCode;

    public AtmLoginMsg(Hand hand, String pinCode) {
        this.hand = hand;
        this.pinCode = pinCode;
    }

    public void encode(PacketBuffer buffer) {
        buffer.writeEnumValue(hand);
        buffer.writeString(pinCode);
    }

    public static AtmLoginMsg decode(PacketBuffer buffer) {
        return new AtmLoginMsg(buffer.readEnumValue(Hand.class), buffer.readString());
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            final ServerPlayerEntity sender = Objects.requireNonNull(ctx.get().getSender());
            final ICreditCardInfo cap = sender.getHeldItem(this.hand).getCapability(CreditCardProvider.CREDIT_CARD_CAPABILITY).orElseThrow(
                    () -> new NullPointerException("Null CreditCard capability")
            );

            if (!cap.hasOwner()) {
                ModPacketHandler.INSTANCE.send(
                        PacketDistributor.PLAYER.with(() -> sender), new AtmErrorMsg()
                );
                return;
            }

            AccountWorldSavedData accountData = AccountWorldSavedData.get(sender.getServerWorld());
            String realPin = accountData.getCardPIN(cap.getCardNumber());
            if (pinCode.equals(realPin)) {
                ModPacketHandler.INSTANCE.send(
                        PacketDistributor.PLAYER.with(() -> sender),
                        new AtmBalanceMsg(accountData.getBalance(cap.getOwner()))
                );
            } else {
                ModPacketHandler.INSTANCE.send(
                        PacketDistributor.PLAYER.with(() -> sender),
                        new AtmWrongPasswordMsg(3) // TODO: Real attempts
                );
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
