package com.exmaple.heady.adapter;

import android.support.v7.widget.RecyclerView;

/**
 * An interface that describes the data display implementation to a
 * {@link RecyclerView.ViewHolder}
 *
 * @param <T> Type of data the view must display
 */
public interface ViewHolderBinder<T> {
    /**
     * To display the object of type T to the view-holder
     *
     * @param data     The instance of data of type T
     * @param position The position in the Adapter
     */
    void bindData(T data, int position);
}
