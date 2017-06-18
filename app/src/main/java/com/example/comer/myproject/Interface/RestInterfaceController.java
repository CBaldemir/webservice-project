package com.example.comer.myproject.Interface;

/**
 * Created by comer on 15.06.2017.
 */
import com.example.comer.myproject.Models.retrofitModel;

import retrofit.Callback;
import retrofit.http.GET;


/**
 * Created by alperbeyler on 10/11/15.
 */
public interface RestInterfaceController {

    // GET yada POST mu olduğunu belirliyoruz.
    @GET("/json")
    void getJsonValues(Callback<retrofitModel[]> response);

}