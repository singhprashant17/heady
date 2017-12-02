package com.exmaple.heady.di;

import com.exmaple.heady.presenter.MainActivityPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, WebServiceModule.class})
public interface WebServiceComponent {
    void inject(MainActivityPresenter presenter);
}
