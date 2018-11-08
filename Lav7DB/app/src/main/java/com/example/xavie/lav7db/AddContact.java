package com.example.xavie.lav7db;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import Models.Contact;
import Models.Databases.DBClass;
import Models.Databases.DBManager;

public class AddContact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        final Intent i = new Intent(this, MainActivity.class);
        Button addButton = (Button) findViewById(R.id.addBtn);
        Button cancButton = (Button) findViewById(R.id.cancBtn);
        final EditText fnInput = (EditText) findViewById(R.id.fnInputBox);
        final EditText lnInput = (EditText) findViewById(R.id.lnInputBox);
        //final EditText pnInput = (EditText) findViewById(R.id.pnInputBox);
        final DBManager db = new DBManager(this);
        final ArrayList<Contact> cList = db.getContactList();
        final Context context = this;
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id = cList.size();

                String fn = fnInput.getText().toString();
                String ln = lnInput.getText().toString();

                //String pn = pnInput.getText().toString();

                /*if (DBClass.getContact(id,context) != null)
                {
                    DBClass.getContact(id,context).addPhoneNum(pn);
                    Toast.makeText(AddContact.this, "Contact Updated",
                            Toast.LENGTH_LONG).show();
                    Log.d("adding phone number",id+"");
                }
                else
                {*/
                    Contact c = new Contact(id,fn,ln);
                    //c.addPhoneNum(pn);
                    DBClass.addContact(c,context);
                    Toast.makeText(AddContact.this, "Contact Added",
                            Toast.LENGTH_LONG).show();
                //}
                startActivity(i);
            }

        });

        cancButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
            }
        });
    }
}
