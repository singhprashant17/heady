package com.exmaple.heady.view;

import com.exmaple.androidmvp.MvpView;
import com.exmaple.heady.model.ProductsX;

import io.realm.RealmList;

public interface RankingListActivityView extends MvpView {
    String getRankingType();

    void displayProducts(RealmList<ProductsX> products);
}
