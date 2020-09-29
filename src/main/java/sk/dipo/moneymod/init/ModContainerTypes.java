package sk.dipo.moneymod.init;

import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.Hand;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import sk.dipo.moneymod.MoneyMod;
import sk.dipo.moneymod.container.AtmContainer;
import sk.dipo.moneymod.container.WalletContainer;

public class ModContainerTypes {

    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS, MoneyMod.MODID);

    public static final RegistryObject<ContainerType<WalletContainer>> WALLET = CONTAINER_TYPES.register("wallet", () -> IForgeContainerType.create((windowId, inv, data) -> {
        Hand hand = data.readEnumValue(Hand.class);
        return new WalletContainer(windowId, inv, inv.player.getHeldItem(hand));
    }));

    public static final RegistryObject<ContainerType<AtmContainer>> ATM = CONTAINER_TYPES.register("atm", () -> IForgeContainerType.create(AtmContainer::new));
}
