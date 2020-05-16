package sk.dipo.moneymod.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
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
            NetworkHooks.openGui((ServerPlayerEntity) playerIn, new INamedContainerProvider() {
                        @Override
                        public ITextComponent getDisplayName() {
                            return new TranslationTextComponent("container.wallet.dipo");
                        }

                        @Override
                        public Container createMenu(int windowID, PlayerInventory inv, PlayerEntity player) {
                            return new WalletContainer(windowID, inv, playerIn, handIn);
                        }
                    },
                    packet -> {
                        packet.writeByte(handIn.ordinal());
                    });
        return ActionResult.resultSuccess(playerIn.getHeldItem(handIn));
    }
}