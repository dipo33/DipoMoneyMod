package sk.dipo.moneymod.init;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import sk.dipo.moneymod.MoneyMod;

import java.util.function.Supplier;

public class ModItemGroups {

    public static final ItemGroup MOD_ITEM_GROUP = new ModItemGroup(MoneyMod.MODID,
            () -> new ItemStack(ModItems.EURO_2.get()));

    public static class ModItemGroup extends ItemGroup {

        private final Supplier<ItemStack> iconSupplier;

        public ModItemGroup(final String name, final Supplier<ItemStack> iconSupplier) {
            super(name);
            this.iconSupplier = iconSupplier;
        }

        @Override
        @MethodsReturnNonnullByDefault
        public ItemStack createIcon() {
            return iconSupplier.get();
        }
    }
}
