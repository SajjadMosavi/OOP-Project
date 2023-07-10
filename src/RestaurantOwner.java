import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class RestaurantOwner extends Person {
    private ArrayList<Restaurant> restaurants = new ArrayList<>();

    public RestaurantOwner(String firstName, String lastName, String userName, String passWord, String nationalCode,
                           String location) {
        super(firstName, lastName, userName, passWord, nationalCode, location);
    }
    /*public String showRestaurant (ArrayList<Restaurant> restaurants){
        ArrayList<String>
        Collections.sort(restaurants);
    }*/
    public void addRestaurant (Restaurant restaurant) {
        restaurants.add(restaurant);
    }

    public ArrayList<Restaurant> getRestaurants() {
        return restaurants;
    }
}
