package com.example.presenters;

import com.example.api.RandomUserApi;
import com.example.api.RandomUserServiceGenerator;
import com.example.interfaces.RandomUsersView;
import com.example.models.RandomUsersData;

import rx.Scheduler;
import rx.Subscriber;

/**
 * Created by gabrielguedes on 27/07/17.
 */

public class RandomUserPresenter {
    private RandomUsersView mView;

    public RandomUserPresenter(RandomUsersView view) {
        mView = view;
    }

    public void getRandomUsers(Scheduler postThread, Scheduler subscribeThread, int page) {
        RandomUserApi randomUserApi = RandomUserServiceGenerator.createService(RandomUserApi.class);
        randomUserApi.doGetRandomUsersData(page)
                .subscribeOn(subscribeThread)
                .observeOn(postThread)
                .subscribe(new Subscriber<RandomUsersData>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(RandomUsersData randomUsersData) {
                        mView.showRandomUser(randomUsersData);
                    }
                });
    }
}
