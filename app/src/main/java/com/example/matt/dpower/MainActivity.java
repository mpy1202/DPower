package com.example.matt.dpower;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView maltList;
    ArrayList<String> malts; //list of malts
    ArrayList<Double> weight; //list of weights for the malts
    ArrayList<Integer> power; //list of diastatic power of each malt

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //this is the listView that contains the malts that are entered
        maltList = (ListView) findViewById(R.id.maltList);
        //ToDo: Change to malt class

        //Initialise the malt lists
        malts = new ArrayList<>();
        weight = new ArrayList<>();
        power = new ArrayList<>();




        /*create an adapter of the type maltadapter
        (class contains the layout and methods for displaying the malts in the list)*/
        final adapter_malt maltAdapter = new adapter_malt(this, malts, weight, power);

        maltList.setAdapter(maltAdapter);



    }

    public void addNewMalt(View view){
        //When (or if) the user presses the plus button this runs to add a malt

        //setup a new intent to go to the additem activity
        Intent intent = new Intent(this, AddItem.class);
        //go to the activity above and get a result back
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) { //check we recieve a result (user not backed out etc..)
            if (requestCode == 1) { //checks that the request was sent by this activity todo: refactor request code

                //extract the returned data from into temp variables..
                String m = data.getStringExtra("maltName");
                String w = data.getStringExtra("maltWeight");
                String p = data.getStringExtra("maltPower");

                //add the newly added values to the lists
                malts.add(m);
                weight.add(Double.valueOf(w));
                power.add(Integer.valueOf(p));

                //create and fill out the maltlist with the required values
                final adapter_malt maltAdapter = new adapter_malt(this, malts, weight, power);
                maltList.setAdapter(maltAdapter);

                //run the lintner calculation
                calcLintner();
            }
        }
    }


    public void calcLintner(){
        //get how many malts
        int len=malts.size();
        double totalWeight = 0;
        double totalLint = 0;

        for(int i = 0; i < len; i++){ //run through the list
            totalWeight += weight.get(i); //sum up the weight total
            totalLint += weight.get(i) * power.get(i); //sum of powers weighted by the 'weight'
        }

        //work out the weighted average from the totals
        double lint = totalLint / totalWeight;

        //enum the linter display text box and set its value to the calculated power set to 1dp
        TextView txtLint = (TextView) findViewById(R.id.txtLint);
        txtLint.setText(String.format("%.1f °L",lint));
    }

}
