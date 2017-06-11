package com.example.b3216.my_youtubesynchronizer.login;

import android.app.Application;
import android.util.Log;

import com.example.b3216.my_youtubesynchronizer.retrofit.TokenDTO;

/**
 * Created by b3216 on 2017-06-11.
 */

public class GlobalApplication extends Application {
    private static GlobalApplication mInstance;
    private String TAG = "kss";
    private TokenDTO userToken;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }
    public void setUserToken(TokenDTO token){
        userToken = token;
        Log.d(TAG, "setUserToken() called with: token = [" + token.toString() + "]");
    }
    public TokenDTO getUserToken(){
        return userToken;
    }

    public static GlobalApplication getInstance() {
        return mInstance;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();

        mInstance = null;
    }
}
