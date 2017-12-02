package com.exmaple.heady.view;

import com.exmaple.androidmvp.MvpView;
import com.exmaple.heady.model.Rankings;

import java.util.List;

public interface ProductRankingFragmentView extends MvpView {
    void displayProductsByRanking(List<Rankings> rankings);
}
