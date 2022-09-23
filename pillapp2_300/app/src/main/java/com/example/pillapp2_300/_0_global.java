package com.example.pillapp2_300;

import android.app.Application;
import android.os.Vibrator;

import androidx.appcompat.app.AlertDialog;

import com.example.pillapp2_300.R;
import com.example.pillapp2_300._1_pill_alarm_data;

public class _0_global extends Application {
    _1_pill_alarm_data[] pillDat;



    //pill
    public void pill_check(){

    }
    public void pill_alarm(String name, int amount, int time){
        Vibrator vib = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        vib.vibrate(60000);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.ic_launcher_background);
        builder.setMessage(name+"을 "+Integer.toString(amount)+"만큼 드셔야 해요!");
        builder.setTitle(to_hm(time));
        builder.setPositiveButton("OK",null);
        builder.setNegativeButton("NO",null);

        AlertDialog alertDialog;
        alertDialog=builder.create();
        alertDialog.show();
    }
    public String to_hm(int time){
        int h = time/60;
        int m = time%60;
        return (Integer.toString(h)+":"+Integer.toString(m));
    }

}
