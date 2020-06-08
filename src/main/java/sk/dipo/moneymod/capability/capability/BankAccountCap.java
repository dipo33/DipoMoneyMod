package sk.dipo.moneymod.capability.capability;

public class BankAccountCap implements IBankAccount {

    private int balance = 50000;

    @Override
    public int getBalance() {
        return this.balance;
    }

    @Override
    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public void deposit(int amount) {
        balance += amount;
    }

    @Override
    public int withdraw(int amount) {
        if (amount > balance) {
            amount = balance;
            balance = 0;
            return amount;
        }
        balance -= amount;
        return amount;
    }
}
