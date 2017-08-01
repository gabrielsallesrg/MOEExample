package com.example.models;

/**
 * Created by gabriel on 13/05/17.
 */

public class RandomUserGenderOption {

    private Long id;

    private String gender;

    public RandomUserGenderOption(Long id, String gender) {
        this.id = id;
        this.gender = gender;
    }

    public RandomUserGenderOption() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
