package com.example.pillapp2_300;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class _1_pill_input extends _0_frame_class {
    public String name;
    public String take_time;
    public String take_amount;
    public String stored;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._1_pill_input);
        //jay
        change_color(1);
        btn_action();


    }

    public void get_data(){
        EditText pill_name_edit = findViewById(R.id.pill_name);
        name = pill_name_edit.getText().toString();
        EditText pill_taketime_edit = findViewById(R.id.take_time);
        take_time = pill_taketime_edit.getText().toString();
        EditText pill_takeamount_edit = findViewById(R.id.take_amount);
        take_amount = pill_takeamount_edit.getText().toString();
        EditText pill_stored_edit = findViewById(R.id.take_amount);
        stored = pill_stored_edit.getText().toString();
    }

    public void submit_action(){
        ImageButton pill_btn = findViewById(R.id.submit_btn);

        pill_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){//pill로 가는 스크립트
                get_data();
                update_pillname();
                add_pill();
            }
        });

    }

    public void update_pillname(){
        SharedPreferences pref = getSharedPreferences("pillnames", MODE_PRIVATE);
        SharedPreferences.Editor editor=pref.edit(); EditText pill_name_edit = findViewById(R.id.pill_name);
        editor.putString(name,name);
        editor.commit();
    }
    public void add_pill(){
        SharedPreferences pref = getSharedPreferences(name, MODE_PRIVATE);
        SharedPreferences.Editor editor=pref.edit();
        JSONArray a = new JSONArray();
        a.put(take_time);
        a.put(take_amount);
        a.put(stored);
        editor.putString(name,a.toString());
        editor.commit();
    }

    //mk2ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
    public void set_pillnames(){

    }




    public void add_pills(String pname, String taketime, String takeamount, String pstored){
        SharedPreferences pref = getSharedPreferences(pname,MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        JSONArray a = new JSONArray();
        a.put(taketime);
        a.put(takeamount);
        a.put(pstored);
        editor.putString(pname, a.toString());
        editor.commit();
    }
    public ArrayList<String> get_pill(String pname){
        SharedPreferences pref = getSharedPreferences(pname, MODE_PRIVATE);
        String json = pref.getString(pname,null);
        ArrayList<String> values =  new ArrayList<String>();
        if(json !=null){
            try{
                JSONArray a = new JSONArray(json);
                values.add(a.optString(0));
                values.add(a.optString(1));
                values.add(a.optString(2));
                values.add(a.optString(3));
            }catch(JSONException e){
                e.printStackTrace();
            }
        }
        return values;
    }



}
