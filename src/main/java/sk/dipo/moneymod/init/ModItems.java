package sk.dipo.moneymod.init;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import sk.dipo.moneymod.MoneyMod;
import sk.dipo.moneymod.items.CreditCardItem;
import sk.dipo.moneymod.items.MoneyItem;
import sk.dipo.moneymod.items.WalletItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, MoneyMod.MODID);

    public static final RegistryObject<Item> CENT_1 = ITEMS.register("cent1", () -> new MoneyItem(new Item.Properties()));
    public static final RegistryObject<Item> CENT_2 = ITEMS.register("cent2", () -> new MoneyItem(new Item.Properties()));
    public static final RegistryObject<Item> CENT_5 = ITEMS.register("cent5", () -> new MoneyItem(new Item.Properties()));
    public static final RegistryObject<Item> CENT_10 = ITEMS.register("cent10", () -> new MoneyItem(new Item.Properties()));
    public static final RegistryObject<Item> CENT_20 = ITEMS.register("cent20", () -> new MoneyItem(new Item.Properties()));
    public static final RegistryObject<Item> CENT_50 = ITEMS.register("cent50", () -> new MoneyItem(new Item.Properties()));
    public static final RegistryObject<Item> EURO_1 = ITEMS.register("euro1", () -> new MoneyItem(new Item.Properties()));
    public static final RegistryObject<Item> EURO_2 = ITEMS.register("euro2", () -> new MoneyItem(new Item.Properties()));
    public static final RegistryObject<Item> EURO_5 = ITEMS.register("euro5", () -> new MoneyItem(new Item.Properties()));
    public static final RegistryObject<Item> EURO_10 = ITEMS.register("euro10", () -> new MoneyItem(new Item.Properties()));
    public static final RegistryObject<Item> EURO_20 = ITEMS.register("euro20", () -> new MoneyItem(new Item.Properties()));
    public static final RegistryObject<Item> EURO_50 = ITEMS.register("euro50", () -> new MoneyItem(new Item.Properties()));
    public static final RegistryObject<Item> EURO_100 = ITEMS.register("euro100", () -> new MoneyItem(new Item.Properties()));
    public static final RegistryObject<Item> EURO_200 = ITEMS.register("euro200", () -> new MoneyItem(new Item.Properties()));
    public static final RegistryObject<Item> EURO_500 = ITEMS.register("euro500", () -> new MoneyItem(new Item.Properties()));

    public static final RegistryObject<Item> WALLET = ITEMS.register("wallet", () -> new WalletItem(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> CREDIT_CARD = ITEMS.register("credit_card", () -> new CreditCardItem(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));

}
