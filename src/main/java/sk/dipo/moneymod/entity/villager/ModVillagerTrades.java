package sk.dipo.moneymod.entity.villager;

import net.minecraft.entity.Entity;
import net.minecraft.entity.merchant.villager.VillagerTrades;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MerchantOffer;
import sk.dipo.moneymod.config.DipoConfig;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class ModVillagerTrades {

    public static final HashMap<Integer, List<VillagerTrades.ITrade>> EXCHANGER_TRADES = new HashMap<>();

    static {
        EXCHANGER_TRADES.put(1, Arrays.asList(
                new VillagerTrades.ITrade[]{
                        new VillagerTrade(new ItemStack(Items.EMERALD), DipoConfig.emeraldValue, 16, 0),
                        new VillagerTrade(DipoConfig.emeraldValue, new ItemStack(Items.EMERALD), 16, 0),
                        new VillagerTrade(new ItemStack(Items.GOLD_INGOT), DipoConfig.goldValue, 16, 0),
                        new VillagerTrade(DipoConfig.goldValue, new ItemStack(Items.GOLD_INGOT), 16, 0)
                })
        );
    }

    static class VillagerTrade implements net.minecraft.entity.merchant.villager.VillagerTrades.ITrade {
        private final ItemStack buyStack;
        private final ItemStack sellStack;
        private final int maxUses;
        private final int xpValue;
        private final float priceMultiplier;

        public VillagerTrade(ItemStack buyStack, ItemStack sellStack, int maxUsesIn, int xpValueIn) {
            this.buyStack = buyStack;
            this.sellStack = sellStack;
            this.maxUses = maxUsesIn;
            this.xpValue = xpValueIn;
            this.priceMultiplier = 0.05F;
        }

        @ParametersAreNonnullByDefault
        public MerchantOffer getOffer(Entity trader, Random rand) {
            return new MerchantOffer(sellStack, buyStack, this.maxUses, this.xpValue, this.priceMultiplier);
        }
    }
}
