package com.exmaple.heady.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.exmaple.androidmvp.MvpActivity;
import com.exmaple.androidmvp.PresenterFactory;
import com.exmaple.heady.R;
import com.exmaple.heady.adapter.ProductListAdapter;
import com.exmaple.heady.model.Products;
import com.exmaple.heady.presenter.ProductListActivityPresenter;
import com.exmaple.heady.utility.Utility;
import com.exmaple.heady.view.ProductListActivityView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductListActivity extends MvpActivity<ProductListActivityPresenter,
        ProductListActivityView> implements ProductListActivityView {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        ButterKnife.bind(this);
        initViews();
    }

    private void initViews() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    protected void onPresenterCreatedOrRestored(ProductListActivityPresenter presenter) {
    }

    @Override
    protected void onStart() {
        super.onStart();
        getPresenter().getProductList();
    }

    @Override
    public PresenterFactory<ProductListActivityPresenter> getPresenterFactory() {
        return ProductListActivityPresenter::new;
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
    public int getCategoryId() {
        return getIntent().getIntExtra("category_id", 0);
    }

    @Override
    public void displayProducts(List<Products> products) {
        recyclerView.setAdapter(new ProductListAdapter(products));
    }
}
