package com.exmaple.heady.model;

import com.exmaple.heady.utility.Constant;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Categories extends RealmObject {

    @PrimaryKey
    private int id;
    private String name;
    private RealmList<Products> products;
    @SerializedName(Constant.Params.CHILD_CATEGORIES)
    private RealmList<Integer> childCategories;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RealmList<Products> getProducts() {
        return products;
    }

    public RealmList<Integer> getChildCategories() {
        return childCategories;
    }
}
