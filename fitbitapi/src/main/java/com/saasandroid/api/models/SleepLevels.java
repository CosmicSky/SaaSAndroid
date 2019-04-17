package com.saasandroid.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class SleepLevels {

    @SerializedName("summary")
    @Expose
    private SleepLevelSummary summary;
    @SerializedName("data")
    @Expose
    private List<SleepData> data = new ArrayList<>();
    @SerializedName("shortData")
    @Expose
    private List<SleepData> shortData = new ArrayList<>();

    /**
     * @return The summary
     */
    public SleepLevelSummary getSummary() {
        return summary;
    }

    /**
     * @param summary The summary
     */
    public void setSummary(SleepLevelSummary summary) {
        this.summary = summary;
    }

    /**
     * @return The data
     */
    public List<SleepData> getData() {
        return data;
    }

    /**
     * @param data The data
     */
    public void setData(List<SleepData> data) {
        this.data = data;
    }

    /**
     * @return The shortData
     */
    public List<SleepData> getShortData() {
        return shortData;
    }

    /**
     * @param shortData The shortData
     */
    public void setShortData(List<SleepData> shortData) {
        this.shortData = shortData;
    }
}
