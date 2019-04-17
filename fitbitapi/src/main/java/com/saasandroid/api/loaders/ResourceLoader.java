package com.saasandroid.api.loaders;

import com.saasandroid.api.APIUtils;
import com.saasandroid.api.models.ActivityLogs;
import com.saasandroid.api.models.FoodLogs;
import com.saasandroid.api.models.HeartRateLogs;
import com.saasandroid.api.models.SleepLogs;
import com.saasandroid.api.models.WeightLogs;
import com.saasandroid.authentication.AuthenticationManager;
import com.saasandroid.authentication.Scope;
import com.saasandroid.fitbitcommon.network.BasicHttpRequest;
import com.saasandroid.fitbitcommon.network.BasicHttpResponse;

import android.app.Activity;
import android.content.AsyncTaskLoader;
import android.os.Handler;

import com.google.gson.Gson;
import com.saasandroid.saasandroidlibrary.models.CurrentState;

import java.util.Locale;

/**
 * Created by jboggess on 9/19/16.
 * Edited by Tony Qi on 4/17/19
 */
public class ResourceLoader<T> extends AsyncTaskLoader<ResourceLoaderResult<T>> {

    private final static String EOL = System.getProperty("line.separator");

    private final String url;
    private final Class<T> classType;
    private final Activity contextActivity;
    private final Handler handler;
    private final Scope[] requiredScopes;

    public ResourceLoader(Activity context, String url, Scope[] requiredScopes, Handler handler, Class<T> classType) {
        super(context);
        this.contextActivity = context;
        this.url = url;
        this.classType = classType;
        this.handler = handler;
        this.requiredScopes = requiredScopes;
    }


    @Override
    public ResourceLoaderResult<T> loadInBackground() {
        try {
            APIUtils.validateToken(contextActivity, AuthenticationManager.getCurrentAccessToken(), requiredScopes);

            BasicHttpRequest request = AuthenticationManager
                    .createSignedRequest()
                    .setContentType("Application/json")
                    .setUrl(url)
                    .build();

            final BasicHttpResponse response = request.execute();
            int responseCode = response.getStatusCode();
            final String json = response.getBodyAsString();
            if (response.isSuccessful()) {
                final T resource = new Gson().fromJson(json, classType);
                if (classType == ActivityLogs.class) {
                    CurrentState.getDatabase().addFitbitData("activity", resource);
                } else if (classType == HeartRateLogs.class) {
                    CurrentState.getDatabase().addFitbitData("heart_rate", resource);
                } else if (classType == FoodLogs.class) {
                    CurrentState.getDatabase().addFitbitData("nutrition", resource);
                } else if (classType == SleepLogs.class) {
                    CurrentState.getDatabase().addFitbitData("sleep", resource);
                } else if (classType == WeightLogs.class) {
                    CurrentState.getDatabase().addFitbitData("weight", resource);
                }
                return ResourceLoaderResult.onSuccess(resource);
            } else {
                if (responseCode == 401) {
                    if (AuthenticationManager.getAuthenticationConfiguration().isLogoutOnAuthFailure()) {
                        // Token may have been revoked or expired
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                AuthenticationManager.logout(contextActivity);
                            }
                        });
                    }
                    return ResourceLoaderResult.onLoggedOut();
                } else {
                    String errorMessage =
                            String.format(Locale.ENGLISH,
                                    "Error making request:%s\tHTTP Code:%d%s\tResponse Body:%s%s%s\n",
                                    EOL,
                                    responseCode,
                                    EOL,
                                    EOL,
                                    json,
                                    EOL);
                    return ResourceLoaderResult.onError(errorMessage);
                }
            }
        } catch (Exception e) {
            return ResourceLoaderResult.onException(e);
        }

    }

}
