package sk.dipo.moneymod.container.factory;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.Hand;
import net.minecraftforge.common.extensions.IForgeContainerType;

public class WalletProvider implements IForgeContainerType<WalletContainer> {
    
    @Override
    public WalletContainer create(int windowId, PlayerInventory playerInv, PacketBuffer extraData) {
        return new WalletContainer(windowId, playerInv, extraData.readEnumValue(Hand.class));
    }
}
