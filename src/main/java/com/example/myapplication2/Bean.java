package com.example.myapplication2;

import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

public class Bean {
    @Id    //表示是表中的主键
    private Long id; //一定是Long型
    private String url;
    private boolean Check;
    @Generated(hash = 1122915083)
    public Bean(Long id, String url, boolean Check) {
        this.id = id;
        this.url = url;
        this.Check = Check;
    }
    @Generated(hash = 80546095)
    public Bean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public Boolean getCheck() {
        return this.Check;
    }
    public void setCheck(Boolean Check) {
        this.Check = Check;
    }
    public void setCheck(boolean Check) {
        this.Check = Check;
    }

}
