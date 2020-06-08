package sk.dipo.moneymod.init;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import sk.dipo.moneymod.MoneyMod;
import sk.dipo.moneymod.tileentity.AtmTileEntity;

public class ModTileEntityTypes {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, MoneyMod.MODID);

    public static final RegistryObject<TileEntityType<AtmTileEntity>> ATM = TILE_ENTITY_TYPES.register("atm", () ->
            TileEntityType.Builder.create(AtmTileEntity::new, ModBlocks.ATM_BLOCK.get())
                    .build(null)
    );
}
