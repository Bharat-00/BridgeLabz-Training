import java.lang.reflect.Method;
class Task {
    public void runTask() {
        for (int i = 0; i < 1_000_000; i++) {}
    }
}
public class MethodTiming {
    public static void main(String[] args) throws Exception {
        Task task = new Task();
        Method method = Task.class.getMethod("runTask");
        long startTime = System.nanoTime();
        method.invoke(task);
        long endTime = System.nanoTime();
        System.out.println("Execution Time (ns): " + (endTime - startTime));
    }
}
