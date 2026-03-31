//Base class
class BankAccount {
    int accountNumber;
    double balance;
    BankAccount(int accountNumber,double balance){
        this.accountNumber=accountNumber;
        this.balance=balance;
    }
}
//SavingsAccount subclass
class SavingsAccount extends BankAccount {
    double interestRate;
    SavingsAccount(int accountNumber,double balance,double interestRate){
        super(accountNumber,balance);
        this.interestRate=interestRate;
    }
    void displayAccountType(){
        System.out.println("AccountType:SavingsAccount");
    }
}
//CheckingAccount subclass
class CheckingAccount extends BankAccount {
    double withdrawalLimit;
    CheckingAccount(int accountNumber,double balance,double withdrawalLimit){
        super(accountNumber,balance);
        this.withdrawalLimit=withdrawalLimit;
    }
    void displayAccountType(){
        System.out.println("AccountType:CheckingAccount");
    }
}
//FixedDepositAccount subclass
class FixedDepositAccount extends BankAccount {
    int lockInPeriod;
    FixedDepositAccount(int accountNumber,double balance,int lockInPeriod){
        super(accountNumber,balance);
        this.lockInPeriod=lockInPeriod;
    }
    void displayAccountType(){
        System.out.println("AccountType:FixedDepositAccount");
    }
}
public class BankAccountTypes {
    public static void main(String[] args){
        BankAccount acc1=new SavingsAccount(1001,50000,4.5);
        BankAccount acc2=new CheckingAccount(1002,30000,10000);
        BankAccount acc3=new FixedDepositAccount(1003,100000,12);
        ((SavingsAccount)acc1).displayAccountType();
        ((CheckingAccount)acc2).displayAccountType();
        ((FixedDepositAccount)acc3).displayAccountType();
    }
}
