package Models.Databases;

import android.content.Context;

import java.lang.reflect.Array;
import java.util.ArrayList;

import Models.Contact;

public class DBClass {
    //private static ArrayList<Contact> cList = new ArrayList<Contact>();

    public static Contact getContact(int id, Context context)
    {
        boolean found = false;
        Contact c = new Contact();
        DBManager db = new DBManager(context);
        ArrayList<Contact> cList = db.getContactList();
        for (int i = 0;i < cList.size();i++)
        {
            if (cList.get(i).getId() == id)
            {
                c = cList.get(i);
            }
        }
        if (found)
        {
            return c;
        }
        else
        {
            return null;
        }

    }



    public static ArrayList<Contact> getContactList(Context context)
    {
        DBManager db = new DBManager(context);
        ArrayList<Contact> cList = db.getContactList();
        return cList;
    }

    /*public static void updateContact(Contact c, Context context)
    {
        DBManager db = new DBManager(context);
        ArrayList<Contact> cList = db.getContactList();
        for (int i = 0;i < cList.size();i++)
        {
            if (cList.get(i).getId() == c.getId())
            {
                cList.set(i,c);
            }
        }
    }*/

    public static Contact addContact(Contact c, Context context)
    {
        DBManager db = new DBManager(context);

        Contact newC = c;
        db.addContact(newC);
        return newC;
    }

    /*public static ArrayList<Contact> searchContactList(String searchCondition)
    {

        ArrayList<Contact> resList = new ArrayList<Contact>();
        ArrayList<Contact> clist = DBClass.getContactList();
        for (int i = 0;i < clist.size();i++)
        {
            if (clist.get(i).getFirstName().toLowerCase().contains(searchCondition.toLowerCase()) ||
                    clist.get(i).getLastName().toLowerCase().contains(searchCondition.toLowerCase()))
                    //Need add phone num search
            {
                resList.add(clist.get(i));
            }
        }

        return resList;
    }*/


}
