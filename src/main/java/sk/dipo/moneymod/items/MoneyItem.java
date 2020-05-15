package sk.dipo.moneymod.items;

import net.minecraft.item.Item;
import sk.dipo.moneymod.init.ModItemGroups;

public class MoneyItem extends Item {
    public MoneyItem(Properties properties) {
        super(properties.group(ModItemGroups.MOD_ITEM_GROUP));
    }
}
