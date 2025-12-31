// Program to simulate an ATM
// BankAccount class definition
class BankAccount {
    // Instance variables
    private final String accountHolder;
    private final String accountNumber;
    private double balance;
    // Constructor to initialize account details
    public BankAccount(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    // Method to deposit money
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
        System.out.println("Current balance: " + balance);
    }
    // Method to withdraw money
    public void withdraw(double amount) {
        System.out.println("Withdrawn amount: " + amount);
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Current balance: " + balance);
        } else {
            System.out.println("Insufficient balance");
        }
    }
    // Method to display current balance
    public void displayBalance() {
        System.out.println("Current balance: " + balance);
    }
}
// Main class
public class ATMSimulator {
    public static void main(String[] args) {
        // Creating BankAccount object
        BankAccount account = new BankAccount("State of Chennai", "ACC1001", 700.0);
        // Displaying current balance
        account.displayBalance();
        // Depositing money
        account.deposit(200.0);
        // Withdrawing money
        account.withdraw(100.0);
        // Attempting to withdraw more than balance
        account.withdraw(900.0);
    }
}
