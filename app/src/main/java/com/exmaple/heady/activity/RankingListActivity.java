package com.exmaple.heady.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.exmaple.androidmvp.MvpActivity;
import com.exmaple.androidmvp.PresenterFactory;
import com.exmaple.heady.R;
import com.exmaple.heady.adapter.RankingProductAdapter;
import com.exmaple.heady.model.ProductsX;
import com.exmaple.heady.presenter.RankingListActivityPresenter;
import com.exmaple.heady.utility.Constant;
import com.exmaple.heady.utility.Utility;
import com.exmaple.heady.view.RankingListActivityView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmList;

public class RankingListActivity extends MvpActivity<RankingListActivityPresenter,
        RankingListActivityView> implements RankingListActivityView {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        ButterKnife.bind(this);
        initViews();
    }

    @Override
    protected void onPresenterCreatedOrRestored(RankingListActivityPresenter presenter) {

    }

    private void initViews() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    protected void onStart() {
        super.onStart();
        getPresenter().getProductList();
    }

    @Override
    public PresenterFactory<RankingListActivityPresenter> getPresenterFactory() {
        return RankingListActivityPresenter::new;
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showMessage(String msg) {
        Utility.displayToast(msg);
    }

    @Override
    public String getRankingType() {
        return getIntent().getStringExtra(Constant.BundleKeys.RANKING_TYPE);
    }

    @Override
    public void displayProducts(RealmList<ProductsX> products) {
        recyclerView.setAdapter(new RankingProductAdapter(products));
    }
}
