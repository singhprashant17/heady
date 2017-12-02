package com.exmaple.heady;

import com.exmaple.heady.model.Categories;
import com.exmaple.heady.model.Products;
import com.exmaple.heady.model.ProductsX;
import com.exmaple.heady.model.Rankings;
import com.exmaple.heady.model.Tax;
import com.exmaple.heady.model.Variants;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.rule.PowerMockRule;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import io.realm.internal.RealmCore;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

@PowerMockIgnore({"org.mockito.*", "org.robolectric.*", "android.*"})
@PrepareForTest({Realm.class, RealmConfiguration.class, RealmQuery.class, RealmResults.class,
        RealmCore.class})
public class RealmModelTest {

    @Rule
    public PowerMockRule rule = new PowerMockRule();
    Realm mockRealm;

    @Before
    public void setup() {
        mockStatic(Realm.class);
        final Realm mockRealm = mock(Realm.class);
        when(Realm.getDefaultInstance()).thenReturn(mockRealm);
        this.mockRealm = mockRealm;
    }

    @Test
    public void testRealmGetDefaultInstanceCalled() {
        assertThat(Realm.getDefaultInstance(), is(mockRealm));
    }

    @Test
    public void testAbleToMockRealmMethods() {
        when(mockRealm.isAutoRefresh()).thenReturn(true);
        assertThat(mockRealm.isAutoRefresh(), is(true));

        when(mockRealm.isAutoRefresh()).thenReturn(false);
        assertThat(mockRealm.isAutoRefresh(), is(false));
    }

    @Test
    public void testAbleToCreateARealmObject() {
        final Categories categories = new Categories();
        when(mockRealm.createObject(Categories.class)).thenReturn(categories);
        final Categories mockCategories = mockRealm.createObject(Categories.class);
        assertThat(mockCategories, is(categories));

        final Products products = new Products();
        when(mockRealm.createObject(Products.class)).thenReturn(products);
        final Products mockProducts = mockRealm.createObject(Products.class);
        assertThat(mockProducts, is(products));

        final ProductsX productsX = new ProductsX();
        when(mockRealm.createObject(ProductsX.class)).thenReturn(productsX);
        final ProductsX mockProductsX = mockRealm.createObject(ProductsX.class);
        assertThat(mockProductsX, is(productsX));

        final Rankings rankings = new Rankings();
        when(mockRealm.createObject(Rankings.class)).thenReturn(rankings);
        final Rankings mockRankings = mockRealm.createObject(Rankings.class);
        assertThat(mockRankings, is(rankings));

        final Tax tax = new Tax();
        when(mockRealm.createObject(Tax.class)).thenReturn(tax);
        final Tax mockTax = mockRealm.createObject(Tax.class);
        assertThat(mockTax, is(tax));

        final Variants variants = new Variants();
        when(mockRealm.createObject(Variants.class)).thenReturn(variants);
        final Variants mockVariants = mockRealm.createObject(Variants.class);
        assertThat(mockVariants, is(variants));

    }
}
