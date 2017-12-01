package com.exmaple.heady.view;

import com.exmaple.androidmvp.MvpView;
import com.exmaple.heady.model.Categories;

import io.realm.RealmResults;

public interface ProductCategoryFragmentView extends MvpView {
    void displayProductsByCategories(RealmResults<Categories> categories);
}
