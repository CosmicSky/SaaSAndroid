package com.saasandroid.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SleepLevelSummary {

    @SerializedName("deep")
    @Expose
    private SleepDeep deep;
    @SerializedName("light")
    @Expose
    private SleepLight light;
    @SerializedName("rem")
    @Expose
    private SleepRem rem;
    @SerializedName("wake")
    @Expose
    private SleepWake wake;

    /**
     * @return The deep
     */
    public SleepDeep getDeep() {
        return deep;
    }

    /**
     * @param deep The deep
     */
    public void setDeep(SleepDeep deep) {
        this.deep = deep;
    }

    /**
     * @return The light
     */
    public SleepLight getLight() {
        return light;
    }

    /**
     * @param light The light
     */
    public void setLight(SleepLight light) {
        this.light = light;
    }

    /**
     * @return The rem
     */
    public SleepRem getRem() {
        return rem;
    }

    /**
     * @param rem The rem
     */
    public void setRem(SleepRem rem) {
        this.rem = rem;
    }

    /**
     * @return The wake
     */
    public SleepWake getWake() {
        return wake;
    }

    /**
     * @param wake The wake
     */
    public void setWake(SleepWake wake) {
        this.wake = wake;
    }
}
