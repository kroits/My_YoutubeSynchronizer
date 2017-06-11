package com.example.b3216.my_youtubesynchronizer.retrofit;

import com.example.b3216.my_youtubesynchronizer.common.URL;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by b3216 on 2017-04-29.
 */

public class DataApiClient<T> {
    private T service;
    private String baseUrl = URL.getYoutubeDataApiURL();

    public T getClient(Class<? extends T> type){
        if(service == null){
            Retrofit client = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            service = client.create(type);

        }
        return service;
    }
    }
