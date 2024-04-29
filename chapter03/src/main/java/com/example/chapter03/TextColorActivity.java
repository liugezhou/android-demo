package com.example.chapter03;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class TextColorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_color);
        TextView tv_world = findViewById(R.id.tv_world);
        tv_world.setTextColor(Color.RED);//Color定义的
        TextView tv_color = findViewById(R.id.tv_color);
        tv_color.setTextColor(0xff00ff00);
        TextView tv_color_six = findViewById(R.id.tv_color_six);
        tv_color_six.setTextColor(0xff00ff); //代码六位是透明的
        TextView tv_xml_bg = findViewById(R.id.tv_java_bg);
        tv_xml_bg.setBackgroundColor(0x66666666);
    }
}