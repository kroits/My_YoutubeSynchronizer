package com.example.b3216.my_youtubesynchronizer.retrofit;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by b3216 on 2017-06-11.
 */

public class Login implements Serializable {
    public Login(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public Login() {}

    @SerializedName("userLoinId")
    private String id;
    @SerializedName("userPassword")
    private String password;

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
}

