package sk.dipo.moneymod.client;

import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sk.dipo.moneymod.MoneyMod;
import sk.dipo.moneymod.client.gui.AtmScreen;
import sk.dipo.moneymod.client.gui.WalletScreen;
import sk.dipo.moneymod.init.ModContainerTypes;

@Mod.EventBusSubscriber(modid = MoneyMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEventSubscriber {

    private static final Logger LOGGER = LogManager.getLogger(MoneyMod.MODID + " Client Mod Event Subscriber");

    /**
     * We need to register our renderers on the client because rendering code does not exist on the server
     * and trying to use it on a dedicated server will crash the game.
     * <p>
     * This method will be called by Forge when it is time for the mod to do its client-side setup
     * This method will always be called after the Registry events.
     * This means that all Blocks, Items, TileEntityTypes, etc. will all have been registered already
     */
    @SubscribeEvent
    public static void onFMLClientSetupEvent(final FMLClientSetupEvent event) {

        // Register TileEntity Renderers
        // ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.MINI_MODEL.get(), MiniModelTileEntityRenderer::new);
        LOGGER.debug("Registered TileEntity Renderers");

        // Register Entity Renderers
        // RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.WILD_BOAR.get(), WildBoarRenderer::new);
        LOGGER.debug("Registered Entity Renderers");

        // Register ContainerType Screens
        // ScreenManager.registerFactory is not safe to call during parallel mod loading so we queue it to run later
        DeferredWorkQueue.runLater(() -> {
            ScreenManager.registerFactory(ModContainerTypes.WALLET.get(), WalletScreen::new);
            ScreenManager.registerFactory(ModContainerTypes.ATM.get(), AtmScreen::new);
            LOGGER.debug("Registered ContainerType Screens");
        });

    }
}
