package com.example.nazabanma.activitys.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.example.nazabanma.R;
import com.example.nazabanma.activitys.activitys.MainActivity;

import java.util.Timer;
import java.util.TimerTask;

//1.延迟三秒
//2.跳转页面
public class WelcomeActivity extends BaseActivity {
    private Timer mTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_welcome);
        init();
    }
    /**
     * 初始化
     */
    private void init(){
        mTimer = new Timer();
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                Log.e("WelcomeActivity", "当前线程为 ：" +Thread.currentThread());
                toMain();
            }
        }, 3*1000);
    }

    private void toMain(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
