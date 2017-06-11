package com.example.b3216.my_youtubesynchronizer.Room_Search;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by b3216 on 2017-05-27.
 */

public class SharedPreferenceData {
//    private static Context mContext;
//
//    public static void setContext(Context c) {
//        mContext = c;
//    }

    public static void saveSettingItem(Context context, String userId){
        SharedPreferences shareData = context.getSharedPreferences("user", MODE_PRIVATE);
        SharedPreferences.Editor editor = shareData.edit();
        editor.putString("userId", userId);
        editor.apply();
    }

    public static String getSettingItem(Context context){
        return context.getSharedPreferences("user",MODE_PRIVATE).getString("userId",null);
    }

    private static void removeSettingItem(Context context,String userId){
        SharedPreferences preferences = context.getSharedPreferences("user", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(userId);
        editor.apply();
    }

    private static void removeSettingAll(Context context) {
        SharedPreferences shareData = context.getSharedPreferences("user",MODE_PRIVATE);
        SharedPreferences.Editor editor = shareData.edit();
        editor.clear();
        editor.apply();
    }
}
