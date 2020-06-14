package sk.dipo.moneymod.client.gui.widget;

public class AtmPinTextComponent {

    private String pinCode = "";
    private String text = "";

    public void appendDigit(int digit) {
        if (digit < 0 || digit > 9)
            throw new IllegalArgumentException("Digit out of range 0 - 9");
        if (pinCode.length() < 4) {
            pinCode += Integer.toString(digit);
            text += " * ";
        }
    }

    public String getFormattedText() {
        return text;
    }

    public boolean isPinFull() {
        return this.pinCode.length() == 4;
    }
    public String getPinCode() {
        return pinCode;
    }
}
