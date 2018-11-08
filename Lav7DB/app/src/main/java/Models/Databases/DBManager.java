package Models.Databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import Models.Contact;

public class DBManager extends SQLiteOpenHelper {

    private static ArrayList<Contact> clist = new ArrayList<>();


    private static final int DATABASE_VERSION = 1;


    private static final String DATABASE_NAME = "contact_db";

    public DBManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static final String PH_TAB_NAME = "PhoneNumbers";
    public static final String PH_COL_ID = "PhoneID";
    public static final String PH_COL_NO = "PhoneNo";
    public static final String PH_COL_TYPE = "PhoneType";
    public static final String PH_COL_CON = "ContactID";

    public static final String CREATE_TAB_PHONE = "CREATE TABLE " + PH_TAB_NAME + "(" +
            PH_COL_ID + "INTEGER PRIMARY KEY AUTOINCREMENT," +
            PH_COL_NO + "INTEGER," +
            PH_COL_TYPE + "TEXT," +
            PH_COL_CON +"INTEGER," +
            "FOREIGN KEY (ContactID) REFERENCES Contacts(ContactID));";

    public static final String CT_TAB_NAME = "Contacts";
    public static final String CT_COL_ID = "ContactID";
    public static final String CT_COL_FN = "FirstName";
    public static final String CT_COL_LN = "LastName";

    public static final String CREATE_TAB_CONTACT = "CREATE TABLE " + CT_TAB_NAME + "(" +
            CT_COL_ID + "INTEGER PRIMARY KEY AUTOINCREMENT," +
            CT_COL_FN + "TEXT," +
            CT_COL_LN + "TEXT);";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TAB_PHONE);
        db.execSQL(CREATE_TAB_CONTACT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public Contact addContact(Contact c)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues vals = new ContentValues();

        vals.put(Contact.COL_FN, c.getFirstName());
        vals.put(Contact.COL_LN, c.getLastName());
        long id = db.insert(Contact.TAB_NAME,null, vals);
        db.close();

        c.setId((int)id);

        clist.add(c);

        return c;
    }

    public ArrayList<Contact> getContactList()
    {
        ArrayList<Contact> list = new ArrayList<Contact>();
        SQLiteDatabase db = this.getWritableDatabase();

        String GET_LIST = "SELECT * FROM " + Contact.TAB_NAME +";";
        Cursor c = db.rawQuery(GET_LIST,null);

        if (c != null)
        {
            c.moveToFirst();
            do {
                Contact ct = new Contact();
                ct.setId(c.getInt(c.getColumnIndex(Contact.COL_ID)));
                ct.setFirstName(c.getString(c.getColumnIndex(Contact.COL_FN)));
                ct.setLastName(c.getString(c.getColumnIndex(Contact.COL_LN)));

                list.add(ct);
            } while (c.moveToNext());
        }
        return list;
    }


}
