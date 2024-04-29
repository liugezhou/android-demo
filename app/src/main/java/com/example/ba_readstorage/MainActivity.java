package com.example.ba_readstorage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONArray;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "liugezhou";
    private static final int STORAGE_PERMISSION_CODE = 1;

    private TextView fileInfoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button scanButton = findViewById(R.id.scanButton);
        fileInfoTextView = findViewById(R.id.fileInfoTextView);

        scanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 检查存储权限
                if (ContextCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    // 权限已授予，开始扫描文件
                    Log.d("liugezhou","开始扫描");
                    startScan();
                } else {
                    Log.d("liugezhou","请求存储权限");
                    // 请求存储权限
                    requestStoragePermission();
//                    startScan();
                }
            }
        });
    }

    private void requestStoragePermission() {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                STORAGE_PERMISSION_CODE);
    }

    private void startScan() {
        Log.d(TAG, "Starting file scan...");
        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            // Permission already granted, start scanning files
            Log.d(TAG, "Storage permission already granted, starting file scan...");
            FileScanner.scanFiles(getContentResolver(), new FileScanner.ScanCallback() {
                @Override
                public void onScanCompleted(JSONArray filesArray) {
                    Log.d("liugezhou","拿到的内容"+ filesArray.toJSONString());
                    showFileInfo(filesArray.toJSONString());
                }
            });
        } else {
            // Request storage permission
            Log.d(TAG, "Requesting storage permission...");
            requestStoragePermission();
        }
    }


    private void showFileInfo(String fileInfo) {
        fileInfoTextView.setText(fileInfo);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == STORAGE_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // 用户授权存储权限，开始扫描文件
                startScan();
            } else {
                // 用户拒绝授权，提示用户
                Toast.makeText(this, "Permission denied. Cannot scan files.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
