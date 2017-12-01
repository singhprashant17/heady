package com.exmaple.heady.avtivity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.exmaple.androidmvp.MvpActivity;
import com.exmaple.androidmvp.PresenterFactory;
import com.exmaple.heady.R;
import com.exmaple.heady.adapter.ProductVariantAdapter;
import com.exmaple.heady.model.Variants;
import com.exmaple.heady.presenter.ProductVariantActivityPresenter;
import com.exmaple.heady.utility.Utility;
import com.exmaple.heady.view.ProductVariantActivityView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmList;

public class ProductVariantActivity extends MvpActivity<ProductVariantActivityPresenter,
        ProductVariantActivityView> implements ProductVariantActivityView {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_variant);
        ButterKnife.bind(this);
        initViews();
    }

    @Override
    protected void onPresenterCreatedOrRestored(ProductVariantActivityPresenter presenter) {

    }

    @Override
    protected void onStart() {
        super.onStart();
        getPresenter().getProductVariants();
    }

    @Override
    public PresenterFactory<ProductVariantActivityPresenter> getPresenterFactory() {
        return ProductVariantActivityPresenter::new;
    }

    private void initViews() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
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
    public int getProductId() {
        return getIntent().getIntExtra("product_id", 0);
    }

    @Override
    public void displayProductVariants(RealmList<Variants> variants) {
        recyclerView.setAdapter(new ProductVariantAdapter(variants));
    }
}
