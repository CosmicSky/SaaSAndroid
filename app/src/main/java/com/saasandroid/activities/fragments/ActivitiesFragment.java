//
//  ActivitiesFragment.java
//  SaaSAndroid
//
//  Created by Tony Qi on 4/15/19.
//  Copyright © 2019 Tony Qi. All rights reserved.
//

package com.saasandroid.activities.fragments;

import android.content.Loader;
import android.os.Bundle;

import com.saasandroid.api.loaders.ResourceLoaderResult;
import com.saasandroid.api.models.Activity;
import com.saasandroid.api.models.ActivityLogs;
import com.saasandroid.api.models.ActivityGoals;
import com.saasandroid.api.models.ActivitySummary;
import com.saasandroid.api.services.ActivityService;
import com.saasandroid.activities.R;

import java.util.List;

public class ActivitiesFragment extends InfoFragment<ActivityLogs> {

    @Override
    public int getTitleResourceId() {
        return R.string.activity;
    }

    @Override
    protected int getLoaderId() {
        return 1;
    }

    @Override
    public Loader<ResourceLoaderResult<ActivityLogs>> onCreateLoader(int id, Bundle args) {
        return ActivityService.getActivityLoader(getActivity());
    }

    @Override
    public void onLoadFinished(Loader<ResourceLoaderResult<ActivityLogs>> loader, ResourceLoaderResult<ActivityLogs> data) {
        super.onLoadFinished(loader, data);
        if (data.isSuccessful()) {
            bindActivityData(data.getResult());
        }
    }

    public void bindActivityData(ActivityLogs activityLogs) {
        StringBuilder stringBuilder = new StringBuilder();

        ActivitySummary activitySummary = activityLogs.getSummary();
        ActivityGoals activityGoals = activityLogs.getGoals();
        List<Activity> activities = activityLogs.getActivities();

        stringBuilder.append("<b>SUMMARY</b> ");
        stringBuilder.append("<br />");
        printKeys(stringBuilder, activitySummary);

        stringBuilder.append("<br /><br />");
        stringBuilder.append("<b>GOALS</b> ");
        stringBuilder.append("<br />");
        printKeys(stringBuilder, activityGoals);

        for (Activity activity : activities) {
            stringBuilder.append("<br /><br />");
            stringBuilder.append("<b>ACTIVITY</b> ");
            stringBuilder.append("<br />");
            printKeys(stringBuilder, activity);
        }

        setMainText(stringBuilder.toString());
    }
}
