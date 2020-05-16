package sk.dipo.moneymod;

import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.Hand;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import sk.dipo.moneymod.container.factory.WalletContainer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusSubscriber {

    @SubscribeEvent
    public static void onContainerRegistry(final RegistryEvent.Register<ContainerType<?>> event) {
        event.getRegistry().register(IForgeContainerType.create((windowId, inv, data) -> {
            Hand hand = data.readEnumValue(Hand.class);
            return new WalletContainer(windowId, inv, hand);
        }).setRegistryName("wallet_container"));
    }
}
