package com.example.gadsleaderboard.DataModel;

import com.google.gson.annotations.SerializedName;

import java.net.URL;

public class DataModelSkillIq {
    @SerializedName("name")
    private  String name;

    @SerializedName("score")
    private  String score;

    @SerializedName("country")
    private  String country;

    @SerializedName("bargeUrl")
    private String badgeUrl;

    public DataModelSkillIq(String name, String score, String country, String badgeUrl) {
        this.name = name;
        this.score = score;
        this.country = country;
        this.badgeUrl = badgeUrl;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String hours) {
        this.score = hours;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }

    public void setBadgeUrl(String badgeUrl) {
        this.badgeUrl = badgeUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
