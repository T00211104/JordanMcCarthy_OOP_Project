package SalesSYS;

//Client.java
/*An instantiable class definition for a Client*/

import java.io.Serializable;
import java.util.GregorianCalendar;

public class Client implements Serializable {
    private int clientID;
    private String firstName;
    private String lastName;
    private String phoneNo;
    private GregorianCalendar dateRegistered;

    public Client(int clientID, String firstName, String lastName, String phoneNo, GregorianCalendar dateRegistered){
        setClientID(clientID);
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNo(phoneNo);
        setDateRegistered(dateRegistered);
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        if (clientID<0 || clientID >100)
            throw new IllegalArgumentException("You must enter a valid clientID");
        else
            this.clientID = clientID;
    }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.equals(""))
            throw new IllegalArgumentException("You must enter a valid first name");
        else
            this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.equals(""))
            throw new IllegalArgumentException("You must enter a valid Last Name");
        else
            this.lastName = lastName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        if (phoneNo != null && phoneNo.isEmpty())
            this.phoneNo = phoneNo;
        else
            this.phoneNo = "not available";
    }

    public GregorianCalendar getDateRegistered() {
        return dateRegistered;
    }



    public void setDateRegistered(GregorianCalendar dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    @Override
    public String toString() {
        return "Client ID: " + getClientID() +
                " First Name: " + getFirstName() +
                " Last Name: " + getLastName() +
                " Phone No: " + getPhoneNo() +
                " Date Registered " + getDateRegistered();
    }
}
