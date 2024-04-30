package com.example.chapter03;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ImageScaleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_scale);
        ImageView image = findViewById(R.id.image_scale);
        image.setImageResource(R.drawable.logo);
        image.setScaleType(ImageView.ScaleType.FIT_CENTER);
    }
}