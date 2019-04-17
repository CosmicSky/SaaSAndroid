package com.saasandroid.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class SleepLogs {

    @SerializedName("sleep")
    @Expose
    private List<Sleep> sleep = new ArrayList<>();
    @SerializedName("summary")
    @Expose
    private SleepSummary summary;

    /**
     * @return The sleep
     */
    public List<Sleep> getSleep() {
        return sleep;
    }

    /**
     * @param sleep The sleep
     */
    public void setSleep(List<Sleep> sleep) {
        this.sleep = sleep;
    }

    /**
     * @return The summary
     */
    public SleepSummary getSummary() {
        return summary;
    }

    /**
     * @param summary The summary
     */
    public void setSummary(SleepSummary summary) {
        this.summary = summary;
    }
}
