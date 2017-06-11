package com.example.b3216.my_youtubesynchronizer.retrofit;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by b3216 on 2017-06-03.
 */

public class Join implements Serializable {
    public Join(String id, String nick , String password, String type){
        this.id = id;
        this.password = password;
        this.nick = nick;
        this.type = type;
    }

    public Join(){}
    @SerializedName("userLoginId")
    private String id;
    @SerializedName("userNickname")
    private String nick;
    @SerializedName("userPassword")
    private String password;
    @SerializedName("userType")
    private String type;



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
}
