package com.exmaple.heady;

import android.app.Application;

import com.exmaple.heady.di.AppModule;
import com.exmaple.heady.di.DaggerWebServiceComponent;
import com.exmaple.heady.di.WebServiceComponent;
import com.exmaple.heady.di.WebServiceModule;

import io.realm.Realm;

public class ApplicationClass extends Application {
    private static ApplicationClass instance;
    private static WebServiceComponent webServiceComponent;

    public static synchronized ApplicationClass getInstance() {
        return instance;
    }

    public static synchronized WebServiceComponent getNetComponent() {
        return webServiceComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Realm.init(this);

        webServiceComponent = DaggerWebServiceComponent.builder()
                // list of modules that are part of this component need to be created here too
                .appModule(new AppModule(this)) // This also corresponds to the name of your
                // module: %component_name%Module
                .webServiceModule(new WebServiceModule(BuildConfig.BASE_URL))
                .build();
    }
}
