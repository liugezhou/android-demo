package com.example.chapter03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.chapter03.utils.DateUtil;

/**
 * 长按点击按钮事件
 */
public class ButtonLongActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_long);
        TextView tv_result = findViewById(R.id.tv_text_view);
        Button tv_long_click = findViewById(R.id.tv_button_long);
        tv_long_click.setOnLongClickListener(v -> {
            String desc = String.format("%s 您长按点击了按钮 3：%s", DateUtil.getNowTime(),((Button)v).getText());
            tv_result.setText(desc);
            return true;
        });
    }
}