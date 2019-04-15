package com.saasandroid.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Value {
    @SerializedName("heartRateZones")
    @Expose
    private HeartRateZones[] heartRateZones;
    @SerializedName("restingHeartRate")
    @Expose
    private Integer restingHeartRate;

    /**
     * @return The heartRateZones
     */
    public HeartRateZones[] getHeartRateZones() {
        return heartRateZones;
    }

    /**
     * @param heartRateZones The heartRateZones
     */
    public void setHeartRateZones(HeartRateZones[] heartRateZones) {
        this.heartRateZones = heartRateZones;
    }

    /**
     * @return The restingHeartRate
     */
    public Integer getRestingHeartRate() {
        return restingHeartRate;
    }

    /**
     * @param restingHeartRate The restingHeartRate
     */
    public void setRestingHeartRate(Integer restingHeartRate) {
        this.restingHeartRate = restingHeartRate;
    }
}
