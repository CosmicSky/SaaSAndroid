package com.saasandroid.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class FoodLogs {

    @SerializedName("foods")
    @Expose
    private List<Food> foods = new ArrayList<>();
    @SerializedName("goals")
    @Expose
    private FoodGoals goals;
    @SerializedName("summary")
    @Expose
    private FoodSummary summary;

    /**
     * @return The foods
     */
    public List<Food> getFoods() {
        return foods;
    }

    /**
     * @param foods The foods
     */
    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    /**
     * @return The goals
     */
    public FoodGoals getGoals() {
        return goals;
    }

    /**
     * @param goals The goals
     */
    public void setGoals(FoodGoals goals) {
        this.goals = goals;
    }

    /**
     * @return The summary
     */
    public FoodSummary getSummary() {
        return summary;
    }

    /**
     * @param summary The summary
     */
    public void setSummary(FoodSummary summary) {
        this.summary = summary;
    }

}
