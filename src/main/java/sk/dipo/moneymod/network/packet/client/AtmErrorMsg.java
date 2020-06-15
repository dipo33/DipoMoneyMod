package sk.dipo.moneymod.network.packet.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;
import sk.dipo.moneymod.client.gui.AtmScreen;
import sk.dipo.moneymod.client.gui.widget.AtmTextComponent;
import sk.dipo.moneymod.container.ContainerHelper;

import java.util.function.Supplier;

public class AtmErrorMsg {

    public void encode(PacketBuffer buffer) {

    }

    public static AtmErrorMsg decode(PacketBuffer buffer) {
        return new AtmErrorMsg();
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            final Screen screen = Minecraft.getInstance().currentScreen;
            if (screen instanceof AtmScreen) {
                AtmScreen atmScreen = (AtmScreen) screen;
                atmScreen.keyPadMode = AtmScreen.KeyPadMode.KeyPadOff;
                atmScreen.displayPIN.clear();
                atmScreen.displayMain = new AtmTextComponent(
                        ContainerHelper.getUnlocalizedText("atm_error")
                );
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
