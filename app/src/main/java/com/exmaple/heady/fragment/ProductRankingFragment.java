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
import com.exmaple.heady.adapter.RankingAdapter;
import com.exmaple.heady.model.Rankings;
import com.exmaple.heady.presenter.ProductRankingFragmentPresenter;
import com.exmaple.heady.view.ProductRankingFragmentView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductRankingFragment extends MvpFragment<ProductRankingFragmentPresenter,
        ProductRankingFragmentView> implements ProductRankingFragmentView, ViewPagerFragment {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    public static ProductRankingFragment newInstance(Bundle bundle) {
        ProductRankingFragment fragment = new ProductRankingFragment();
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
        getPresenter().getProductsByRanking();
    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    protected void onPresenterCreatedOrRestored(ProductRankingFragmentPresenter presenter) {

    }

    @Override
    public PresenterFactory<ProductRankingFragmentPresenter> getPresenterFactory() {
        return ProductRankingFragmentPresenter::new;
    }

    @Override
    public void displayProductsByRanking(List<Rankings> rankings) {
        recyclerView.setAdapter(new RankingAdapter(rankings));
    }
}
