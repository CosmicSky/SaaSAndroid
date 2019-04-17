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
    private HeartRateValue value;

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
    public HeartRateValue getValue() {
        return value;
    }

    /**
     * @param value The value
     */
    public void setValue(HeartRateValue value) {
        this.value = value;
    }
}
