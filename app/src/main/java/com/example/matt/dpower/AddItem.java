package com.example.matt.dpower;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddItem extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        Button btn = (Button) findViewById(R.id.btnAddData);
        btn.setOnClickListener(new View.OnClickListener(){public void onClick(View v){addMalt();}});



    }

   public void addMalt(){


        EditText edtMaltName = (EditText) findViewById(R.id.edtMaltName);
        EditText edtMaltWeight = (EditText) findViewById(R.id.edtMaltWeight);
        EditText edtMaltPower = (EditText) findViewById(R.id.edtMaltPower);

        String maltName = edtMaltName.getText().toString();
        String maltWeight = edtMaltWeight.getText().toString();
        String maltPower = edtMaltPower.getText().toString();

        //ToDo: Check for zero inputs and not allow them

        Intent returnIntent = new Intent();
        returnIntent.putExtra("maltName",maltName);
        returnIntent.putExtra("maltWeight",maltWeight);
        returnIntent.putExtra("maltPower",maltPower);
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }
}
