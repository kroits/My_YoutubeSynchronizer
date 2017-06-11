package com.example.b3216.my_youtubesynchronizer.retrofit;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by b3216 on 2017-06-03.
 */

public class LoginResponse implements Serializable {
    public LoginResponse(String code, String message, TokenDTO data){
        this.code = code;
        this.message = message;
        this.data = data;
    }
    public LoginResponse(){}
    @SerializedName("resultCode")
    private String code;
    @SerializedName("resultMessage")
    private String message;
    @SerializedName("data")
    private TokenDTO data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TokenDTO getData() {
        return data;
    }

    public void setData(TokenDTO data) {
        this.data = data;
    }
}
