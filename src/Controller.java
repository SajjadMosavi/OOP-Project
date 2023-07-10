import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Controller {
    //HashMap<String, ArrayList<Comment>> salam = new HashMap<>();
    private ArrayList<RestaurantOwner> restaurantOwners = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Person> people = new ArrayList<>();
    private ArrayList<Restaurant> restaurants = new ArrayList<>();
    private ArrayList<String> restaurantsID = new ArrayList<>();
    private ArrayList<String> foodsID = new ArrayList<>();
    private ArrayList<Food> foods = new ArrayList<>();
    private ArrayList<String> ordersID = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();
    private ArrayList<String> commentsID = new ArrayList<>();
    private ArrayList<Comment> comments = new ArrayList<>();



    public String addFoodToCart (Food food, Customer customer) {
        if (food.getFoodStatus().equalsIgnoreCase("active")){
            customer.getCart().add(food);
            return "food add successful";
        }
        else {
            return "food is over";
        }
    }

    public String showRestaurantsByName (String restaurantName){
        StringBuilder showRestaurantsByName = new StringBuilder("");
        showRestaurantsByName.append("Restaurant Name").append("\t").append("Restaurant ID").append("\n");
        for (Restaurant restaurant : searchRestaurantByRestaurantName(restaurantName)) {
            showRestaurantsByName.append(restaurant.getRestaurantName()).append("\t").append(restaurant.getRestaurantID())
                    .append("\n");
        }
        return showRestaurantsByName.toString();
    }
    public String showFoodsByName (String foodName, Restaurant restaurant){
        StringBuilder showFoodsByName = new StringBuilder("");
        showFoodsByName.append("Food Name").append("\t").append("Food ID").append("\n");
        for (Food food : searchFoodByFoodName(foodName, restaurant)) {
            showFoodsByName.append(food.getFoodName()).append("\t").append(food.getFoodID())
                    .append("\n");
        }
        return showFoodsByName.toString();
    }
    public String displayCart (Customer customer){
        StringBuilder cart = new StringBuilder("");
        cart.append("Restaurant Name").append("\t").append("Food Name").append("\t").append("Food ID").append("\n");
        for (Food food : customer.getCart()) {
            cart.append(food.getRestaurant().getRestaurantName()).append("\t").append(food.getFoodName()).append("\t")
                    .append(food.getFoodID()).append("\n");
        }
        return cart.toString();
    }

    public ArrayList<Food> searchFoodByFoodName (String foodName, Restaurant restaurant) {
        ArrayList<Food> foods = new ArrayList<>();
        for (Food food : restaurant.getFoodMenu()) {
            if (food.getFoodName().equals(foodName)){
                foods.add(food);
            }
        }
        return foods;
    }
    public ArrayList<Restaurant> searchRestaurantByRestaurantName (String restaurantName) {
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        for (Restaurant restaurant : this.restaurants) {
            if (restaurant.getRestaurantName().equals(restaurantName)){
                restaurants.add(restaurant);
            }
        }
        return restaurants;
    }

    public Comment searchCommentByCommentID (String commentID){
        for (Comment comment : comments) {
            if (comment.getCommentID().equals(commentID)){
                return comment;
            }
        }
        return null;
    }
    public Restaurant searchRestaurantByRestaurantID (String restaurantID){
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getRestaurantID().equals(restaurantID)){
                return restaurant;
            }
        }
        return null;
    }

    public Order searchOrderByOrderID (String orderID){
        for (Order order : orders) {
            if (order.getOrderID().equals(orderID)){
                return order;
            }
        }
        return null;
    }

    public RestaurantOwner searchRestaurantOwnerByNationalCode (String nationalCode){
        for (RestaurantOwner restaurantOwner : restaurantOwners) {
            if (restaurantOwner.getNationalCode().equals(nationalCode)){
                return restaurantOwner;
            }
        }
        return null;
    }

    public RestaurantOwner searchRestaurantOwnerByUserName (String userName){
        for (RestaurantOwner restaurantOwner : restaurantOwners) {
            if (restaurantOwner.getUserName().equals(userName)){
                return restaurantOwner;
            }
        }
        return null;
    }


    public Customer searchCustomerByNationalCode (String nationalCode){
        for (Customer customer : customers) {
            if (customer.getUserName().equals(nationalCode)){
                return customer;
            }
        }
        return null;
    }
    public Customer searchCustomerByUserName (String userName){
        for (Customer customer : customers) {
            if (customer.getUserName().equals(userName)){
                return customer;
            }
        }
        return null;
    }

    public Food searchFoodByFoodID (String foodID){
        for (Food food : foods) {
            if (food.getFoodID().equals(foodID)){
                return food;
            }
        }
        return null;
    }

    public String editRestaurantLocation(Restaurant restaurant, String restaurantLocation){
        restaurants.remove(restaurant);
        restaurant.setLocation(restaurantLocation);
        restaurants.add(restaurant);
        return "edit restaurant location successful";
    }

    public String editFoodName(Food food, String foodName) {
        foods.remove(food);
        food.setFoodName(foodName);
        foods.add(food);
        return "edit food name successful";
    }
    public String editOrderStatus(Order order, String orderStatus) {
        orders.remove(order);
        order.setOrderStatus(orderStatus);
        orders.add(order);
        return "edit order status successful";
    }
    public String editResponse(Comment comment, String response) {
        comments.remove(comment);
        comment.getResponse().setComment(response);
        comments.add(comment);
        return "edit response successful";
    }
    public String deleteFood(Food food) {
        foods.remove(food);
        foodsID.remove(food.getFoodID());
        food.getRestaurant().removeFood(food);
        return "delete food name successful";
    }
    public String editFoodPrice(Food food, String foodPrice) {
        foods.remove(food);
        food.setFoodName(foodPrice);
        foods.add(food);
        return "edit food price successful";
    }
    public String activeFood(Food food) {
        foods.remove(food);
        food.setFoodStatus("active");
        foods.add(food);
        return "edit food status successful";
    }
    public String deActiveFood(Food food) {
        foods.remove(food);
        food.setFoodStatus("deActive");
        foods.add(food);
        return "edit food status successful";
    }

    public String addRestaurantOwner(String firstName, String lastName, String restaurantOwnerUserName, String passWord,
                                     String restaurantOwnerNationalCode, String location){
        RestaurantOwner restaurantOwner = new RestaurantOwner(firstName, lastName, restaurantOwnerUserName, passWord,
                restaurantOwnerNationalCode, location);
        restaurantOwners.add(restaurantOwner);
        people.add(restaurantOwner);
        return "add restaurant owner successful";
    }
    public String addOrder(Customer customer, String orderID, ArrayList<Food> foods, String orderTime,
                           String deliveryTime, String originLocation, String destinationLocation) {
        Order order = new Order(customer, orderID, foods, orderTime, deliveryTime, originLocation, destinationLocation);
        orders.add(order);
        ordersID.add(orderID);
        customer.getOrders().add(order);
        customer.getCart().removeAll(customer.getCart());
        return "confirm order successful";
    }

    public String addCustomer(String firstName, String lastName, String customerUserName, String passWord,
                              String customerNationalCode, String location) {
        Customer customer = new Customer(firstName, lastName, customerUserName, passWord, customerNationalCode,
                location);
        customers.add(customer);
        people.add(customer);
        return "add customer successful";
    }

    public String addRestaurant(RestaurantOwner restaurantOwner, String restaurantName, String restaurantID,
                                String location) {
        Restaurant restaurant = new Restaurant(restaurantOwner, restaurantName, restaurantID, location);
        restaurants.add(restaurant);
        restaurantsID.add(restaurantID);
        restaurantOwner.addRestaurant(restaurant);
        return "add restaurant successful";
    }

    public String addFood(String foodType, String foodName, String foodID, Restaurant restaurant, String foodBiography,
                          String price) {
        Food food = new Food(foodType, foodName, foodID, restaurant, foodBiography, price);
        restaurant.addFood(food);
        foods.add(food);
        foodsID.add(foodID);
        return "add food successful";
    }
    public String addResponse (RestaurantOwner restaurantOwner, Order order, String responseDetail, String commentID) {
        Comment response = new Comment(restaurantOwner, order, responseDetail, commentID);
        order.getComment().setResponse(response);
        comments.add(response);
        commentsID.add(commentID);
        return "add response successful";
    }

    public String restaurantIDIsNonRepetitive (String restaurantID){
        for (String string : restaurantsID) {
            if (string.equalsIgnoreCase(restaurantID)){
                return null;
            }
        }
        return restaurantID;
    }
    public String commentIDIsNonRepetitive (String commentID){
        for (String string : commentsID) {
            if (string.equalsIgnoreCase(commentID)){
                return null;
            }
        }
        return commentID;
    }

    public String foodIDIsNonRepetitive (String foodID){
        for (String string : foodsID) {
            if (string.equalsIgnoreCase(foodID)){
                return null;
            }
        }
        return foodID;
    }
    public String orderIDIsNonRepetitive (String orderID){
        for (String string : ordersID) {
            if (string.equalsIgnoreCase(orderID)){
                return null;
            }
        }
        return orderID;
    }
    public boolean foodHasActiveOrder(Food food){
        for (Order order : orders) {
            if (foodIsInOrder(order, food) && order.getOrderStatus().equalsIgnoreCase("active")){
                return true;
            }
        }
        return false;
    }
    public boolean foodIsInOrder (Order order, Food food) {
        for (Food food1 : order.getFood()) {
            if (food1.getFoodID().equals(food.getFoodID())) {
                return true;
            }
        }
        return false;
    }
    public boolean restaurantIsInOrder (Order order, Restaurant restaurant) {
        for (Food food1 : order.getFood()) {
            if (food1.getRestaurant().getRestaurantID().equals(restaurant.getRestaurantID())) {
                return true;
            }
        }
        return false;
    }
    public boolean foodIsInRestaurant (Restaurant restaurant, Food food) {
        for (Food food1 : restaurant.getFoodMenu()) {
            if (food1.getFoodID().equals(food.getFoodID())) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Restaurant> sortRestaurant (ArrayList<Restaurant> restaurants){
        ArrayList<Restaurant> sortedRestaurant = new ArrayList<>(List.copyOf(restaurants));
        boolean swapped;
        for (int i = 0; i < sortedRestaurant.size(); i++) {
            swapped = true;
            for (int j = 0; j < sortedRestaurant.size() - i - 1; j++){
                if (restaurants.get(j).getRestaurantName().compareTo(restaurants.get(j + 1).getRestaurantName()) > 0){
                    Collections.swap(sortedRestaurant, j, j + 1);
                    swapped = false;
                }
                else if (restaurants.get(j).getRestaurantName().compareTo(restaurants.get(j + 1).getRestaurantName()) == 0
                        && Integer.parseInt(restaurants.get(j).getRestaurantID()) > Integer.parseInt(restaurants.get(j + 1).getRestaurantID())) {
                        Collections.swap(sortedRestaurant, j, j + 1);
                        swapped = false;
                }
            }
            if (swapped){
                break;
            }
        }
        return sortedRestaurant;
    }

    public String showRestaurants (RestaurantOwner restaurantOwner) {
        StringBuilder restaurants = new StringBuilder("");
        restaurants.append("Restaurant Name").append("\t").append("Restaurant ID").append("\n");
        for (Restaurant restaurant : sortRestaurant(restaurantOwner.getRestaurants())) {
            restaurants.append(restaurant.getRestaurantName()).append("\t").append(restaurant.getRestaurantID())
                    .append("\n");
        }
        return restaurants.toString();
    }

    public String selectMenu(String foodType, Restaurant restaurant){
        StringBuilder restaurantMenu = new StringBuilder("");
        restaurantMenu.append(foodType).append("\n").append("Food Name").append("\t").append("Food ID").append("\t")
                .append("Food Price").append("\t").append("Discount Percentage").append("\t").append("Final Price")
                .append("\t").append("Food Status").append("\n");
        for (Food food : restaurant.getFoodMenu()) {
            if (food.getFoodType().equalsIgnoreCase(foodType)){
                restaurantMenu.append(food.getFoodName()).append("\t").append(food.getFoodID()).append("\t")
                        .append(food.getPrice()).append("\t").append(food.getDiscountPercentage()).append("\t")
                        .append(food.getFinalPrice()).append("\t").append(food.getFoodStatus()).append("\n");
            }

        }
        return restaurantMenu.toString();
    }
    public String showMenu(Restaurant restaurant){
        StringBuilder restaurantMenu = new StringBuilder("");
        restaurantMenu.append("Food Type").append("\t").append("Food Name").append("\t").append("Food ID").append("\t")
                .append("Food Price").append("\t").append("Discount Percentage").append("\t").append("Final Price")
                .append("\t").append("Food Status").append("\n");
        for (Food food : restaurant.getFoodMenu()) {
            restaurantMenu.append(food.getFoodType()).append("\t").append(food.getFoodName()).append("\t")
                    .append(food.getFoodID()).append("\t").append(food.getPrice()).append("\t")
                    .append(food.getDiscountPercentage()).append("\t").append(food.getFinalPrice()).append("\t")
                    .append(food.getFoodStatus()).append("\n");
        }
        return restaurantMenu.toString();
    }

    public String showRestaurantOrders (Restaurant restaurant){
        StringBuilder restaurantOrders = new StringBuilder("");
        restaurantOrders.append("Customer Name").append("\t").append("Foods Name").append("\t").append("Order ID").append("\t")
                .append("Order time").append("\t").append("Delivery Time").append("\t").append("Destination Location")
                .append("\t").append("Order Status").append("\n");
        for (Order order : orders) {
            for (Food food : order.getFood()){
                if (foodIsInRestaurant(restaurant, food)){
                    restaurantOrders.append(order.getCustomer().getFirstName()).append(" ").append(order.getCustomer().getLastName())
                            .append(" ").append(food.getFoodName()).append("\t").append(food.getFoodName())
                            .append("\t").append(order.getOrderID()).append("\t").append(order.getOrderTime())
                            .append("\t").append(order.getDeliveryTime()).append("\t").append(order.getDestinationLocation())
                            .append("\t").append(order.getOrderStatus()).append("\n");

                }
            }

        }
        return restaurantOrders.toString();
    }
    public String showCustomerOrders(Customer customer){
        StringBuilder customerOrders = new StringBuilder("");
        customerOrders.append("Restaurant Name").append("\t").append("Food Name").append("\t").append("Order ID").append("\t")
                .append("Order time").append("\t").append("Delivery Time").append("\t").append("Destination Location")
                .append("\t").append("Order Status").append("\n");
        for (Order order : customer.getOrders()) {
            for (Food food : order.getFood()){
                customerOrders.append(food.getRestaurant().getRestaurantName()).append("\t").append(food.getFoodName())
                        .append("\t").append(order.getOrderID()).append("\t").append(order.getOrderID()).append("\t")
                        .append(order.getOrderTime()).append("\t").append(order.getDeliveryTime()).append("\t")
                        .append(order.getDestinationLocation()).append("\t").append(order.getOrderStatus()).append("\n");
            }
        }
        return customerOrders.toString();
    }
    public String showOpenRestaurantOrders(Restaurant restaurant){
        StringBuilder restaurantOrders = new StringBuilder("");
        restaurantOrders.append("Customer Name").append("\t").append("Food Name").append("\t").append("Order ID").append("\t")
                .append("Order time").append("\t").append("Delivery Time").append("\t").append("Destination Location")
                .append("\t").append("Order Status").append("\n");
            for (Order order : orders) {
                for (Food food : order.getFood()){
                    if (foodIsInRestaurant(restaurant, food) && order.getOrderStatus().equals("open")){
                        restaurantOrders.append(order.getCustomer().getFirstName()).append(" ").append(order.getCustomer().getLastName())
                                .append(" ").append(food.getFoodName()).append("\t").append(food.getFoodName())
                                .append("\t").append(order.getOrderID()).append("\t").append(order.getOrderTime())
                                .append("\t").append(order.getDeliveryTime()).append("\t").append(order.getDestinationLocation())
                                .append("\t").append(order.getOrderStatus()).append("\n");

                    }
                }
            }
        return restaurantOrders.toString();
    }

    public String showOrderDetail (Order order){
        StringBuilder orderDetail = new StringBuilder("");
        orderDetail.append("Restaurant Name").append("\t").append("Food Name").append("\t").append("Order ID").append("\t")
                .append("Order time").append("\t").append("Delivery Time").append("\t").append("Destination Location")
                .append("\t").append("Order Status").append("\n");
        for (Food food : order.getFood()) {
            orderDetail.append(food.getRestaurant().getRestaurantName()).append("\t").append(food.getFoodName())
                    .append("\t").append(order.getOrderID()).append("\t").append(order.getOrderID()).append("\t")
                    .append(order.getOrderTime()).append("\t").append(order.getDeliveryTime()).append("\t")
                    .append(order.getDestinationLocation()).append("\t").append(order.getOrderStatus()).append("\n");
        }
        orderDetail.append("total price: ").append(order.getTotalPrice()).append("\n");
        return orderDetail.toString();
    }

    public String displayFoodComments (Food food){
        StringBuilder foodComments = new StringBuilder("");
        for (Order order : orders) {
            if (foodIsInOrder(order, food)){
                foodComments.append(order.getComment().getCommentID()).append(" ")
                        .append(order.getComment().getPerson().getFirstName()).append(":\n")
                        .append(order.getComment().getComment()).append("\n").append(getFoodNamesInOrder(order)).append("\n");
                if (!order.getComment().getResponse().getComment().isEmpty()){
                    foodComments.append("\t").append(order.getComment().getResponse().getCommentID()).append(" ")
                            .append(order.getComment().getResponse().getComment()).append("\n");
                }
            }

        }
        return foodComments.toString();
    }

    public String displayRestaurantComments (Restaurant restaurant){
        StringBuilder restaurantsComments = new StringBuilder("");

        for (Comment comment : restaurant.getComments()) {
            restaurantsComments.append(comment.getCommentID()).append(" ")
                    .append(comment.getPerson().getFirstName()).append(":\n")
                    .append(comment.getComment()).append("\n").append(getFoodNamesInOrder(comment.getOrder())).append("\n");
            if (!comment.getResponse().getComment().isEmpty()){
                restaurantsComments.append("\t").append(comment.getResponse().getCommentID()).append(" ")
                        .append(comment.getResponse().getComment()).append("\n");
            }
        }
        return restaurantsComments.toString();
    }

    public String getFoodNamesInOrder (Order order) {
        StringBuilder foodNamesInOrder = new StringBuilder("");
        for (Food food : order.getFood()) {
            foodNamesInOrder.append(food.getFoodName()).append("\t");
        }
        return foodNamesInOrder.toString();
    }

}
