package com.saasandroid.api.services;

import com.saasandroid.api.exceptions.MissingScopesException;
import com.saasandroid.api.exceptions.TokenExpiredException;
import com.saasandroid.api.loaders.ResourceLoaderFactory;
import com.saasandroid.api.loaders.ResourceLoaderResult;
import com.saasandroid.api.models.HeartRate;
import com.saasandroid.authentication.Scope;

import android.app.Activity;
import android.content.Loader;

public class HeartRateService {

    private final static String HEARTRATE_URL = "https://api.fitbit.com/1/user/-/activities/heart/date/today/today.json";
    private static final ResourceLoaderFactory<HeartRate> HEARTRATE_LOADER_FACTORY = new ResourceLoaderFactory<>(HEARTRATE_URL, HeartRate.class);

    public static Loader<ResourceLoaderResult<HeartRate>> getHeartRateLoader(Activity activityContext) throws MissingScopesException, TokenExpiredException {
        return HEARTRATE_LOADER_FACTORY.newResourceLoader(activityContext, new Scope[]{Scope.heartrate});
    }

}
