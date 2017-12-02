package com.exmaple.heady.presenter;

import com.exmaple.androidmvp.MvpPresenter;
import com.exmaple.heady.ApplicationClass;
import com.exmaple.heady.R;
import com.exmaple.heady.model.Response;
import com.exmaple.heady.utility.Utility;
import com.exmaple.heady.view.MainActivityView;
import com.exmaple.heady.webservice.ApiCallMethods;
import com.exmaple.heady.webservice.NoInternetException;

import javax.inject.Inject;

import io.realm.Realm;
import rx.SingleSubscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

public class MainActivityPresenter implements MvpPresenter<MainActivityView> {
    @Inject
    ApiCallMethods service;
    private MainActivityView view;
    private Subscription subscription;

    public MainActivityPresenter() {
        ApplicationClass.getNetComponent().inject(this);
        subscription = Subscriptions.empty();
    }

    @Override
    public void attach(MainActivityView view) {
        this.view = view;
    }

    @Override
    public void detach() {
        subscription.unsubscribe();
        view.stopLoading();
    }

    public void getData() {
        subscription = service.getData()
                .doOnSubscribe(() -> {
                    // chk if network available
                    if (!Utility.checkNetwork()) {
                        throw new NoInternetException();
                    }
                })
                .doOnSuccess(response -> {
                    // write to DB
                    final Realm realm = Realm.getDefaultInstance();
                    try {
                        realm.executeTransaction(realm1 -> {
                            realm1.copyToRealmOrUpdate(response.getCategories());
                            realm1.copyToRealmOrUpdate(response.getRankings());
                        });
                    } finally {
                        realm.close();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(() ->
                        view.startLoading(view.getContext().getString(R.string.loading)))
                .subscribe(new SingleSubscriber<Response>() {
                    @Override
                    public void onSuccess(Response response) {
                        view.stopLoading();
                        view.displayCategories(response.getCategories());
                        view.displayRankings(response.getRankings());
                    }

                    @Override
                    public void onError(Throwable error) {
                        error.printStackTrace();
                        view.stopLoading();
                        if (error instanceof NoInternetException) {
                            Utility.displayToast(view.getContext()
                                    .getString(R.string.no_internet_msg));
                        }
                    }
                });
    }
}
