package com.example.b3216.my_youtubesynchronizer.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.b3216.my_youtubesynchronizer.R;
import com.example.b3216.my_youtubesynchronizer.retrofit.DataApiClient;
import com.example.b3216.my_youtubesynchronizer.retrofit.DefaultRestClient;
import com.example.b3216.my_youtubesynchronizer.retrofit.Join;
import com.example.b3216.my_youtubesynchronizer.retrofit.JoinResponse;
import com.example.b3216.my_youtubesynchronizer.retrofit.LoginRetrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by b3216 on 2017-06-03.
 */

public class JoinActivity extends AppCompatActivity{
    String TAG = "KSS" + getClass().getSimpleName();
    DefaultRestClient<LoginRetrofit> loginDefaultClient;
    LoginRetrofit mLoginRetrofit;
    Join join = new Join();
    Button joinButton;
    EditText idText, nickText, passText;
    private String id, nick, pass;
    private DataApiClient<LoginRetrofit> mClient;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join_activity);

        Intent intent = new Intent(this.getIntent());
//        initRetrofit();
        initJoin();
        initView();



    }

    private void initJoin(){
        loginDefaultClient = new DefaultRestClient<>();
        mLoginRetrofit = loginDefaultClient.getClient(LoginRetrofit.class);
    }

    private void post(String id, String nick, String password, String type ){
        Call<JoinResponse> call = mLoginRetrofit.postStand(new Join(id, nick, password,type));
        call.enqueue(new Callback<JoinResponse>(){
            @Override
            public void onResponse(Call<JoinResponse> call, Response<JoinResponse> response){
                if(response.isSuccessful()){
                    Log.d(TAG, "onResponse: success");
                    JoinResponse test = response.body();
                    Log.d(TAG, "onResponse: " +test.getCode() +test.getMessage());
                }
                else {
                    Log.d(TAG, "onResponse: fail");
                    Log.d(TAG, "onResponse: " + response.errorBody().toString());
                    Log.d(TAG, "onResponse: "+response.body().getCode());
                }
            }

            @Override
            public void onFailure(Call<JoinResponse> call, Throwable t){
                Log.d(TAG, "onFailure: fail2");
                t.printStackTrace();
            }
        });

        Log.d(TAG, "post: init");
    }

    private void initView(){
        joinButton = (Button) findViewById(R.id.join);
        idText = (EditText) findViewById(R.id.id);
        nickText = (EditText)findViewById(R.id.nick);
        passText = (EditText) findViewById(R.id.pass);



        joinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                post(idText.getText().toString(),nickText.getText().toString(),passText.getText().toString(),"STANDARD");
            }
        });

    }

    private void initRetrofit(){
        loginDefaultClient = new DefaultRestClient<>();
        mLoginRetrofit =loginDefaultClient.getClient(LoginRetrofit.class);
    }
}
