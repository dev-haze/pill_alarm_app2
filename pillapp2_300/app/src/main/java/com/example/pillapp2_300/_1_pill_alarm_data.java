package com.example.pillapp2_300;

public class _1_pill_alarm_data {
    public String name;
    public String time;
    public String amount;
    public String stored;


    public _1_pill_alarm_data(){

    }
    public void add(String name, String time, String amount, String stored){
        this.name=name;
        this.time=time;
        this.amount=amount;
        this.stored=stored;
    }

}
