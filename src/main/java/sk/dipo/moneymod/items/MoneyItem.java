package sk.dipo.moneymod.items;

import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import sk.dipo.moneymod.datagen.tag.ModItemTags;
import sk.dipo.moneymod.init.ModItemGroups;
import sk.dipo.moneymod.init.ModItems;

import java.util.Random;

public class MoneyItem extends Item {

    private final int value;

    private static final int[] COIN_VALUES = {
            50000, 20000, 10000, 5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5, 2, 1
    };

    public MoneyItem(Properties properties, int value) {
        super(properties.group(ModItemGroups.MOD_ITEM_GROUP));
        this.value = value;
    }

    public static int getMaxCoinValue(int value) {
        for (int coin : COIN_VALUES) {
            if (value / coin > 0)
                return coin;
        }
        return 0;
    }

    public static Item getCoinByValue(int value) {
        switch (value) {
            case 1:
                return ModItems.CENT_1.get();
            case 2:
                return ModItems.CENT_2.get();
            case 5:
                return ModItems.CENT_5.get();
            case 10:
                return ModItems.CENT_10.get();
            case 20:
                return ModItems.CENT_20.get();
            case 50:
                return ModItems.CENT_50.get();
            case 100:
                return ModItems.EURO_1.get();
            case 200:
                return ModItems.EURO_2.get();
            case 500:
                return ModItems.EURO_5.get();
            case 1000:
                return ModItems.EURO_10.get();
            case 2000:
                return ModItems.EURO_20.get();
            case 5000:
                return ModItems.EURO_50.get();
            case 10000:
                return ModItems.EURO_100.get();
            case 20000:
                return ModItems.EURO_200.get();
            case 50000:
                return ModItems.EURO_500.get();
        }
        return Items.AIR;
    }

    public static int getCoinValue(Item item) {
        if (item instanceof MoneyItem)
            return ((MoneyItem) item).value;
        return 0;
    }

    public static void addRandomMoneyDrop(LivingDropsEvent event, int low, int high) {
        int value = new Random().nextInt(high - low + 1) + low;

        for (int coin : COIN_VALUES) {
            int amount = value / coin;
            value = value % coin;

            if (amount > 0) {
                ItemStack drop = new ItemStack(getCoinByValue(coin), amount);
                ItemEntity entity = new ItemEntity(event.getEntity().getEntityWorld(), event.getEntity().getPosX(), event.getEntity().getPosY(), event.getEntity().getPosZ(), drop);
                event.getDrops().add(entity);
            }
        }
    }
}
