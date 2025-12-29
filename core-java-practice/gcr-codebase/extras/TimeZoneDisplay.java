import java.time.ZoneId;
import java.time.ZonedDateTime;
public class TimeZoneDisplay {
    public static void main(String[] args) {
        // Current time in GMT
        ZonedDateTime gmtTime = ZonedDateTime.now(ZoneId.of("GMT"));
        // Current time in Indian Standard Time
        ZonedDateTime istTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        // Current time in Pacific Standard Time
        ZonedDateTime pstTime = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
        // Display results
        System.out.println("Current Time in Different Time Zones:");
        System.out.println("-------------------------------------");
        System.out.println("GMT (Greenwich Mean Time): " + gmtTime);
        System.out.println("IST (Indian Standard Time): " + istTime);
        System.out.println("PST (Pacific Standard Time): " + pstTime);
    }
}
