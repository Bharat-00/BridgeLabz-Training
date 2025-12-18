import java.util.*;
public class temperatureConversion {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the temp in celsius:");
        float t =sc.nextFloat();
        float f= (t*9/5)+32;
        System.out.println("temp in fahrenheit:"+f);
    }
    
}
