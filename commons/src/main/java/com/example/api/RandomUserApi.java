package com.example.api;

import com.example.models.RandomUsersData;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by gabrielguedes on 26/07/17.
 */

public interface RandomUserApi {

    @GET("/api/1.1/?results=15")
    Observable<RandomUsersData> doGetRandomUsersData(@Query("page") int page);
}
