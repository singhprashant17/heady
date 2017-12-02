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
import com.exmaple.heady.model.ProductsX;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.exmaple.heady.utility.Constant.BundleKeys.PRODUCT_ID;

public class RankingProductAdapter extends RecyclerView.Adapter<RankingProductAdapter.ViewHolder> {

    private final List<ProductsX> products;

    public RankingProductAdapter(List<ProductsX> products) {
        this.products = products;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.simple_item, parent, false);
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

    public class ViewHolder extends RecyclerView.ViewHolder implements ViewHolderBinder<ProductsX> {
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
        public void bindData(ProductsX data, int position) {
            mContentView.setText(String.valueOf(data.getViewCount()));
            itemView.setOnClickListener(v -> {
                final Context context = itemView.getContext();
                final Intent intent = new Intent(context, ProductVariantActivity.class);
                intent.putExtra(PRODUCT_ID, data.getId());
                context.startActivity(intent);
            });
        }
    }
}
