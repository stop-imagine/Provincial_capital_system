package com.example.nazabanma.activitys.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.nazabanma.R;
import com.example.nazabanma.activitys.activitys.StudyGaoxiao;
import com.example.nazabanma.activitys.activitys.StudyJingdian;
import com.example.nazabanma.activitys.activitys.StudyMeishi;

/**
 * A simple {@link Fragment} subclass.
 */
public class f_user_play extends Fragment{


    Button button1, button2, button3;
    public f_user_play() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_play, container, false);
    }

    @Override
    public void onActivityCreated(Bundle saveInstanceState) {
        super.onActivityCreated(saveInstanceState);
        button1 = getActivity().findViewById(R.id.btn_play_jingdian);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), StudyJingdian.class);
                startActivity(intent);
            }
        });
        button2 = getActivity().findViewById(R.id.btn_play_meishi);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), StudyMeishi.class);
                startActivity(intent);
            }
        });
        button3 = getActivity().findViewById(R.id.btn_play_gaoxiao);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), StudyGaoxiao.class);
                startActivity(intent);
            }
        });
    }

}
