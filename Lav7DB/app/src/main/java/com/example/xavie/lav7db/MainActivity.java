package com.example.xavie.lav7db;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import Models.Contact;
import Models.Databases.DBClass;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Contact> contacts = new ArrayList<Contact>();
    ContactAdapter cA;
    final Context c = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Intent goToAdd = new Intent(this, AddContact.class);
        Button addContactBtn = (Button) findViewById(R.id.addContactBtn);

        addContactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(goToAdd);

            }
        });

        RecyclerView rv = findViewById(R.id.RecyclerViewMain);
        contacts = DBClass.getContactList(this);
        cA = new ContactAdapter(contacts);
        rv.setAdapter(cA);
        rv.setLayoutManager(new LinearLayoutManager(this));
    }
}
