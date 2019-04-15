package com.saasandroid.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Value {
    @SerializedName("heartRateZones")
    @Expose
    private HeartRateZones[] heartRateZones;

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
}
