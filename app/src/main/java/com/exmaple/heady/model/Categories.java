package com.exmaple.heady.model;

import com.exmaple.heady.utility.Constant;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

public class Categories extends RealmObject {

    private int id;
    private String name;
    private List<Products> products;
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

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    public RealmList<Integer> getChildCategories() {
        return childCategories;
    }
}
