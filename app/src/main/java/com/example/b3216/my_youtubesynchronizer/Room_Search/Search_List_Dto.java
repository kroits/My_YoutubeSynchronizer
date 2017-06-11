package com.example.b3216.my_youtubesynchronizer.Room_Search;

/**
 * Created by b3216 on 2017-05-27.
 */

public class Search_List_Dto {

    private String searchword;
    public Search_List_Dto(){}


    public Search_List_Dto(String serachword){
        this.searchword = serachword;
    }

    public String getSearchword() {
        return searchword;
    }

    public void setSearchword(String searchword) {
        this.searchword = searchword;
    }
}
