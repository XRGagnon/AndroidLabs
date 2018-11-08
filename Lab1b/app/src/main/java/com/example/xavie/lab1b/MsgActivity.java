package com.example.xavie.lab1b;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;

public class MsgActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msg);

        final EditText inputBox = (EditText) findViewById(R.id.msgInputBox);
        final Button submitButton = (Button) findViewById(R.id.submitButton);
        final Intent returnData = new Intent(this, MainActivity.class);

        submitButton.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                returnData.putExtra("msg",inputBox.getText().toString());
                setResult(0,returnData);
                MsgActivity.super.finish();
            }
        });
    }
}
