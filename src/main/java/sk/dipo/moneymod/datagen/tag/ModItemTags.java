package sk.dipo.moneymod.datagen.tag;

import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import sk.dipo.moneymod.MoneyMod;

public class ModItemTags {

    public static final ITag.INamedTag<Item> MONEY = tag("money");

    private static ITag.INamedTag<Item> tag(String name) {
        return ItemTags.makeWrapperTag(MoneyMod.MODID + ":" + name);
    }
}
