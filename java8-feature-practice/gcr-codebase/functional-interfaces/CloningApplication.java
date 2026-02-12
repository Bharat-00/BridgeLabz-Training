// Cloneable marker interface
class Product implements Cloneable {
    private String name;
    public Product(String name) {
        this.name = name;
    }
    // Provides clone implementation
    public Product clone() throws CloneNotSupportedException {
        return (Product) super.clone();
    }
    public String getName() {
        return name;
    }
}
public class CloningApplication {
    public static void main(String[] args) throws Exception {
        Product original = new Product("Laptop");
        Product copy = original.clone();
        System.out.println("Original: " + original.getName());
        System.out.println("Cloned: " + copy.getName());
    }
}
