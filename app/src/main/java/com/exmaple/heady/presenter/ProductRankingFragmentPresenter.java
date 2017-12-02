package com.exmaple.heady.presenter;

import com.exmaple.androidmvp.MvpPresenter;
import com.exmaple.heady.model.Rankings;
import com.exmaple.heady.view.ProductRankingFragmentView;

import io.realm.Realm;
import io.realm.RealmResults;

public class ProductRankingFragmentPresenter implements MvpPresenter<ProductRankingFragmentView> {
    private ProductRankingFragmentView view;
    private Realm realm;

    @Override
    public void attach(ProductRankingFragmentView view) {
        this.view = view;
        realm = Realm.getDefaultInstance();
    }

    @Override
    public void detach() {
        realm.close();
    }

    public void getProductsByRanking() {
        final RealmResults<Rankings> rankings = realm.where(Rankings.class).findAll();
        view.displayProductsByRanking(rankings);
    }
}
