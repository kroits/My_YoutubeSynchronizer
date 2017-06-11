package com.example.b3216.my_youtubesynchronizer.retrofit;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by b3216 on 2017-06-03.
 */

public class JoinResponse implements Serializable {
    public JoinResponse(String code, String message, String data){
        this.code = code;
        this.message = message;
        this.data = data;
    }
    public JoinResponse(){}
    @SerializedName("resultCode")
    private String code;
    @SerializedName("resultMessage")
    private String message;
    @SerializedName("data")
    private String data;

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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
