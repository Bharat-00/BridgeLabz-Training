abstract class BankAccount {
    private final String accountNumber;
    private final double balance;
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public final double getBalance() {
        return balance;
    }
    public abstract double calculateFee();
}
class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }
    @Override
    public double calculateFee() {
        return getBalance() * 0.005;
    }
}
class CheckingAccount extends BankAccount {
    public CheckingAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }
    @Override
    public double calculateFee() {
        return getBalance() < 1000 ? 1.0 : 0.0;
    }
}
public class BankAccountHierarchy {
    public static void main(String[] args) {
        BankAccount savings = new SavingsAccount("12345", 1000.0);
        System.out.printf("%.2f%n", savings.calculateFee());
        BankAccount savings2 = new SavingsAccount("11111", 500.0);
        System.out.printf("%.2f%n", savings2.calculateFee());
        BankAccount checking1 = new CheckingAccount("22222", 1500.0);
        System.out.printf("%.2f%n", checking1.calculateFee());
        BankAccount checking2 = new CheckingAccount("33333", 500.0);
        System.out.printf("%.2f%n", checking2.calculateFee());
    }
}
