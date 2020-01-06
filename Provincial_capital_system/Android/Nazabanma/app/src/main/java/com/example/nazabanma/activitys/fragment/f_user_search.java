package com.example.nazabanma.activitys.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nazabanma.R;
import com.example.nazabanma.activitys.activitys.HttpUtil;
import com.example.nazabanma.activitys.entity.shenghui;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class f_user_search extends Fragment {

    private EditText editText;
    private ImageView input_search;
    private TextView tv1, tv2, tv3, tv4;
    private String huiming, meishi, jingdian, gaoxiao;
    public f_user_search() {
        // Required empty public constructor
    }

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        public void handleMessage(Message message){
            switch (message.what){
                case 0:
                    tv1.setText("");
                    tv2.setText("");
                    tv3.setText("");
                    tv4.setText("");
                    Toast.makeText(getActivity(), "该省名不存在", Toast.LENGTH_SHORT).show();
                    break;
                case 1:
                    tv1.setText(huiming);
                    tv2.setText(meishi);
                    tv3.setText(jingdian);
                    tv4.setText(gaoxiao);
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
        return inflater.inflate(R.layout.fragment_user_search, container, false);
    }
    @Override
    public void onActivityCreated(Bundle saveInstanceState) {
        super.onActivityCreated(saveInstanceState);
        editText = getActivity().findViewById(R.id.user_search_input);
        input_search = getActivity().findViewById(R.id.user_search_image);
        tv1 = getActivity().findViewById(R.id.iv_text1);
        tv2 = getActivity().findViewById(R.id.iv_text2);
        tv3 = getActivity().findViewById(R.id.iv_text3);
        tv4 = getActivity().findViewById(R.id.iv_text4);

        input_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = editText.getText().toString();
                if(!TextUtils.isEmpty(input)){
                    String address = "http://111.231.141.166:80/shkp_system_war/SelectServlet";
                    selectWithOkHttp(address, input);
                } else {
                    Toast.makeText(getActivity(), "省名不能为空", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void selectWithOkHttp(String Address, String Shengmin) {
        HttpUtil.selectWithOkHttp(Address,Shengmin, new Callback() {
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
        shenghui sh = gson.fromJson(jsonData, shenghui.class);
        huiming = sh.getHuiming();
        meishi = sh.getMeishi();
        jingdian = sh.getJingdian();
        gaoxiao = sh.getGaoxiao();
        Log.d("chaxun", "huiming is " + huiming);
        Log.d("chaxun", "meishi is " + meishi);
        Log.d("chaxun", "jingdian is " + jingdian);
        Log.d("chaxun", "gaoxiao is " + gaoxiao);

        Message message = new Message();
        message.what = 1;
        if(meishi == null) {
            message.what = 0;
        }
        handler.sendMessage(message);

    }


}
