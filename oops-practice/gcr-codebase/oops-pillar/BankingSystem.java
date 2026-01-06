import java.util.ArrayList;
import java.util.List;
/* -------------------- INTERFACE -------------------- */
interface Loanable {
    void applyForLoan();
    double calculateLoanEligibility();
}
/* -------------------- ABSTRACT CLASS -------------------- */
abstract class BankAccount {
    // Encapsulated fields
    private final String accountNumber;
    private final String holderName;
    protected double balance;
    // Constructor
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }
    // Concrete methods
    public void deposit(double amount) {
        balance += amount;
        System.out.println("₹" + amount + " deposited successfully.");
    }
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }
    // Abstract method
    public abstract double calculateInterest();
    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }
    public String getHolderName() {
        return holderName;
    }
    public double getBalance() {
        return balance;
    }
}
/* -------------------- SAVINGS ACCOUNT -------------------- */
class SavingsAccount extends BankAccount implements Loanable {
    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }
    @Override
    public double calculateInterest() {
        return balance * 0.04;
    }
    @Override
    public void applyForLoan() {
        System.out.println("Loan applied for Savings Account.");
    }
    @Override
    public double calculateLoanEligibility() {
        return balance * 5;
    }
}
/* -------------------- CURRENT ACCOUNT -------------------- */
class CurrentAccount extends BankAccount implements Loanable {
    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }
    @Override
    public double calculateInterest() {
        return balance * 0.02;
    }
    @Override
    public void applyForLoan() {
        System.out.println("Loan applied for Current Account.");
    }
    @Override
    public double calculateLoanEligibility() {
        return balance * 3;
    }
}
/* -------------------- MAIN CLASS -------------------- */
public class BankingSystem {
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(new SavingsAccount("SB101", "Rahul Mehta", 50000));
        accounts.add(new CurrentAccount("CA202", "Anita Singh", 80000));
        System.out.println("===== Bank Account Details =====");
        // Polymorphism
        for (BankAccount account : accounts) {
            double interest = account.calculateInterest();
            System.out.println("Account Holder : " + account.getHolderName());
            System.out.println("Account Number : " + account.getAccountNumber());
            System.out.println("Balance        : ₹" + account.getBalance());
            System.out.println("Interest Earned: ₹" + interest);
            if (account instanceof Loanable loanable) {
                loanable.applyForLoan();
                System.out.println("Loan Eligibility: ₹" +
                        loanable.calculateLoanEligibility());
            }
            System.out.println("--------------------------------");
        }
    }
}
