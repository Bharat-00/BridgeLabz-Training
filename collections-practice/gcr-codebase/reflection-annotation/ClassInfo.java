import java.lang.reflect.*;
class Sample {
    private int value;
    public Sample() {}
    public void display() {}
}
public class ClassInfo {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("Sample");
        System.out.println("Class Name: " + cls.getName());
        System.out.println("\nFields:");
        for (Field field : cls.getDeclaredFields()) {
            System.out.println(field.getName());
        }
        System.out.println("\nMethods:");
        for (Method method : cls.getDeclaredMethods()) {
            System.out.println(method.getName());
        }
        System.out.println("\nConstructors:");
        for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
            System.out.println(constructor.getName());
        }
    }
}
