package com.exmaple.heady.presenter;

import com.exmaple.heady.view.ProductListActivityView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ProductListActivityPresenterTest {
    private ProductListActivityView view;
    private ProductListActivityPresenter presenter;

    @Before
    public void setUp() throws Exception {
        view = Mockito.mock(ProductListActivityView.class);
        presenter = new ProductListActivityPresenter();
        presenter.attach(view);
    }

    @After
    public void tearDown() throws Exception {
        view = null;
        presenter = null;
    }

    @Test
    public void getProductList() throws Exception {
        presenter.getProductList();
        Mockito.verify(view, Mockito.atLeastOnce()).getCategoryId();
    }

}