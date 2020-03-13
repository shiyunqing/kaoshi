package com.example.myapplication2.model;


import com.example.myapplication2.User;
import com.example.myapplication2.net.Apiservice;
import com.example.myapplication2.net.Result;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Net_Model {
    public void getData(final Result result) {
        Retrofit build = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Apiservice.BASE_URL)
                .build();
        Apiservice apiservice = build.create(Apiservice.class);
        Observable<User> data1 = apiservice.getData1();
        data1.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<User>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(User user) {
                        result.OnSueecess(user);
                    }

                    @Override
                    public void onError(Throwable e) {
                        result.OnFall(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
