package com.saasandroid.api.services;

import com.saasandroid.api.exceptions.MissingScopesException;
import com.saasandroid.api.exceptions.TokenExpiredException;
import com.saasandroid.api.loaders.ResourceLoaderFactory;
import com.saasandroid.api.loaders.ResourceLoaderResult;
import com.saasandroid.api.models.SleepLogs;
import com.saasandroid.authentication.Scope;

import android.app.Activity;
import android.content.Loader;

public class SleepService {

    public final static String SLEEP_URL = "https://api.fitbit.com/1.2/user/-/sleep/date/today.json";
    private static final ResourceLoaderFactory<SleepLogs> SLEEP_LOADER_FACTORY = new ResourceLoaderFactory<>(SLEEP_URL, SleepLogs.class);

    public static Loader<ResourceLoaderResult<SleepLogs>> getSleepLoader(Activity activityContext) throws MissingScopesException, TokenExpiredException {
        return SLEEP_LOADER_FACTORY.newResourceLoader(activityContext, new Scope[]{Scope.sleep});
    }

}
