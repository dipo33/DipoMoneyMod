package sk.dipo.moneymod.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import org.apache.logging.log4j.LogManager;
import sk.dipo.moneymod.MoneyMod;
import sk.dipo.moneymod.client.gui.widget.AtmButton;
import sk.dipo.moneymod.client.gui.widget.AtmNumericButton;
import sk.dipo.moneymod.client.gui.widget.AtmPinTextComponent;
import sk.dipo.moneymod.client.gui.widget.AtmTextComponent;
import sk.dipo.moneymod.container.AtmContainer;
import sk.dipo.moneymod.container.ContainerHelper;
import sk.dipo.moneymod.network.ModPacketHandler;
import sk.dipo.moneymod.network.packet.AtmInitSessionMsg;
import sk.dipo.moneymod.network.packet.AtmSignCardMsg;

public class AtmScreen extends ContainerScreen<AtmContainer> {

    private static final ResourceLocation GUI = new ResourceLocation(MoneyMod.MODID, "textures/gui/container/atm.png");

    private AtmPinTextComponent displayPIN = new AtmPinTextComponent();
    public AtmTextComponent displayMain;
    public KeyPadMode keyPadMode = KeyPadMode.KeyPadOff;

    public AtmScreen(AtmContainer container, PlayerInventory inv, ITextComponent name) {
        super(container, inv, name);
        this.displayMain = new AtmTextComponent(ContainerHelper.getUnlocalizedText("loading"));
        this.xSize = 243;
        this.ySize = 222;
        ModPacketHandler.INSTANCE.sendToServer(new AtmInitSessionMsg(this.getContainer().tileEntity.hand));
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
        this.font.drawString(new TranslationTextComponent(ContainerHelper.getUnlocalizedText("atm_in")).getFormattedText(), 42, 31, 4210752);
        this.font.drawString(new TranslationTextComponent(ContainerHelper.getUnlocalizedText("atm_out")).getFormattedText(), 42, 81, 4210752);
        this.font.drawString(displayMain.getFormattedText(), 44, 17, 16777215);
        this.font.drawString(displayPIN.getFormattedText(), 219, 27, 16777215);
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
        Button.IPressable onPressNum = (button) -> {
            switch (keyPadMode) {
                case SetPin:
                case Login:
                    displayPIN.appendDigit(((AtmNumericButton) button).value);
                    break;
            }
            LogManager.getLogger().debug("text");
        };
        Button.IPressable onConfirm = (button) -> {
            switch (keyPadMode) {
                case SetPin:
                    if (displayPIN.isPinFull())
                        ModPacketHandler.INSTANCE.sendToServer(new AtmSignCardMsg(this.getContainer().tileEntity.hand, displayPIN.getPinCode()));
                    break;
            }
            LogManager.getLogger().debug("text");
        };

        this.addButton(new AtmNumericButton(this.width / 2 + 95, this.height / 2 - 25, 16, 16, 1, onPressNum));
        this.addButton(new AtmNumericButton(this.width / 2 + 113, this.height / 2 - 25, 16, 16, 2, onPressNum));
        this.addButton(new AtmNumericButton(this.width / 2 + 131, this.height / 2 - 25, 16, 16, 3, onPressNum));
        this.addButton(new AtmNumericButton(this.width / 2 + 95, this.height / 2 - 43, 16, 16, 4, onPressNum));
        this.addButton(new AtmNumericButton(this.width / 2 + 113, this.height / 2 - 43, 16, 16, 5, onPressNum));
        this.addButton(new AtmNumericButton(this.width / 2 + 131, this.height / 2 - 43, 16, 16, 6, onPressNum));
        this.addButton(new AtmNumericButton(this.width / 2 + 95, this.height / 2 - 61, 16, 16, 7, onPressNum));
        this.addButton(new AtmNumericButton(this.width / 2 + 113, this.height / 2 - 61, 16, 16, 8, onPressNum));
        this.addButton(new AtmNumericButton(this.width / 2 + 131, this.height / 2 - 61, 16, 16, 9, onPressNum));
        this.addButton(new AtmNumericButton(this.width / 2 + 95, this.height / 2 - 7, 16, 16, 0, onPressNum));
        this.addButton(new AtmButton(this.width / 2 + 113, this.height / 2 - 7, 16, 16, ".", 0, onPressNum));
        this.addButton(new AtmButton(this.width / 2 + 131, this.height / 2 - 7, 16, 16, "C", 1, onPressNum));
        this.addButton(new AtmButton(this.width / 2 + 95, this.height / 2 + 11, 23, 16, Character.toString((char) 0x2B06), 2, onConfirm));
        this.addButton(new AtmButton(this.width / 2 + 124, this.height / 2 + 11, 23, 16, Character.toString((char) 0x2B07), 3, onPressNum));
    }

    @Override
    public void removed() {
        super.removed();
        this.displayMain.stopThread();
    }

    public enum KeyPadMode {
        KeyPadOff,
        SetPin,
        Login,
        Balance
    }
}
