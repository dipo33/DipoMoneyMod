package sk.dipo.moneymod.datagen.tag;

import net.minecraft.item.Item;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;
import sk.dipo.moneymod.MoneyMod;

public class ModItemTags {

    public static final Tag<Item> MONEY = tag("money");

    private static Tag<Item> tag(String name) {
        return new ItemTags.Wrapper(new ResourceLocation(MoneyMod.MODID, name));
    }
}
