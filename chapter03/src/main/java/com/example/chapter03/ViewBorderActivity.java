package com.example.chapter03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.chapter03.utils.Utils;

public class ViewBorderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_border);
        TextView content = findViewById(R.id.tv_content);
        ViewGroup.LayoutParams params = content.getLayoutParams();
        params.width = Utils.dip2px(this,200); // width设置的是px
        content.setLayoutParams(params);
    }
}