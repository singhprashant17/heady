package com.exmaple.heady.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.exmaple.heady.R;
import com.exmaple.heady.activity.RankingListActivity;
import com.exmaple.heady.model.Rankings;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.exmaple.heady.utility.Constant.BundleKeys.RANKING_TYPE;

public class RankingAdapter extends RecyclerView.Adapter<RankingAdapter.ViewHolder> {

    private final List<Rankings> rankings;

    public RankingAdapter(List<Rankings> rankings) {
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
        public void bindData(Rankings data, int position) {
            mIdView.setText(data.getRanking());

            itemView.setOnClickListener(v -> {
                final Intent intent = new Intent(context, RankingListActivity.class);
                intent.putExtra(RANKING_TYPE, data.getRanking());
                context.startActivity(intent);
            });
        }
    }
}
