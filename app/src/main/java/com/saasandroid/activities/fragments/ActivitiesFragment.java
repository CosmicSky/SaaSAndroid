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
import com.saasandroid.api.models.DailyActivitySummary;
import com.saasandroid.api.models.Goals;
import com.saasandroid.api.models.Summary;
import com.saasandroid.api.services.ActivityService;
import com.saasandroid.activities.R;

public class ActivitiesFragment extends InfoFragment<DailyActivitySummary> {

    @Override
    public int getTitleResourceId() {
        return R.string.activity_info;
    }

    @Override
    protected int getLoaderId() {
        return 1;
    }

    @Override
    public Loader<ResourceLoaderResult<DailyActivitySummary>> onCreateLoader(int id, Bundle args) {
        return ActivityService.getDailyActivitySummaryLoader(getActivity());
    }

    @Override
    public void onLoadFinished(Loader<ResourceLoaderResult<DailyActivitySummary>> loader, ResourceLoaderResult<DailyActivitySummary> data) {
        super.onLoadFinished(loader, data);
        if (data.isSuccessful()) {
            bindActivityData(data.getResult());
        }
    }

    public void bindActivityData(DailyActivitySummary dailyActivitySummary) {
        StringBuilder stringBuilder = new StringBuilder();

        Summary summary = dailyActivitySummary.getSummary();
        Goals goals = dailyActivitySummary.getGoals();

        stringBuilder.append("<b>SUMMARY</b> ");
        stringBuilder.append("<br />");
        printKeys(stringBuilder, summary);

        stringBuilder.append("<br /><br />");
        stringBuilder.append("<b>GOALS</b> ");
        stringBuilder.append("<br />");
        printKeys(stringBuilder, goals);

        setMainText(stringBuilder.toString());
    }
}
