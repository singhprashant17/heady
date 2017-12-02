package com.exmaple.heady.view;

import com.exmaple.androidmvp.MvpView;
import com.exmaple.heady.model.Categories;

import java.util.List;

public interface ProductCategoryFragmentView extends MvpView {
    void displayProductsByCategories(List<Categories> categories);
}
