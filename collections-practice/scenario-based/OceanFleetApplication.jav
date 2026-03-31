import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// Vessel model class
class Vessel {
    private String vesselId;
    private String vesselName;
    private double averageSpeed;
    private String vesselType;
    // No-argument constructor
    public Vessel() {
    }
    // Parameterized constructor
    public Vessel(String vesselId, String vesselName, double averageSpeed, String vesselType) {
        this.vesselId = vesselId;
        this.vesselName = vesselName;
        this.averageSpeed = averageSpeed;
        this.vesselType = vesselType;
    }
    public String getVesselId() {
        return vesselId;
    }
    public String getVesselName() {
        return vesselName;
    }
    public double getAverageSpeed() {
        return averageSpeed;
    }
    public String getVesselType() {
        return vesselType;
    }
}
// Utility class to manage vessels
class VesselUtil {
    private List<Vessel> vesselList = new ArrayList<>();
    // Adds a vessel to the list
    public void addVesselPerformance(Vessel vessel) {
        vesselList.add(vessel);
    }
    // Retrieves vessel details by vesselId
    public Vessel getVesselById(String vesselId) {
        for (Vessel vessel : vesselList) {
            if (vessel.getVesselId().equals(vesselId)) {
                return vessel;
            }
        }
        return null;
    }
    // Retrieves vessels with the highest average speed
    public List<Vessel> getHighPerformanceVessels() {
        List<Vessel> result = new ArrayList<>();
        double maxSpeed = 0;
        for (Vessel vessel : vesselList) {
            if (vessel.getAverageSpeed() > maxSpeed) {
                maxSpeed = vessel.getAverageSpeed();
            }
        }
        for (Vessel vessel : vesselList) {
            if (vessel.getAverageSpeed() == maxSpeed) {
                result.add(vessel);
            }
        }
        return result;
    }
}
// Main application class
public class OceanFleetApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VesselUtil vesselUtil = new VesselUtil();
        // Reads number of vessels
        int numberOfVessels = Integer.parseInt(scanner.nextLine());
        // Reads vessel details
        for (int i = 0; i < numberOfVessels; i++) {
            String input = scanner.nextLine();
            String[] data = input.split(":");
            String vesselId = data[0];
            String vesselName = data[1];
            double averageSpeed = Double.parseDouble(data[2]);
            String vesselType = data[3];
            Vessel vessel = new Vessel(vesselId, vesselName, averageSpeed, vesselType);
            vesselUtil.addVesselPerformance(vessel);
        }
        // Reads vesselId to check
        String searchVesselId = scanner.nextLine();
        Vessel vessel = vesselUtil.getVesselById(searchVesselId);
        if (vessel != null) {
            System.out.println(
                    vessel.getVesselId() + " | " +
                    vessel.getVesselName() + " | " +
                    vessel.getVesselType() + " | " +
                    vessel.getAverageSpeed() + " knots"
            );
        } else {
            System.out.println("Vessel Id " + searchVesselId + " not found");
        }
        // Displays high performance vessels
        System.out.println("High performance vessels are");
        List<Vessel> highPerformanceVessels = vesselUtil.getHighPerformanceVessels();
        for (Vessel v : highPerformanceVessels) {
            System.out.println(
                    v.getVesselId() + " | " +
                    v.getVesselName() + " | " +
                    v.getVesselType() + " | " +
                    v.getAverageSpeed() + " knots"
            );
        }
        scanner.close();
    }
}
