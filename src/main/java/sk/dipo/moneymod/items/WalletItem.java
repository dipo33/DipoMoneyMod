package sk.dipo.moneymod.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import sk.dipo.moneymod.container.factory.WalletContainer;

public class WalletItem extends Item {

    public WalletItem(Properties properties) {
        super(properties
                .maxStackSize(1)
        );
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (!worldIn.isRemote)
            NetworkHooks.openGui((ServerPlayerEntity) playerIn, new SimpleNamedContainerProvider(WalletContainer::new, new TranslationTextComponent("container.mymod.wallet")),
                    packet -> {
                packet.writeByte(handIn.ordinal());
            });
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}