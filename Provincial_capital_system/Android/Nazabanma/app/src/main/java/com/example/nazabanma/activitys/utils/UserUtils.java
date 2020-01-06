package com.example.nazabanma.activitys.utils;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;

import com.blankj.utilcode.util.RegexUtils;
import com.example.nazabanma.activitys.activitys.LoginActivity;

public class UserUtils {
    /**
     * 验证管理员账号密码的合法性
     */
    public static boolean validateLogin(Context context, String phone, String password){
        //简单判断 正则表达式：以1开头，后面是10位数字
        //RegexUtils.isMobileSimple(phone);
        // 精确判断 正则表达式：目前各大运行商发布的号码开头
       // RegexUtils.isMobileExact(phone);
        if(!RegexUtils.isMobileExact(phone)){
            Toast.makeText(context,"无效手机号",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(context,"请输入密码",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    /**
     * 退出登录
     */
    public static void logout(Context context){
        Intent intent = new Intent(context, LoginActivity.class);
        //添加intent标识符，清理task栈，并且生成一个task栈
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
