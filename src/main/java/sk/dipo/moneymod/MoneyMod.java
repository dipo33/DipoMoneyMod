package sk.dipo.moneymod;

import net.minecraft.village.PointOfInterestType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sk.dipo.moneymod.capability.CapabilityHandler;
import sk.dipo.moneymod.capability.capability.CreditCardInfo;
import sk.dipo.moneymod.capability.capability.ICreditCardInfo;
import sk.dipo.moneymod.capability.storage.CreditCardStorage;
import sk.dipo.moneymod.config.DipoConfig;
import sk.dipo.moneymod.init.*;
import sk.dipo.moneymod.network.ModPacketHandler;

@Mod(MoneyMod.MODID)
public class MoneyMod {
    public static final String MODID = "dipomoneymod";
    private static final Logger LOGGER = LogManager.getLogger();
    public static MoneyMod instance;

    public MoneyMod() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::enqueueIMC);
        modEventBus.addListener(this::processIMC);
        modEventBus.addListener(this::doClientStuff);

        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, DipoConfig.CLIENT_SPEC);

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new CapabilityHandler());

        instance = this;

        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModContainerTypes.CONTAINER_TYPES.register(modEventBus);
        ModTileEntityTypes.TILE_ENTITY_TYPES.register(modEventBus);
        ModPOITypes.POI_TYPES.register(modEventBus);
        ModVillagerProfessions.PROFESSIONS.register(modEventBus);
    }

    private void setup(final FMLCommonSetupEvent event) {
        // Pre-Init Code
        LOGGER.info("Pre-Init Started");

        PointOfInterestType.registerBlockStates(ModPOITypes.ATM.get());

        CapabilityManager.INSTANCE.register(ICreditCardInfo.class, new CreditCardStorage(), CreditCardInfo::new);

        ModPacketHandler.registerMessages();

        LOGGER.info("Pre-Init Finished");
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // Client-Only Code
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
        // Code to Dispatch IMC to Another Mod
    }

    private void processIMC(final InterModProcessEvent event) {
        // Code to Handle IMC from Other Mods
    }
}
