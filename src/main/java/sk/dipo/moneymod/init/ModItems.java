package sk.dipo.moneymod.init;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import sk.dipo.moneymod.MoneyMod;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, MoneyMod.MODID);

    public static final RegistryObject<Item> CENT_1 = ITEMS.register("cent1", () -> new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> CENT_2 = ITEMS.register("cent2", () -> new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> CENT_5 = ITEMS.register("cent5", () -> new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> CENT_10 = ITEMS.register("cent10", () -> new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> CENT_20 = ITEMS.register("cent20", () -> new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> CENT_50 = ITEMS.register("cent50", () -> new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> EURO_1 = ITEMS.register("euro1", () -> new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> EURO_2 = ITEMS.register("euro2", () -> new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> EURO_5 = ITEMS.register("euro5", () -> new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> EURO_10 = ITEMS.register("euro10", () -> new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> EURO_20 = ITEMS.register("euro20", () -> new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> EURO_50 = ITEMS.register("euro50", () -> new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> EURO_100 = ITEMS.register("euro100", () -> new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> EURO_200 = ITEMS.register("euro200", () -> new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> EURO_500 = ITEMS.register("euro500", () -> new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
}
