package sk.dipo.moneymod.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import sk.dipo.moneymod.MoneyMod;
import sk.dipo.moneymod.client.gui.widget.AtmButton;
import sk.dipo.moneymod.container.AtmContainer;

public class AtmScreen extends ContainerScreen<AtmContainer> {

    private static final ResourceLocation GUI = new ResourceLocation(MoneyMod.MODID, "textures/gui/container/atm.png");

    public AtmScreen(AtmContainer container, PlayerInventory inv, ITextComponent name) {
        super(container, inv, name);
        this.xSize = 243;
        this.ySize = 222;
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks) {
        this.renderBackground();
        super.render(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        this.font.drawString(this.title.getFormattedText(), 42.0F, 5.0F, 0x404040);
        this.font.drawString(this.playerInventory.getDisplayName().getFormattedText(), 42.0F, (float) (this.ySize - 93), 0x404040);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        assert this.minecraft != null : "Minecraft is null";

        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bindTexture(GUI);
        int relX = (this.width - this.xSize + 68) / 2;
        int relY = (this.height - this.ySize) / 2;
        this.blit(relX, relY, 0, 0, this.xSize, this.ySize);
    }

    @Override
    protected void init() {
        super.init();
        this.addButton(new AtmButton(this.width / 2 + 95, this.height / 2 - 25, 16, 16, "1"));
        this.addButton(new AtmButton(this.width / 2 + 113, this.height / 2 - 25, 16, 16, "2"));
        this.addButton(new AtmButton(this.width / 2 + 131, this.height / 2 - 25, 16, 16, "3"));
        this.addButton(new AtmButton(this.width / 2 + 95, this.height / 2 - 43, 16, 16, "4"));
        this.addButton(new AtmButton(this.width / 2 + 113, this.height / 2 - 43, 16, 16, "5"));
        this.addButton(new AtmButton(this.width / 2 + 131, this.height / 2 - 43, 16, 16, "6"));
        this.addButton(new AtmButton(this.width / 2 + 95, this.height / 2 - 61, 16, 16, "7"));
        this.addButton(new AtmButton(this.width / 2 + 113, this.height / 2 - 61, 16, 16, "8"));
        this.addButton(new AtmButton(this.width / 2 + 131, this.height / 2 - 61, 16, 16, "9"));
        this.addButton(new AtmButton(this.width / 2 + 113, this.height / 2 - 7, 16, 16, "0"));
        this.addButton(new AtmButton(this.width / 2 + 131, this.height / 2 - 7, 16, 16, "."));
    }

    @Override
    public boolean mouseClicked(double p_mouseClicked_1_, double p_mouseClicked_3_, int p_mouseClicked_5_) {
        return super.mouseClicked(p_mouseClicked_1_, p_mouseClicked_3_, p_mouseClicked_5_);
    }
}
