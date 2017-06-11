package com.example.b3216.my_youtubesynchronizer.Room_Search;

import com.google.gson.internal.LinkedTreeMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by b3216 on 2017-04-29.
 */

public class HashmapToYoutubeSearchResult {
    public static List<YoutubeSearchResult> convert(HashMap rawResult){
        ArrayList<LinkedTreeMap> arr = (ArrayList<LinkedTreeMap>) rawResult.get("items");
        ArrayList<YoutubeSearchResult> results = new ArrayList<>();
        for (LinkedTreeMap each:
                arr) {
            String videoId = (String) ((LinkedTreeMap) each.get("id")).get("videoId");
            String thumbnailUrl = (String) ((LinkedTreeMap) ((LinkedTreeMap) ((LinkedTreeMap) each.get("snippet")).get("thumbnails")).get("default")).get("url");
            String title = (String) ((LinkedTreeMap) each.get("snippet")).get("title");
            String description = (String) ((LinkedTreeMap) each.get("snippet")).get("description");
            results.add(new YoutubeSearchResult(videoId, thumbnailUrl, title, description));
        }

        return results;
    }
}
