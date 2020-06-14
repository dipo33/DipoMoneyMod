package sk.dipo.moneymod.world;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.WorldSavedData;
import sk.dipo.moneymod.MoneyMod;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AccountWorldSavedData extends WorldSavedData {

    private static final String DATA_NAME = MoneyMod.MODID + "_AccountData";

    private final Map<UUID, PlayerAccount> accounts;

    public AccountWorldSavedData() {
        super(DATA_NAME);
        accounts = new HashMap<>();
    }

    public String getPlayerName(UUID player) {
        return accounts.get(player).getPlayerName();
    }

    public int getBalance(UUID player) {
        return accounts.get(player).getBalance();
    }

    public void setBalance(UUID player, int balance) {
        accounts.get(player).setBalance(balance);
        this.markDirty();
    }

    public void deposit(UUID player, int amount) {
        accounts.get(player).deposit(amount);
        this.markDirty();
    }

    public int withdraw(UUID player, int amount) {
        final int withdrawal = accounts.get(player).withdraw(amount);
        this.markDirty();
        return withdrawal;
    }

    public void createAccount(UUID player, String name) {
        if (accounts.containsKey(player))
            return;
        accounts.put(player, new PlayerAccount(name));
        this.markDirty();
    }

    @Override
    public void read(CompoundNBT nbt) {
        ListNBT listNBT = (ListNBT) nbt.get("Accounts");
        accounts.clear();
        if (listNBT == null)
            return;

        listNBT.forEach((nbtAccount) -> {
            CompoundNBT compoundNBT = (CompoundNBT) nbtAccount;
            final UUID player = compoundNBT.getUniqueId("Player");
            final String name = compoundNBT.getString("PlayerName");
            final int balance = compoundNBT.getInt("Balance");
            accounts.put(player, new PlayerAccount(name, balance));
        });
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        ListNBT listNBT = new ListNBT();
        accounts.forEach((player, account) -> {
            CompoundNBT compoundNBT = new CompoundNBT();
            compoundNBT.putUniqueId("Player", player);
            compoundNBT.putString("PlayerName", account.getPlayerName());
            compoundNBT.putInt("Balance", account.getBalance());
            listNBT.add(compoundNBT);
        });
        compound.put("Accounts", listNBT);
        return compound;
    }

    public static AccountWorldSavedData get(World world) {
        return get((ServerWorld) world);
    }

    public static AccountWorldSavedData get(ServerWorld world) {
        return world.getSavedData().getOrCreate(AccountWorldSavedData::new, DATA_NAME);
    }

    static class PlayerAccount {

        private String playerName;
        private int balance;

        public PlayerAccount(String playerName, int balance) {
            this.playerName = playerName;
            this.balance = balance;
        }

        public PlayerAccount(String playerName) {
            this(playerName, 50000);
        }

        public String getPlayerName() {
            return playerName;
        }

        public void setPlayerName(String playerName) {
            this.playerName = playerName;
        }

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }

        public void deposit(int amount) {
            this.balance += amount;
        }

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
}
