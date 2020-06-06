package sk.dipo.moneymod.datagen;

import net.minecraft.block.Blocks;
import net.minecraft.data.*;
import net.minecraft.item.Items;
import sk.dipo.moneymod.MoneyMod;
import sk.dipo.moneymod.init.ModBlocks;
import sk.dipo.moneymod.init.ModItems;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Consumer;

public class Recipes extends RecipeProvider {

    public Recipes(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    @ParametersAreNonnullByDefault
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        registerMoneyRecipes(consumer);

        /* Wallet */
        ShapedRecipeBuilder.shapedRecipe(ModItems.WALLET.get())
                .patternLine(" S ")
                .patternLine("LLL")
                .patternLine(" S ")
                .key('S', Items.STRING)
                .key('L', Items.LEATHER)
                .addCriterion("leather", hasItem(Items.LEATHER))
                .addCriterion("string", hasItem(Items.STRING))
                .build(consumer);

        /* ATM */
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.ATM_BLOCK.get())
                .patternLine("QQQ")
                .patternLine("QDQ")
                .patternLine("QHQ")
                .key('Q', Blocks.QUARTZ_BLOCK)
                .key('D', Blocks.DROPPER)
                .key('H', Blocks.HOPPER)
                .addCriterion("quartz", hasItem(Items.QUARTZ))
                .addCriterion("dropper", hasItem(Items.DROPPER))
                .addCriterion("hopper", hasItem(Items.HOPPER))
                .build(consumer);
    }

    private void registerMoneyRecipes(Consumer<IFinishedRecipe> consumer) {
        /* Smaller to bigger */
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.EURO_500.get())
                .addIngredient(ModItems.EURO_200.get(), 2)
                .addIngredient(ModItems.EURO_100.get())
                .setGroup(MoneyMod.MODID)
                .addCriterion("200e", hasItem(ModItems.EURO_200.get()))
                .addCriterion("100e", hasItem(ModItems.EURO_100.get()))
                .build(consumer, "euro500_2x200_100");
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.EURO_50.get())
                .addIngredient(ModItems.EURO_20.get(), 2)
                .addIngredient(ModItems.EURO_10.get())
                .setGroup(MoneyMod.MODID)
                .addCriterion("20e", hasItem(ModItems.EURO_20.get()))
                .addCriterion("10e", hasItem(ModItems.EURO_10.get()))
                .build(consumer, "euro50_2x20_10");
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.EURO_5.get())
                .addIngredient(ModItems.EURO_2.get(), 2)
                .addIngredient(ModItems.EURO_1.get())
                .setGroup(MoneyMod.MODID)
                .addCriterion("2e", hasItem(ModItems.EURO_2.get()))
                .addCriterion("1e", hasItem(ModItems.EURO_1.get()))
                .build(consumer, "euro5_2x2_1");
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.CENT_50.get())
                .addIngredient(ModItems.CENT_20.get(), 2)
                .addIngredient(ModItems.CENT_10.get())
                .setGroup(MoneyMod.MODID)
                .addCriterion("20c", hasItem(ModItems.CENT_20.get()))
                .addCriterion("10c", hasItem(ModItems.CENT_10.get()))
                .build(consumer, "cent50_2x20_10");
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.CENT_5.get())
                .addIngredient(ModItems.CENT_2.get(), 2)
                .addIngredient(ModItems.CENT_1.get())
                .setGroup(MoneyMod.MODID)
                .addCriterion("2c", hasItem(ModItems.CENT_2.get()))
                .addCriterion("1c", hasItem(ModItems.CENT_1.get()))
                .build(consumer, "cent5_2x2_1");
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.EURO_500.get())
                .addIngredient(ModItems.EURO_100.get(), 5)
                .setGroup(MoneyMod.MODID)
                .addCriterion("100e", hasItem(ModItems.EURO_100.get()))
                .build(consumer, "euro500_5x100");
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.EURO_50.get())
                .addIngredient(ModItems.EURO_10.get(), 5)
                .setGroup(MoneyMod.MODID)
                .addCriterion("10e", hasItem(ModItems.EURO_10.get()))
                .build(consumer, "euro50_5x10");
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.EURO_5.get())
                .addIngredient(ModItems.EURO_1.get(), 5)
                .setGroup(MoneyMod.MODID)
                .addCriterion("1e", hasItem(ModItems.EURO_1.get()))
                .build(consumer, "euro5_5x1");
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.CENT_50.get())
                .addIngredient(ModItems.CENT_10.get(), 5)
                .setGroup(MoneyMod.MODID)
                .addCriterion("10c", hasItem(ModItems.CENT_10.get()))
                .build(consumer, "cent50_5x10");
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.CENT_5.get())
                .addIngredient(ModItems.CENT_1.get(), 5)
                .setGroup(MoneyMod.MODID)
                .addCriterion("1c", hasItem(ModItems.CENT_1.get()))
                .build(consumer, "cent5_5x1");
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.EURO_200.get())
                .addIngredient(ModItems.EURO_100.get(), 2)
                .setGroup(MoneyMod.MODID)
                .addCriterion("100e", hasItem(ModItems.EURO_100.get()))
                .build(consumer, "euro200_2x100");
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.EURO_20.get())
                .addIngredient(ModItems.EURO_10.get(), 2)
                .setGroup(MoneyMod.MODID)
                .addCriterion("10e", hasItem(ModItems.EURO_10.get()))
                .build(consumer, "euro20_2x10");
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.EURO_2.get())
                .addIngredient(ModItems.EURO_1.get(), 2)
                .setGroup(MoneyMod.MODID)
                .addCriterion("1e", hasItem(ModItems.EURO_1.get()))
                .build(consumer, "euro2_2x1");
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.CENT_20.get())
                .addIngredient(ModItems.CENT_10.get(), 2)
                .setGroup(MoneyMod.MODID)
                .addCriterion("10c", hasItem(ModItems.CENT_10.get()))
                .build(consumer, "cent20_2x10");
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.CENT_2.get())
                .addIngredient(ModItems.CENT_1.get(), 2)
                .setGroup(MoneyMod.MODID)
                .addCriterion("1c", hasItem(ModItems.CENT_1.get()))
                .build(consumer, "cent2_2x1");
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.EURO_100.get())
                .addIngredient(ModItems.EURO_50.get(), 2)
                .setGroup(MoneyMod.MODID)
                .addCriterion("50e", hasItem(ModItems.EURO_50.get()))
                .build(consumer, "euro100_2x50");
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.EURO_100.get())
                .addIngredient(ModItems.EURO_20.get(), 5)
                .setGroup(MoneyMod.MODID)
                .addCriterion("20e", hasItem(ModItems.EURO_20.get()))
                .build(consumer, "euro100_5x20");
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.EURO_10.get())
                .addIngredient(ModItems.EURO_5.get(), 2)
                .setGroup(MoneyMod.MODID)
                .addCriterion("5e", hasItem(ModItems.EURO_5.get()))
                .build(consumer, "euro10_2x5");
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.EURO_10.get())
                .addIngredient(ModItems.EURO_2.get(), 5)
                .setGroup(MoneyMod.MODID)
                .addCriterion("2e", hasItem(ModItems.EURO_2.get()))
                .build(consumer, "euro10_5x2");
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.EURO_1.get())
                .addIngredient(ModItems.CENT_50.get(), 2)
                .setGroup(MoneyMod.MODID)
                .addCriterion("50c", hasItem(ModItems.CENT_50.get()))
                .build(consumer, "euro1_2x50");
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.EURO_1.get())
                .addIngredient(ModItems.CENT_20.get(), 5)
                .setGroup(MoneyMod.MODID)
                .addCriterion("20c", hasItem(ModItems.CENT_20.get()))
                .build(consumer, "euro1_5x20");
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.CENT_10.get())
                .addIngredient(ModItems.CENT_5.get(), 2)
                .setGroup(MoneyMod.MODID)
                .addCriterion("5c", hasItem(ModItems.CENT_5.get()))
                .build(consumer, "cent10_2x5");
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.CENT_10.get())
                .addIngredient(ModItems.CENT_2.get(), 5)
                .setGroup(MoneyMod.MODID)
                .addCriterion("2c", hasItem(ModItems.CENT_2.get()))
                .build(consumer, "cent10_5x2");

        /* Bigger to smaller */
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.EURO_100.get(), 5)
                .addIngredient(ModItems.EURO_500.get())
                .setGroup(MoneyMod.MODID)
                .addCriterion("500e", hasItem(ModItems.EURO_500.get()))
                .build(consumer, "euro100_500");
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.EURO_10.get(), 5)
                .addIngredient(ModItems.EURO_50.get())
                .setGroup(MoneyMod.MODID)
                .addCriterion("50e", hasItem(ModItems.EURO_50.get()))
                .build(consumer, "euro10_50");
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.EURO_1.get(), 5)
                .addIngredient(ModItems.EURO_5.get())
                .setGroup(MoneyMod.MODID)
                .addCriterion("5e", hasItem(ModItems.EURO_5.get()))
                .build(consumer, "euro1_5");
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.EURO_100.get(), 2)
                .addIngredient(ModItems.EURO_200.get())
                .setGroup(MoneyMod.MODID)
                .addCriterion("200e", hasItem(ModItems.EURO_200.get()))
                .build(consumer, "euro100_200");
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.EURO_10.get(), 2)
                .addIngredient(ModItems.EURO_20.get())
                .setGroup(MoneyMod.MODID)
                .addCriterion("20e", hasItem(ModItems.EURO_20.get()))
                .build(consumer, "euro10_20");
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.EURO_1.get(), 2)
                .addIngredient(ModItems.EURO_2.get())
                .setGroup(MoneyMod.MODID)
                .addCriterion("2e", hasItem(ModItems.EURO_2.get()))
                .build(consumer, "euro1_2");
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.CENT_10.get(), 5)
                .addIngredient(ModItems.CENT_50.get())
                .setGroup(MoneyMod.MODID)
                .addCriterion("50c", hasItem(ModItems.CENT_50.get()))
                .build(consumer, "cent10_50");
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.CENT_1.get(), 5)
                .addIngredient(ModItems.CENT_5.get())
                .setGroup(MoneyMod.MODID)
                .addCriterion("5c", hasItem(ModItems.CENT_5.get()))
                .build(consumer, "cent1_5");
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.CENT_10.get(), 2)
                .addIngredient(ModItems.CENT_20.get())
                .setGroup(MoneyMod.MODID)
                .addCriterion("20c", hasItem(ModItems.CENT_20.get()))
                .build(consumer, "cent10_20");
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.CENT_1.get(), 2)
                .addIngredient(ModItems.CENT_2.get())
                .setGroup(MoneyMod.MODID)
                .addCriterion("2c", hasItem(ModItems.CENT_2.get()))
                .build(consumer, "cent1_2");
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.EURO_50.get(), 2)
                .addIngredient(ModItems.EURO_100.get())
                .setGroup(MoneyMod.MODID)
                .addCriterion("100e", hasItem(ModItems.EURO_100.get()))
                .build(consumer, "euro50_100");
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.EURO_5.get(), 2)
                .addIngredient(ModItems.EURO_10.get())
                .setGroup(MoneyMod.MODID)
                .addCriterion("10e", hasItem(ModItems.EURO_10.get()))
                .build(consumer, "euro5_10");
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.CENT_50.get(), 2)
                .addIngredient(ModItems.EURO_1.get())
                .setGroup(MoneyMod.MODID)
                .addCriterion("1e", hasItem(ModItems.EURO_1.get()))
                .build(consumer, "cent50_1");
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.CENT_5.get(), 2)
                .addIngredient(ModItems.CENT_10.get())
                .setGroup(MoneyMod.MODID)
                .addCriterion("10c", hasItem(ModItems.CENT_10.get()))
                .build(consumer, "cent5_10");
    }
}
