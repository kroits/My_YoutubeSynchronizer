package com.example.b3216.my_youtubesynchronizer.Room_Search;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


/**
 * Created by b3216 on 2017-04-22.
 */

public class Room_Search_Dto<T> implements Serializable{
    @SerializedName("data")
    private T data;
    @SerializedName("resultCode")
    private String resultCode;
    @SerializedName("resultMessage")
    private String resultMessage;

    public Room_Search_Dto(T data, String resultCode, String resultMessage){
        this.data = data;
        this.resultCode = resultCode;
        this.resultCode = resultMessage;
    }
    public T getData(){
        return data;
    }
    public void setData(T data){
        this.data = data;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode (String resultCode){
        this.resultCode = resultCode;
    }

    public String getResultMessage(){
        return resultMessage;
    }

    public void setResultMessage(String resultMessage){
        this.resultMessage = resultMessage;
    }

}
