class Chef extends Thread {
    private String dishName;
    private int preparationTime;
    public Chef(String chefName, String dishName, double preparationSeconds) {
        super(chefName);
        this.dishName = dishName;
        this.preparationTime = (int) (preparationSeconds * 1000);
    }
    @Override
    public void run() {
        System.out.println(getName() + " started preparing " + dishName);
        int[] progressSteps = {25, 50, 75, 100};
        for (int progress : progressSteps) {
            try {
                Thread.sleep(preparationTime / 4); // divide time into 4 equal parts
            } catch (InterruptedException e) {
                System.out.println(getName() + " was interrupted.");
            }
            System.out.println(getName() + " preparing " + dishName +
                    ": " + progress + "% complete");
        }
        System.out.println(getName() + " completed " + dishName);
    }
}
public class RestaurantOrderProcessingSystem {
    public static void main(String[] args) throws InterruptedException {
        Chef chef1 = new Chef("Chef-1", "Pizza", 3);
        Chef chef2 = new Chef("Chef-2", "Pasta", 2);
        Chef chef3 = new Chef("Chef-3", "Salad", 1);
        Chef chef4 = new Chef("Chef-4", "Burger", 2.5);
        chef1.start();
        chef2.start();
        chef3.start();
        chef4.start();
        chef1.join();
        chef2.join();
        chef3.join();
        chef4.join();
        System.out.println("Kitchen closed - All orders completed");
    }
}
