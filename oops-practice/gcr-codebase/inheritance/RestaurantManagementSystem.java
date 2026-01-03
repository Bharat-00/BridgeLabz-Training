//Interface representing worker behavior
interface Worker {
    void performDuties();
}
//Superclass
class Person {
    String name;
    int id;
    Person(String name,int id){
        this.name=name;
        this.id=id;
    }
}
//Chef class inheriting Person and implementing Worker
class Chef extends Person implements Worker {
    Chef(String name,int id){
        super(name,id);
    }
    @Override
    public void performDuties(){
        System.out.println("ChefPreparesFood");
    }
}
//Waiter class inheriting Person and implementing Worker
class Waiter extends Person implements Worker {
    Waiter(String name,int id){
        super(name,id);
    }
    @Override
    public void performDuties(){
        System.out.println("WaiterServesCustomers");
    }
}
public class RestaurantManagementSystem {
    public static void main(String[] args){
        Worker w1=new Chef("Rohit",101);
        Worker w2=new Waiter("Amit",102);
        w1.performDuties();
        w2.performDuties();
    }
}
