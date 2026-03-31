import java.util.*;
class BankingSystem {
    // Stores account balance (AccountNumber -> Balance)
    private HashMap<Integer, Integer> accounts = new HashMap<>();
    // Withdrawal requests
    private Queue<Integer> withdrawalQueue = new LinkedList<>();
    // Add account
    public void addAccount(int accountNumber, int balance) {
        accounts.put(accountNumber, balance);
    }
    // Request withdrawal
    public void requestWithdrawal(int accountNumber) {
        withdrawalQueue.add(accountNumber);
    }
    // Process withdrawals
    public void processWithdrawals(int amount) {
        while (!withdrawalQueue.isEmpty()) {
            int accNo = withdrawalQueue.poll();
            int balance = accounts.get(accNo);
            if (balance >= amount) {
                accounts.put(accNo, balance - amount);
                System.out.println("Withdrawal successful for Account " + accNo);
            } else {
                System.out.println("Insufficient balance for Account " + accNo);
            }
        }
    }
    // Display customers sorted by balance
    public void displaySortedByBalance() {
        TreeMap<Integer, Integer> sorted = new TreeMap<>();
        for (Map.Entry<Integer, Integer> entry : accounts.entrySet()) {
            sorted.put(entry.getValue(), entry.getKey());
        }
        System.out.println("Accounts Sorted By Balance: " + sorted);
    }
    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();
        bank.addAccount(101, 5000);
        bank.addAccount(102, 12000);
        bank.addAccount(103, 3000);
        bank.requestWithdrawal(101);
        bank.requestWithdrawal(103);
        bank.processWithdrawals(2000);
        bank.displaySortedByBalance();
    }
}
