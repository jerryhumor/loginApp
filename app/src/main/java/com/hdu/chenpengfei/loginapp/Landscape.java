package com.hdu.chenpengfei.loginapp;

import org.litepal.crud.DataSupport;

/**
 * Created by hanjianhao on 17/4/29.
 */

public class Landscape extends DataSupport {

    private int id;
    private int imgId;
    private String introduce;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}
