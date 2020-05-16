package sk.dipo.moneymod.init;

import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.registries.ObjectHolder;
import sk.dipo.moneymod.container.factory.WalletContainer;

public class ModContainerTypes {

    @ObjectHolder("dipomoneymod:wallet_container")
    public static ContainerType<WalletContainer> WALLET_CONTAINER = null;

//    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = new DeferredRegister<>(ForgeRegistries.CONTAINERS, MoneyMod.MODID);
//
//    public static final RegistryObject<ContainerType<WalletContainer>> WALLET = CONTAINER_TYPES.register("wallet", IForgeContainerType.create((windowId, inv, data) -> {
//        Hand pos = data.readEnumValue(Hand.class);
//        return new WalletContainer(windowId, inv, pos);
//    }));
}
