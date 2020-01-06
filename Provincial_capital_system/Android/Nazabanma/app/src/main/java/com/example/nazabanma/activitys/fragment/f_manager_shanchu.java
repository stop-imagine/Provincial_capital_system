package com.example.nazabanma.activitys.fragment;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nazabanma.R;
import com.example.nazabanma.activitys.activitys.HttpUtil;
import com.example.nazabanma.activitys.activitys.StudyGaoxiao;
import com.example.nazabanma.activitys.activitys.StudyJingdian;
import com.example.nazabanma.activitys.activitys.StudyMeishi;
import com.example.nazabanma.activitys.entity.shenghui;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class f_manager_shanchu extends Fragment{
    Button button1;
    EditText editText;
    public f_manager_shanchu() {
        // Required empty public constructor
    }
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        public void handleMessage(Message message){
            switch (message.what){
                case 1:
                    Toast.makeText(getActivity(), "删除成功", Toast.LENGTH_SHORT).show();
                    break;
                case 0:
                    Toast.makeText(getActivity(), "删除失败", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_f_manager_shanchu, container, false);
    }

    @Override
    public void onActivityCreated(Bundle saveInstanceState) {
        super.onActivityCreated(saveInstanceState);
        editText = getActivity().findViewById(R.id.iv_text1);
        button1 = getActivity().findViewById(R.id.btn_shanchu);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = editText.getText().toString();
                if(!TextUtils.isEmpty(input)){
                    String address = "http://111.231.141.166:80/shkp_system_war/DeleteServlet";
                    //Toast.makeText(getActivity(), input, Toast.LENGTH_SHORT).show();
                    deleteWithOkHttp(address, input);
                } else {
                    Toast.makeText(getActivity(), "省名不能为空", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void deleteWithOkHttp(String Address, String Shengmin) {
        HttpUtil.DeleteWithOkHttp(Address,Shengmin, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) { }
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
        Message message = new Message();
        message.what = 1;
        if(jsonData.equals("false")) {
            message.what = 0;
        }
        handler.sendMessage(message);
    }

}
