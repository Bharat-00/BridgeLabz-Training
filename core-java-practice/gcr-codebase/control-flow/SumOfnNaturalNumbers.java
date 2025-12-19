import java.util.Scanner;
public class SumOfnNaturalNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num=sc.nextInt();
        if(num>=1){
            int sum = num*(num+1)/2;
            System.out.println("Sum of first "+num+" natural numbers is: "+sum);
        }
        else{
            System.out.println("Thne number "+num+" is not a natural number");
        }
        
    }
    
}
