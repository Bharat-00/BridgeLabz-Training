import java.util.*;
// Abstract Course Type
abstract class CourseType {
    protected String courseName;
    public CourseType(String courseName) {
        this.courseName = courseName;
    }
    public abstract String evaluationMethod();
}
// Different Evaluation Types
class ExamCourse extends CourseType {
    public ExamCourse(String name) {
        super(name);
    }
    @Override
    public String evaluationMethod() {
        return "Evaluation via Written Exams";
    }
}
class AssignmentCourse extends CourseType {
    public AssignmentCourse(String name) {
        super(name);
    }
    @Override
    public String evaluationMethod() {
        return "Evaluation via Assignments";
    }
}
class ResearchCourse extends CourseType {
    public ResearchCourse(String name) {
        super(name);
    }
    @Override
    public String evaluationMethod() {
        return "Evaluation via Research Work";
    }
}
// Generic Course Manager
class Course<T extends CourseType> {
    private List<T> courses = new ArrayList<>();
    public void addCourse(T course) {
        courses.add(course);
    }
    public List<T> getCourses() {
        return courses;
    }
}
// Utility using Wildcards
class CourseUtils {
    public static void displayCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            System.out.println(course.courseName + " → " + course.evaluationMethod());
        }
    }
}
// Main Class
public class UniversityCourseManager {
    public static void main(String[] args) {
        Course<ExamCourse> examCourses = new Course<>();
        examCourses.addCourse(new ExamCourse("Mathematics"));
        Course<AssignmentCourse> assignmentCourses = new Course<>();
        assignmentCourses.addCourse(new AssignmentCourse("Software Engineering"));
        Course<ResearchCourse> researchCourses = new Course<>();
        researchCourses.addCourse(new ResearchCourse("AI Research"));
        System.out.println("University Courses:");
        CourseUtils.displayCourses(examCourses.getCourses());
        CourseUtils.displayCourses(assignmentCourses.getCourses());
        CourseUtils.displayCourses(researchCourses.getCourses());
    }
}
