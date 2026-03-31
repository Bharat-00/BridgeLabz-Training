// Main Class
public class BankAccountManagement {
    public String accountNumber;    // Accessible everywhere
    protected String accountHolder; // Accessible to subclasses
    private double balance;         // Accessible ONLY inside BankAccount
    public BankAccountManagement(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }
    // Public method to access private balance
    public double getBalance() {
        return balance;
    }
    // Public method to modify private balance
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Deposited: $" + amount);
        }
    }
    public static void main(String[] args) {
        System.out.println("--- Problem 3: Bank Account Management ---");   
        SavingsAccount mySavings = new SavingsAccount("ACC-12345", "John Doe", 5000.0);
        mySavings.displayAccountInfo();
        // Modifying private balance via public method
        mySavings.deposit(1500.0);
        System.out.println("New Balance: $" + mySavings.getBalance());
    }
}
// Subclass
class SavingsAccount extends BankAccountManagement {   
    public SavingsAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }
    public void displayAccountInfo() {
        // Accessing public variable directly
        System.out.println("Account Number: " + accountNumber);   
        // Accessing protected variable directly (Allowed in subclass)
        System.out.println("Account Holder: " + accountHolder);
        // System.out.println(balance); // ERROR: Cannot access private variable directly
        // Must use public method
        System.out.println("Current Balance: $" + getBalance()); 
    }
}