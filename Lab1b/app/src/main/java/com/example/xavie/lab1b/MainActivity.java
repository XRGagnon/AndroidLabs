package com.example.xavie.lab1b;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button getMsgButton = (Button) findViewById(R.id.getMsgBtn);
        TextView msgBox = (TextView) findViewById(R.id.msgBox);
        final Intent i = new Intent(this, MsgActivity.class);

        getMsgButton.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivityForResult(i,1);
            }
        });

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent returnData)
    {
        if(resultCode == 0 && requestCode == 1)
        {
            TextView msgBox = (TextView) findViewById(R.id.msgBox);
            String msg = returnData.getStringExtra("msg");
            msgBox.setText(msg);
        }
    }
}
