package com.example.b3216.my_youtubesynchronizer.Room_Search;

/**
 * Created by b3216 on 2017-04-29.
 */

public class YoutubeSearchResult {

    private String videoId;
    private String thumbnailUrl;
    private String title;
    private String description;

    public YoutubeSearchResult(String videoId, String thumbnailUrl, String title, String description){
        this.videoId = videoId;
        this.thumbnailUrl = thumbnailUrl;
        this.title = title;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
