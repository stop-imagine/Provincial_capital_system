package com.example.nazabanma.activitys.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.nazabanma.R;
import com.example.nazabanma.activitys.fragment.f_user_play;
import com.example.nazabanma.activitys.fragment.f_user_search;
import com.example.nazabanma.activitys.fragment.f_user_setting;

public class UserHomeActivitiy extends BaseActivity implements View.OnClickListener{

    private FragmentManager fragmentManager;
    private RelativeLayout rl_content;
    private ImageView item1_iv,item2_iv,item3_iv;
    private TextView item1_tv,item2_tv,item3_tv;
    private LinearLayout item1,item2,item3;
    private ImageView[] ivs;
    private TextView[] tvs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_home_user);
        init();
        fragmentManager = getSupportFragmentManager();
        initListener();
    }

    private void init(){
        initNavBar(false,"省会科普系统",false);
        rl_content = (RelativeLayout) findViewById(R.id.rl_content);
        item1_iv = (ImageView) findViewById(R.id.user_search_iv);
        item1_tv = (TextView) findViewById(R.id.user_search_tv);
        item1 = (LinearLayout) findViewById(R.id.user_search);
        item2_iv = (ImageView) findViewById(R.id.user_play_iv);
        item2_tv = (TextView) findViewById(R.id.user_play_tv);
        item2 = (LinearLayout) findViewById(R.id.user_play);
        item3_iv = (ImageView) findViewById(R.id.user_setting_iv);
        item3_tv = (TextView) findViewById(R.id.user_setting_tv);
        item3 = (LinearLayout) findViewById(R.id.user_setting);
        ivs = new ImageView[]{item1_iv,item2_iv,item3_iv};
        tvs = new TextView[]{item1_tv,item2_tv,item3_tv};
    }
    private void initListener() {
        item1.setOnClickListener(this);
        item2.setOnClickListener(this);
        item3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.user_search: {
                FragmentTransaction transaction = fragmentManager.beginTransaction();//创建一个事务
                transaction.replace(R.id.rl_content,new f_user_search());
                transaction.commit();//事务一定要提交，replace才会有效
                setCheck(0);//自定义方法
                break;
            }
            case R.id.user_play: {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.rl_content,new f_user_play());
                transaction.commit();
                setCheck(1);
                break;
            }
            case R.id.user_setting: {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.rl_content,new f_user_setting());
                transaction.commit();
                setCheck(2);
                break;
            }
            default:break;
        }
    }

    public void setCheck(int itemId){
        //这个方法设置底部导航栏选中时的效果
        for (int i = 0; i < 3; i++) {
            ivs[i].setColorFilter(Color.parseColor("#0f0f0f"));
            tvs[i].setTextColor(Color.parseColor("#0f0f0f"));
        }
        ivs[itemId].setColorFilter(Color.GREEN);
        tvs[itemId].setTextColor(Color.GREEN);
    }

}
