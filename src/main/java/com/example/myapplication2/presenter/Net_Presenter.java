package com.example.myapplication2.presenter;

import com.example.myapplication2.User;
import com.example.myapplication2.model.Net_Model;
import com.example.myapplication2.net.Result;
import com.example.myapplication2.view.Net_View;

public class Net_Presenter {
    private Net_View mView;
    private final Net_Model model;

    public Net_Presenter(Net_View view) {
        this.mView = view;
        model = new Net_Model();
    }

    public void getData() {
        model.getData(new Result() {
            @Override
            public void OnSueecess(User user) {
                mView.setData(user);
            }

            @Override
            public void OnFall(String str) {
                mView.setToast(str);
            }
        });
    }
}
