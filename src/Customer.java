import java.util.ArrayList;

public class Customer extends Person{

    private ArrayList<Food> cart = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();
    public Customer(String firstName, String lastName, String userName, String passWord, String nationalCode,
                    String location) {
        super(firstName, lastName, userName, passWord, nationalCode, location);
        wallet = "100";
    }

    public Customer() {

    }


    public ArrayList<Food> getCart() {
        return cart;
    }

    public void setCart(ArrayList<Food> cart) {
        this.cart = cart;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }
}
