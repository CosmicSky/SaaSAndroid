package com.saasandroid.api.services;

import com.saasandroid.api.exceptions.MissingScopesException;
import com.saasandroid.api.exceptions.TokenExpiredException;
import com.saasandroid.api.loaders.ResourceLoaderFactory;
import com.saasandroid.api.loaders.ResourceLoaderResult;
import com.saasandroid.api.models.WeightLogs;
import com.saasandroid.authentication.Scope;

import android.app.Activity;
import android.content.Loader;

public class WeightService {

    private final static String WEIGHT_URL = "https://api.fitbit.com/1/user/-/body/log/weight/date/today.json";
    private static final ResourceLoaderFactory<WeightLogs> WEIGHT_LOG_LOADER_FACTORY = new ResourceLoaderFactory<>(WEIGHT_URL, WeightLogs.class);

    public static Loader<ResourceLoaderResult<WeightLogs>> getWeightLogLoader(Activity activityContext) throws MissingScopesException, TokenExpiredException {
        return WEIGHT_LOG_LOADER_FACTORY.newResourceLoader(activityContext, new Scope[]{Scope.weight});
    }

}
