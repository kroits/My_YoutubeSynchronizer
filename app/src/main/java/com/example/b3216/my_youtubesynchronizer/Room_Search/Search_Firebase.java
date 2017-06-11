package com.example.b3216.my_youtubesynchronizer.Room_Search;

import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by b3216 on 2017-05-27.
 */

public class Search_Firebase  {

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    Search_Firebase(EditText editText){
        Search_List_Dto search_list_dto = new Search_List_Dto(editText.getText().toString());
        databaseReference.child("users").push().child("검색어").push().setValue(search_list_dto);
        editText.setText("");
    }

}
