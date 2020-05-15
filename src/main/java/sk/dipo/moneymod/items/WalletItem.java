package sk.dipo.moneymod.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class WalletItem extends Item {

    public static LazyOptional<IItemHandler> idk;

    public WalletItem(Properties properties) {
        super(properties
                .maxStackSize(1)
        );
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (!worldIn.isRemote)
            idk = playerIn.getHeldItem(handIn).getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY);
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    //    @Override
//    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
//        return super.onItemRightClick(worldIn, playerIn, handIn);
//        if (!worldIn.isRemote) {
//            NetworkHooks.openGui();
//            if (hand == EnumHand.MAIN_HAND)
//                player.openGui(MoneyMod.instance, GuiHandler.GUI_WALLET_MAIN, world, player.getPosition().getX(), player.getPosition().getY(),
//                        player.getPosition().getZ());
//            else
//                player.openGui(MoneyMod.instance, GuiHandler.GUI_WALLET_OFF, world, player.getPosition().getX(), player.getPosition().getY(),
//                        player.getPosition().getZ());
//
//            return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
//        }
//        return new ActionResult<ItemStack>(EnumActionResult.PASS, player.getHeldItem(hand));
//    }
}