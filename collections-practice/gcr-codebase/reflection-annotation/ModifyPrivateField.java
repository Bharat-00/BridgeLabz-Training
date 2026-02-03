import java.lang.reflect.Field;
class Person {
    private int age = 20;
}
public class ModifyPrivateField {
    public static void main(String[] args) throws Exception {
        Person person = new Person();
        Field field = Person.class.getDeclaredField("age");
        field.setAccessible(true);
        field.set(person, 25);
        System.out.println("Modified Age: " + field.get(person));
    }
}
