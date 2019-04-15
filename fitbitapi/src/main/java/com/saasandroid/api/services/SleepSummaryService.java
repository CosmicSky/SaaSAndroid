package com.saasandroid.api.services;

import com.saasandroid.api.exceptions.MissingScopesException;
import com.saasandroid.api.exceptions.TokenExpiredException;
import com.saasandroid.api.loaders.ResourceLoaderFactory;
import com.saasandroid.api.loaders.ResourceLoaderResult;
import com.saasandroid.api.models.SleepSummary;
import com.saasandroid.authentication.Scope;

import android.app.Activity;
import android.content.Loader;

public class SleepSummaryService {

    private final static String SLEEP_URL = "https://api.fitbit.com/1.2/user/-/sleep/date/today.json";
    private static final ResourceLoaderFactory<SleepSummary> SLEEP_SUMMARY_LOADER_FACTORY = new ResourceLoaderFactory<>(SLEEP_URL, SleepSummary.class);

    public static Loader<ResourceLoaderResult<SleepSummary>> getSleepSummaryLoader(Activity activityContext) throws MissingScopesException, TokenExpiredException {
        return SLEEP_SUMMARY_LOADER_FACTORY.newResourceLoader(activityContext, new Scope[]{Scope.sleep});
    }

}
