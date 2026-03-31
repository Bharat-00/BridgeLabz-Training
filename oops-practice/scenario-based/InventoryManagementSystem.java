class OutOfStockException extends Exception {
    public OutOfStockException(String msg) {
        super(msg);
    }
}
interface AlertService {
    void sendAlert(String msg);
}
class Inventory implements AlertService {
    int stock = 5;
    void sellItem() throws OutOfStockException {
        if (stock == 0)
            throw new OutOfStockException("Out of Stock!");
        stock--;
        System.out.println("Item sold. Stock left: " + stock);
    }
    @Override
    public void sendAlert(String msg) {
        System.out.println("ALERT: " + msg);
    }
}
public class InventoryManagementSystem {
    public static void main(String[] args) throws Exception {
        Inventory inv = new Inventory();
        inv.sellItem();
    }
}
