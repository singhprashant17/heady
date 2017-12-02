package com.exmaple.heady.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.exmaple.heady.R;
import com.exmaple.heady.model.Variants;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductVariantAdapter extends RecyclerView.Adapter<ProductVariantAdapter.ViewHolder> {

    private final List<Variants> variants;

    public ProductVariantAdapter(List<Variants> variants) {
        this.variants = variants;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.simple_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindData(variants.get(position), position);
    }

    @Override
    public int getItemCount() {
        return variants.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements ViewHolderBinder<Variants> {
        private final Context context;
        @BindView(R.id.id)
        public TextView mIdView;
        @BindView(R.id.content)
        public TextView mContentView;

        public ViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void bindData(Variants data, int position) {
            mIdView.setText(context.getString(R.string.variant_detail_format, data.getColor(),
                    data.getSize(), data.getPrice()));
        }
    }
}
