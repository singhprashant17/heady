package com.exmaple.heady.presenter;

import com.exmaple.heady.view.RankingListActivityView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class RankingListActivityPresenterTest {
    private RankingListActivityView view;
    private RankingListActivityPresenter presenter;

    @Before
    public void setUp() throws Exception {
        view = Mockito.mock(RankingListActivityView.class);
        presenter = new RankingListActivityPresenter();
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
        Mockito.verify(view, Mockito.atLeastOnce()).getRankingType();
    }
}
