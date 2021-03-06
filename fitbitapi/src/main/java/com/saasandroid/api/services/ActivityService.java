package com.saasandroid.api.services;

import com.saasandroid.api.exceptions.MissingScopesException;
import com.saasandroid.api.exceptions.TokenExpiredException;
import com.saasandroid.api.loaders.ResourceLoaderFactory;
import com.saasandroid.api.loaders.ResourceLoaderResult;
import com.saasandroid.api.models.ActivityLogs;
import com.saasandroid.authentication.Scope;

import android.app.Activity;
import android.content.Loader;

public class ActivityService {

    public final static String ACTIVITIES_URL = "https://api.fitbit.com/1/user/-/activities/date/today.json";
    private static final ResourceLoaderFactory<ActivityLogs> USER_ACTIVITIES_LOADER_FACTORY = new ResourceLoaderFactory<>(ACTIVITIES_URL, ActivityLogs.class);

    public static Loader<ResourceLoaderResult<ActivityLogs>> getActivityLoader(Activity activityContext) throws MissingScopesException, TokenExpiredException {
        return USER_ACTIVITIES_LOADER_FACTORY.newResourceLoader(activityContext, new Scope[]{Scope.activity});
    }

}
