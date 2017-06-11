package com.example.b3216.my_youtubesynchronizer.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.b3216.my_youtubesynchronizer.MainActivity;
import com.example.b3216.my_youtubesynchronizer.R;
import com.example.b3216.my_youtubesynchronizer.retrofit.DefaultClient;
import com.example.b3216.my_youtubesynchronizer.retrofit.LoginResponse;
import com.example.b3216.my_youtubesynchronizer.retrofit.LoginRetrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by b3216 on 2017-06-11.
 */

public class LoginActivity extends AppCompatActivity{
    String TAG = "KSS" + getClass().getSimpleName();
    DefaultClient<LoginRetrofit> loginDefaultClient;
    LoginRetrofit mLoginRetrofit;
    private String id, password;
    LoginResponse test = new LoginResponse();
    String type = "STANDARD";



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        Intent intent = new Intent(this.getIntent());

        initRetrofit();
        initView();
//        get("aaaa","1111", "STANDARD");


    }

    private LoginResponse get(String id, String password, String type){
        Call<LoginResponse> call = mLoginRetrofit.getStand(id, password, type);
        call.enqueue(new Callback<LoginResponse>(){
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response){
                if(response.isSuccessful()){
                    Log.d(TAG, "onResponse: success");
                    test = response.body();
                    GlobalApplication.getInstance().setUserToken(test.getData());
                    Log.d(TAG, "onResponse: " + test.getCode() + test.getMessage());
                    Log.d(TAG, "onResponse: " + test.getData().getAuthorizationToken());
                }
                else {
                    Log.d(TAG, "onResponse: fail");
                    Log.d(TAG, "onResponse: " + response.errorBody().toString());
//                    Log.d(TAG, "onResponse: " + response.body().getCode());
                }
            }
            
            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t){
                Log.d(TAG, "onFailure: fail2");
                t.printStackTrace();
            }
        });
        Log.d(TAG, "get: init");
        return test;
    }
    private void initRetrofit(){
        loginDefaultClient = new DefaultClient<>();
        mLoginRetrofit =loginDefaultClient.getClient(LoginRetrofit.class);
    }

    private void initView(){
        Button loginButton;
        final EditText idtext;
        final EditText passwordtext;

        idtext = (EditText) findViewById(R.id.idtext);
        passwordtext = (EditText) findViewById(R.id.passwordtext);
        loginButton = (Button) findViewById(R.id.login);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                get(idtext.getText().toString(), passwordtext.getText().toString(),"STANDARD");
                Intent intent1 = new Intent(LoginActivity.this , MainActivity.class);
                startActivity(intent1);
            }
        });
    }
}
