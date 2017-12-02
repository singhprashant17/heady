package com.exmaple.heady.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;

import com.exmaple.heady.fragment.ProductCategoryFragment;
import com.exmaple.heady.fragment.ProductRankingFragment;
import com.exmaple.heady.fragment.ViewPagerFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private final int tabCount;
    private final SparseArray<ViewPagerFragment> registeredFragments = new SparseArray<>();

    public ViewPagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return ProductRankingFragment.newInstance(null);
            case 1:
            default:
                return ProductCategoryFragment.newInstance(null);
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        final Object object = super.instantiateItem(container, position);
        if (!(object instanceof ViewPagerFragment)) {
            throw new IllegalStateException("Must implement ViewPagerFragment");
        }
        ViewPagerFragment fragment = (ViewPagerFragment) object;
        registeredFragments.put(position, fragment);
        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        registeredFragments.remove(position);
        super.destroyItem(container, position, object);
    }

    public ViewPagerFragment getRegisteredFragment(int position) {
        return registeredFragments.get(position);
    }
}
