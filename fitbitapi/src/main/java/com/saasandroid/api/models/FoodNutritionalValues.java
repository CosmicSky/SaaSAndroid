package com.saasandroid.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FoodNutritionalValues {

    @SerializedName("calories")
    @Expose
    private Integer calories;
    @SerializedName("carbs")
    @Expose
    private Double carbs;
    @SerializedName("fat")
    @Expose
    private Double fat;
    @SerializedName("fiber")
    @Expose
    private Double fiber;
    @SerializedName("protein")
    @Expose
    private Double protein;
    @SerializedName("sodium")
    @Expose
    private Double sodium;

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
     * @return The carbs
     */
    public Double getCarbs() {
        return carbs;
    }

    /**
     * @param carbs The carbs
     */
    public void setCarbs(Double carbs) {
        this.carbs = carbs;
    }

    /**
     * @return The fat
     */
    public Double getFat() {
        return fat;
    }

    /**
     * @param fat The fat
     */
    public void setFat(Double fat) {
        this.fat = fat;
    }

    /**
     * @return The fiber
     */
    public Double getFiber() {
        return fiber;
    }

    /**
     * @param fiber The fiber
     */
    public void setFiber(Double fiber) {
        this.fiber = fiber;
    }

    /**
     * @return The protein
     */
    public Double getProtein() {
        return protein;
    }

    /**
     * @param protein The protein
     */
    public void setProtein(Double protein) {
        this.protein = protein;
    }

    /**
     * @return The sodium
     */
    public Double getSodium() {
        return sodium;
    }

    /**
     * @param sodium The sodium
     */
    public void setSodium(Double sodium) {
        this.sodium = sodium;
    }
}
