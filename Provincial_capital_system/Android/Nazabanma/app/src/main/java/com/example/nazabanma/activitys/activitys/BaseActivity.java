package com.example.nazabanma.activitys.activitys;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import com.example.nazabanma.R;

public class BaseActivity extends AppCompatActivity {


    private ImageView mIvBack, mIvMe;
    private TextView mTvTitle;

    protected <T extends View> T fd(@IdRes int id){
        return findViewById(id);
    }
    //ActionBar 初始化
    protected void initNavBar(boolean isShowBack, String title, boolean isShowMe){
        mIvBack = fd(R.id.iv_back);
        mTvTitle = fd(R.id.tv_title);
        mIvMe = fd(R.id.iv_me);

        mIvBack.setVisibility(isShowBack ? View.VISIBLE : View.GONE);
        mIvMe.setVisibility(isShowMe ? View.VISIBLE : View.GONE);
        mTvTitle.setText(title);

        mIvBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                onBackPressed();               //执行回退操作
            }
        });
        mIvMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BaseActivity.this, MeActivity.class));
            }
        });

    }
}
