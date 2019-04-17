package com.saasandroid.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FoodGoals {
    @SerializedName("calories")
    @Expose
    private Integer calories;

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
}
