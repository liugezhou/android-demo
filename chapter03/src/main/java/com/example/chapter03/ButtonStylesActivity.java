package com.example.chapter03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.chapter03.utils.DateUtil;

public class ButtonStylesActivity extends AppCompatActivity {

    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_styles);
        // onCreate中代码执行一次
        // 控件的初始化放在onCreate中，因为这只要执行一次，如果放在click中会点击几次执行几次
        tv_result = findViewById(R.id.tv_result);
    }

    public void clickButton(View view){
        String desc = String.format("%s您点击了按钮：%s",DateUtil.getNowTime(),((Button)view).getText());
        tv_result.setText(desc);
    }
}