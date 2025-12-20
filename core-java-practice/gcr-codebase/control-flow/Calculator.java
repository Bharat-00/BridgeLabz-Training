import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the first number: ");
        double first = sc.nextDouble();
        System.out.println("Enter the second number: ");
        double second = sc.nextDouble();
        System.out.println("Enter an operator (+, -, *, /): ");
        String op = sc.next();
        switch (op) {
            case "+" -> System.out.println(first + second);
            case "-" -> System.out.println(first - second);
            case "*" -> System.out.println(first * second);
            case "/" -> {
                if (second != 0) {
                    System.out.println(first / second);
                } else {
                    System.out.println("Division by zero not allowed");
                }
            }
            default -> System.out.println("Invalid Operator");
        }
    }
}
