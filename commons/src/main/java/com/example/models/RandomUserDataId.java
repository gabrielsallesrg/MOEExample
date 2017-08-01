package com.example.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by gabriel on 23/04/17.
 */

public class RandomUserDataId implements Serializable {

    private Long id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("value")
    @Expose
    private String value;

    public RandomUserDataId(Long id, String name, String value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public RandomUserDataId() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int describeContents() {
        return 0;
    }
}