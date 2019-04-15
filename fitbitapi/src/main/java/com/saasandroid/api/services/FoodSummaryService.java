package com.saasandroid.api.services;

import com.saasandroid.api.exceptions.MissingScopesException;
import com.saasandroid.api.exceptions.TokenExpiredException;
import com.saasandroid.api.loaders.ResourceLoaderFactory;
import com.saasandroid.api.loaders.ResourceLoaderResult;
import com.saasandroid.api.models.FoodSummary;
import com.saasandroid.authentication.Scope;

import android.app.Activity;
import android.content.Loader;

public class FoodSummaryService {

    private final static String FOOD_URL = "https://api.fitbit.com/1/user/-/foods/log/date/today.json";
    private static final ResourceLoaderFactory<FoodSummary> FOOD_SUMMARY_LOADER_FACTORY = new ResourceLoaderFactory<>(FOOD_URL, FoodSummary.class);

    public static Loader<ResourceLoaderResult<FoodSummary>> getFoodSummaryLoader(Activity activityContext) throws MissingScopesException, TokenExpiredException {
        return FOOD_SUMMARY_LOADER_FACTORY.newResourceLoader(activityContext, new Scope[]{Scope.nutrition});
    }

}
