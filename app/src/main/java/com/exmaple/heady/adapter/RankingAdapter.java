package com.exmaple.heady.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.exmaple.heady.R;
import com.exmaple.heady.model.Rankings;
import com.exmaple.heady.utility.Utility;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmResults;

public class RankingAdapter extends RecyclerView.Adapter<RankingAdapter.ViewHolder> {

    private final RealmResults<Rankings> rankings;

    public RankingAdapter(RealmResults<Rankings> rankings) {
        this.rankings = rankings;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.simple_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindData(rankings.get(position), position);
    }

    @Override
    public int getItemCount() {
        return rankings.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements ViewHolderBinder<Rankings> {
        @BindView(R.id.id)
        public TextView mIdView;
        @BindView(R.id.content)
        public TextView mContentView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void bindData(Rankings data, int position) {
            mIdView.setText(data.getRanking());

            itemView.setOnClickListener(v -> {
                Utility.displayToast("goto list by ranking");
            });
        }
    }
}
