package com.example.pillapp2_300;

public class _1_pill_alarm_list_item {
    String name;
    int time;
    int amount;

    public _1_pill_alarm_list_item(String name, int time, int amount) {
        this.name = name;
        this.time = time;
        this.amount = amount;
    }

    public String get_name() {
        return name;
    }

    public int get_time() {
        return time;
    }

    public int get_amount() {
        return amount;
    }
}
