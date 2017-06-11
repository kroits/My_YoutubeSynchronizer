package com.example.b3216.my_youtubesynchronizer.retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by b3216 on 2017-06-03.
 */

public interface LoginRetrofit {
    @POST("api/user/join")
    Call<JoinResponse> postStand(
            @Body Join stand
    );

    @GET("api/user/login")
    Call<LoginResponse> getStand(
            @Header("userLoginId")String loginId , @Header("userPassword") String loginPassword,
            @Header("userType") String usertype
    );


}
