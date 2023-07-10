import java.util.ArrayList;
import java.util.HashMap;

public class Comment {
    private Person person;
    private Order order;
    private String comment;
    private String commentID;
    private Comment response = new Comment();

    public Comment() {
    }

    public Comment(Customer customer, Order order, String comment, String commentID) {
        this.person = customer;
        this.order = order;
        this.comment = comment;
        this.commentID = commentID;
    }
    public Comment(RestaurantOwner restaurantOwner, Order order, String comment, String commentID) {
        this.person = restaurantOwner;
        this.order = order;
        this.comment = comment;
        this.commentID = commentID;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Order getOrder() {
        return order;
    }

    public void setResponse(Comment response) {
        this.response = response;
    }

    public String getCommentID() {
        return commentID;
    }

    public Comment getResponse() {
        return response;
    }

    public Person getPerson() {
        return person;
    }

    public String getComment() {
        return comment;
    }
}
