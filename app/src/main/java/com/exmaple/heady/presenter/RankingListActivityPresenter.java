package com.exmaple.heady.presenter;

import com.exmaple.androidmvp.MvpPresenter;
import com.exmaple.heady.model.Rankings;
import com.exmaple.heady.view.RankingListActivityView;

import io.realm.Realm;

public class RankingListActivityPresenter implements MvpPresenter<RankingListActivityView> {
    private RankingListActivityView view;
    private Realm realm;

    @Override
    public void attach(RankingListActivityView view) {
        this.view = view;
        realm = Realm.getDefaultInstance();
    }

    @Override
    public void detach() {
        realm.close();
    }

    public void getProductList() {
        final Rankings ranking = realm.where(Rankings.class)
                .equalTo("ranking", view.getRankingType()).findFirst();
        if (ranking != null) {
            view.displayProducts(ranking.getProducts());
        }
    }
}
