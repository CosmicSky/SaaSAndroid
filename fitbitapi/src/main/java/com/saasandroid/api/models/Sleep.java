package com.saasandroid.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Sleep {
    @SerializedName("dateOfSleep")
    @Expose
    private Date dateOfSleep;
    @SerializedName("duration")
    @Expose
    private Integer duration;
    @SerializedName("efficiency")
    @Expose
    private Integer efficiency;
    @SerializedName("isMainSleep")
    @Expose
    private boolean isMainSleep;
    @SerializedName("levels")
    @Expose
    private SleepLevels levels;
    @SerializedName("logId")
    @Expose
    private Integer logId;
    @SerializedName("minutesAfterWakeup")
    @Expose
    private Integer minutesAfterWakeup;
    @SerializedName("minutesAsleep")
    @Expose
    private Integer minutesAsleep;
    @SerializedName("minutesAwake")
    @Expose
    private Integer minutesAwake;
    @SerializedName("minutesToFallAsleep")
    @Expose
    private Integer minutesToFallAsleep;
    @SerializedName("startTime")
    @Expose
    private Date startTime;
    @SerializedName("timeInBed")
    @Expose
    private Integer timeInBed;
    @SerializedName("type")
    @Expose
    private String type;

    /**
     * @return The dateOfSleep
     */
    public Date getDateOfSleep() {
        return dateOfSleep;
    }

    /**
     * @param dateOfSleep The dateOfSleep
     */
    public void setDateOfSleep(Date dateOfSleep) {
        this.dateOfSleep = dateOfSleep;
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
     * @return The efficiency
     */
    public Integer getEfficiency() {
        return efficiency;
    }

    /**
     * @param efficiency The efficiency
     */
    public void setEfficiency(Integer efficiency) {
        this.efficiency = efficiency;
    }

    /**
     * @return The isMainSleep
     */
    public boolean isMainSleep() {
        return isMainSleep;
    }

    /**
     * @param mainSleep The isMainSleep
     */
    public void setMainSleep(boolean mainSleep) {
        isMainSleep = mainSleep;
    }

    /**
     * @return The levels
     */
    public SleepLevels getLevels() {
        return levels;
    }

    /**
     * @param levels The levels
     */
    public void setLevels(SleepLevels levels) {
        this.levels = levels;
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
     * @return The minutesAfterWakeup
     */
    public Integer getMinutesAfterWakeup() {
        return minutesAfterWakeup;
    }

    /**
     * @param minutesAfterWakeup The minutesAfterWakeup
     */
    public void setMinutesAfterWakeup(Integer minutesAfterWakeup) {
        this.minutesAfterWakeup = minutesAfterWakeup;
    }

    /**
     * @return The minutesAsleep
     */
    public Integer getMinutesAsleep() {
        return minutesAsleep;
    }

    /**
     * @param minutesAsleep The minutesAsleep
     */
    public void setMinutesAsleep(Integer minutesAsleep) {
        this.minutesAsleep = minutesAsleep;
    }

    /**
     * @return The minutesAwake
     */
    public Integer getMinutesAwake() {
        return minutesAwake;
    }

    /**
     * @param minutesAwake The minutesAwake
     */
    public void setMinutesAwake(Integer minutesAwake) {
        this.minutesAwake = minutesAwake;
    }

    /**
     * @return The minutesToFallAsleep
     */
    public Integer getMinutesToFallAsleep() {
        return minutesToFallAsleep;
    }

    /**
     * @param minutesToFallAsleep The minutesToFallAsleep
     */
    public void setMinutesToFallAsleep(Integer minutesToFallAsleep) {
        this.minutesToFallAsleep = minutesToFallAsleep;
    }

    /**
     * @return The startTime
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * @param startTime The startTime
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * @return The timeInBed
     */
    public Integer getTimeInBed() {
        return timeInBed;
    }

    /**
     * @param timeInBed The timeInBed
     */
    public void setTimeInBed(Integer timeInBed) {
        this.timeInBed = timeInBed;
    }

    /**
     * @return The type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type The type
     */
    public void setType(String type) {
        this.type = type;
    }
}
