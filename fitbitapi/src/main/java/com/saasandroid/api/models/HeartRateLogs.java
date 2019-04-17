package com.saasandroid.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class HeartRateLogs {

    @SerializedName("heartRate")
    @Expose
    private List<HeartRate> heartRate = new ArrayList<>();

    /**
     * @return The heartRate
     */
    public List<HeartRate> getHeartRate() {
        return heartRate;
    }

    /**
     * @param heartRate The heartRate
     */
    public void setHeartRate(List<HeartRate> heartRate) {
        this.heartRate = heartRate;
    }

}
