package com.example.nazabanma.activitys.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.nazabanma.R;
import com.example.nazabanma.activitys.utils.UserUtils;

public class MeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_me);
        initView();
    }

    private void initView(){
        initNavBar(true, "个人中心", false);
    }

    /**
     * 退出登录
     */
    public void onLogoutClick(View v){
        UserUtils.logout(this);
    }
}
