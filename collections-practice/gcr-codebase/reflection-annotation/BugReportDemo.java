import java.lang.annotation.*;
import java.lang.reflect.Method;
// Container annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}
// Repeatable annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}
class BugTracker {
    @BugReport(description = "NullPointerException occurs")
    @BugReport(description = "Performance issue on large input")
    public void process() {
        System.out.println("Processing...");
    }
}
public class BugReportDemo {
    public static void main(String[] args) throws Exception {
        Method method = BugTracker.class.getMethod("process");
        BugReport[] reports = method.getAnnotationsByType(BugReport.class);
        for (BugReport report : reports) {
            System.out.println("Bug: " + report.description());
        }
    }
}
