package com.exmaple.heady.model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Rankings extends RealmObject {

    @PrimaryKey
    private String ranking;
    private RealmList<ProductsX> products;

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    public RealmList<ProductsX> getProducts() {
        return products;
    }

}
