package sk.dipo.moneymod.client.gui.widget;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.text.TranslationTextComponent;

import java.util.ArrayList;
import java.util.List;

public class AtmTextComponent extends Thread {

    private String text;
    private final TranslationTextComponent name;
    private final FontRenderer fontRenderer;
    private List<String> formats;
    private boolean shouldStop = false;

    private static final int MOVE_START_DELAY = 1500;
    private static final int MOVE_CHAR_DELAY = 100;
    private static final int NEW_SENTENCE_DELAY = 200;
    private static final int MAX_SENTENCE_LENGTH = 156;

    public AtmTextComponent(String unlocalizedName, Object... args) {
        this.name = new TranslationTextComponent(unlocalizedName);
        this.fontRenderer = Minecraft.getInstance().fontRenderer;
        this.formats = new ArrayList<>();
        for (Object arg : args) {
            if (arg instanceof String)
                formats.add((String) arg);
            else if (arg instanceof Integer)
                formats.add(Integer.toString((Integer) arg));
            else
                throw new IllegalArgumentException("Invalid Type Of AtmTextComponent");
        }
        this.start();
    }

    @Override
    public void run() {
        String temp = applyFormats(name.getFormattedText());
        text = fontRenderer.trimStringToWidth(temp, MAX_SENTENCE_LENGTH);

        try {
            Thread.sleep(MOVE_START_DELAY);
            while (fontRenderer.getStringWidth(temp) > MAX_SENTENCE_LENGTH && !shouldStop) {
                temp = temp.substring(1);
                text = fontRenderer.trimStringToWidth(temp, MAX_SENTENCE_LENGTH);
                if (fontRenderer.getStringWidth(temp) < NEW_SENTENCE_DELAY)
                    temp += "        " + applyFormats(name.getFormattedText());
                Thread.sleep(MOVE_CHAR_DELAY);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String applyFormats(String text) {
        for (String format : formats) {
            text = String.format(text, format);
        }
        return text;
    }

    public String getFormattedText() {
        return text;
    }

    public void stopThread() {
        this.shouldStop = true;
    }
}
