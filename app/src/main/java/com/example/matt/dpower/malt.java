package com.example.matt.dpower;

/**
 * Created by matt on 15/01/18.
 *
 * Malt Class: the malt has a name, weight and a diastatic power.
 * Each malt can have its name set and its power value set.
 *
 */

public class malt {

    String name;
    double weight;
    int power;

    public malt(String n, double w, int p){
        name = n;
        weight = w;
        power = p;
    }

    public String getName(){
        return name;
    }

    public double getWeight(){
        return weight;
    }

    public int getPower(){
        return power;
    }

}
