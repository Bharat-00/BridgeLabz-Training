import java.util.Scanner;
public class CheckSmallestOfTheThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();
        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();
        System.out.print("Enter third number: ");
        int num3 = sc.nextInt();
        if(num1<num2 && num1<num3){
            System.out.println("yes, first number is the smallest");
        }
        else{
            System.out.println("no, first number is not the smallest");
        }
    }
    
}
