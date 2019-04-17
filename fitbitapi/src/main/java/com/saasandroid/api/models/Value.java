package com.saasandroid.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Value {
    @SerializedName("customHeartRateZones")
    @Expose
    private List<Object> customHeartRateZones = new ArrayList<>();
    @SerializedName("heartRateZones")
    @Expose
    private List<HeartRateZones> heartRateZones = new ArrayList<>();
    @SerializedName("restingHeartRate")
    @Expose
    private Integer restingHeartRate;

    /**
     * @return The customHeartRateZones
     */
    public List<Object> getCustomHeartRateZones() {
        return customHeartRateZones;
    }

    /**
     * @param customHeartRateZones The customHeartRateZones
     */
    public void setCustomHeartRateZones(List<Object> customHeartRateZones) {
        this.customHeartRateZones = customHeartRateZones;
    }

    /**
     * @return The heartRateZones
     */
    public List<HeartRateZones> getHeartRateZones() {
        return heartRateZones;
    }

    /**
     * @param heartRateZones The heartRateZones
     */
    public void setHeartRateZones(List<HeartRateZones> heartRateZones) {
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
