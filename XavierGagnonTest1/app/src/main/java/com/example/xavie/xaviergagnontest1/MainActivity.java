package com.example.xavie.xaviergagnontest1;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    double diners;
    double cost;
    double tip;
    double amountPerPerson;
    double tipPerPerson;
    String tipString;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        i = new Intent(this,BonusActivity.class);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText numInput = (EditText) findViewById(R.id.numInput);
        final EditText costInput = (EditText) findViewById(R.id.costInput);
        final Spinner tipInput = (Spinner) findViewById(R.id.tipInput);

        final Button calcButton = (Button) findViewById(R.id.submitButton);
        final TextView resultText = (TextView) findViewById(R.id.resultText);

        final DecimalFormat precision = new DecimalFormat("$0.00");




        calcButton.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                try{
                    tipString = tipInput.getSelectedItem().toString();
                    diners = Double.parseDouble(numInput.getText().toString());
                    cost = Double.parseDouble(costInput.getText().toString());
                    tip = Double.parseDouble(tipString);
                    amountPerPerson = cost/diners;
                    tipPerPerson = tip*amountPerPerson/100;
                    resultText.setText("The total amount per person is "+precision.format(amountPerPerson)
                            + ". From that amount, the tip per person is " +
                            precision.format(tipPerPerson));
                    resultText.setTextColor(Color.BLACK);
                }
                catch(Exception e)
                {
                    resultText.setText("The Input entered cannot be calculated");
                    resultText.setTextColor(Color.RED);
                }


            }
        });

    Button menuButton = (Button) findViewById(R.id.menuButton);
    menuButton.setOnClickListener(new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            PopupMenu popup = new PopupMenu(MainActivity.this, v);
            popup.setOnMenuItemClickListener(MainActivity.this);
            MenuInflater inflater = popup.getMenuInflater();
            inflater.inflate(R.menu.menu, popup.getMenu());
            popup.show();
        }
    });

    }
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.exitButton:
                this.finishAffinity();
                return true;
            case R.id.bonusButton:
                startActivity(i);
                return true;
            default:
                return false;
        }
    }

}
