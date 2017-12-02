package com.exmaple.heady.presenter;

import com.exmaple.heady.model.Categories;
import com.exmaple.heady.view.ProductCategoryFragmentView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ProductCategoryFragmentPresenterTest {

    private ProductCategoryFragmentView view;
    private ProductCategoryFragmentPresenter presenter;

    @Before
    public void setUp() throws Exception {
        view = Mockito.mock(ProductCategoryFragmentView.class);
        presenter = new ProductCategoryFragmentPresenter();
        presenter.attach(view);
    }

    @After
    public void tearDown() throws Exception {
        view = null;
        presenter = null;
    }

    @Test
    public void getProductsByCategory() throws Exception {
        presenter.getProductsByCategory();
        Mockito.verify(view, Mockito.atLeastOnce())
                .displayProductsByCategories(Mockito.anyListOf(Categories.class));
    }
}