package com.exmaple.heady.model;

import com.exmaple.heady.utility.Constant;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class ProductsX extends RealmObject {

    private int id;
    @SerializedName(Constant.Params.VIEW_COUNT)
    private int viewCount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }
}
