//Base class
class Employee {
    String name;
    int id;
    double salary;
    Employee(String name,int id,double salary){
        this.name=name;
        this.id=id;
        this.salary=salary;
    }
    void displayDetails(){
        System.out.println("Name:"+name);
        System.out.println("Id:"+id);
        System.out.println("Salary:"+salary);
    }
}
//Manager subclass
class Manager extends Employee{
    int teamSize;
    Manager(String name,int id,double salary,int teamSize){
        super(name,id,salary);
        this.teamSize=teamSize;
    }
    @Override
    void displayDetails(){
        super.displayDetails();
        System.out.println("TeamSize:"+teamSize);
    }
}
//Developer subclass
class Developer extends Employee{
    String programmingLanguage;
    Developer(String name,int id,double salary,String programmingLanguage){
        super(name,id,salary);
        this.programmingLanguage=programmingLanguage;
    }
    @Override
    void displayDetails(){
        super.displayDetails();
        System.out.println("Language:"+programmingLanguage);
    }
}
//Intern subclass
class Intern extends Employee{
    int durationMonths;
    Intern(String name,int id,double salary,int durationMonths){
        super(name,id,salary);
        this.durationMonths=durationMonths;
    }
    @Override
    void displayDetails(){
        super.displayDetails();
        System.out.println("DurationMonths:"+durationMonths);
    }
}
public class EmployeeManagement {
    public static void main(String[] args){
        Employee e1=new Manager("Ravi",101,80000,5);
        Employee e2=new Developer("Aman",102,60000,"Java");
        Employee e3=new Intern("Neha",103,15000,6);
        e1.displayDetails();
        System.out.println();
        e2.displayDetails();
        System.out.println();
        e3.displayDetails();
    }
}
