package com.example.pillapp2_300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class _0_frame_class extends AppCompatActivity {
    _0_global g_func;
    _0_permission permission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._1_pill);
        //jay
        btn_action();
    }

    void change_color(int num){
        ImageButton pill_btn = findViewById(R.id.pill_btn);
        ImageButton check_btn = findViewById(R.id.check_btn);
        ImageButton pe_btn = findViewById(R.id.pe_btn);

        if(num==1){
            pill_btn.setBackgroundColor(Color.rgb(116,191,183));
            check_btn.setBackgroundColor(Color.rgb(141,228,218));
            pe_btn.setBackgroundColor(Color.rgb(141,228,218));
        }
        else if(num==2){
            check_btn.setBackgroundColor(Color.rgb(116,191,183));
            pe_btn.setBackgroundColor(Color.rgb(141,228,218));
            pill_btn.setBackgroundColor(Color.rgb(141,228,218));
        }
        else if(num==3){
            pe_btn.setBackgroundColor(Color.rgb(116,191,183));
            pill_btn.setBackgroundColor(Color.rgb(141,228,218));
            check_btn.setBackgroundColor(Color.rgb(141,228,218));
        }
    }

    //-----함수 구현부
    //jay_method
    void btn_action(){
        //main으로 넘어가는 버튼 기능
        ImageButton pill_btn = findViewById(R.id.pill_btn);
        ImageButton check_btn = findViewById(R.id.check_btn);
        ImageButton pe_btn = findViewById(R.id.pe_btn);

        pill_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){//pill로 가는 스크립트
                Intent intent = new Intent(getApplicationContext(), _1_pill.class);


                //intent.putExtra("name", "gildong");
                startActivity(intent);
            }
        });
        //check로 넘어가는 버튼 기능
        check_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){//check로 넘어감
                Intent intent = new Intent(getApplicationContext(), _2_check.class);
                startActivity(intent);

            }
        });
        //pe로 넘어가는 버튼 기능
        pe_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), _3_pe.class);
                startActivity(intent);
            }
        });
    }

    void onclick(){

    }
}
