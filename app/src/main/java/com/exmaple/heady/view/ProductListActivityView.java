package com.exmaple.heady.view;

import com.exmaple.androidmvp.MvpView;
import com.exmaple.heady.model.Products;

import java.util.List;

public interface ProductListActivityView extends MvpView {
    int getCategoryId();

    void displayProducts(List<Products> products);
}
