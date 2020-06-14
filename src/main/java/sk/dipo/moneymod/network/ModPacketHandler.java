package sk.dipo.moneymod.network;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;
import sk.dipo.moneymod.MoneyMod;
import sk.dipo.moneymod.network.packet.AtmCardSignedMsg;
import sk.dipo.moneymod.network.packet.AtmInitSessionMsg;
import sk.dipo.moneymod.network.packet.AtmSignCardMsg;

public class ModPacketHandler {

    private static int id = 0;
    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(MoneyMod.MODID, "main"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );

    public static void registerMessages() {
        INSTANCE.registerMessage(id++, AtmInitSessionMsg.class, AtmInitSessionMsg::encode, AtmInitSessionMsg::decode, AtmInitSessionMsg::handle);
        INSTANCE.registerMessage(id++, AtmCardSignedMsg.class, AtmCardSignedMsg::encode, AtmCardSignedMsg::decode, AtmCardSignedMsg::handle);
        INSTANCE.registerMessage(id++, AtmSignCardMsg.class, AtmSignCardMsg::encode, AtmSignCardMsg::decode, AtmSignCardMsg::handle);
    }
}
