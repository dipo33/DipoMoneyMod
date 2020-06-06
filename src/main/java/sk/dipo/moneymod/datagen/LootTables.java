package sk.dipo.moneymod.datagen;

import net.minecraft.data.DataGenerator;
import sk.dipo.moneymod.init.ModBlocks;

public class LootTables extends BaseLootTableProvider {

    public LootTables(DataGenerator dataGeneratorIn) {
        super(dataGeneratorIn);
    }

    @Override
    protected void addTables() {
        lootTables.put(ModBlocks.ATM_BLOCK.get(), createStandardBlockTable("ATM", ModBlocks.ATM_BLOCK.get()));
    }
}