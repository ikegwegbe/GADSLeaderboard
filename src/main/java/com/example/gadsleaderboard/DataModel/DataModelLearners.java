package com.example.gadsleaderboard.DataModel;

import com.google.gson.annotations.SerializedName;

import java.net.URL;

public class DataModelLearners {
    @SerializedName("name")
    private  String name;

    @SerializedName("hours")
    private  String hours;

    @SerializedName("country")
    private  String country;


    @SerializedName("bargeUrl")
    private URL badgeUrl;


    public DataModelLearners(String name, String hours, String country, URL badgeUrl) {
        this.name = name;
        this.hours = hours;
        this.country = country;
        this.badgeUrl = badgeUrl;
    }


    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public URL getBadgeUrl() {
        return badgeUrl;
    }

    public void setBadgeUrl(URL badgeUrl) {
        this.badgeUrl = badgeUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
