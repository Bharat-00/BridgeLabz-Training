import java.lang.reflect.Field;
class Configuration {
    private static final String API_KEY = "OLD_KEY";
}
public class ModifyStaticFinal {
    public static void main(String[] args) throws Exception {
        Field field = Configuration.class.getDeclaredField("API_KEY");
        field.setAccessible(true);
        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(field, field.getModifiers() & ~java.lang.reflect.Modifier.FINAL);
        field.set(null, "NEW_KEY");
        System.out.println("Modified API_KEY: " + field.get(null));
    }
}
