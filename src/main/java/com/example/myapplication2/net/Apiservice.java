package com.example.myapplication2.net;

import com.example.myapplication2.User;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Apiservice {
    String BASE_URL = "https://cdwan.cn/";//https://cdwan.cn/api/topic/list

    @GET("api/topic/list")
    Observable<User> getData1();
}
