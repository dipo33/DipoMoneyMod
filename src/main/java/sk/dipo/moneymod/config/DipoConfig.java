package sk.dipo.moneymod.config;

import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Tuple;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;
import sk.dipo.moneymod.MoneyMod;
import sk.dipo.moneymod.init.ModItems;
import sk.dipo.moneymod.items.MoneyItem;

import java.util.HashMap;
import java.util.Map;

@Mod.EventBusSubscriber(modid = MoneyMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DipoConfig {

    public static final ClientConfig CLIENT;
    public static final ForgeConfigSpec CLIENT_SPEC;
    public static boolean doMobsDropMoney;
    public static boolean allowVillager;
    public static ItemStack emeraldValue;
    public static ItemStack goldValue;
    public static Map<EntityType<?>, Tuple<Integer, Integer>> ENTITIES;
    public static Map<EntityType<?>, Map<Integer, Tuple<Integer, Integer>>> SLIMES;

    static {
        ENTITIES = new HashMap<>();
        SLIMES = new HashMap<>();
        ENTITIES.put(EntityType.BAT, new Tuple<>(0, 0));
        ENTITIES.put(EntityType.BEE, new Tuple<>(0, 0));
        ENTITIES.put(EntityType.BLAZE, new Tuple<>(20, 50));
        ENTITIES.put(EntityType.CAT, new Tuple<>(0, 0));
        ENTITIES.put(EntityType.CAVE_SPIDER, new Tuple<>(5, 10));
        ENTITIES.put(EntityType.CHICKEN, new Tuple<>(0, 0));
        ENTITIES.put(EntityType.COD, new Tuple<>(0, 0));
        ENTITIES.put(EntityType.COW, new Tuple<>(0, 0));
        ENTITIES.put(EntityType.CREEPER, new Tuple<>(10, 20));
        ENTITIES.put(EntityType.DONKEY, new Tuple<>(0, 0));
        ENTITIES.put(EntityType.DOLPHIN, new Tuple<>(0, 0));
        ENTITIES.put(EntityType.DROWNED, new Tuple<>(1, 10));
        ENTITIES.put(EntityType.ELDER_GUARDIAN, new Tuple<>(1000, 3000));
        ENTITIES.put(EntityType.ENDER_DRAGON, new Tuple<>(10000, 20000));
        ENTITIES.put(EntityType.ENDERMAN, new Tuple<>(15, 40));
        ENTITIES.put(EntityType.ENDERMITE, new Tuple<>(10, 50));
        ENTITIES.put(EntityType.EVOKER, new Tuple<>(300, 1000));
        ENTITIES.put(EntityType.FOX, new Tuple<>(0, 0));
        ENTITIES.put(EntityType.GHAST, new Tuple<>(50, 100));
        ENTITIES.put(EntityType.GIANT, new Tuple<>(0, 0));
        ENTITIES.put(EntityType.GUARDIAN, new Tuple<>(15, 30));
        ENTITIES.put(EntityType.HORSE, new Tuple<>(0, 0));
        ENTITIES.put(EntityType.HUSK, new Tuple<>(1, 10));
        ENTITIES.put(EntityType.ILLUSIONER, new Tuple<>(0, 0));
        ENTITIES.put(EntityType.LLAMA, new Tuple<>(0, 0));
        ENTITIES.put(EntityType.MULE, new Tuple<>(0, 0));
        ENTITIES.put(EntityType.MOOSHROOM, new Tuple<>(0, 0));
        ENTITIES.put(EntityType.OCELOT, new Tuple<>(0, 0));
        ENTITIES.put(EntityType.PANDA, new Tuple<>(0, 0));
        ENTITIES.put(EntityType.PARROT, new Tuple<>(0, 0));
        ENTITIES.put(EntityType.PIG, new Tuple<>(0, 0));
        ENTITIES.put(EntityType.PUFFERFISH, new Tuple<>(0, 0));
        ENTITIES.put(EntityType.ZOMBIFIED_PIGLIN, new Tuple<>(10, 20)); // FIXME: PIGMAN
        ENTITIES.put(EntityType.POLAR_BEAR, new Tuple<>(0, 0));
        ENTITIES.put(EntityType.RABBIT, new Tuple<>(0, 0));
        ENTITIES.put(EntityType.SALMON, new Tuple<>(0, 0));
        ENTITIES.put(EntityType.SHEEP, new Tuple<>(0, 0));
        ENTITIES.put(EntityType.SHULKER, new Tuple<>(10, 50));
        ENTITIES.put(EntityType.SILVERFISH, new Tuple<>(1, 10));
        ENTITIES.put(EntityType.SKELETON, new Tuple<>(5, 15));
        ENTITIES.put(EntityType.SKELETON_HORSE, new Tuple<>(30, 60));
        ENTITIES.put(EntityType.SNOW_GOLEM, new Tuple<>(0, 0));
        ENTITIES.put(EntityType.SPIDER, new Tuple<>(5, 15));
        ENTITIES.put(EntityType.SQUID, new Tuple<>(0, 0));
        ENTITIES.put(EntityType.STRAY, new Tuple<>(10, 20));
        ENTITIES.put(EntityType.TRADER_LLAMA, new Tuple<>(0, 0));
        ENTITIES.put(EntityType.TROPICAL_FISH, new Tuple<>(0, 0));
        ENTITIES.put(EntityType.TURTLE, new Tuple<>(0, 0));
        ENTITIES.put(EntityType.VEX, new Tuple<>(5, 20));
        ENTITIES.put(EntityType.VILLAGER, new Tuple<>(0, 0));
        ENTITIES.put(EntityType.IRON_GOLEM, new Tuple<>(0, 0));
        ENTITIES.put(EntityType.VINDICATOR, new Tuple<>(50, 100));
        ENTITIES.put(EntityType.PILLAGER, new Tuple<>(50, 100));
        ENTITIES.put(EntityType.WANDERING_TRADER, new Tuple<>(0, 0));
        ENTITIES.put(EntityType.WITCH, new Tuple<>(50, 100));
        ENTITIES.put(EntityType.WITHER, new Tuple<>(5000, 7500));
        ENTITIES.put(EntityType.WITHER_SKELETON, new Tuple<>(10, 40));
        ENTITIES.put(EntityType.WOLF, new Tuple<>(0, 0));
        ENTITIES.put(EntityType.ZOMBIE, new Tuple<>(1, 10));
        ENTITIES.put(EntityType.ZOMBIE_HORSE, new Tuple<>(30, 100));
        ENTITIES.put(EntityType.ZOMBIE_VILLAGER, new Tuple<>(1, 10));
        ENTITIES.put(EntityType.PHANTOM, new Tuple<>(20, 50));
        ENTITIES.put(EntityType.RAVAGER, new Tuple<>(1000, 1500));

        Map<Integer, Tuple<Integer, Integer>> regularSlimes = new HashMap<>();
        regularSlimes.put(1, new Tuple<>(1, 2));
        regularSlimes.put(2, new Tuple<>(2, 3));
        regularSlimes.put(4, new Tuple<>(4, 5));
        SLIMES.put(EntityType.SLIME, regularSlimes);

        Map<Integer, Tuple<Integer, Integer>> magmaSlimes = new HashMap<>();
        magmaSlimes.put(1, new Tuple<>(1, 10));
        magmaSlimes.put(2, new Tuple<>(10, 20));
        magmaSlimes.put(4, new Tuple<>(20, 40));
        SLIMES.put(EntityType.MAGMA_CUBE, magmaSlimes);

        final Pair<ClientConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(ClientConfig::new);
        CLIENT_SPEC = specPair.getRight();
        CLIENT = specPair.getLeft();
    }

    public static void bakeConfig() {
        doMobsDropMoney = CLIENT.doMobsDropMoney.get();
        allowVillager = CLIENT.allowVillager.get();

        int maxCoinValue = MoneyItem.getMaxCoinValue(CLIENT.emeraldValue.get());
        emeraldValue = new ItemStack(MoneyItem.getCoinByValue(maxCoinValue), CLIENT.emeraldValue.get() / maxCoinValue);
        maxCoinValue = MoneyItem.getMaxCoinValue(CLIENT.goldValue.get());
        goldValue = new ItemStack(MoneyItem.getCoinByValue(maxCoinValue), CLIENT.goldValue.get() / maxCoinValue);

        CLIENT.ENTITIES.forEach((k, v) ->
                ENTITIES.put(k, new Tuple<>(v.getA().get(), v.getB().get()))
        );

        CLIENT.SLIMES.forEach((k, v) -> {
            final Map<Integer, Tuple<Integer, Integer>> slimes = SLIMES.get(k);
            v.forEach((kk, vv) ->
                    slimes.put(kk, new Tuple<>(vv.getA().get(), vv.getB().get()))
            );
        });
    }

    @SubscribeEvent
    public static void onModConfigEvent(final ModConfig.ModConfigEvent configEvent) {
        if (configEvent.getConfig().getSpec() == DipoConfig.CLIENT_SPEC) {
            bakeConfig();
        }
    }

    public static class ClientConfig {

        public final ForgeConfigSpec.BooleanValue doMobsDropMoney;
        public final ForgeConfigSpec.BooleanValue allowVillager;
        public final ForgeConfigSpec.IntValue emeraldValue;
        public final ForgeConfigSpec.IntValue goldValue;
        public final Map<EntityType<?>, Tuple<ForgeConfigSpec.IntValue, ForgeConfigSpec.IntValue>> ENTITIES = new HashMap<>();
        public final Map<EntityType<?>, Map<Integer, Tuple<ForgeConfigSpec.IntValue, ForgeConfigSpec.IntValue>>> SLIMES = new HashMap<>();

        public ClientConfig(ForgeConfigSpec.Builder builder) {
            doMobsDropMoney = builder
                    .comment("Should mobs drop money when killed")
                    .translation(MoneyMod.MODID + ".config." + "doMobsDropMoney")
                    .define("doMobsDropMoney", true);

            builder.push("Villager Exchanger");
            allowVillager = builder
                    .comment("Is Exchanger Villager allowed")
                    .translation(MoneyMod.MODID + ".config." + "allowVillager")
                    .define("allowVillager", true);
            emeraldValue = builder
                    .comment("Value of one emerald in cents")
                    .translation(MoneyMod.MODID + ".config." + "emeraldValue")
                    .defineInRange("emeraldValue", 500, 0, 3200000);
            goldValue = builder
                    .comment("Value of one gold ingot in cents")
                    .translation(MoneyMod.MODID + ".config." + "goldValue")
                    .defineInRange("goldValue", 100, 0, 3200000);
            builder.pop();

            builder.push("Mob Drops");
            DipoConfig.ENTITIES.forEach((k, v) -> {
                String name = k.getName().getString().replaceAll(" ", "");
                builder.push(name);
                ForgeConfigSpec.IntValue min = builder
                        .comment("Minimal money drop of " + name)
                        .translation(MoneyMod.MODID + ".config." + name)
                        .defineInRange(name + "Min", v.getA(), 0, 3200000);
                ForgeConfigSpec.IntValue max = builder
                        .comment("Maximal money drop of " + name)
                        .translation(MoneyMod.MODID + ".config." + name)
                        .defineInRange(name + "Max", v.getB(), 0, 3200000);
                this.ENTITIES.put(k, new Tuple<>(min, max));
                builder.pop();
            });
            DipoConfig.SLIMES.forEach((entityType, map) -> {
                Map<Integer, Tuple<ForgeConfigSpec.IntValue, ForgeConfigSpec.IntValue>> slimes = new HashMap<>();
                String typeStr = entityType.getName().getString().replaceAll(" ", "");
                builder.push(typeStr);
                map.forEach((slimeSize, integerTuple) -> {
                    String name = "Size_" + slimeSize;
                    builder.push(name);
                    ForgeConfigSpec.IntValue min = builder
                            .comment("Minimal money drop of " + typeStr + " of size " + slimeSize)
                            .translation(MoneyMod.MODID + ".config." + typeStr + "_" + name)
                            .defineInRange(typeStr + "_" + name + "_Min", integerTuple.getA(), 0, 3200000);
                    ForgeConfigSpec.IntValue max = builder
                            .comment("Maximal money drop of " + typeStr + " of size " + slimeSize)
                            .translation(MoneyMod.MODID + ".config." + typeStr + "_" + name)
                            .defineInRange(typeStr + "_" + name + "_Max", integerTuple.getB(), 0, 3200000);
                    slimes.put(slimeSize, new Tuple<>(min, max));
                    builder.pop();
                });
                this.SLIMES.put(entityType, slimes);
                builder.pop();
            });
            builder.pop();
        }
    }
}
