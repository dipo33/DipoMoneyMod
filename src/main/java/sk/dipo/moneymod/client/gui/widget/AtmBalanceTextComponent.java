package sk.dipo.moneymod.client.gui.widget;

public class AtmBalanceTextComponent {

    int value;

    public AtmBalanceTextComponent(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%d.%02d", value / 100, value % 100);
    }
}
