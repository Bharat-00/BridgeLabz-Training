class LegacyAPI {
    @Deprecated
    void oldFeature() {
        System.out.println("Old feature is deprecated");
    }
    void newFeature() {
        System.out.println("New feature is recommended");
    }
}
public class DeprecatedDemo {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        api.oldFeature();   // Generates warning
        api.newFeature();
    }
}
