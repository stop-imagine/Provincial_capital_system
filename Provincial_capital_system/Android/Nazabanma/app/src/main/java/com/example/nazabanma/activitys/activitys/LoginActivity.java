package com.example.nazabanma.activitys.activitys;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nazabanma.R;
import com.example.nazabanma.activitys.utils.UserUtils;
import com.example.nazabanma.activitys.views.inputView;

public class LoginActivity extends BaseActivity {

    private inputView mInputPhone, mInputPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);
        initView();
    }

    private  void initView(){
        initNavBar(false,"登录",false);
        mInputPhone = fd(R.id.input_phone);
        mInputPassword = fd(R.id.input_password);
    }

    public void onCommitClick(View v){
        String phone = mInputPhone.getInputStr();
        String password = mInputPassword.getInputStr();
        if(!UserUtils.validateLogin(this, phone, password)){
            return;
        }
        if(phone.equals("15919569156") && password.equals("123456")){
            Intent intent=new Intent(LoginActivity.this, ManagerHomeActivity.class);
            startActivity(intent);
            finish();
            Toast.makeText(this, "登录成功！",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "账号密码错误！", Toast.LENGTH_SHORT).show();
        }
    }
}

