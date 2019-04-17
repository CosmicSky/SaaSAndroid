package com.saasandroid.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.time.Clock;


public class Activity {

    @SerializedName("activityId")
    @Expose
    private Integer activityId;
    @SerializedName("activityParentId")
    @Expose
    private Integer activityParentId;
    @SerializedName("calories")
    @Expose
    private Integer calories;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("distance")
    @Expose
    private Double distance;
    @SerializedName("duration")
    @Expose
    private Integer duration;
    @SerializedName("hasStartTime")
    @Expose
    private boolean hasStartTime;
    @SerializedName("isFavorite")
    @Expose
    private boolean isFavorite;
    @SerializedName("logId")
    @Expose
    private Integer logId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("startTime")
    @Expose
    private Clock startTime;
    @SerializedName("steps")
    @Expose
    private Integer steps;

    /**
     * @return The activityId
     */
    public Integer getActivityId() {
        return activityId;
    }

    /**
     * @param activityId The activityId
     */
    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    /**
     * @return The activityParentId
     */
    public Integer getActivityParentId() {
        return activityParentId;
    }

    /**
     * @param activityParentId The activityParentId
     */
    public void setActivityParentId(Integer activityParentId) {
        this.activityParentId = activityParentId;
    }

    /**
     * @return The calories
     */
    public Integer getCalories() {
        return calories;
    }

    /**
     * @param calories The calories
     */
    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    /**
     * @return The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return The distance
     */
    public Double getDistance() {
        return distance;
    }

    /**
     * @param distance The distance
     */
    public void setDistance(Double distance) {
        this.distance = distance;
    }

    /**
     * @return The duration
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     * @param duration The duration
     */
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    /**
     * @return The hasStartTime
     */
    public boolean isHasStartTime() {
        return hasStartTime;
    }

    /**
     * @param hasStartTime The hasStartTime
     */
    public void setHasStartTime(boolean hasStartTime) {
        this.hasStartTime = hasStartTime;
    }

    /**
     * @return The favorite
     */
    public boolean isFavorite() {
        return isFavorite;
    }

    /**
     * @param favorite The favorite
     */
    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    /**
     * @return The logId
     */
    public Integer getLogId() {
        return logId;
    }

    /**
     * @param logId The logId
     */
    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The startTime
     */
    public Clock getStartTime() {
        return startTime;
    }

    /**
     * @param startTime The startTime
     */
    public void setStartTime(Clock startTime) {
        this.startTime = startTime;
    }

    /**
     * @return The steps
     */
    public Integer getSteps() {
        return steps;
    }

    /**
     * @param steps The steps
     */
    public void setSteps(Integer steps) {
        this.steps = steps;
    }
}
