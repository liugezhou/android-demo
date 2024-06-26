package com.example.chapter03;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuProvider;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import com.example.chapter03.utils.DateUtil;

public abstract class ButtonClickActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_click);
        textView = findViewById(R.id.tv_text_view);
        Button tv_button = findViewById(R.id.tv_button);
        Button tv_button_public = findViewById(R.id.tv_button_public);
        tv_button.setOnClickListener(new MyFirstButtonListener(textView)); //逻辑一：第一种监听 click 事件
        tv_button_public.setOnClickListener(this); //逻辑二：第二种监听click事件。方法实现了View.OnClickListener,然后实现onClick方法，通过判断 id判断是哪个点击

        TextView tv_long_click = findViewById(R.id.tv_button_long);
        tv_long_click.setOnLongClickListener(v -> {
            String desc = String.format("%s 您长按点击了按钮 3：%s",DateUtil.getNowTime(),((Button)v).getText());
            tv_long_click.setText(desc);
            return true;
        });
    }

    @Override
    public void onClick(View v) {
        Log.d("liugezhou","smqng");
        if(v.getId() == R.id.tv_button_public){
            Log.d("liugezhou","public");
            String desc = String.format("%s 您点击了按钮2：%s", DateUtil.getNowTime(), ((Button) v).getText());
            textView.setText(desc);
        }
    }

    static class MyFirstButtonListener implements View.OnClickListener {
        private final TextView textView;

        public MyFirstButtonListener(TextView textView) {
            this.textView = textView;
        }

        @Override
        public void onClick(View v) {
            Log.d("liugezhou", "进入 onClick方法");
            String desc = String.format("%s 您点击了按钮：%s", DateUtil.getNowTime(), ((Button) v).getText());
            textView.setText(desc);
        }
    }
}