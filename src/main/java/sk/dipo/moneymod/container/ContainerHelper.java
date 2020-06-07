package sk.dipo.moneymod.container;

import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;

import java.util.Objects;

public class ContainerHelper {

    public static <T extends Container> String getUnlocalizedText(ContainerType<T> containerType) {
        return String.format("container.%s.%s",
                Objects.requireNonNull(containerType.getRegistryName()).getNamespace(),
                containerType.getRegistryName().getPath()
        );
    }
}
