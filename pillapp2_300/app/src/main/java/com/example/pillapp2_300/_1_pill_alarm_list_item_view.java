package com.example.pillapp2_300;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class _1_pill_alarm_list_item_view extends LinearLayout  {
    TextView name, amount, time;

    public _1_pill_alarm_list_item_view(Context context){
        super(context);
        init(context);
    }

    public _1_pill_alarm_list_item_view(Context context, @Nullable AttributeSet attrs){
        super(context,attrs);
    }
    private void init(Context context){
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout._1_pill_list_item,this,true);
        this.name=findViewById(R.id.name);
        this.amount=findViewById(R.id.amount);
        this.time=findViewById(R.id.time);
        this.time=findViewById(R.id.time);
    }
    public void setName(String name){
        this.name.setText(name);
    }
    public void setAmount(int amount){
        this.amount.setText( Integer.toString(amount));
    }
    public void setTime(int time){
        this.time.setText(Integer.toString(time));
    }



}
