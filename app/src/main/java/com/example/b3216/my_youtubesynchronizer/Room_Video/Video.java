package com.example.b3216.my_youtubesynchronizer.Room_Video;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.b3216.my_youtubesynchronizer.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

/**
 * Created by b3216 on 2017-05-13.
 */

public class Video extends YouTubeBaseActivity{
    public static Context mContext;

    YouTubePlayerView youtubeView;
    Button playbutton;
    YouTubePlayer.OnInitializedListener listener;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = new Intent(this.getIntent());

        playbutton = (Button) findViewById(R.id.play);
        youtubeView = (YouTubePlayerView) findViewById(R.id.youtubeView);
        listener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("IQEDU7SZI2Y");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        playbutton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                youtubeView.initialize("AIzaSyD3zbGPXwgSWz_ZzL2js6FnyHknyPp_6PA",listener);
            }
        });


    }


}
