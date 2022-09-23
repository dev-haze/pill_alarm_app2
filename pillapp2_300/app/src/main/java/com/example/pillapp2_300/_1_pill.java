package com.example.pillapp2_300;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.BaseAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class _1_pill extends _0_frame_class {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._1_pill);
        //jay
        change_color(1);
        btn_action();
        createClick();



        //list
        ListView listView=findViewById(R.id.list);
        SingleAdapter adapter = new SingleAdapter();
        adapter.addItem(new _1_pill_alarm_list_item("test1", 1, 1));
        adapter.addItem(new _1_pill_alarm_list_item("test1", 1, 1));
        adapter.addItem(new _1_pill_alarm_list_item("test2", 1, 1));
        adapter.addItem(new _1_pill_alarm_list_item("test3", 1, 1));
        adapter.addItem(new _1_pill_alarm_list_item("test4", 1, 1));
        adapter.addItem(new _1_pill_alarm_list_item("test5", 1, 1));


        init_listview();


    }

    public void init_listview(){
        ListView listView = findViewById(R.id.list);
        SingleAdapter adapter = new SingleAdapter();

        ArrayList<String> names = get_pref_list("names");
        ArrayList<String> take_times = get_pref_list("take_times");
        ArrayList<String> take_amounts = get_pref_list("names");

        for(int i=0; i<names.size(); i++){
            adapter.addItem(new _1_pill_alarm_list_item(names.get(i),Integer.parseInt(take_times.get(i)),Integer.parseInt(take_amounts.get(i))));
        }
        listView.setAdapter(adapter);
    }


    public ArrayList<String> get_pref_list(String key){
        SharedPreferences pref = getSharedPreferences(key, MODE_PRIVATE);
        String json = pref.getString(key,null);
        ArrayList<String> values = new ArrayList<String>();
        if(json != null){
            try{
                JSONArray a = new JSONArray(json);
                for(int i=0; i<a.length(); i++){
                    values.add(a.optString(i));
                }
            }catch(JSONException e){
                e.printStackTrace();
            }
        }
        return values;
    }



    //list--------------------------------------------------
    public void add_item(String name, int amount, int time){
        ListView listView=findViewById(R.id.list);
        SingleAdapter adapter = new SingleAdapter();
        adapter.addItem(new _1_pill_alarm_list_item(name, amount, time));
    }


    class SingleAdapter extends BaseAdapter{
        ArrayList<_1_pill_alarm_list_item> items=new ArrayList<_1_pill_alarm_list_item>();
        @Override
        public int getCount(){
            return items.size();
        }
        public void addItem(_1_pill_alarm_list_item item){
            items.add(item);
        }
        @Override
        public Object getItem(int position){
            return items.get(position);
        }
        @Override
        public long getItemId(int position){
            return position;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            _1_pill_alarm_list_item_view pillview = null;
            if(convertView==null){
                pillview=new _1_pill_alarm_list_item_view(getApplicationContext());
            }else{
                pillview=(_1_pill_alarm_list_item_view)convertView;
            }
            _1_pill_alarm_list_item item = items.get(position);
            pillview.setName(item.get_name());
            pillview.setTime(item.get_time());
            pillview.setAmount(item.get_amount());
            return pillview;
        }

    }


    void createClick(){
        ImageButton create_btn = findViewById(R.id.create_btn);
        create_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), _1_pill_logic_input.class);
                startActivity(intent);
            }
        });
    }

}