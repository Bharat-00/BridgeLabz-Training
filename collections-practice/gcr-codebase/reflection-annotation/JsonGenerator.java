import java.lang.reflect.Field;
class Person {
    String name;
    int age;
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
public class JsonGenerator {
    public static String toJson(Object obj) throws IllegalAccessException {
        StringBuilder json = new StringBuilder("{");
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            json.append("\"").append(fields[i].getName()).append("\": ");
            json.append("\"").append(fields[i].get(obj)).append("\"");
            if (i < fields.length - 1) {
                json.append(", ");
            }
        }
        json.append("}");
        return json.toString();
    }
    public static void main(String[] args) throws Exception {
        Person person = new Person("Leo", 25);
        System.out.println(toJson(person));
    }
}
