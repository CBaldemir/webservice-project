package com.example.comer.myproject.Interface;

import com.example.comer.myproject.Models.retrofitModel;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by comer on 15.06.2017.
 */
public interface RestInterfaceController5 {
    // GET yada POST mu olduğunu belirliyoruz.
    @GET("/jsonnews3")
    void getJsonValues(Callback<retrofitModel[]> response);

}