import java.time.LocalDateTime;
class BankAccount {
    private double balance = 10000;
    public synchronized boolean withdraw(String customerName, double amount) {
        System.out.println("[" + customerName + "] Attempting to withdraw " + amount);
        if (balance >= amount) {
            try {
                Thread.sleep(500); // simulate processing delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance -= amount;
            System.out.println("Transaction successful: " + customerName +
                    ", Amount: " + amount +
                    ", Balance: " + balance +
                    ", Time: " + LocalDateTime.now());
            return true;
        } else {
            System.out.println("Transaction failed: " + customerName +
                    ", Amount: " + amount +
                    ", Insufficient Balance, Time: " + LocalDateTime.now());
            return false;
        }
    }
}
class Transaction implements Runnable {
    private BankAccount account;
    private String customerName;
    private double amount;
    public Transaction(BankAccount account, String customerName, double amount) {
        this.account = account;
        this.customerName = customerName;
        this.amount = amount;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " State: " +
                Thread.currentThread().getState());
        account.withdraw(customerName, amount);
    }
}
public class BankingSystem {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount();
        Thread t1 = new Thread(new Transaction(account, "Customer-1", 3000), "ATM-1");
        Thread t2 = new Thread(new Transaction(account, "Customer-2", 4000), "ATM-2");
        Thread t3 = new Thread(new Transaction(account, "Customer-3", 2000), "ATM-3");
        Thread t4 = new Thread(new Transaction(account, "Customer-4", 5000), "ATM-4");
        Thread t5 = new Thread(new Transaction(account, "Customer-5", 1500), "ATM-5");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();
        System.out.println("All transactions processed.");
    }
}
