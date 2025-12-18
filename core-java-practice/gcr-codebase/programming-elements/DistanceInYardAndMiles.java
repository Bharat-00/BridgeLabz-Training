import java.util.Scanner;
public class DistanceInYardAndMiles {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double distanceInFeet = input.nextDouble();
        double yards = distanceInFeet / 3;
        double miles = yards / 1760;
        System.out.println("The distance in feet is " + distanceInFeet +" while in yards is " + yards +" and miles is " + miles);
    }
}
