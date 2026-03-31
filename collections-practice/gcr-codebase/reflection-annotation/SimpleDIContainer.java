import java.lang.annotation.*;
import java.lang.reflect.Field;
@Retention(RetentionPolicy.RUNTIME)
@interface Inject {}
class Service {
    void serve() {
        System.out.println("Service is running");
    }
}
class Client {
    @Inject
    private Service service;
    void execute() {
        service.serve();
    }
}
public class SimpleDIContainer {
    public static void injectDependencies(Object obj) throws Exception {
        for (Field field : obj.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                field.set(obj, field.getType().getDeclaredConstructor().newInstance());
            }
        }
    }
    public static void main(String[] args) throws Exception {
        Client client = new Client();
        injectDependencies(client);
        client.execute();
    }
}
