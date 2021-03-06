package com.rg.gabrielguedes.moeexample.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.models.RandomUser;
import com.rg.gabrielguedes.moeexample.RootActivity;
import com.rg.gabrielguedes.moeexample.databinding.RandomUserCellBinding;
import com.rg.gabrielguedes.moeexample.ui.RandomUserDetailActivity;
import com.rg.gabrielguedes.moeexample.ui.RandomUserHomeFragment;
import com.rg.gabrielguedes.moeexample.R;

import java.util.ArrayList;

import fr.castorflex.android.circularprogressbar.CircularProgressBar;

import static com.example.Constants.RANDOM_USER;
import static com.example.Constants.RANDOM_USER_DETAIL;
import static com.example.Constants.TOOLBAR_TITLE;


public class RandomUserRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<RandomUser> mData;
    private final int VIEW_ITEM = 1;
    private final int VIEW_LOADING = 0;


    public RandomUserRecyclerViewAdapter (ArrayList<RandomUser> data, RecyclerView recyclerView) {
        mData = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == VIEW_ITEM) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            RandomUserCellBinding binding = RandomUserCellBinding.inflate(layoutInflater, parent, false);
            return new RandomUserViewHolder(binding);
        } else if (viewType == VIEW_LOADING) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_loading_list_item, parent, false);
            return new LoadingViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof RandomUserViewHolder) {
            RandomUser current = mData.get(position);
            ((RandomUserViewHolder) holder).bind(current);
        } else {
            ((LoadingViewHolder) holder).circularProgressBar.setIndeterminate(true);
        }
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void addNewData(ArrayList<RandomUser> newData) {
        int previousDataSize = mData.size();
        mData.addAll(newData);
        notifyItemRangeInserted(previousDataSize, newData.size());
    }

    public void updatePosition(int pos, RandomUser randomUser) {
        mData.remove(pos);
        mData.add(pos, randomUser);
        notifyItemChanged(pos);
    }

    public void removePosition(int pos) {
        mData.remove(pos);
        notifyItemRemoved(pos);
    }

    public ArrayList<RandomUser> getAllData() {
        return mData;
    }

    @Override
    public int getItemViewType(int position) {
        return mData.get(position) != null ? VIEW_ITEM : VIEW_LOADING;
    }

    static class RandomUserViewHolder extends RecyclerView.ViewHolder {
        private final RandomUserCellBinding mBinding;

        private RandomUserViewHolder(RandomUserCellBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
            mBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();

                    Pair<View, String> pair = new Pair<>(v.findViewById(R.id.thumbnail), v.getResources().getString(R.string.transition_random_user_image));
                    ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((RootActivity)context, pair);

                    Intent intent = new Intent(context, RandomUserDetailActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(RANDOM_USER, mBinding.getRandomuser());
                    intent.putExtras(bundle);

                    Fragment fragment = ((RootActivity)context).getCurrentFragment();
                    ((RandomUserHomeFragment) fragment).setChosenUserPos(getLayoutPosition());
                    intent.putExtra(TOOLBAR_TITLE, fragment.getResources().getString(R.string.randomuser));
                    fragment.startActivityForResult(intent, RANDOM_USER_DETAIL, options.toBundle());
                }
            });
        }

        private void bind (RandomUser user) {
            mBinding.setRandomuser(user);
            mBinding.executePendingBindings();
        }
    }

    static class LoadingViewHolder extends RecyclerView.ViewHolder {
        private final CircularProgressBar circularProgressBar;

        private LoadingViewHolder(View itemView) {
            super(itemView);
            circularProgressBar = (CircularProgressBar) itemView.findViewById(R.id.circularProgressBar);
        }
    }
}