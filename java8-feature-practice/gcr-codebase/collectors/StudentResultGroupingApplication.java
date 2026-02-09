import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
public class StudentResultGroupingApplication {
    public static void main(String[] args) {
        // Student list
        List<Student> students = Arrays.asList(
                new Student("Amit", "A"),
                new Student("Neha", "B"),
                new Student("Ravi", "A"),
                new Student("Ananya", "C")
        );
        // Groups student names by grade
        Map<String, List<String>> studentsByGrade = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGrade,
                        Collectors.mapping(Student::getName, Collectors.toList())
                ));
        studentsByGrade.forEach((grade, names) ->
                System.out.println(grade + " -> " + names));
    }
}
class Student {
    private String name;
    private String grade;
    public Student(String name, String grade) {
        this.name = name;
        this.grade = grade;
    }
    public String getName() {
        return name;
    }
    public String getGrade() {
        return grade;
    }
}
