package com.example.matt.dpower;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView maltList;
    ArrayList<String> malts;
    ArrayList<Double> weight;
    ArrayList<Integer> power;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        maltList = (ListView) findViewById(R.id.maltList);
        //ToDo: Change to malt class
        malts = new ArrayList<>();
        weight = new ArrayList<>();
        power = new ArrayList<>();





        final adapter_malt maltAdapter = new adapter_malt(this, malts, weight, power);

        maltList.setAdapter(maltAdapter);



    }

    public void addNewMalt(View view){
        Intent intent = new Intent(this, AddItem.class);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == 1) {
                String m = data.getStringExtra("maltName");
                String w = data.getStringExtra("maltWeight");
                String p = data.getStringExtra("maltPower");

                malts.add(m);
                weight.add(Double.valueOf(w));
                power.add(Integer.valueOf(p));


                final adapter_malt maltAdapter = new adapter_malt(this, malts, weight, power);

                maltList.setAdapter(maltAdapter);

                //ToDo: Calculate total Lintner and display it
            }
        }
    }

}
