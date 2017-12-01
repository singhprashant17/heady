package com.exmaple.heady.view;

import com.exmaple.androidmvp.MvpView;
import com.exmaple.heady.model.Products;

import io.realm.RealmList;

public interface ProductListActivityView extends MvpView {
    int getCategoryId();

    void displayProducts(RealmList<Products> products);
}
