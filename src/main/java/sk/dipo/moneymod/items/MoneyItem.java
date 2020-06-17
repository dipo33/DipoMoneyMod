package sk.dipo.moneymod.items;

import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import sk.dipo.moneymod.datagen.tag.ModItemTags;
import sk.dipo.moneymod.init.ModItemGroups;

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
        for (Item item : ModItemTags.MONEY.getAllElements()) {
            if (((MoneyItem) item).value == value)
                return item;
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
