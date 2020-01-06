package com.example.nazabanma.activitys.activitys;

import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.example.nazabanma.R;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nazabanma.activitys.entity.shenghui;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;


import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class StudyGaoxiao extends BaseActivity implements View.OnClickListener {

    private Button play;
    private int btnPlayFlay = 0;
    private Timer timer = new Timer();
    private TimerTask timerTask;
    private int GlideFlag = 1;
    private TextView ivText1;
    private TextView ivText2;
    private TextView ivText3;
    private int speed;
    private String shengming;
    private String huiming;
    private String gaoxiao;

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    // if(flag){
                    if(GlideFlag > 34) {
                        GlideFlag = 1;
                    }
                    String address = "http://111.231.141.166:80/shkp_system_war/ShenghuiServlet";
                    String id = String.valueOf(GlideFlag);
                    shenghuiWithOkHttp(address, id);
                {}
                ivText1.setText(shengming);
                ivText2.setText(huiming);
                ivText3.setText(gaoxiao);
                GlideFlag++;
                break;
            }
        }
    };
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏顶部栏
        getSupportActionBar().hide();
        setContentView(R.layout.activity_study_gaoxiao);
        init();
        play = findViewById(R.id.btn_play);
        play.setOnClickListener(this);
        ivText1 = findViewById(R.id.iv_text1);
        ivText2 = findViewById(R.id.iv_text2);
        ivText3 = findViewById(R.id.iv_text3);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        speed = pref.getInt("speed",2) * 1000;
    }

    private void init(){
        initNavBar(false,"高校",false);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_play:
                btnPlayFlay++;
                if (btnPlayFlay%2==1) {
                    play.setText("暂停");
                    Toast.makeText(StudyGaoxiao.this,"当前速度为:"+speed/1000+"秒一次",Toast.LENGTH_SHORT).show();
                    startTimer();
                }
                else{
                    play.setText("开始");
                    stopTimer();
                }
                break;
            default:
                break;
        }
    }

    //开启计时器
    private void startTimer(){
        if (timer == null) {
            timer = new Timer();
        }
        //计时器任务
        if (timerTask == null) {
            timerTask = new TimerTask() {
                @Override
                public void run() {
                    Message message = new Message();
                    message.what = 1;
                    handler.sendMessage(message);
                }
            };
        }
        if(timer != null && timer != null )
            timer.schedule(timerTask,speed,speed);        //延迟1S后执行一次timerTask,然后每隔4s执行一次timerTask
    }

    //关闭计时器,应该关闭计时器并清空,关闭计时器任务并清空,否则开启关闭计时器后再开启计时器会造成崩溃
    private void stopTimer(){
        if (timer != null) {
            timer.cancel();
            timer= null;
        }
        if (timerTask != null) {
            timerTask.cancel();
            timerTask = null;
        }
    }

    private void shenghuiWithOkHttp(String Address, String id) {
        HttpUtil.ShenghuiWithOkHttp(Address,id, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //得到服务器返回的具体内容
                final String responseData = response.body().string();       //返回你的response
                System.out.println("响应信息： " + responseData);
                parseJSONWithGSON(responseData);
            }
        });
    }
    private void parseJSONWithGSON(String jsonData) {
        Gson gson = new Gson();
        shenghui sh = gson.fromJson(jsonData, shenghui.class);
        shengming = sh.getShengming();
        huiming = sh.getHuiming();
        gaoxiao = sh.getGaoxiao();
    }
}

