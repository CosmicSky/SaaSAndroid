package com.saasandroid.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class LoggedFood {
    @SerializedName("accessLevel")
    @Expose
    private String accessLevel;
    @SerializedName("amount")
    @Expose
    private Double amount;
    @SerializedName("brand")
    @Expose
    private String brand;
    @SerializedName("calories")
    @Expose
    private Integer calories;
    @SerializedName("foodId")
    @Expose
    private Integer foodId;
    @SerializedName("mealTypeId")
    @Expose
    private Integer mealTypeId;
    @SerializedName("locale")
    @Expose
    private String locale;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("unit")
    @Expose
    private Unit unit;
    @SerializedName("units")
    @Expose
    private List<Integer> units = new ArrayList<>();

    /**
     * @return The accessLevel
     */
    public String getAccessLevel() {
        return accessLevel;
    }

    /**
     * @param accessLevel The accessLevel
     */
    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    /**
     * @return The amount
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * @param amount The amount
     */
    public void setCalories(Double amount) {
        this.amount = amount;
    }

    /**
     * @return The brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand The brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
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
     * @return The calories
     */
    public Integer getFoodId() {
        return foodId;
    }

    /**
     * @param foodId The foodId
     */
    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    /**
     * @return The mealTypeId
     */
    public Integer getMealTypeId() {
        return mealTypeId;
    }

    /**
     * @param mealTypeId The mealTypeId
     */
    public void setMealTypeId(Integer mealTypeId) {
        this.mealTypeId = mealTypeId;
    }

    /**
     * @return The locale
     */
    public String getLocale() {
        return locale;
    }

    /**
     * @param locale The locale
     */
    public void setLocale(String locale) {
        this.locale = locale;
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
     * @return The unit
     */
    public Unit getUnit() {
        return unit;
    }

    /**
     * @param unit The unit
     */
    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    /**
     * @return The units
     */
    public List<Integer> getUnits() {
        return units;
    }

    /**
     * @param units The units
     */
    public void setUnit(List<Integer> units) {
        this.units = units;
    }
}
