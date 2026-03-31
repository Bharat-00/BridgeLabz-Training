//Base class
class Person {
    String name;
    int age;
    Person(String name,int age){
        this.name=name;
        this.age=age;
    }
}
//Teacher subclass
class Teacher extends Person {
    String subject;
    Teacher(String name,int age,String subject){
        super(name,age);
        this.subject=subject;
    }
    void displayRole(){
        System.out.println("Role:Teacher");
    }
}
//Student subclass
class Student extends Person {
    String grade;
    Student(String name,int age,String grade){
        super(name,age);
        this.grade=grade;
    }
    void displayRole(){
        System.out.println("Role:Student");
    }
}
//Staff subclass
class Staff extends Person {
    String department;
    Staff(String name,int age,String department){
        super(name,age);
        this.department=department;
    }
    void displayRole(){
        System.out.println("Role:Staff");
    }
}
public class SchoolSystemWithDifferentRoles {
    public static void main(String[] args){
        Person p1=new Teacher("Ramesh",40,"Maths");
        Person p2=new Student("Anita",16,"10th");
        Person p3=new Staff("Suresh",35,"Admin");
        ((Teacher)p1).displayRole();
        ((Student)p2).displayRole();
        ((Staff)p3).displayRole();
    }
}
