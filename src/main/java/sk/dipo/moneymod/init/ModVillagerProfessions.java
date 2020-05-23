package sk.dipo.moneymod.init;

import com.google.common.collect.ImmutableSet;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import sk.dipo.moneymod.MoneyMod;

public class ModVillagerProfessions {

    public static final DeferredRegister<VillagerProfession> PROFESSIONS = new DeferredRegister<>(ForgeRegistries.PROFESSIONS, MoneyMod.MODID);

    public static RegistryObject<VillagerProfession> EXCHANGER = PROFESSIONS.register("exchanger", () -> new VillagerProfession("exchanger", ModPOITypes.ATM.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_ARMORER));
}
