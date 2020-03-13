package com.example.myapplication2.view;

import com.example.myapplication2.User;

import java.util.List;

public class Evec {
    public int position;
    public List<User.ResultsBean> beans;

    public Evec(int position, List<User.ResultsBean> beans) {
        this.position = position;
        this.beans = beans;
    }

    public int getPosition() {
        return position;
    }

    public List<User.ResultsBean> getBeans() {
        return beans;
    }
}
