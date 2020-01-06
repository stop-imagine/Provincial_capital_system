package com.example.nazabanma.activitys.fragment;


import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nazabanma.R;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class f_user_setting extends Fragment {

    private Button button_fast, button_middle, button_slow, button_sure;
    private EditText et;
    private SharedPreferences.Editor editor;
    private SharedPreferences pref;

    public f_user_setting() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_setting, container, false);
    }

    @Override
    public void onActivityCreated(Bundle saveInstanceState) {
        super.onActivityCreated(saveInstanceState);
        button_fast = getActivity().findViewById(R.id.btn_setting_fast);
        button_middle = getActivity().findViewById(R.id.btn_setting_middle);
        button_slow = getActivity().findViewById(R.id.btn_setting_slow);
        button_sure = getActivity().findViewById(R.id.btn_setting_sure);
        et = getActivity().findViewById(R.id.et_setting_speed);

        pref = PreferenceManager.getDefaultSharedPreferences(getActivity());

        button_fast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor = pref.edit();
                editor.putInt("speed", 1);
                editor.apply();
                //1s
                Toast.makeText(getActivity(),"当前速度：快",Toast.LENGTH_SHORT).show();
            }
        });
        button_middle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor = pref.edit();
                editor.putInt("speed", 2);
                editor.apply();
                //2s
                Toast.makeText(getActivity(),"当前速度：中",Toast.LENGTH_SHORT).show();
            }
        });
        button_slow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor = pref.edit();
                editor.putInt("speed", 3);
                editor.apply();
                //3s
                Toast.makeText(getActivity(),"当前速度：慢",Toast.LENGTH_SHORT).show();
            }
        });
        button_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = et.getText().toString();
                if(str.equals("")) {
                    Toast.makeText(getActivity(),"您的输入为空，请重新输入！",Toast.LENGTH_SHORT).show();
                } else {
                    int i =Integer.parseInt(str);
                    if(i < 1 || i > 100) {
                        Toast.makeText(getActivity(),"请输入有效值：1 - 100 ！",Toast.LENGTH_SHORT).show();
                    } else {
                        editor = pref.edit();
                        editor.putInt("speed", i);
                        editor.apply();
                        Toast.makeText(getActivity(),"设置成功，当前速度为："+i+"秒/次",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

}
