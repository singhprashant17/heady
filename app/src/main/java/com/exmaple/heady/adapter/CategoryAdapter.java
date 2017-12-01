package com.exmaple.heady.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.exmaple.heady.R;
import com.exmaple.heady.avtivity.ProductListActivity;
import com.exmaple.heady.model.Categories;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private final List<Categories> items;

    public CategoryAdapter(List<Categories> items) {
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.simple_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.bindData(items.get(position), position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements
            ViewHolderBinder<Categories> {
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
        public void bindData(Categories data, int position) {
            mIdView.setText(data.getName());

            itemView.setOnClickListener(v -> {
                final Context context = itemView.getContext();
                final Intent intent = new Intent(context, ProductListActivity.class);
                intent.putExtra("category_id", data.getId());
                context.startActivity(intent);
            });
        }
    }
}
