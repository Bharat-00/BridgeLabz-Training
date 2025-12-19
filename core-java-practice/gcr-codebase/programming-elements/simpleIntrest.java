import java.util.*;
public class SimpleIntrest {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the principle amount:");
        double p=sc.nextDouble();
        System.out.println("Enter the rate:");
        int r= sc.nextInt();
        System.out.println("Enter the time:");
        int t=sc.nextInt();
        double intrest=(p*r*t)/100;
        System.out.println("The simple intrest is:"+intrest);
    }
}
