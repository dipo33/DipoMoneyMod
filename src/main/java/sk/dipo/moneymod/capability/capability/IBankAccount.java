package sk.dipo.moneymod.capability.capability;

public interface IBankAccount {

    int getBalance();

    void setBalance(int balance);

    void deposit(int amount);

    int withdraw(int amount);
}
