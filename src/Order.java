import java.sql.Time;
import java.util.ArrayList;

public class Order {
    private Customer customer;
    private String orderID;
    private ArrayList<Food> foods = new ArrayList<>();
    private String orderTime;
    private String deliveryTime;
    private String originLocation;
    private String destinationLocation;
    private String orderStatus;
    private Comment comment;



    public Order(Customer customer, String orderID, ArrayList<Food> foods, String orderTime, String deliveryTime, String originLocation,
                 String destinationLocation) {
        this.customer = customer;
        this.orderID = orderID;
        this.foods = foods;
        this.orderTime = orderTime;
        this.deliveryTime = deliveryTime;
        this.originLocation = originLocation;
        this.destinationLocation = destinationLocation;
        this.orderStatus = "open";
    }

    public Customer getCustomer() {
        return customer;
    }

    public Comment getComment() {
        return comment;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public ArrayList<Food> getFood() {
        return foods;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getOriginLocation() {
        return originLocation;
    }

    public void setOriginLocation(String originLocation) {
        this.originLocation = originLocation;
    }

    public String getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(String destinationLocation) {
        this.destinationLocation = destinationLocation;
    }
    public String getTotalPrice () {
        int totalPrice = 0;
        for (Food food : foods) {
            totalPrice += Integer.parseInt(food.getPrice());
        }
        return Integer.toString(totalPrice);
    }
}
