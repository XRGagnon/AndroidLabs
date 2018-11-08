package Models;

import java.util.ArrayList;

public class Contact {


    public static final String TAB_NAME = "Contacts";
    public static final String COL_ID = "ContactID";
    public static final String COL_FN = "FirstName";
    public static final String COL_LN = "LastName";

    private int id;
    private String firstName;
    private String lastName;
    //private ArrayList<PhoneNumber> phoneNums = new ArrayList<PhoneNumber>();


    public Contact() {
    }

    public Contact(int id /*,ArrayList<PhoneNumber> phoneNums*/) {
        this.id = id;
        //this.phoneNums = phoneNums;
    }

    public Contact(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /*public ArrayList<PhoneNumber> getPhoneNums() {
        return phoneNums;
    }

    public void setPhoneNums(ArrayList<PhoneNumber> phoneNums) {
        this.phoneNums = phoneNums;
    }

    public void addPhoneNum(String phoneNum)
    {
        PhoneNumber pn = new PhoneNumber(phoneNum, PhoneNumber.phoneTypes.Home);
        phoneNums.add(pn);
    }*/
}
