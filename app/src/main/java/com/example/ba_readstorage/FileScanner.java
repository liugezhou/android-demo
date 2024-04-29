package com.example.ba_readstorage; // 请根据你的包名修改这里的包名

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class FileScanner {

    private static final String TAG = "liugezhou";

    public interface ScanCallback {
        void onScanCompleted(JSONArray filesArray);
    }

    public static void scanFiles(ContentResolver contentResolver, ScanCallback callback) {
        JSONArray filesArray = new JSONArray();
        try {
            Uri uri = MediaStore.Files.getContentUri("external");
            String[] projection = {
                    MediaStore.Files.FileColumns.DATA,
                    MediaStore.Files.FileColumns.DISPLAY_NAME,
                    MediaStore.Files.FileColumns.SIZE,
                    MediaStore.Files.FileColumns.DATE_ADDED
            };
            String selection = MediaStore.Files.FileColumns.DATA + " LIKE ?";
            String[] selectionArgs = new String[]{"%/sdcard/download/%.xlsx"};

            Log.d("liugezhou","开始进行循环了！！！！");
            Log.d("liugezhou","开始进行循环了！！！！");
            Cursor cursor = contentResolver.query(uri, projection, selection, selectionArgs, null);
            Log.d("liugezhou", cursor.toString());
            if (cursor != null) {
                Log.d("liugezhou", "cursor不是 null");
                while (cursor.moveToNext()) {
                    Log.d("liugezhou", "cursor不是 null!!!!!!!!!");
                    String filePath = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Files.FileColumns.DATA));
                    Log.d("liugezhou","filePath" + filePath);
                    String fileName = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Files.FileColumns.DISPLAY_NAME));
                    long fileSize = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Files.FileColumns.SIZE));
                    long fileDateAdded = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Files.FileColumns.DATE_ADDED));

                    JSONObject fileObject = new JSONObject();
                    fileObject.put("filePath", filePath);
                    fileObject.put("fileName", fileName);
                    fileObject.put("fileSize", fileSize);
                    fileObject.put("fileDateAdded", fileDateAdded);

                    filesArray.add(fileObject);
                }
                cursor.close();
            }
        } catch (Exception e) {
            Log.e(TAG, "Error scanning files: " + e.getMessage());
        }
       Log.d("ssssss",String.valueOf(filesArray));
        // 调用回调方法，将扫描结果传递给调用者
        callback.onScanCompleted(filesArray);
    }

}

