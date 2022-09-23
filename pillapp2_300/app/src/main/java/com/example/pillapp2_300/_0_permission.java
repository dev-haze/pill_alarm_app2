package com.example.pillapp2_300;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class _0_permission {
    private Context context;
    private Activity activity;

    private String[] permissions={
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.VIBRATE
    };

    private List permissionList;

    private final int MULTIPLE_PERMISSIONS=1023;
    public _0_permission(Activity _activity, Context context){
        this.activity=_activity;
        this.context=context;
    }
    public boolean checkPermission(){
        int rsult;
        permissionList = new ArrayList<>();

        for(String pm: permissions){
            rsult= ContextCompat.checkSelfPermission(context,pm);
            if(rsult!= PackageManager.PERMISSION_GRANTED){
                permissionList.add(pm);
            }
        }
        if(!permissionList.isEmpty()){
            return false;
        }
        return true;
    }

    public void requestPermission(){
        ActivityCompat.requestPermissions(activity,(String[]) permissionList.toArray(new String[permissionList.size()]),MULTIPLE_PERMISSIONS);
    }

    public boolean permissionResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults){
        if(requestCode==MULTIPLE_PERMISSIONS && (grantResults.length>0)){
            for(int i=0; i<grantResults.length; i++){
                if(grantResults[i]==-1){
                    return false;
                }
            }
        }
        return true;
    }

    public void permissionCheck() {
        // PermissionSupport.java 클래스 객체 생성
        // 권한 체크 후 리턴이 false로 들어오면
        if (!this.checkPermission()){
            //권한 요청
            this.requestPermission();
        }
    }

}
