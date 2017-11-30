package com.exmaple.heady.avtivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import com.exmaple.androidmvp.MvpActivity;
import com.exmaple.androidmvp.PresenterFactory;
import com.exmaple.heady.R;
import com.exmaple.heady.model.Categories;
import com.exmaple.heady.model.Rankings;
import com.exmaple.heady.presenter.MainActivityPresenter;
import com.exmaple.heady.utility.Utility;
import com.exmaple.heady.view.MainActivityView;

import java.util.List;

public class MainActivity extends MvpActivity<MainActivityPresenter, MainActivityView> implements
        MainActivityView {

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        // TODO: 30/11/17
    }

    @Override
    public void displayRankings(List<Rankings> rankings) {
        // TODO: 30/11/17
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
}
