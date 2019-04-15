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
import com.saasandroid.activities.R;
import com.saasandroid.api.models.SleepSummary;
import com.saasandroid.api.services.SleepSummaryService;

public class SleepFragment extends InfoFragment<SleepSummary> {

    @Override
    public int getTitleResourceId() {
        return R.string.sleep;
    }

    @Override
    protected int getLoaderId() {
        return 3;
    }

    @Override
    public Loader<ResourceLoaderResult<SleepSummary>> onCreateLoader(int id, Bundle args) {
        return SleepSummaryService.getSleepSummaryLoader(getActivity());
    }

    @Override
    public void onLoadFinished(Loader<ResourceLoaderResult<SleepSummary>> loader, ResourceLoaderResult<SleepSummary> data) {
        super.onLoadFinished(loader, data);
        if (data.isSuccessful()) {
            bindActivityData(data.getResult());
        }
    }

    public void bindActivityData(SleepSummary sleepSummary) {
        StringBuilder stringBuilder = new StringBuilder();

        if (sleepSummary.getTotalMinutesAsleep() == null) {
            stringBuilder.append("Missing Today's Sleep Data");
        } else {
            printKeys(stringBuilder, sleepSummary);
        }

        setMainText(stringBuilder.toString());
    }
}
