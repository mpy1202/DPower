package com.example.matt.dpower;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by matt on 15/01/18.
 */

public class adapter_malt extends BaseAdapter {

    LayoutInflater mInflater;
    ArrayList<String> malts;
    ArrayList<Double> weight;
    ArrayList<Integer> power;

    public adapter_malt(Context c, ArrayList<String> m, ArrayList<Double> w, ArrayList<Integer> p){
        malts = m;
        weight = w;
        power = p;

        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return malts.size();
    }

    @Override
    public Object getItem(int i) {
        return malts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v = mInflater.inflate(R.layout.malt_list_detail, null);
        TextView textView_name = (TextView) v.findViewById(R.id.textView_name);
        TextView textView_power = (TextView) v.findViewById(R.id.textView_power);
        TextView textView_weight = (TextView) v.findViewById(R.id.textView_weight);

        String maltName  = malts.get(i);
        String maltWeight =String.format("%.1f kg",weight.get(i));
        String maltPower = String.format("%d °L", power.get(i));

        textView_name.setText(maltName);
        textView_power.setText(maltPower);
        textView_weight.setText(maltWeight);


        return v;
    }
}
