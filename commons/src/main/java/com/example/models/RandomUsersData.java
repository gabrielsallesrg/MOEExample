package com.example.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by gabriel on 23/04/17.
 */

public class RandomUsersData implements Serializable {

    @SerializedName("results")
    @Expose
    private List<RandomUser> results = null;

    @SerializedName("info")
    @Expose
    private RandomUserInfo info;

    public RandomUsersData() {
    }

    public List<RandomUser> getResults() {
        return results;
    }

    public void setResults(List<RandomUser> results) {
        this.results = results;
    }

    public RandomUserInfo getInfo() {
        return info;
    }

    public void setInfo(RandomUserInfo info) {
        this.info = info;
    }

    public int describeContents() {
        return 0;
    }
}
