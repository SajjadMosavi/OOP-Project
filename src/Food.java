import java.util.ArrayList;

public class Food {
    private String foodName;
    private String foodID;
    private String foodType;
    private Restaurant restaurant;
    private String foodBiography;
    private String  score;
    private Comment foodComment;
    private String foodStatus;
    private String price;
    private String discountPercentage;
    private String finalPrice = Integer.toString((1 - Integer.parseInt(discountPercentage) / 100 ) *
            Integer.parseInt(price));
    private Customer customer = new Customer();
    public Food(String foodType, String foodName, String foodID, Restaurant restaurant, String foodBiography,
                String price) {
        this.foodType = foodType;
        this.foodName = foodName;
        this.foodID = foodID;
        this.restaurant = restaurant;
        this.foodBiography = foodBiography;
        this.price = price;
        foodStatus = "active";
        discountPercentage = "0";
        score = "0";
    }

    public Customer getCustomer() {
        return customer;
    }


    public void setFoodStatus(String foodStatus) {
        this.foodStatus = foodStatus;
    }

    public String getFoodStatus() {
        return foodStatus;
    }

    public String getDiscountPercentage() {
        return discountPercentage;
    }

    public String getFinalPrice() {
        return finalPrice;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getFoodType() {
        return foodType;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getFoodID() {
        return foodID;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public String getFoodBiography() {
        return foodBiography;
    }

    public String getScore() {
        return score;
    }

    public Comment getFoodComment() {
        return foodComment;
    }

    public String getPrice() {
        return price;
    }
}
