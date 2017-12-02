package com.exmaple.heady.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.exmaple.heady.R;
import com.exmaple.heady.activity.ProductVariantActivity;
import com.exmaple.heady.model.Products;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.exmaple.heady.utility.Constant.DateFormat.OUTPUT_FORMAT;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ViewHolder> {

    private final List<Products> products;

    public ProductListAdapter(List<Products> products) {
        this.products = products;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.bindData(products.get(position), position);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements ViewHolderBinder<Products> {
        @BindView(R.id.id)
        public TextView mIdView;
        @BindView(R.id.content)
        public TextView mContentView;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }

        @Override
        public void bindData(Products data, int position) {
            mIdView.setText(data.getName());
            mContentView.setText(data.getFormattedDate(OUTPUT_FORMAT));
            itemView.setOnClickListener(v -> {
                final Context context = itemView.getContext();
                final Intent intent = new Intent(context, ProductVariantActivity.class);
                intent.putExtra("product_id", data.getId());
                context.startActivity(intent);
            });
        }
    }
}
