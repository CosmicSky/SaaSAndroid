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
import com.saasandroid.api.models.SleepLogs;
import com.saasandroid.api.models.SleepSummary;
import com.saasandroid.api.services.SleepService;

import java.util.List;

public class SleepFragment extends InfoFragment<SleepLogs> {

    @Override
    public int getTitleResourceId() {
        return R.string.sleep;
    }

    @Override
    protected int getLoaderId() {
        return 3;
    }

    @Override
    public Loader<ResourceLoaderResult<SleepLogs>> onCreateLoader(int id, Bundle args) {
        return SleepService.getSleepLoader(getActivity());
    }

    @Override
    public void onLoadFinished(Loader<ResourceLoaderResult<SleepLogs>> loader, ResourceLoaderResult<SleepLogs> data) {
        super.onLoadFinished(loader, data);
        if (data.isSuccessful()) {
            bindActivityData(data.getResult());
        }
    }

    public void bindActivityData(SleepLogs sleepLogs) {
        StringBuilder stringBuilder = new StringBuilder();

        SleepSummary summary = sleepLogs.getSummary();
        List<Object> sleeps = sleepLogs.getSleep();

        stringBuilder.append("<b>SUMMARY</b> ");
        stringBuilder.append("<br />");
        printKeys(stringBuilder, summary);

        for (Object sleep : sleeps) {
            stringBuilder.append("<br /><br />");
            stringBuilder.append("<b>SLEEP</b> ");
            stringBuilder.append("<br />");
            printKeys(stringBuilder, sleep);
        }

        setMainText(stringBuilder.toString());
    }
}
