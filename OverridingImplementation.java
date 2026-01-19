import java.util.*;
class Animal{
    void eat(int a){
        System.out.println("Human is eating");
    }
}
class Dog extends Animal{
    @Override
    void eat(int a){
        System.out.println("Dog is eating");
    }
}
public class OverridingImplementation{
	public static void main(String[] args) {
	    Scanner sc =new Scanner(System.in);
	    Animal animal =new Animal();
	    Dog dog=new Dog();
	    System.out.println("Enter the num: ");
		int n=sc.nextInt();
		animal.eat(n);
		dog.eat(n);
		
	}
}
