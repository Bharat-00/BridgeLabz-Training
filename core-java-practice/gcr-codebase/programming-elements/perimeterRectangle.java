import java.util.*;
public class PerimeterRectangle {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the length of the rectangle:");
        float length=sc.nextFloat();
        System.out.println("Enter the width of the rectangle:");
        float width=sc.nextFloat();
        double perimeter=2*(length+width);
        System.out.println("The perimeter of the rectangle is:"+perimeter);
    }
    
}
