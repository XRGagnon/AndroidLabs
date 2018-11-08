package com.example.xavie.layouttestapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.Intent;

public class FrameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);

        final Button tButton = (Button) findViewById(R.id.topButton);
        final Button bButton = (Button) findViewById(R.id.botButton);
        final FrameLayout top = (FrameLayout) findViewById(R.id.frameTop);
        final FrameLayout bot = (FrameLayout) findViewById(R.id.frameBot);
        tButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
               bigger(top,bot);
            }
        });
        bButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                bigger(bot,top);
            }
        });
    }



    public void bigger(FrameLayout x, FrameLayout y)
    {
        LinearLayout.LayoutParams superWeight = new LinearLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,FrameLayout.LayoutParams.MATCH_PARENT);
        superWeight.weight = 2;
        LinearLayout.LayoutParams miniWeight = new LinearLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,FrameLayout.LayoutParams.MATCH_PARENT);
        miniWeight.weight = 1;

        x.setLayoutParams(superWeight);
        y.setLayoutParams(miniWeight);
    }
}
