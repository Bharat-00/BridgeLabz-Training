//Superclass
class Animal {
    String name;
    int age;
    Animal(String name,int age){
        this.name=name;
        this.age=age;
    }
    //Method to be overridden
    void makeSound(){
        System.out.println("AnimalMakesSound");
    }
}
//Subclass Dog
class Dog extends Animal{
    Dog(String name,int age){
        super(name,age);
    }
    @Override
    void makeSound(){
        System.out.println("DogBarks");
    }
}
//Subclass Cat
class Cat extends Animal{
    Cat(String name,int age){
        super(name,age);
    }
    @Override
    void makeSound(){
        System.out.println("CatMeows");
    }
}
//Subclass Bird
class Bird extends Animal{
    Bird(String name,int age){
        super(name,age);
    }
    @Override
    void makeSound(){
        System.out.println("BirdChirps");
    }
}
public class AnimalHierarchy {
    public static void main(String[] args){
        Animal a1=new Dog("Buddy",3);
        Animal a2=new Cat("Kitty",2);
        Animal a3=new Bird("Tweety",1);
        a1.makeSound();
        a2.makeSound();
        a3.makeSound();
    }
}
