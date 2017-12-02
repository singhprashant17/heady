package com.exmaple.heady.presenter;

import com.exmaple.heady.model.Rankings;
import com.exmaple.heady.view.ProductRankingFragmentView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ProductRankingFragmentPresenterTest {
    private ProductRankingFragmentView view;
    private ProductRankingFragmentPresenter presenter;

    @Before
    public void setUp() throws Exception {
        view = Mockito.mock(ProductRankingFragmentView.class);
        presenter = new ProductRankingFragmentPresenter();
        presenter.attach(view);
    }

    @After
    public void tearDown() throws Exception {
        view = null;
        presenter = null;
    }

    @Test
    public void getProductsByRanking() throws Exception {
        presenter.getProductsByRanking();
        Mockito.verify(view, Mockito.atLeastOnce())
                .displayProductsByRanking(Mockito.anyListOf(Rankings.class));
    }

}