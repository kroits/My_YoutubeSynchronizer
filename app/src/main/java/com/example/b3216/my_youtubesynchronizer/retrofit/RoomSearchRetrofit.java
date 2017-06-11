package com.example.b3216.my_youtubesynchronizer.retrofit;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by b3216 on 2017-04-22.
 */

public interface RoomSearchRetrofit {
    @GET("youtube/v3/search?part=id,snippet&type=video")
    Call<HashMap> getSearchResults(@Query("q") String q,
                                   @Query("key") String key);
}
