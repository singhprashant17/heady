package com.exmaple.heady.di;

import com.exmaple.heady.ApplicationClass;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    ApplicationClass mApplication;

    public AppModule(ApplicationClass application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    ApplicationClass providesApplication() {
        return mApplication;
    }
}
