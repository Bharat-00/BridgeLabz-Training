import java.util.*;
public class CheckSpringSeason {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the month number (1-12): ");
        int month=sc.nextInt();
        System.out.println("Enter the day of the month (1-31): ");
        int day=sc.nextInt();
        if(month>=3 && month<=6){
            if(month==3 && day>=20 || month==6 && day<=20){
                System.out.println("Its a spring season.");
            } else {
                System.out.println("Its not a spring season.");
            }
        } else {
            System.out.println("Its not a spring season.");
        }
    }
    
}
