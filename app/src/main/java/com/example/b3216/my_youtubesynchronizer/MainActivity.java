package com.example.b3216.my_youtubesynchronizer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.b3216.my_youtubesynchronizer.Room_Search.HashmapToYoutubeSearchResult;
import com.example.b3216.my_youtubesynchronizer.Room_Search.Search_List_Dto;
import com.example.b3216.my_youtubesynchronizer.Room_Search.YoutubeSearchResult;
import com.example.b3216.my_youtubesynchronizer.Room_Video.Video;
import com.example.b3216.my_youtubesynchronizer.login.JoinActivity;
import com.example.b3216.my_youtubesynchronizer.login.LoginActivity;
import com.example.b3216.my_youtubesynchronizer.retrofit.DataApiClient;
import com.example.b3216.my_youtubesynchronizer.retrofit.DefaultRestClient;
import com.example.b3216.my_youtubesynchronizer.retrofit.Join;
import com.example.b3216.my_youtubesynchronizer.retrofit.LoginRetrofit;
import com.example.b3216.my_youtubesynchronizer.retrofit.RoomSearchRetrofit;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.b3216.my_youtubesynchronizer.Room_Search.SharedPreferenceData.getSettingItem;
import static com.example.b3216.my_youtubesynchronizer.Room_Search.StoreUtill.setContext;
import static com.example.b3216.my_youtubesynchronizer.Room_Search.StoreUtill.storeUserId;

public class MainActivity extends AppCompatActivity{

    private final String TAG = "SS" +getClass().getSimpleName();
    private DataApiClient<RoomSearchRetrofit> mClient;
    private RoomSearchRetrofit mRoomSearchRetrofit;
    private final String DataApiKey = "AIzaSyCBhDNNMTrvPrpzrZx6BsWlDsPKNArQcEI";
    private String Searchword ="";
    private ListView listView;
    private EditText editText;
    private Button sendButton;
    private String userName;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    private String userId = null;
    private DatabaseReference userRef = null;
    private ArrayAdapter adapter;
    private Button joinButton;
    private Button loginButton;
    DefaultRestClient<LoginRetrofit> loginDefaultClient;
    LoginRetrofit mLoginRetrofit;
    Join join = new Join();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        initFbUserRef();

        initView();

        initRetrofit();
//        search(editText.getText().toString());


    }


    private void search(String q){
        Call<HashMap> call = mRoomSearchRetrofit.getSearchResults(q,DataApiKey);
        call.enqueue(new Callback<HashMap>() {
            @Override
            public void onResponse(Call<HashMap> call, Response<HashMap> response){
                Log.d(TAG, "onResponse search: "+ (response.body()));

                List<YoutubeSearchResult> youtubeSearchResults = HashmapToYoutubeSearchResult.convert(response.body());
                Log.d(TAG, "onResponse search: " +youtubeSearchResults.toString());


            }

            @Override
            public void onFailure(Call<HashMap> call,Throwable t){
                Log.d(TAG, "onFailure: ");
            }
        });
    }

    private void initRetrofit(){
        mClient = new DataApiClient<>();
        mRoomSearchRetrofit =mClient.getClient(RoomSearchRetrofit.class);
    }
    void initFbUserRef(){
        if(getSettingItem(getApplicationContext()) == null) {
            userRef = databaseReference.child("users").push();
            userId = userRef.getKey();
            setContext(getApplication());
            storeUserId(userId);
        }
        else {
            userId = getSettingItem(getApplicationContext());
        }
    }

    void initView() {
        listView = (ListView) findViewById(R.id.searchlist);
        editText = (EditText) findViewById(R.id.searchword);
        sendButton = (Button) findViewById(R.id.search);
        joinButton = (Button) findViewById(R.id.join);
        loginButton = (Button) findViewById(R.id.login);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1);
        listView.setAdapter(adapter);

        joinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, JoinActivity.class);
                startActivity(intent);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        sendButton.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Search_List_Dto firebaseDTO = new Search_List_Dto(editText.getText().toString());

                databaseReference.child("users").child(userId).child("검색어").push().setValue(firebaseDTO);
                editText.setText("");
            }
        });
        databaseReference.child("users").child(userId).child("검색어").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Search_List_Dto search_List_Dto = dataSnapshot.getValue(Search_List_Dto.class);
                adapter.add(search_List_Dto.getSearchword());
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        Button intentbutton = (Button)findViewById(R.id.intent);

        intentbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(MainActivity.this, Video.class);
                startActivity(i);
            }
        });
    }



}
