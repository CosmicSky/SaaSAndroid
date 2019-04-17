package com.saasandroid.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Food {
    @SerializedName("isFavorite")
    @Expose
    private boolean isFavorite;
    @SerializedName("logDate")
    @Expose
    private Date logDate;
    @SerializedName("logId")
    @Expose
    private Integer logId;
    @SerializedName("loggedFood")
    @Expose
    private LoggedFood loggedFood;
    @SerializedName("nutritionalValues")
    @Expose
    private NutritionalValues nutritionalValues;

    /**
     * @return The isFavorite
     */
    public boolean getIsFavorite() {
        return isFavorite;
    }

    /**
     * @param isFavorite The isFavorite
     */
    public void setFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

    /**
     * @return The logDate
     */
    public Date getLogDate() {
        return logDate;
    }

    /**
     * @param logDate The logDate
     */
    public void setLogDate(Date logDate) {
        this.logDate = logDate;
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
     * @return The loggedFood
     */
    public LoggedFood getLoggedFood() {
        return loggedFood;
    }

    /**
     * @param loggedFood The loggedFood
     */
    public void setLoggedFood(LoggedFood loggedFood) {
        this.loggedFood = loggedFood;
    }

    /**
     * @return The nutritionalValues
     */
    public NutritionalValues getNutritionalValues() {
        return nutritionalValues;
    }

    /**
     * @param nutritionalValues The nutritionalValues
     */
    public void setNutritionalValues(NutritionalValues nutritionalValues) {
        this.nutritionalValues = nutritionalValues;
    }
}
