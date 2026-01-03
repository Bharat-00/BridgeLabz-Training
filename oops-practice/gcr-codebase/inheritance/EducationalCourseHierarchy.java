//Base class
class Course {
    String courseName;
    int duration;
    Course(String courseName,int duration){
        this.courseName=courseName;
        this.duration=duration;
    }
    void displayCourseDetails(){
        System.out.println("CourseName:"+courseName);
        System.out.println("Duration:"+duration+"Weeks");
    }
}
//First level subclass
class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;
    OnlineCourse(String courseName,int duration,String platform,boolean isRecorded){
        super(courseName,duration);
        this.platform=platform;
        this.isRecorded=isRecorded;
    }
    @Override
    void displayCourseDetails(){
        super.displayCourseDetails();
        System.out.println("Platform:"+platform);
        System.out.println("Recorded:"+isRecorded);
    }
}
//Second level subclass
class PaidOnlineCourse extends OnlineCourse {
    double fee;
    double discount;
    PaidOnlineCourse(String courseName,int duration,String platform,boolean isRecorded,double fee,double discount){
        super(courseName,duration,platform,isRecorded);
        this.fee=fee;
        this.discount=discount;
    }
    @Override
    void displayCourseDetails(){
        super.displayCourseDetails();
        System.out.println("Fee:"+fee);
        System.out.println("Discount:"+discount+"%");
    }
}
public class EducationalCourseHierarchy {
    public static void main(String[] args){
        PaidOnlineCourse course=new PaidOnlineCourse(
                "JavaFullStack",
                12,
                "Udemy",
                true,
                15000,
                20
        );
        course.displayCourseDetails();
    }
}
