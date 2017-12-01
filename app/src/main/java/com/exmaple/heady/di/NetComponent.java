package com.exmaple.heady.di;

import com.exmaple.heady.presenter.MainActivityPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    void inject(MainActivityPresenter presenter);
}
