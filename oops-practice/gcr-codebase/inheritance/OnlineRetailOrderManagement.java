//Base class
class Order {
    int orderId;
    String orderDate;
    Order(int orderId,String orderDate){
        this.orderId=orderId;
        this.orderDate=orderDate;
    }
    //Method to return order status
    String getOrderStatus(){
        return "OrderPlaced";
    }
}
//First level subclass
class ShippedOrder extends Order {
    @SuppressWarnings("unused")
    String trackingNumber;
    ShippedOrder(int orderId,String orderDate,String trackingNumber){
        super(orderId,orderDate);
        this.trackingNumber=trackingNumber;
    }
    @Override
    String getOrderStatus(){
        return "OrderShipped";
    }
}
//Second level subclass
class DeliveredOrder extends ShippedOrder {
    @SuppressWarnings("unused")
    String deliveryDate;
    DeliveredOrder(int orderId,String orderDate,String trackingNumber,String deliveryDate){
        super(orderId,orderDate,trackingNumber);
        this.deliveryDate=deliveryDate;
    }
    @Override
    String getOrderStatus(){
        return "OrderDelivered";
    }
}
public class OnlineRetailOrderManagement {
    public static void main(String[] args){
        Order order=new Order(101,"01-08-2024");
        ShippedOrder shipped=new ShippedOrder(102,"02-08-2024","TRK12345");
        DeliveredOrder delivered=new DeliveredOrder(103,"03-08-2024","TRK67890","05-08-2024");
        System.out.println("OrderStatus:"+order.getOrderStatus());
        System.out.println("ShippedOrderStatus:"+shipped.getOrderStatus());
        System.out.println("DeliveredOrderStatus:"+delivered.getOrderStatus());
    }
}
