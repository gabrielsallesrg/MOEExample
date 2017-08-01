package com.example.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by gabriel on 23/04/17.
 */

public class RandomUserName implements Serializable {

    private Long id;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("first")
    @Expose
    private String first;

    @SerializedName("last")
    @Expose
    private String last;

    public RandomUserName(Long id, String title, String first, String last) {
        this.id = id;
        this.title = title;
        this.first = first;
        this.last = last;
    }

    public RandomUserName() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int describeContents() {
        return 0;
    }
}
