import java.lang.reflect.*;
interface Greeting {
    void sayHello();
}
class GreetingImpl implements Greeting {
    public void sayHello() {
        System.out.println("Hello from Greeting!");
    }
}
class LoggingHandler implements InvocationHandler {
    private Object target;
    LoggingHandler(Object target) {
        this.target = target;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Executing method: " + method.getName());
        return method.invoke(target, args);
    }
}
public class LoggingProxy {
    public static void main(String[] args) {
        Greeting greeting = new GreetingImpl();
        Greeting proxy = (Greeting) Proxy.newProxyInstance(
                greeting.getClass().getClassLoader(),
                greeting.getClass().getInterfaces(),
                new LoggingHandler(greeting)
        );
        proxy.sayHello();
    }
}
