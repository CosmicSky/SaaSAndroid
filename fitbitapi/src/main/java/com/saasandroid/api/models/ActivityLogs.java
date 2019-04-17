package com.saasandroid.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ActivityLogs {

    @SerializedName("activities")
    @Expose
    private List<Activity> activities = new ArrayList<>();
    @SerializedName("goals")
    @Expose
    private ActivityGoals goals;
    @SerializedName("summary")
    @Expose
    private ActivitySummary summary;

    /**
     * @return The activities
     */
    public List<Activity> getActivities() {
        return activities;
    }

    /**
     * @param activities The activities
     */
    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    /**
     * @return The goals
     */
    public ActivityGoals getGoals() {
        return goals;
    }

    /**
     * @param goals The goals
     */
    public void setGoals(ActivityGoals goals) {
        this.goals = goals;
    }

    /**
     * @return The summary
     */
    public ActivitySummary getSummary() {
        return summary;
    }

    /**
     * @param summary The summary
     */
    public void setSummary(ActivitySummary summary) {
        this.summary = summary;
    }

}
