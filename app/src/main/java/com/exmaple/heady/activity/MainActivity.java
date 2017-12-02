package com.exmaple.heady.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.exmaple.androidmvp.MvpActivity;
import com.exmaple.androidmvp.PresenterFactory;
import com.exmaple.heady.R;
import com.exmaple.heady.adapter.ViewPagerAdapter;
import com.exmaple.heady.model.Categories;
import com.exmaple.heady.model.Rankings;
import com.exmaple.heady.presenter.MainActivityPresenter;
import com.exmaple.heady.utility.Utility;
import com.exmaple.heady.view.MainActivityView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends MvpActivity<MainActivityPresenter, MainActivityView> implements
        MainActivityView, TabLayout.OnTabSelectedListener {

    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    private ProgressDialog progressDialog;
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initViews();
    }

    private void initViews() {
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),
                tabLayout.getTabCount());
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(this);
    }

    @Override
    protected void onPresenterCreatedOrRestored(MainActivityPresenter presenter) {
        presenter.getData();
    }

    @Override
    public PresenterFactory<MainActivityPresenter> getPresenterFactory() {
        return MainActivityPresenter::new;
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
    public void displayCategories(List<Categories> categories) {
        viewPagerAdapter.getRegisteredFragment(1).updateFragment();
    }

    @Override
    public void displayRankings(List<Rankings> rankings) {
        viewPagerAdapter.getRegisteredFragment(0).updateFragment();
    }

    @Override
    public void startLoading(String message) {
        if (progressDialog == null) {
            progressDialog = Utility.getProgressDialog(this);
        }
        progressDialog.setMessage(message);
        progressDialog.show();
    }

    @Override
    public void stopLoading() {
        progressDialog.dismiss();
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
