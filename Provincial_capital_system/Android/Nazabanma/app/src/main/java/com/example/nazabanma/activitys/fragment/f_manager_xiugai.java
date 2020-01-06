package com.example.nazabanma.activitys.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nazabanma.R;
import com.example.nazabanma.activitys.activitys.HttpUtil;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class f_manager_xiugai extends Fragment{

    private EditText et1, et2, et3, et4, et5;
    private Button button1;
    public f_manager_xiugai() {
        // Required empty public constructor
    }
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        public void handleMessage(Message message){
            switch (message.what){
                case 1:
                    Toast.makeText(getActivity(), "修改成功", Toast.LENGTH_SHORT).show();
                    break;
                case 0:
                    Toast.makeText(getActivity(), "修改失败", Toast.LENGTH_SHORT).show();
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
        return inflater.inflate(R.layout.fragment_f_manager_xiugai, container, false);
    }

    @Override
    public void onActivityCreated(Bundle saveInstanceState) {
        super.onActivityCreated(saveInstanceState);
        et1 = getActivity().findViewById(R.id.iv_text1);
        et2 = getActivity().findViewById(R.id.iv_text2);
        et3 = getActivity().findViewById(R.id.iv_text3);
        et4 = getActivity().findViewById(R.id.iv_text4);
        et5 = getActivity().findViewById(R.id.iv_text5);
        button1 = getActivity().findViewById(R.id.btn_xiugai);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String address = "http://111.231.141.166:80/shkp_system_war/UpdateServlet";
                String addShengming = et1.getText().toString();
                String addHuiming = et2.getText().toString();
                String addMeishi = et3.getText().toString();
                String addJingdian = et4.getText().toString();
                String addGaoxiao = et5.getText().toString();
                updateWithOkHttp(address,addShengming,addHuiming,addMeishi,addJingdian,addGaoxiao);
            }
        });
    }

    private void updateWithOkHttp(String address, String addShengming, String addHuiming, String addMeishi, String addJingdian, String addGaoxiao) {
        HttpUtil.updateWithOkHttp(address, addShengming, addHuiming, addMeishi, addJingdian, addGaoxiao, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) { }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //得到服务器返回的具体内容
                final String responseData = response.body().string();       //返回你的response
                System.out.println("响应信息： " + responseData);
                parseJSONWithGSON(responseData);
            }

            private void parseJSONWithGSON(String jsonData) {
                Message message = new Message();
                message.what = 1;
                if(jsonData.equals("false")) {
                    message.what = 0;
                }
                handler.sendMessage(message);
            }
        });
    }

}
