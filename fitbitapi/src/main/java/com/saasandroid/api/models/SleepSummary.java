package com.saasandroid.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class SleepSummary {

    @SerializedName("totalMinutesAsleep")
    @Expose
    private Integer totalMinutesAsleep;
    @SerializedName("totalSleepRecords")
    @Expose
    private Integer totalSleepRecords;
    @SerializedName("totalTimeInBed")
    @Expose
    private Integer totalTimeInBed;

    /**
     * @return The totalMinutesAsleep
     */
    public Integer getTotalMinutesAsleep() {
        return totalMinutesAsleep;
    }

    /**
     * @param totalMinutesAsleep The totalMinutesAsleep
     */
    public void setTotalMinutesAsleep(Integer totalMinutesAsleep) {
        this.totalMinutesAsleep = totalMinutesAsleep;
    }

    /**
     * @return The totalSleepRecords
     */
    public Integer getTotalSleepRecords() {
        return totalSleepRecords;
    }

    /**
     * @param totalSleepRecords The totalSleepRecords
     */
    public void setTotalSleepRecords(Integer totalSleepRecords) {
        this.totalSleepRecords = totalSleepRecords;
    }

    /**
     * @return The totalTimeInBed
     */
    public Integer getTotalTimeInBed() {
        return totalTimeInBed;
    }

    /**
     * @param totalTimeInBed The totalTimeInBed
     */
    public void setTotalTimeInBed(Integer totalTimeInBed) {
        this.totalTimeInBed = totalTimeInBed;
    }
}
