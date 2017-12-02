package com.exmaple.heady.presenter;

import com.exmaple.heady.view.ProductVariantActivityView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ProductVariantActivityPresenterTest {
    private ProductVariantActivityView view;
    private ProductVariantActivityPresenter presenter;

    @Before
    public void setUp() throws Exception {
        view = Mockito.mock(ProductVariantActivityView.class);
        presenter = new ProductVariantActivityPresenter();
        presenter.attach(view);
    }

    @After
    public void tearDown() throws Exception {
        view = null;
        presenter = null;
    }

    @Test
    public void getProductVariants() throws Exception {
        presenter.getProductVariants();
        Mockito.verify(view, Mockito.atLeastOnce()).getProductId();
    }
}