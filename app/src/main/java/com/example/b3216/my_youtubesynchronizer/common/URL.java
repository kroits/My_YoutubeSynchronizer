package com.example.b3216.my_youtubesynchronizer.common;

/**
 * Created by b3216 on 2017-04-29.
 */

public class URL {
    private static final String ourServerURL = "http://13.124.12.120:8081/";
    private static final String youtubeDataApiURL = "https://www.googleapis.com/";

    public static String getOurServerURL(){
        return ourServerURL;
    }
    public static String getYoutubeDataApiURL(){
        return youtubeDataApiURL;
    }
}
