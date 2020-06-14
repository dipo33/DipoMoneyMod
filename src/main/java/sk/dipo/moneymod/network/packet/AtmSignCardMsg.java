package sk.dipo.moneymod.network.packet;

import net.minecraft.network.PacketBuffer;
import net.minecraft.util.Hand;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.network.PacketDistributor;
import sk.dipo.moneymod.capability.capability.ICreditCard;
import sk.dipo.moneymod.capability.provider.CreditCardProvider;
import sk.dipo.moneymod.network.ModPacketHandler;

import java.util.Objects;
import java.util.function.Supplier;

public class AtmSignCardMsg {

    private final Hand hand;
    private final String pinCode;

    public AtmSignCardMsg(Hand hand, String pinCode) {
        this.hand = hand;
        this.pinCode = pinCode;
    }

    public void encode(PacketBuffer buffer) {
        buffer.writeEnumValue(hand);
        buffer.writeString(pinCode);
    }

    public static AtmSignCardMsg decode(PacketBuffer buffer) {
        return new AtmSignCardMsg(buffer.readEnumValue(Hand.class), buffer.readString());
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            final ICreditCard cap = Objects.requireNonNull(ctx.get().getSender()).getHeldItem(this.hand).getCapability(CreditCardProvider.CREDIT_CARD_CAPABILITY).orElseThrow(
                    () -> new NullPointerException("Null CreditCard capability")
            );

            cap.newOwner(Objects.requireNonNull(ctx.get().getSender()).getGameProfile().getId());
            cap.setPin(this.pinCode);

            ModPacketHandler.INSTANCE.send(
                    PacketDistributor.PLAYER.with(() -> ctx.get().getSender()),
                    new AtmCardSignedMsg(true, Objects.requireNonNull(ctx.get().getSender()).getGameProfile().getName())
            );
        });
        ctx.get().setPacketHandled(true);
    }
}
