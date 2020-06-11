package sk.dipo.moneymod.network.packet;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.Hand;
import net.minecraftforge.fml.network.NetworkEvent;
import sk.dipo.moneymod.capability.capability.ICreditCard;
import sk.dipo.moneymod.capability.provider.CreditCardProvider;
import sk.dipo.moneymod.client.gui.AtmScreen;
import sk.dipo.moneymod.container.ContainerHelper;

import java.util.function.Supplier;

public class AtmCardSignedMsg {

    private final boolean cardSigned;

    public AtmCardSignedMsg(boolean cardSigned) {
        this.cardSigned = cardSigned;
    }

    public void encode(PacketBuffer buffer) {
        buffer.writeBoolean(cardSigned);
    }

    public static AtmCardSignedMsg decode(PacketBuffer buffer) {
        return new AtmCardSignedMsg(buffer.readBoolean());
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            final Screen screen = Minecraft.getInstance().currentScreen;
            if (screen instanceof AtmScreen) {
                if (cardSigned)
                    ((AtmScreen) screen).displayMain = ContainerHelper.getUnlocalizedText("atm_login");
                else
                    ((AtmScreen) screen).displayMain = ContainerHelper.getUnlocalizedText("card_not_signed");
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
