package com.example.xavie.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Act1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act1);
        final String uname = "admin";
        final String pword = "pass";

        final Intent goToAct2 = new Intent(this,Act2.class);

        Button logButton = (Button) findViewById(R.id.logButton);
        logButton.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                EditText unInputBox = (EditText) findViewById(R.id.unInput);
                EditText pwInputBox = (EditText) findViewById(R.id.pwInput);

                String unInput = unInputBox.getText().toString();
                String pwInput = pwInputBox.getText().toString();
                if (uname.equals(unInput) && pwInput.equals(pword))
                {
                    goToAct2.putExtra("uname",unInput);
                    startActivity(goToAct2);
                }
                else
                {
                    TextView respText = (TextView) findViewById(R.id.respText);
                    respText.setText(("Incorrect Password or Username"));
                }

            }
        });
    }
}
