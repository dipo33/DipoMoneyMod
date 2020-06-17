package sk.dipo.moneymod.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import sk.dipo.moneymod.datagen.tag.ModItemTags;
import sk.dipo.moneymod.init.ModItems;

public class ItemTags extends ItemTagsProvider {

    public ItemTags(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void registerTags() {
        super.registerTags();
        getBuilder(ModItemTags.MONEY).add(ModItems.CENT_1.get(), ModItems.CENT_2.get(), ModItems.CENT_5.get(),
                ModItems.CENT_10.get(), ModItems.CENT_20.get(), ModItems.CENT_50.get(), ModItems.EURO_1.get(),
                ModItems.EURO_2.get(), ModItems.EURO_5.get(), ModItems.EURO_10.get(), ModItems.EURO_20.get(),
                ModItems.EURO_50.get(), ModItems.EURO_100.get(), ModItems.EURO_200.get(), ModItems.EURO_500.get());
    }
}
