import java.util.ArrayList;
import java.util.List;
// Category marker interfaces
interface Category {
    double getMaxPrice();
}
class BookCategory implements Category {
    public double getMaxPrice() {
        return 1000;
    }
}
class ClothingCategory implements Category {
    public double getMaxPrice() {
        return 5000;
    }
}
class GadgetCategory implements Category {
    public double getMaxPrice() {
        return 50000;
    }
}
// Generic Product class
class Product<T extends Category> {
    private String name;
    private double price;
    private T category;
    public Product(String name, double price, T category) {
        if (price > category.getMaxPrice()) {
            throw new IllegalArgumentException("Price exceeds category limit");
        }
        this.name = name;
        this.price = price;
        this.category = category;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public double getPrice() {
        return price;
    }
    public String getDetails() {
        return name + " | Price: " + price + " | Category: " + category.getClass().getSimpleName();
    }
}
// Utility class with generic method
class DiscountUtil {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discountedPrice = product.getPrice() -
                (product.getPrice() * percentage / 100);
        product.setPrice(discountedPrice);
    }
}
// Main class
public class OnlineMarketplaceApp {
    public static void main(String[] args) {
        List<Product<?>> catalog = new ArrayList<>();
        Product<BookCategory> book =
                new Product<>("Java Programming", 800, new BookCategory());
        Product<ClothingCategory> shirt =
                new Product<>("T-Shirt", 1200, new ClothingCategory());
        Product<GadgetCategory> phone =
                new Product<>("Smartphone", 30000, new GadgetCategory());
        catalog.add(book);
        catalog.add(shirt);
        catalog.add(phone);
        DiscountUtil.applyDiscount(book, 10);
        DiscountUtil.applyDiscount(phone, 5);
        System.out.println("=== Product Catalog ===");
        for (Product<?> product : catalog) {
            System.out.println(product.getDetails());
        }
    }
}
