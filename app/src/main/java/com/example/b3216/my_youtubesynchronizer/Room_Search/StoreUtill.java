package com.example.b3216.my_youtubesynchronizer.Room_Search;

import android.content.Context;
import android.util.Log;

import static com.example.b3216.my_youtubesynchronizer.Room_Search.SharedPreferenceData.saveSettingItem;

/**
 * Created by b3216 on 2017-05-27.
 */

public class StoreUtill {
    static String TAG = "ss";
        public static Context mContext;

    public static void setContext(Context c) {
        mContext = c;
    }

    public static void storeUserId(String userId){
        saveSettingItem(mContext, userId);
        Log.d(TAG, "storeUserId() called with: userId = [" + userId + "]");
    }
}
