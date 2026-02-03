class Student {
    Student() {
        System.out.println("Student object created");
    }
}
public class CreateObjectDynamically {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("Student");
        Object obj = cls.getDeclaredConstructor().newInstance();
    }
}
