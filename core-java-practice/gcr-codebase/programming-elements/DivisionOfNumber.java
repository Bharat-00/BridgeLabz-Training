import java.util.Scanner;
public class DivisionOfNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the dividend:");
        double number1=sc.nextDouble();
        System.out.println("Enter the divisor:");
        double number2=sc.nextDouble();
        double quotient=number1/number2;
        int remainder=(int)number1%(int)number2;
        System.out.println("The Quotient is " + quotient +" and Reminder is " + remainder +" of two number " + number1 + " and " + number2);
    }
}
