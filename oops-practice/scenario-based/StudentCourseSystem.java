class CourseLimitExceededException extends Exception {
    public CourseLimitExceededException(String msg) {
        super(msg);
    }
}
abstract class Person {
    String name;
}
class Student extends Person {
    int courseCount = 0;
    void enrollCourse() throws CourseLimitExceededException {
        if (courseCount >= 5)
            throw new CourseLimitExceededException("Course limit exceeded");
        courseCount++;
        System.out.println("Course enrolled. Total: " + courseCount);
    }
}
public class StudentCourseSystem {
    public static void main(String[] args) throws Exception {
        Student s = new Student();
        s.enrollCourse();
    }
}
