package com.example.chapter03;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuProvider;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.chapter03.utils.DateUtil;

public  class ButtonEnableActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_test;
    private TextView tv_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_enable);
        Button btn_restart = findViewById(R.id.btn_restart);
        Button btn_close = findViewById(R.id.btn_close);
        btn_test = findViewById(R.id.btn_test);
        tv_view = findViewById(R.id.tv_view);

        btn_restart.setOnClickListener(this);
        btn_close.setOnClickListener(this);
        btn_test.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_restart){
            btn_test.setEnabled(true);
            btn_test.setTextColor(Color.BLACK);
        }else if(v.getId() == R.id.btn_close){
            btn_test.setEnabled(false);
            btn_test.setTextColor(Color.GRAY);
        }else if(v.getId() == R.id.btn_test){
            String desc = String.format("%s 您点击了按钮:%s", DateUtil.getNowTime(),((Button) v).getText());
            tv_view.setText(desc);
        }
    }

    @Override
    public void addMenuProvider(@NonNull MenuProvider provider, @NonNull LifecycleOwner owner, @NonNull Lifecycle.State state) {

    }
}