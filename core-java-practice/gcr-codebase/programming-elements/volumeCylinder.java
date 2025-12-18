import java.util.*;
public class volumeCylinder {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the height of the cylinder:");
        float h=sc.nextFloat();
        System.out.println("Enter the radius:");
        float r=sc.nextFloat();
        float volume=(float) (3.14*(r*r)*h);
        System.out.println("Volume of the cylinder is:"+ volume);
    }
    
}
