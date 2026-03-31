import java.lang.annotation.*;
import java.lang.reflect.Method;
// Step 1: Define annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}
// Service class
class Service {
    @ImportantMethod
    public void saveData() {
        System.out.println("Data saved");
    }
    @ImportantMethod(level = "MEDIUM")
    public void updateData() {
        System.out.println("Data updated");
    }
    public void deleteData() {
        System.out.println("Data deleted");
    }
}
// Step 2 & 3: Retrieve annotated methods
public class ImportantMethodDemo {
    public static void main(String[] args) {
        Method[] methods = Service.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod im =
                        method.getAnnotation(ImportantMethod.class);
                System.out.println(
                        "Method: " + method.getName() +
                        ", Importance Level: " + im.level()
                );
            }
        }
    }
}
