@FunctionalInterface
interface LightBehavior {
    void activate();
}
public class SmartHomeLighting {
    public static void main(String[] args) {
        // Lambda for motion detection
        LightBehavior motionTrigger = () ->
                System.out.println("Motion detected → Lights turned ON at full brightness");
        // Lambda for time of day (night mode)
        LightBehavior nightTimeTrigger = () ->
                System.out.println("Night time → Lights set to dim mode");
        // Lambda for voice command
        LightBehavior voiceCommandTrigger = () ->
                System.out.println("Voice command received → Lights adjusted as requested");
        // Executing different light patterns dynamically
        motionTrigger.activate();
        nightTimeTrigger.activate();
        voiceCommandTrigger.activate();
    }
}
