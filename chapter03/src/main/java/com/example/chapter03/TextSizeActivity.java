package com.example.chapter03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class TextSizeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_size);
//        TextView hello = findViewById(R.id.tv_hello);
//        hello.setTextSize(30); //SP,官方推荐使用 sp 单位
    }
}