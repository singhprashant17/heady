package com.exmaple.heady.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.exmaple.androidmvp.MvpFragment;
import com.exmaple.androidmvp.PresenterFactory;
import com.exmaple.heady.R;
import com.exmaple.heady.adapter.CategoryAdapter;
import com.exmaple.heady.model.Categories;
import com.exmaple.heady.presenter.ProductCategoryFragmentPresenter;
import com.exmaple.heady.utility.Utility;
import com.exmaple.heady.view.ProductCategoryFragmentView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductCategoryFragment extends MvpFragment<ProductCategoryFragmentPresenter,
        ProductCategoryFragmentView> implements ProductCategoryFragmentView, ViewPagerFragment {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    public static ProductCategoryFragment newInstance(Bundle bundle) {
        ProductCategoryFragment fragment = new ProductCategoryFragment();
        if (bundle != null) {
            fragment.setArguments(bundle);
        }
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ranking, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void refresh() {
        getPresenter().getProductsByCategory();
    }

    @Override
    public void showMessage(String msg) {
        Utility.displayToast(msg);
    }

    @Override
    protected void onPresenterCreatedOrRestored(ProductCategoryFragmentPresenter presenter) {

    }

    @Override
    public PresenterFactory<ProductCategoryFragmentPresenter> getPresenterFactory() {
        return ProductCategoryFragmentPresenter::new;
    }

    @Override
    public void displayProductsByCategories(List<Categories> categories) {
        recyclerView.setAdapter(new CategoryAdapter(categories));
    }
}
