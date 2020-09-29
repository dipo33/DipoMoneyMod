package sk.dipo.moneymod.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ForgeBlockTagsProvider;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ForgeBlockTagsProvider blockTags = new ForgeBlockTagsProvider(generator, event.getExistingFileHelper());
        if (event.includeServer()) {
            generator.addProvider(new Recipes(generator));
            generator.addProvider(new LootTables(generator));
            generator.addProvider(new ItemTags(generator, blockTags, event.getExistingFileHelper()));
        }
    }
}