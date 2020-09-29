package sk.dipo.moneymod.init;

import com.google.common.collect.ImmutableSet;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.village.PointOfInterestType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import sk.dipo.moneymod.MoneyMod;

import java.util.Set;

public class ModPOITypes {

    private static Set<BlockState> getAllStates(Block blockIn) {
        return ImmutableSet.copyOf(blockIn.getStateContainer().getValidStates());
    }

    public static final DeferredRegister<PointOfInterestType> POI_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, MoneyMod.MODID);

    public static RegistryObject<PointOfInterestType> ATM = POI_TYPES.register("exchanger", () -> new PointOfInterestType("exchanger", getAllStates(ModBlocks.ATM_BLOCK.get()), 1, 1));
}
