package sk.dipo.moneymod.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import sk.dipo.moneymod.MoneyMod;
import sk.dipo.moneymod.block.AtmBlock;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, MoneyMod.MODID);

    // TODO: Add correct Hardness / Resistance
    public static final RegistryObject<Block> ATM = BLOCKS.register("atm", () -> new AtmBlock(Block.Properties.create(Material.ROCK, MaterialColor.QUARTZ)));
}
