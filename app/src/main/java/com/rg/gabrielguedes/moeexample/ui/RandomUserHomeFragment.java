package com.rg.gabrielguedes.moeexample.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.interfaces.RandomUsersView;
import com.example.models.RandomUser;
import com.example.models.RandomUsersData;
import com.example.presenters.RandomUserPresenter;
import com.rg.gabrielguedes.moeexample.R;
import com.rg.gabrielguedes.moeexample.adapters.RandomUserRecyclerViewAdapter;

import java.util.ArrayList;

import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.example.Constants.CURRENT_PAGE;
import static com.example.Constants.HAS_NEW_DATA;
import static com.example.Constants.RANDOM_USER;
import static com.example.Constants.RANDOM_USERS_DATAS;
import static com.example.Constants.RANDOM_USER_DETAIL;
import static com.rg.gabrielguedes.moeexample.helperclasses.UsefulMethods.calculateNoOfColumns;


public class RandomUserHomeFragment extends Fragment implements RandomUsersView {

    private OnFragmentInteractionListener mListener;
    private SwipeRefreshLayout mNoInternetLayout;
    private RecyclerView mRecyclerView;
    private RandomUserRecyclerViewAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private boolean mIsLoading = true;
    ArrayList<RandomUser> mData;
    private int mPage = -1;
    private int mScrollState = 0;
    private int mChosenPos = -1;
    private RandomUserPresenter mRandomUserPresenter;


    public RandomUserHomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_random_user_home, container, false);

        mRandomUserPresenter = new RandomUserPresenter(this);

        mNoInternetLayout = (SwipeRefreshLayout) view.findViewById(R.id.no_internet_layout);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.randomuser_recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new RandomUserRecyclerViewAdapter(new ArrayList<RandomUser>(), mRecyclerView);
        mRecyclerView.setItemAnimator(new SlideInLeftAnimator());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(false);
        mLayoutManager = new GridLayoutManager(getContext(), calculateNoOfColumns(getContext()));
        mLayoutManager.setAutoMeasureEnabled(false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                mScrollState = newState;
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int pos = ((LinearLayoutManager) mLayoutManager).findLastCompletelyVisibleItemPosition();
                int numItems = mAdapter.getItemCount();
                if (pos >= numItems - 1 && !mIsLoading) {
                    mRecyclerView.setItemAnimator(null);
                    mIsLoading = true;
                    prepareForRequestMoreData();
                    if (mScrollState == 0 || mScrollState == 2)
                        mRecyclerView.scrollToPosition(pos + 1);
                    requestMoreData();
                }
            }
        });

        mNoInternetLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                hideRecyclerView(false);
                mNoInternetLayout.setRefreshing(false);
                requestMoreData();
            }
        });

        if (savedInstanceState != null) {
            mData = (ArrayList<RandomUser>) savedInstanceState.getSerializable(RANDOM_USERS_DATAS);
            mAdapter.addNewData(mData);
            mPage = savedInstanceState.getInt(CURRENT_PAGE, 0);
            mIsLoading = false;
        } else {
            prepareForRequestMoreData();
            requestMoreData();
        }

        return view;
    }

    private void prepareForRequestMoreData() {
        mData = mAdapter.getAllData();
        mData.add(null);
        mAdapter.notifyItemInserted(mData.size() - 1);
    }

    private void requestMoreData() {
        mRandomUserPresenter.getRandomUsers(AndroidSchedulers.mainThread(), Schedulers.newThread(), mPage++);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case (RANDOM_USER_DETAIL) : {
                if (resultCode == Activity.RESULT_OK && mChosenPos >= 0) {
                    Bundle bundle = data.getExtras();
                    if (data.getBooleanExtra(HAS_NEW_DATA, false)) {
                        RandomUser randomUser = bundle.getParcelable(RANDOM_USER);
                        mAdapter.updatePosition(mChosenPos, randomUser);
                    }
                }
                break;
            }
        }
    }

    public void setChosenUserPos(int pos){
        mChosenPos = pos;
    }

    public void hideRecyclerView(boolean hideRecyclerView) {
        if (hideRecyclerView) {
            mNoInternetLayout.setVisibility(View.VISIBLE);
            mRecyclerView.setVisibility(View.GONE);
        } else {
            mRecyclerView.setVisibility(View.VISIBLE);
            mNoInternetLayout.setVisibility(View.GONE);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putSerializable(RANDOM_USERS_DATAS, mData);
        savedInstanceState.putInt(CURRENT_PAGE, mPage);
        super.onSaveInstanceState(savedInstanceState);
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void showRandomUser(RandomUsersData randomUsersData) {
        ArrayList<RandomUser> data = (ArrayList<RandomUser>) randomUsersData.getResults();
        mData.remove(mData.size() - 1);
        mAdapter.notifyItemRemoved(mData.size());
        mAdapter.addNewData(data);
        mIsLoading = false;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}


