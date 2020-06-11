package sk.dipo.moneymod.client.gui.widget;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import org.apache.logging.log4j.LogManager;
import sk.dipo.moneymod.MoneyMod;

public class AtmButton extends Button {

    private static final ResourceLocation BUTTON_TEXTURES = new ResourceLocation(MoneyMod.MODID,
            "textures/gui/container/atm.png");

    private final int offset;
    private boolean isClicked = false;

    public AtmButton(int widthIn, int heightIn, int width, int height, String text, int buttonType, Button.IPressable onPress) {
        super(widthIn, heightIn, width, height, text, onPress);
        this.offset = getButtonOffset(buttonType);
    }

    @Override
    public void renderButton(int p_renderButton_1_, int p_renderButton_2_, float p_renderButton_3_) {
        Minecraft minecraft = Minecraft.getInstance();
        FontRenderer fontrenderer = minecraft.fontRenderer;
        minecraft.getTextureManager().bindTexture(BUTTON_TEXTURES);
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        // idk
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);

        this.blit(this.x, this.y, this.width * getState() + this.offset, 225, this.width, this.height);
        this.renderBg(minecraft, p_renderButton_1_, p_renderButton_2_);
        int j = getFGColor();
        this.drawCenteredString(fontrenderer, this.getMessage(), this.x + this.width / 2, this.y + (this.height - 8) / 2, j | MathHelper.ceil(this.alpha * 255.0F) << 24);
    }

    @Override
    public void onClick(double p_onClick_1_, double p_onClick_3_) {
        super.onClick(p_onClick_1_, p_onClick_3_);
        this.isClicked = true;
    }

    @Override
    public void onRelease(double p_onRelease_1_, double p_onRelease_3_) {
        super.onRelease(p_onRelease_1_, p_onRelease_3_);
        this.isClicked = false;
    }

    private int getState() {
        if (isHovered())
            if (isClicked)
                return 0;
            else
                return 2;
        isClicked = false;
        return 1;
    }

    private static int getButtonOffset(int buttonType) {
        switch (buttonType) {
            case 0:
                return 0;
            case 1:
                return 48;
            case 2:
                return 96;
            case 3:
                return 165;
        }

        return 0;
    }
}
