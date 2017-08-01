package com.example.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by gabriel on 23/04/17.
 */

public class RandomUserInfo implements Serializable {

    @SerializedName("seed")
    @Expose
    private String seed;
    @SerializedName("results")
    @Expose
    private int results;
    @SerializedName("page")
    @Expose
    private int page;
    @SerializedName("version")
    @Expose
    private String version;

    public RandomUserInfo(String seed, int results, int page, String version) {
        this.seed = seed;
        this.results = results;
        this.page = page;
        this.version = version;
    }

    public RandomUserInfo() {
    }

    public String getSeed() {
        return seed;
    }

    public void setSeed(String seed) {
        this.seed = seed;
    }

    public int getResults() {
        return results;
    }

    public void setResults(int results) {
        this.results = results;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int describeContents() {
        return 0;
    }
}
