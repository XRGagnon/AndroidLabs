package com.example.xavie.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Act2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act2);

        TextView welcText = (TextView) findViewById(R.id.welcText);
        welcText.setText("Welcome back, " + getIntent().getStringExtra("uname"));
        final Intent goToAct1 = new Intent(this, Act1.class);
        Button logoutButton = (Button) findViewById(R.id.logoutButton);


        logoutButton.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                startActivity(goToAct1);
            }



        });

    }
}
