import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;

public class InputProcessor {

    private Scanner scanner = new Scanner(System.in);
    private Controller controller = new Controller();
    private String input;
    public void start(){
        while (true){
            input = scanner.nextLine();
            input = input.trim();
            if (input.equalsIgnoreCase("add restaurant owner")){
                processAddRestaurantOwner();
            }

            else if (input.equalsIgnoreCase("add customer")){
                processAddCustomer();
            }

            else if (input.equalsIgnoreCase("login restaurant owner")) {
                processLoginRestaurantOwner();
            }
            else if (input.equalsIgnoreCase("login customer")) {
                processLoginCustomer();
            }
            else if (input.equalsIgnoreCase("exit")){
                break;
            }
            else {
                System.err.println("Invalid command!");
            }
        }
    }

    private void restaurantsManagement(RestaurantOwner restaurantOwner){
        if (restaurantOwner.getRestaurants().size() == 1){
            restaurantManagement (restaurantOwner.getRestaurants().get(0));
        }
        else {
            processShowRestaurant (restaurantOwner);
        }
        while (true){
            input = scanner.nextLine();
            input = input.trim();
            if (input.equalsIgnoreCase("select restaurant")){
                processSelectRestaurantForRestaurantOwner();
            }
            else if (input.equalsIgnoreCase("add restaurant")){
                processAddRestaurant(restaurantOwner);
            }
            else if (input.equalsIgnoreCase("show restaurants")){
                processShowRestaurant (restaurantOwner);
            }
            else if (input.equalsIgnoreCase("exit")){
                start();
            }
            else {
                System.err.println("Invalid command!");
            }
        }
    }

    private void restaurantManagement (Restaurant restaurant){
        while (true){
            input = scanner.nextLine();
            input = input.trim();
            if (input.equalsIgnoreCase("select food")){
                processSelectFood(restaurant);
            }
            else if (input.equalsIgnoreCase("add food")) {
                processAddFood(restaurant);
            }
            else if (input.equalsIgnoreCase("show menu")){
                processShowMenu(restaurant);
            }
            else if (input.equalsIgnoreCase("select menu")){
                processSelectMenu(restaurant);
            }
            else if (input.equalsIgnoreCase("show orders")){
            processShowRestaurantOrders(restaurant);
            }
            else if (input.equalsIgnoreCase("show open orders")){
                processShowOpenRestaurantOrders(restaurant);
            }
            else if (input.equalsIgnoreCase("select order")){
                processSelectRestaurantOrder(restaurant);
            }
            else if (input.equalsIgnoreCase("show location")){
                processShowRestaurantLocation(restaurant);
            }
            else if (input.equalsIgnoreCase("edit location")){
                processEditRestaurantLocation(restaurant);
            }
            else if (input.equalsIgnoreCase("display ratings")){
                processDisplayRestaurantRatings(restaurant);
            }
            else if (input.equalsIgnoreCase("exit")){
                restaurantsManagement(restaurant.getRestaurantOwner());
            }
            else {
                System.err.println("Invalid command!");
            }
        }

    }

    private void foodManagement (Food food){
        while (true) {
            input = scanner.nextLine();
            input = input.trim();
            if (input.equalsIgnoreCase("edit name")) {
                processEditFoodName(food);
            } else if (input.equalsIgnoreCase("edit price")) {
                processEditFoodPrice(food);
            } else if (input.equalsIgnoreCase("delete")) {
                processDeleteFood(food);
            } else if (input.equalsIgnoreCase("deActive")) {
                processDeActiveFood(food);
            } else if (input.equalsIgnoreCase("active")) {
                processActiveFood(food);
            }
            else if (input.equalsIgnoreCase("display ratings")){
                processDisplayFoodRatings(food);
            }
            else if (input.equalsIgnoreCase("display comments")){
                processDisplayFoodComments(food);
            }
            else if (input.equalsIgnoreCase("select comment")){
                processSelectComment(food);
            }
            else if (input.equalsIgnoreCase("exit")){
                restaurantManagement(food.getRestaurant());
            }
            else {
                System.err.println("Invalid command!");
            }
        }
    }

    private void responseManagement (Comment comment, Food food) {
        while (true) {
            input = scanner.nextLine();
            input = input.trim();
            if (input.equalsIgnoreCase("add response")){
                processAddResponse(comment);
            }
            else if (input.equalsIgnoreCase("edit response")){
                processEditResponse(comment);
            }
            else if (input.equalsIgnoreCase("exit")) {
                foodManagement(food);
            } else {
                System.err.println("Invalid command!");
            }

        }
    }

    private void orderManagement (Order order, Restaurant restaurant) {
        while (true) {
            input = scanner.nextLine();
            input = input.trim();
            if (input.equalsIgnoreCase("edit order")) {
                processEditOrderStatus(order);
            }
            else if (input.equalsIgnoreCase("exit")) {
                restaurantManagement(restaurant);
            } else {
                System.err.println("Invalid command!");
            }
        }

    }

    private void customerManagement (Customer customer) {
        while (true) {
            input = scanner.nextLine();
            input = input.trim();
            if (input.equalsIgnoreCase("search restaurant")) {
                processSearchRestaurant();
            }
            else if (input.equalsIgnoreCase("select restaurant")) {
                processSelectRestaurantForCustomer(customer);
            }
            else if (input.equalsIgnoreCase("display cart")) {
                processDisplayCart(customer);
            }
            else if (input.equalsIgnoreCase("confirm order")) {
                processConfirmOrder(customer);
            }
            else if (input.equalsIgnoreCase("show order history")) {
                processShowCustomerOrders(customer);
            }
            else if (input.equalsIgnoreCase("select order")){
                processSelectCustomerOrder(customer);
            }
            else if (input.equalsIgnoreCase("charge wallet")){
                processChargeCustomerWallet(customer);
            }
            else if (input.equalsIgnoreCase("display wallet")){
                processDisplayCustomerWallet(customer);
            }
            else if (input.equalsIgnoreCase("exit")) {
                start();
            }
            else {
                System.err.println("Invalid command!");
            }
        }
    }

    private void restaurantManagementForCustomer (Restaurant restaurant, Customer customer){
        while (true) {
            input = scanner.nextLine();
            input = input.trim();
            if (input.equalsIgnoreCase("search food")) {
                processSearchFood(restaurant);
            }
            else if (input.equalsIgnoreCase("display comments")) {
                processDisplayRestaurantComments(restaurant);
            }
            else if (input.equalsIgnoreCase("select food")) {
                processSelectRestaurantForCustomer(customer);
            }
            else if (input.equalsIgnoreCase("exit")) {
                customerManagement(customer);
            }
            else {
                System.err.println("Invalid command!");
            }

        }
    }
    private void foodManagementForCustomer(Food food, Customer customer){
        while (true) {
            input = scanner.nextLine();
            input = input.trim();
            if (input.equalsIgnoreCase("display comments")) {
                processDisplayFoodComments(food);
            }
            else if (input.equalsIgnoreCase("add to cart")){
                processAddFoodToCart(food, customer);
            }
            else if (input.equalsIgnoreCase("display ratings")){
                processDisplayFoodRatings(food);
            }
            else if (input.equalsIgnoreCase("exit")) {
                restaurantManagementForCustomer(food.getRestaurant(), customer);
            }
            else {
                System.err.println("Invalid command!");
            }

        }
    }
    private void processChargeCustomerWallet (Customer customer){
        System.out.println("Please enter your amount");
        String amount = scanner.nextLine();
        customer.setWallet(Integer.toString(Integer.parseInt(customer.getWallet()) + Integer.parseInt(amount)));
    }
    private void processDisplayCustomerWallet (Customer customer) {
        System.out.println(customer.getWallet());
    }
    private void processConfirmOrder (Customer customer) {
        String deliveryTime = getDeliveryTime();
        String destinationLocation = customer.getCart().get(0).getRestaurant().getLocation();
        String output = controller.addOrder(customer, setOrderID(), customer.getCart(), getOrderTime(), deliveryTime,
                customer.getLocation(), destinationLocation);
        System.out.println(output);
    }
    private String getOrderTime () {
        LocalTime localTime = LocalTime.now();
        return localTime.toString();
    }
    private String getDeliveryTime () {
        LocalTime localTime = LocalTime.now();
        return localTime.toString();
    }

    private void processDisplayCart (Customer customer) {
        String cart = controller.displayCart (customer);
        System.out.println(cart);
    }

    private void processShowCustomerOrders (Customer customer) {
        String customerOrder = controller.showCustomerOrders(customer);
        System.out.println(customerOrder);
    }
    private void processAddFoodToCart (Food food, Customer customer){
        String output = controller.addFoodToCart (food, customer);
        System.out.println(output);
    }
    private void processSearchRestaurant() {
        String restaurantName = getRestaurantName();
        String restaurantsNames = controller.showRestaurantsByName(restaurantName);
        System.out.println(restaurantsNames);
    }
    private void processSearchFood (Restaurant restaurant) {
        String foodName = getFoodName();
        String foodsNames = controller.showFoodsByName(foodName, restaurant);
        System.out.println(foodsNames);
    }

    private void processEditOrderStatus(Order order) {
        System.out.println("Please enter order status");
        String orderStatus = scanner.nextLine();
        String output = controller.editOrderStatus(order, orderStatus);
        System.out.println(output);

    }

    private void processShowRestaurantOrders (Restaurant restaurant) {
        String restaurantOrder = controller.showRestaurantOrders(restaurant);
        System.out.println(restaurantOrder);
    }

    private void processEditResponse(Comment comment) {
            String response = getResponse();
            String output = controller.editResponse(comment, response);
            System.out.println(output);
    }

    private void processSelectComment(Food food) {
        System.out.println("Please enter comment ID");
        String commentID = scanner.nextLine();
        Comment comment = controller.searchCommentByCommentID(commentID);
        if (food == null){
            System.err.println("comment not found");
            //restaurantOwner.showRestaurant();
        }
        else {
            System.out.println("select comment successful");
            responseManagement(comment, food);
        }
    }

    private void processAddResponse (Comment comment) {
        String output = controller.addResponse((RestaurantOwner) comment.getPerson(), comment.getOrder(), setCommentID(), getResponse());
        System.out.println(output);
    }

    private void processDisplayFoodComments (Food food)
    {
        String foodComments = controller.displayFoodComments (food);
        System.out.println(foodComments);
    }
    private void processDisplayRestaurantComments (Restaurant restaurant)
    {
        String restaurantsComments = controller.displayRestaurantComments(restaurant);
        System.out.println(restaurantsComments);
    }

    private void processDisplayFoodRatings(Food food){

        System.out.println(food.getScore());
    }
    private void processDisplayRestaurantRatings(Restaurant restaurant){
        System.out.println(restaurant.getScore());
    }
    private void processSelectFood(Restaurant restaurant) {
        System.out.println("Please enter food ID");
        String foodID = scanner.nextLine();
        Food food = controller.searchFoodByFoodID(foodID);
        if (food == null){
            System.err.println("food not found");
            //restaurantOwner.showRestaurant();
        }
        else {
            System.out.println("select food successful");
            foodManagement(food);
        }
    }
    private void processSelectRestaurantOrder(Restaurant restaurant) {
        System.out.println("Please enter order ID");
        String orderID = scanner.nextLine();
        Order order = controller.searchOrderByOrderID(orderID);
        if (order == null){
            System.err.println("order not found");
            //restaurantOwner.showRestaurant();
        }
        else {
            System.out.println("select order successful");
            orderManagement(order, restaurant);
        }
    }
    private void processSelectCustomerOrder(Customer customer) {
        System.out.println("Please enter order ID");
        String orderID = scanner.nextLine();
        Order order = controller.searchOrderByOrderID(orderID);
        if (order == null){
            System.err.println("order not found");
            //restaurantOwner.showRestaurant();
        }
        else {
            System.out.println(controller.showOrderDetail(order));
        }
    }
    private void processShowRestaurant(RestaurantOwner restaurantOwner) {
        String restaurants = controller.showRestaurants(restaurantOwner);
        System.out.println(restaurants);
    }

    private void processDeActiveFood(Food food) {
        if (controller.foodHasActiveOrder(food)) {
            System.err.println("you cant do this because this food has active order");
        }
        else {
            String output = controller.deActiveFood(food);
            System.out.println(output);
        }
    }

    private void processActiveFood (Food food) {
        if (controller.foodHasActiveOrder(food)){
            System.err.println("you cant do this because this food has active order");
        }
        else {
            String output = controller.activeFood(food);
            System.out.println(output);
        }
    }

    private void processDeleteFood(Food food) {
        if (controller.foodHasActiveOrder(food)){
            System.err.println("you cant do this because this food has active order");
        }
        else if (areYouSure("Are you sure you want to delete this food?")){
            String output = controller.deleteFood(food);
            System.out.println(output);
            return;
        }
    }

    private void processEditFoodName (Food food) {
            String foodName = getFoodName();
            String output = controller.editFoodName(food, foodName);
            System.out.println(output);

    }

    private void processEditFoodPrice (Food food) {
            String foodPrice = getFoodPrice();
            String output = controller.editFoodPrice(food, foodPrice);
            System.out.println(output);
    }

    private void processSelectMenu (Restaurant restaurant) {
        System.out.println("Please enter food type");
        String foodType = scanner.nextLine();
        String restaurantMenu = controller.selectMenu(foodType, restaurant);
        System.out.println(restaurantMenu);
    }
    private void processShowOpenRestaurantOrders (Restaurant restaurant) {
        String openRestaurantOrders = controller.showOpenRestaurantOrders(restaurant);
        System.out.println(openRestaurantOrders);
    }

    private void processShowMenu (Restaurant restaurant) {
        String restaurantMenu = controller.showMenu(restaurant);
        System.out.println(restaurantMenu);
    }

    private void processEditRestaurantLocation (Restaurant restaurant) {
        String restaurantLocation = getRestaurantLocation();
        String output = controller.editRestaurantLocation(restaurant, restaurantLocation);
        System.out.println(output);
    }

    private void processShowRestaurantLocation (Restaurant restaurant) {
        System.out.println(restaurant.getLocation());
    }

    private void processAddRestaurant (RestaurantOwner restaurantOwner) {
        String output = controller.addRestaurant(restaurantOwner, getRestaurantName(), setRestaurantID(),
                getRestaurantLocation());
        System.out.println(output);
    }

    private void processAddFood (Restaurant restaurant) {
        String output = controller.addFood(getFoodType(), getFoodName(), setFoodID(), restaurant, getFoodBiography(),
                getFoodPrice());
        System.out.println(output);
    }

    private void processSelectRestaurantForRestaurantOwner() {
        System.out.println("Please enter restaurant ID");
        String restaurantID = scanner.nextLine();
        Restaurant restaurant = controller.searchRestaurantByRestaurantID(restaurantID);
        if (restaurant == null){
            System.err.println("restaurant not found");
            //restaurantOwner.showRestaurant();
        }
        else {
            System.out.println("select restaurant successful");
            restaurantManagement(restaurant);
        }
    }

    private void processSelectRestaurantForCustomer(Customer customer) {
        System.out.println("Please enter restaurant ID");
        String restaurantID = scanner.nextLine();
        Restaurant restaurant = controller.searchRestaurantByRestaurantID(restaurantID);
        if (restaurant == null){
            System.err.println("restaurant not found");
            //restaurantOwner.showRestaurant();
        }
        else {
            System.out.println("select restaurant successful");
            processShowMenu(restaurant);
            restaurantManagementForCustomer(restaurant, customer);
        }
    }
    private void processSelectFoodForCustomer(Restaurant restaurant, Customer customer) {
        System.out.println("Please enter food ID");
        String foodID = scanner.nextLine();
        Food food = controller.searchFoodByFoodID(foodID);
        if (food == null){
            System.err.println("food not found");
            //restaurantOwner.showRestaurant();
        }
        else {
            System.out.println("select food successful");
            foodManagementForCustomer(food, customer);
        }
    }

    private void processLoginRestaurantOwner() {
        System.out.println("Please enter your username:");
        String userName = scanner.nextLine();
        System.out.println("Please enter your password:");
        String passWord = scanner.nextLine();
        RestaurantOwner restaurantOwner = controller.searchRestaurantOwnerByUserName(userName);
        if (restaurantOwner == null){
            System.err.println("username not found");
        }
        else {
            if (restaurantOwner.getPassWord().equals(passWord)) {
                System.out.println("login restaurant owner successful");
                restaurantsManagement(restaurantOwner);
            } else {
                System.err.println("password is incorrect");
            }
        }
    }

    private void processLoginCustomer() {
        System.out.println("Please enter your username:");
        String userName = scanner.nextLine();
        System.out.println("Please enter your password:");
        String passWord = scanner.nextLine();
        Customer customer = controller.searchCustomerByUserName(userName);
        if (customer == null){
            System.err.println("username not found");
        }
        else {
            if (customer.getPassWord().equals(passWord)) {
                System.out.println("login customer successful");
                customerManagement(customer);
            } else {
                System.err.println("password is incorrect");
            }
        }
    }

    private void processAddCustomer() {
        String output = controller.addCustomer(getFirstName(), getLastName(), getCustomerUserName(),
                getPassWord(), getCustomerNationalCode(), getLocation());
        System.out.println(output);
    }

    private void processAddRestaurantOwner(){
        String output = controller.addRestaurantOwner(getFirstName(), getLastName(), getRestaurantOwnerUserName(),
                getPassWord(), getRestaurantOwnerNationalCode(), getLocation());
        System.out.println(output);
    }
    private String getResponse() {
        System.out.println("Please enter your response:");
        return scanner.nextLine();
    }
    private String getFirstName() {
        System.out.println("Please enter your firstname:");
        return scanner.nextLine();
    }
    private String getLastName() {
        System.out.println("Please enter your lastname:");
        return scanner.nextLine();
    }

    private String getRestaurantOwnerUserName() {
        System.out.println("Please enter your username:");
        String userName = scanner.nextLine();
        if (controller.searchRestaurantOwnerByUserName(userName) != null){
            System.err.println("username was taken!");
            return (getRestaurantOwnerUserName());
        }
        return userName;
    }

    private String getCustomerUserName() {
        System.out.println("Please enter your username:");
        String userName = scanner.nextLine();
        if (controller.searchCustomerByUserName(userName) != null){
            System.err.println("username was taken!");
            return (getCustomerUserName());
        }
        return userName;
    }

    private String getPassWord() {
        System.out.println("Please enter your password:");
        return scanner.nextLine();
    }

    private String getRestaurantOwnerNationalCode() {
        System.out.println("Please enter your national code:");
        String nationalCode = scanner.nextLine();
        if (controller.searchRestaurantOwnerByNationalCode(nationalCode) != null){
            System.err.println("national code was taken!");
            return (getCustomerNationalCode());
        }
        return nationalCode;
    }

    private String getCustomerNationalCode() {
        System.out.println("Please enter your national code:");
        String nationalCode = scanner.nextLine();
        if (controller.searchCustomerByNationalCode(nationalCode) != null){
            System.err.println("national code was taken!");
            return (getCustomerNationalCode());
        }
        return nationalCode;
    }

    private String getLocation() {
        System.out.println("Please enter your location:");
        return scanner.nextLine();
    }

    private String getRestaurantName() {
        System.out.println("Please enter your restaurant name:");
        return scanner.nextLine();
    }

    private String getRestaurantLocation() {
        System.out.println("Please enter your restaurant location:");
        return scanner.nextLine();
    }

    private String getFoodName() {
        System.out.println("Please enter your food name:");
        return scanner.nextLine();
    }

    private String getFoodPrice() {
        System.out.println("Please enter your food price:");
        return scanner.nextLine();
    }

    private String getFoodBiography() {
        System.out.println("Please enter your food biography:");
        return scanner.nextLine();
    }
    private String getFoodType() {
        System.out.println("Please enter your food Type:");
        return scanner.nextLine();
    }

    private String setRestaurantID() {
        Random random = new Random();
        String restaurantId = Integer.toString(random.nextInt(10000,99999));
        while (controller.restaurantIDIsNonRepetitive(restaurantId) == null){
            restaurantId = Integer.toString(random.nextInt(10000,99999));
        }
        return restaurantId;
    }
    private String setFoodID() {
        Random random = new Random();
        String foodId = Integer.toString(random.nextInt(100000,999999));
        while (controller.foodIDIsNonRepetitive(foodId) == null){
            foodId = Integer.toString(random.nextInt(100000,999999));
        }
        return foodId;
    }
    private String setOrderID() {
        Random random = new Random();
        String orderId = Integer.toString(random.nextInt(100000, 999999));
        while (controller.orderIDIsNonRepetitive(orderId) == null) {
            orderId = Integer.toString(random.nextInt(100000, 999999));
        }
        return orderId;
    }
    private String setCommentID() {
        Random random = new Random();
        String commentID = Integer.toString(random.nextInt(1000000, 9999999));
        while (controller.commentIDIsNonRepetitive(commentID) == null) {
            commentID = Integer.toString(random.nextInt(1000000, 9999999));
        }
        return commentID;
    }
    private boolean areYouSure (String waringMessage){
        System.out.println(waringMessage);
        return scanner.nextLine().trim().equalsIgnoreCase("yes");
    }

}
