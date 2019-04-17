package com.saasandroid.api.services;

import com.saasandroid.api.exceptions.MissingScopesException;
import com.saasandroid.api.exceptions.TokenExpiredException;
import com.saasandroid.api.loaders.ResourceLoaderFactory;
import com.saasandroid.api.loaders.ResourceLoaderResult;
import com.saasandroid.api.models.FoodLogs;
import com.saasandroid.authentication.Scope;

import android.app.Activity;
import android.content.Loader;

public class FoodSummaryService {

    public final static String FOOD_URL = "https://api.fitbit.com/1/user/-/foods/log/date/today.json";
    private static final ResourceLoaderFactory<FoodLogs> FOOD_LOADER_FACTORY = new ResourceLoaderFactory<>(FOOD_URL, FoodLogs.class);

    public static Loader<ResourceLoaderResult<FoodLogs>> getFoodLoader(Activity activityContext) throws MissingScopesException, TokenExpiredException {
        return FOOD_LOADER_FACTORY.newResourceLoader(activityContext, new Scope[]{Scope.nutrition});
    }

}
