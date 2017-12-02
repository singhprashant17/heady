package com.exmaple.heady.presenter;

import com.exmaple.androidmvp.MvpPresenter;
import com.exmaple.heady.model.Products;
import com.exmaple.heady.utility.Constant;
import com.exmaple.heady.view.ProductVariantActivityView;

import io.realm.Realm;

public class ProductVariantActivityPresenter implements MvpPresenter<ProductVariantActivityView> {
    private ProductVariantActivityView view;
    private Realm realm;

    @Override
    public void attach(ProductVariantActivityView view) {
        this.view = view;
        realm = Realm.getDefaultInstance();
    }

    @Override
    public void detach() {
        realm.close();
    }

    public void getProductVariants() {
        final Products product = realm.where(Products.class)
                .equalTo(Constant.DatabaseKeys.ID, view.getProductId()).findFirst();
        if (product != null) {
            view.displayProductVariants(product.getVariants());
        }
    }
}
