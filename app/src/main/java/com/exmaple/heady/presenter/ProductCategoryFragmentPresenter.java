package com.exmaple.heady.presenter;

import com.exmaple.androidmvp.MvpPresenter;
import com.exmaple.heady.model.Categories;
import com.exmaple.heady.view.ProductCategoryFragmentView;

import io.realm.Realm;
import io.realm.RealmResults;

public class ProductCategoryFragmentPresenter implements MvpPresenter<ProductCategoryFragmentView> {
    private ProductCategoryFragmentView view;
    private Realm realm;

    @Override
    public void attach(ProductCategoryFragmentView view) {
        this.view = view;
        realm = Realm.getDefaultInstance();
    }

    @Override
    public void detach() {
        realm.close();
    }

    public void getProductsByCategory() {
        final RealmResults<Categories> categories = realm.where(Categories.class).findAll();
        view.displayProductsByCategories(categories);
    }
}
