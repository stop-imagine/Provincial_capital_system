package com.example.nazabanma.activitys.activitys;
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
import com.example.nazabanma.activitys.fragment.f_manager_chaxun;
import com.example.nazabanma.activitys.fragment.f_manager_shanchu;
import com.example.nazabanma.activitys.fragment.f_manager_xiugai;
import com.example.nazabanma.activitys.fragment.f_manager_zengjia;
import com.example.nazabanma.activitys.fragment.f_user_play;
import com.example.nazabanma.activitys.fragment.f_user_search;
import com.example.nazabanma.activitys.fragment.f_user_setting;

public class ManagerHomeActivity extends BaseActivity implements View.OnClickListener{

    private FragmentManager fragmentManager;
    private RelativeLayout rl_content;
    private ImageView item1_iv,item2_iv,item3_iv,item4_iv;
    private TextView item1_tv,item2_tv,item3_tv,item4_tv;
    private LinearLayout item1,item2,item3,item4;
    private ImageView[] ivs;
    private TextView[] tvs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_home_manager);
        init();
        fragmentManager = getSupportFragmentManager();
        initListener();
    }

    private void init(){
        initNavBar(false,"省会科普系统",true);
        rl_content = (RelativeLayout) findViewById(R.id.rl_content);
        item1_iv = (ImageView) findViewById(R.id.gl_zengjia_iv);
        item1_tv = (TextView) findViewById(R.id.gl_zengjia_tv);
        item1 = (LinearLayout) findViewById(R.id.gl_zengjia);
        item2_iv = (ImageView) findViewById(R.id.gl_shanchu_iv);
        item2_tv = (TextView) findViewById(R.id.gl_shanchu_tv);
        item2 = (LinearLayout) findViewById(R.id.gl_shanchu);
        item3_iv = (ImageView) findViewById(R.id.gl_chaxun_iv);
        item3_tv = (TextView) findViewById(R.id.gl_chaxun_tv);
        item3 = (LinearLayout)findViewById(R.id.gl_chaxun);
        item4_iv = (ImageView) findViewById(R.id.gl_xiugai_iv);
        item4_tv = (TextView) findViewById(R.id.gl_xiugai_tv);
        item4 = (LinearLayout) findViewById(R.id.gl_xiugai);
        ivs = new ImageView[]{item1_iv,item2_iv,item3_iv,item4_iv};
        tvs = new TextView[]{item1_tv,item2_tv,item3_tv,item4_tv};
    }
    private void initListener() {
        item1.setOnClickListener(this);
        item2.setOnClickListener(this);
        item3.setOnClickListener(this);
        item4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.gl_zengjia: {
                FragmentTransaction transaction = fragmentManager.beginTransaction();//创建一个事务
                transaction.replace(R.id.rl_content,new f_manager_zengjia());
                transaction.commit();//事务一定要提交，replace才会有效
                setCheck(0);//自定义方法
                break;
            }
            case R.id.gl_shanchu: {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.rl_content,new f_manager_shanchu());
                transaction.commit();
                setCheck(1);
                break;
            }
            case R.id.gl_chaxun: {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.rl_content,new f_manager_chaxun());
                transaction.commit();
                setCheck(2);
                break;
            }
            case R.id.gl_xiugai: {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.rl_content,new f_manager_xiugai());
                transaction.commit();
                setCheck(3);
                break;
            }
            default:break;
        }
    }

    public void setCheck(int itemId){
        //这个方法设置底部导航栏选中时的效果
        for (int i = 0; i < 4; i++) {
            ivs[i].setColorFilter(Color.parseColor("#0f0f0f"));
            tvs[i].setTextColor(Color.parseColor("#0f0f0f"));
        }
        ivs[itemId].setColorFilter(Color.GREEN);
        tvs[itemId].setTextColor(Color.GREEN);
    }

}
