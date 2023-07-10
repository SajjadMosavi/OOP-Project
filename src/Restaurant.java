import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private RestaurantOwner restaurantOwner;
    private String restaurantName;

    private String restaurantID;
    private String location;
    private ArrayList<Food> foodMenu = new ArrayList<>();
    private ArrayList<Comment> comments = new ArrayList<>();
    private String score;

    public Restaurant(RestaurantOwner restaurantOwner, String restaurantName, String restaurantID, String location) {
        this.restaurantOwner = restaurantOwner;
        this.restaurantName = restaurantName;
        this.restaurantID = restaurantID;
        this.location = location;
        score = "0";
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public String getRestaurantID() {
        return restaurantID;
    }
    public void removeFood (Food food) {
        foodMenu.remove(food);
    }


    public void setLocation(String location) {
        this.location = location;
    }

    public String getRestaurantName() {
        return restaurantName;
    }
    public String getLocation() {
        return location;
    }

    public ArrayList<Food> getFoodMenu() {
        return foodMenu;
    }

    public String getScore() {
        return score;
    }

    public void addFood(Food food) {
        foodMenu.add(food);
    }

    public RestaurantOwner getRestaurantOwner() {
        return restaurantOwner;
    }

}
