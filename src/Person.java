import java.util.HashMap;

public abstract class Person {
    protected String firstName;
    protected String lastName;
    protected String userName;
    protected String passWord;
    protected String nationalCode;
    protected String location;
    protected String wallet;
    //key = orderID  value = OrderHistory

    public Person(String firstName, String lastName, String userName, String passWord, String nationalCode, String location) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.passWord = passWord;
        this.nationalCode = nationalCode;
        this.location = location;
    }

    public Person() {

    }

    public String getPassWord() {
        return passWord;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public String getLocation() {
        return location;
    }

    public String getWallet() {
        return wallet;
    }

    public void setWallet(String wallet) {
        this.wallet = wallet;
    }
}
