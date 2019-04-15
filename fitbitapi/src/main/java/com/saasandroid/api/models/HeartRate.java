package com.saasandroid.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class HeartRate {
    @SerializedName("dateTime")
    @Expose
    private Date dateTime;
    @SerializedName("value")
    @Expose
    private Value value;

    /**
     * @return The dateTime
     */
    public Date getDateTime() {
        return dateTime;
    }

    /**
     * @param dateTime The dateTime
     */
    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * @return The value
     */
    public Value getValue() {
        return value;
    }

    /**
     * @param value The value
     */
    public void setValue(Value value) {
        this.value = value;
    }
}
