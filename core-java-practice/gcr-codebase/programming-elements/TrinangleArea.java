import java.util.Scanner;
public class TrinangleArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the base of the triangle:");
        double base = sc.nextDouble();
        System.out.println("Enter the height of the triangle:");
        double height = sc.nextDouble();
        double areaSqCm = 0.5 * base * height;
        double areaSqIn = areaSqCm / (2.54 * 2.54);
        System.out.println("The Area of the triangle in sq in is " + areaSqIn +" and sq cm is " + areaSqCm);
    }
}