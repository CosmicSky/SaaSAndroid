package com.saasandroid.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class SleepData {

    @SerializedName("datetime")
    @Expose
    private Date datetime;
    @SerializedName("level")
    @Expose
    private String level;
    @SerializedName("seconds")
    @Expose
    private Integer seconds;

    /**
     * @return The datetime
     */
    public Date getDatetime() {
        return datetime;
    }

    /**
     * @param datetime The datetime
     */
    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    /**
     * @return The level
     */
    public String getLevel() {
        return level;
    }

    /**
     * @param level The level
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * @return The seconds
     */
    public Integer getSeconds() {
        return seconds;
    }

    /**
     * @param seconds The seconds
     */
    public void setSeconds(Integer seconds) {
        this.seconds = seconds;
    }
}
