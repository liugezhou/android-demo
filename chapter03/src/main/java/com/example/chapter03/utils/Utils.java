package com.example.chapter03.utils;

import android.content.Context;

public class Utils {
    public static int dip2px(Context context, float dpValue){
        // 获取当前手机的像素密度(1个dp对应几个 px)
        float scale = context.getResources().getDisplayMetrics().density;
        return (int)(dpValue * scale + 0.5f);
    }
}
