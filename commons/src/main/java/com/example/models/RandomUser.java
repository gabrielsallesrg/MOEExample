package com.example.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by gabriel on 23/04/17.
 */

public class RandomUser implements Serializable {

    private Long ru_id;
    
    @SerializedName("gender")
    @Expose
    private String gender;

    @SerializedName("name")
    @Expose
    private RandomUserName name;

    @SerializedName("location")
    @Expose
    private RandomUserLocation location;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("login")
    @Expose
    private RandomUserLogin login;

    @SerializedName("dob")
    @Expose
    private String dob;

    @SerializedName("registered")
    @Expose
    private String registered;

    @SerializedName("phone")
    @Expose
    private String phone;

    @SerializedName("cell")
    @Expose
    private String cell;

    @SerializedName("id")
    @Expose
    private RandomUserDataId dataId;

    @SerializedName("picture")
    @Expose
    private RandomUserPicture picture;

    @SerializedName("nat")
    @Expose
    private String nat;

    private boolean favorite = false;



    public RandomUser() {
    }

    public RandomUser(Long ru_id, String gender, String email, String dob, String registered, String phone, String cell, String nat,
            boolean favorite) {
        this.ru_id = ru_id;
        this.gender = gender;
        this.email = email;
        this.dob = dob;
        this.registered = registered;
        this.phone = phone;
        this.cell = cell;
        this.nat = nat;
        this.favorite = favorite;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getRegistered() {
        return registered;
    }

    public void setRegistered(String registered) {
        this.registered = registered;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getNat() {
        return nat;
    }

    public void setNat(String nat) {
        this.nat = nat;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public String getNiceName() {
        return name.getTitle() + " " + name.getLast();
    }

    public String getFullName() {
        return name.getTitle() + " " + name.getFirst() + " " + name.getLast();
    }

    public String getFullAddress() {
        return location.getStreet() + "\n" + location.getCity() + " / " + location.getState() + " / " + nat + "\n" + location.getPostcode();
    }

    public String getAddressForMaps() {
        return location.getCity() + "," + nat;
    }

    public int describeContents() {
        return 0;
    }

    public boolean getFavorite() {
        return this.favorite;
    }



    public Long getRu_id() {
        return this.ru_id;
    }

    public void setRu_id(Long ru_id) {
        this.ru_id = ru_id;
    }

    public RandomUserPicture getPicture() {
        return picture;
    }

    public RandomUserName getName() {
        return name;
    }

    public RandomUserLocation getLocation() {
        return location;
    }

    public RandomUserLogin getLogin() {
        return login;
    }

    public RandomUserDataId getDataId() {
        return dataId;
    }

    public void deleteId(){
        this.ru_id = null;
        this.getPicture().setId(null);
        this.getName().setId(null);
        this.getLogin().setId(null);
        this.getLocation().setId(null);
        this.getDataId().setId(null);
    }

}
