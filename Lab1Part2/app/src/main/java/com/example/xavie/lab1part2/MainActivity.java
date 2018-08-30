package com.example.xavie.lab1part2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button conButton = (Button) findViewById(R.id.convertButton);
        conButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                EditText nameBox = (EditText) findViewById(R.id.nameTextBox);
                TextView resultText = (TextView) findViewById(R.id.convertTextBox);

                String revName = new StringBuilder(nameBox.getText().toString()).reverse().toString();

                resultText.setText(revName);
            }
        });
        //This is a coment
        //The comment has a spelling mistake


    }


}
