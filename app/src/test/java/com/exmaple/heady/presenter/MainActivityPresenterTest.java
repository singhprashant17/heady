package com.exmaple.heady.presenter;

import android.content.Context;

import com.exmaple.heady.model.Response;
import com.exmaple.heady.utility.Utility;
import com.exmaple.heady.view.MainActivityView;
import com.exmaple.heady.webservice.ApiCallMethods;
import com.exmaple.heady.webservice.WebService;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import rx.Scheduler;
import rx.Single;
import rx.android.plugins.RxAndroidPlugins;
import rx.android.plugins.RxAndroidSchedulersHook;
import rx.plugins.RxJavaPlugins;
import rx.plugins.RxJavaSchedulersHook;
import rx.schedulers.Schedulers;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Utility.class, WebService.class})
public class MainActivityPresenterTest {
    @Mock
    ApiCallMethods service;
    @InjectMocks
    private MainActivityPresenter presenter;
    @Mock
    private MainActivityView view;
    private Context context;


    @Before
    public void setUp() throws Exception {
        PowerMockito.mockStatic(WebService.class);
        PowerMockito.mockStatic(Utility.class);
        PowerMockito.when(Utility.checkNetwork())
                .thenAnswer(new Answer<Boolean>() {
                    @Override
                    public Boolean answer(InvocationOnMock invocation) throws Throwable {
                        return true;
                    }
                });
        PowerMockito.when(WebService.createService())
                .then(new Answer<ApiCallMethods>() {
                    @Override
                    public ApiCallMethods answer(InvocationOnMock invocation) throws Throwable {
                        return service;
                    }
                });

        // Override RxJava schedulers
        RxJavaPlugins.getInstance()
                .registerSchedulersHook(new RxJavaSchedulersHook() {
                    @Override
                    public Scheduler getComputationScheduler() {
                        return Schedulers.immediate();
                    }

                    @Override
                    public Scheduler getIOScheduler() {
                        return Schedulers.immediate();
                    }

                    @Override
                    public Scheduler getNewThreadScheduler() {
                        return Schedulers.immediate();
                    }
                });

        // Override RxAndroid schedulers
        final RxAndroidPlugins rxAndroidPlugins = RxAndroidPlugins.getInstance();
        rxAndroidPlugins.registerSchedulersHook(new RxAndroidSchedulersHook() {
            @Override
            public Scheduler getMainThreadScheduler() {
                return Schedulers.immediate();
            }
        });

        context = mock(Context.class);
        Mockito.when(view.getContext()).thenReturn(context);
        Mockito.when(context.getString(anyInt())).thenReturn("");


        // Mockito has a very convenient way to inject mocks by using the @Mock annotation. To
        // inject the mocks in the test the initMocks method needs to be called.
        MockitoAnnotations.initMocks(this);

        presenter = new MainActivityPresenter();
        presenter.attach(view);
    }

    @After
    public void tearDown() throws Exception {
        RxJavaPlugins.getInstance().reset();
        RxAndroidPlugins.getInstance().reset();
    }

    @Test
    public void getData() throws Exception {
        final Response response = new Response();
        Mockito.when(service.getData()).thenReturn(Single.just(response));

        presenter.getData();
        Mockito.verify(view, Mockito.atLeastOnce()).getContext();
        Mockito.verify(view, Mockito.atLeastOnce()).stopLoading();

    }

}