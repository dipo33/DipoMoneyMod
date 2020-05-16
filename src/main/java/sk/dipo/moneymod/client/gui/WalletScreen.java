package sk.dipo.moneymod.client.gui;

import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import sk.dipo.moneymod.container.factory.WalletContainer;

public class WalletScreen extends ContainerScreen<WalletContainer> {

    private static final ResourceLocation GUI = new ResourceLocation("minecraft", "textures/gui/container/generic_54.png");
    private final PlayerInventory inventoryPlayer;
    private ItemStack wallet;

    public WalletScreen(WalletContainer container, PlayerInventory inv, ITextComponent name) {
        super(container, inv, name);
        this.inventoryPlayer = inv;
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks) {
        this.renderBackground();
        super.render(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
//        this.fontRenderer.drawString(wallet.getDisplayName(), 8, 5, 4210752);
//        this.fontRenderer.drawString(I18n.format(this.inventoryPlayer.getName(), new Object[0]), 8, this.ySize - 93, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bindTexture(GUI);
        int relX = (this.width - this.xSize) / 2;
        int relY = (this.height - this.ySize) / 2;
        this.blit(relX, relY - 1, 0, 0, this.xSize, 71);
        this.blit(relX, relY + 70, 0, 126, this.xSize, 96);
    }
}
