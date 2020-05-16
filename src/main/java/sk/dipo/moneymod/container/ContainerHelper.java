package sk.dipo.moneymod.container;

import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;

public class ContainerHelper {

    public static <T extends Container> String getUnlocalizedText(ContainerType<T> containerType) {
        return "container." + containerType.getRegistryName().getNamespace() + "." + containerType.getRegistryName().getPath();
    }
}
