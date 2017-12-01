package com.exmaple.heady.view;

import com.exmaple.androidmvp.MvpView;
import com.exmaple.heady.model.Variants;

import io.realm.RealmList;

public interface ProductVariantActivityView extends MvpView {
    int getProductId();

    void displayProductVariants(RealmList<Variants> variants);
}
