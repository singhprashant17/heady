package com.exmaple.heady.view;

import com.exmaple.androidmvp.MvpView;
import com.exmaple.heady.model.Rankings;

import io.realm.RealmResults;

public interface ProductRankingFragmentView extends MvpView {
    void displayProductsByRanking(RealmResults<Rankings> rankings);
}
