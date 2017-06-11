package com.example.b3216.my_youtubesynchronizer.retrofit;

/**
 * Created by b3216 on 2017-06-11.
 */

public class TokenDTO {
    private String authorizationToken;

    public String getAuthorizationToken() {
        return authorizationToken;
    }

    public void setAuthorizationToken(String authorizationToken) {
        this.authorizationToken = authorizationToken;
    }

    @Override
    public String toString() {
        return "TokenDTO{" +
                "authorizationToken='" + authorizationToken + '\'' +
                '}';
    }
}
