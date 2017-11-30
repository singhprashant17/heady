package com.exmaple.heady.view;

import com.exmaple.androidmvp.MvpLoadingView;
import com.exmaple.heady.model.Categories;
import com.exmaple.heady.model.Rankings;

import java.util.List;

public interface MainActivityView extends MvpLoadingView {
    void displayCategories(List<Categories> categories);

    void displayRankings(List<Rankings> rankings);
}
