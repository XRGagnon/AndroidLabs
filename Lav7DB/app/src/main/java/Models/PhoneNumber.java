package Models;

public class PhoneNumber {
    public enum phoneTypes {Home,Mobile,Work}
    private String phoneNum;
    private phoneTypes phoneType;

    public static final String TAB_NAME = "PhoneNumbers";
    public static final String COL_ID = "PhoneID";
    public static final String COL_NO = "PhoneNo";
    public static final String COL_TYPE = "PhoneType";
    public static final String COL_CON = "ContactID";

    public PhoneNumber(String phoneNum, phoneTypes phoneType) {
        this.phoneNum = phoneNum;
        this.phoneType = phoneType;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public phoneTypes getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(phoneTypes phoneType) {
        this.phoneType = phoneType;
    }
}
