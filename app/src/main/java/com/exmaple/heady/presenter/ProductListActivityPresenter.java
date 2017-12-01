package com.exmaple.heady.presenter;

import com.exmaple.androidmvp.MvpPresenter;
import com.exmaple.heady.model.Categories;
import com.exmaple.heady.view.ProductListActivityView;

import io.realm.Realm;

public class ProductListActivityPresenter implements MvpPresenter<ProductListActivityView> {
    private ProductListActivityView view;
    private Realm realm;

    @Override
    public void attach(ProductListActivityView view) {
        this.view = view;
        realm = Realm.getDefaultInstance();
    }

    @Override
    public void detach() {
        realm.close();
    }

    public void getProductList() {
        final Categories category = realm.where(Categories.class)
                .equalTo("id", view.getCategoryId()).findFirst();
        if (category != null) {
            view.displayProducts(category.getProducts());
        }
    }
}
