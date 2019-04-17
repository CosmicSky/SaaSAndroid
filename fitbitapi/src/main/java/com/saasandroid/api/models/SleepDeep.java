package com.saasandroid.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SleepDeep {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("minutes")
    @Expose
    private Integer minutes;
    @SerializedName("thirtyDayAvgMinutes")
    @Expose
    private Integer thirtyDayAvgMinutes;

    /**
     * @return The count
     */
    public Integer getCount() {
        return count;
    }

    /**
     * @param count The count
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * @return The minutes
     */
    public Integer getMinutes() {
        return minutes;
    }

    /**
     * @param minutes The minutes
     */
    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    /**
     * @return The thirtyDayAvgMinutes
     */
    public Integer getThirtyDayAvgMinutes() {
        return thirtyDayAvgMinutes;
    }

    /**
     * @param thirtyDayAvgMinutes The thirtyDayAvgMinutes
     */
    public void setThirtyDayAvgMinutes(Integer thirtyDayAvgMinutes) {
        this.thirtyDayAvgMinutes = thirtyDayAvgMinutes;
    }
}
