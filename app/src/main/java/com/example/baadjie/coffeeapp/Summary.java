package com.example.baadjie.coffeeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Summary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        TextView tvSummary;
        tvSummary= (TextView) findViewById(R.id.tvReaults);

        Intent intent=getIntent();
        String display="Thank you for purchasing in our store"+ "  "+MainActivity.NAME+"\n\n\n" +
                ""+" Oder number is " +"  "+"#0000"+intent.getStringExtra(MainActivity.NUMBER) +"\n\n"+" " +
                "number of Items  :"+intent.getStringExtra(MainActivity.COUNT)+"\n\n"+
                "Cash             :"+"R "+intent.getStringExtra(MainActivity.CASH)+"\n\n" +
                "Change           :"+"R "+intent.getStringExtra(MainActivity.CHANGE)+"\n\n"
                +"Total : " +"R "+intent.getStringExtra(MainActivity.TOTAL);

        tvSummary.setText(""+display);
    }
}
