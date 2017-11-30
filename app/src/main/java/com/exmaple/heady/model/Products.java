package com.exmaple.heady.model;

import com.exmaple.heady.utility.Constant;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;

public class Products extends RealmObject {

    private int id;
    private String name;
    @SerializedName(Constant.Params.DATE_ADDED)
    private String dateAdded;
    private Tax tax;
    private RealmList<Variants> variants;

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

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Tax getTax() {
        return tax;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }

    public RealmList<Variants> getVariants() {
        return variants;
    }
}
