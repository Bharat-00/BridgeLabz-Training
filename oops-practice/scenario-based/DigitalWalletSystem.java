import java.util.ArrayList;
import java.util.List;
/* ===================== Custom Exception ===================== */
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
/* ===================== Transaction Class ===================== */
class Transaction {
    private final String type;
    private final double amount;
    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }
    @Override
    public String toString() {
        return type + " : ₹" + amount;
    }
}
/* ===================== Wallet Class ===================== */
class Wallet {
    private double balance;
    private final List<Transaction> transactions;
    public Wallet() {
        balance = 0;
        transactions = new ArrayList<>();
    }
    public void addMoney(double amount) {
        balance += amount;
        transactions.add(new Transaction("Money Added", amount));
        System.out.println("₹" + amount + " added to wallet");
    }
    public void withdrawMoney(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient Balance!");
        }
        balance -= amount;
        transactions.add(new Transaction("Money Withdrawn", amount));
        System.out.println("₹" + amount + " withdrawn from wallet");
    }
    public double getBalance() {
        return balance;
    }
    public List<Transaction> getTransactions() {
        return transactions;
    }
}
/* ===================== User Class ===================== */
class User {
    private int userId;
    private final String name;
    private final Wallet wallet;
    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
        this.wallet = new Wallet();
    }
    public String getName() {
        return name;
    }
    public Wallet getWallet() {
        return wallet;
    }
}
/* ===================== Transfer Interface ===================== */
interface TransferService {
    void transfer(User from, User to, double amount) throws InsufficientBalanceException;
}
/* ===================== Wallet to Wallet Transfer ===================== */
class WalletTransfer implements TransferService {
    @Override
    public void transfer(User from, User to, double amount) throws InsufficientBalanceException {
        from.getWallet().withdrawMoney(amount);
        to.getWallet().addMoney(amount);
        System.out.println("₹" + amount + " transferred from " +
                from.getName() + " to " + to.getName());
    }
}
/* ===================== Bank to Wallet Transfer ===================== */
class BankTransfer implements TransferService {
    public void transfer(User from, User to, double amount) {
        to.getWallet().addMoney(amount);
        System.out.println("₹" + amount + " transferred from Bank to " + to.getName());
    }
}
/* ===================== Main Class ===================== */
public class DigitalWalletSystem {
    public static void main(String[] args) {
        try {
            User user1 = new User(1, "Amit");
            User user2 = new User(2, "Riya");
            // Add money
            user1.getWallet().addMoney(3000);
            // Wallet to Wallet Transfer
            TransferService walletTransfer = new WalletTransfer();
            walletTransfer.transfer(user1, user2, 1000);
            // Bank to Wallet Transfer
            TransferService bankTransfer = new BankTransfer();
            bankTransfer.transfer(null, user2, 2000);
            // Display balance
            System.out.println("\nFinal Balance of " + user2.getName() +": ₹" + user2.getWallet().getBalance());
            // Display transaction history
            System.out.println("\nTransaction History:");
            for (Transaction t : user2.getWallet().getTransactions()) {
                System.out.println(t);
            }
        } catch (InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
