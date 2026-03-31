import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
class User {
    private String name;
    private int age;
    public String toString() {
        return "User{name='" + name + "', age=" + age + "}";
    }
}
public class ObjectMapper {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) throws Exception {
        T obj = clazz.getDeclaredConstructor().newInstance();
        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            Field field = clazz.getDeclaredField(entry.getKey());
            field.setAccessible(true);
            field.set(obj, entry.getValue());
        }
        return obj;
    }
    public static void main(String[] args) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Leo");
        map.put("age", 22);
        User user = toObject(User.class, map);
        System.out.println(user);
    }
}
