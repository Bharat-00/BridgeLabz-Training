import java.util.Scanner;
public class LaunchCountdown {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the countdown start number: ");
        int counter = sc.nextInt();
        while (counter >= 0) {
            System.out.println(counter);
            counter--;
        }
    }    
}
