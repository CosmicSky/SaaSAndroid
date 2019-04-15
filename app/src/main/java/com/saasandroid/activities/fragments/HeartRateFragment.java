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
import com.saasandroid.api.models.HeartRate;
import com.saasandroid.api.models.HeartRateZones;
import com.saasandroid.activities.R;
import com.saasandroid.api.models.Value;
import com.saasandroid.api.services.HeartRateService;

public class HeartRateFragment extends InfoFragment<HeartRate> {

    @Override
    public int getTitleResourceId() {
        return R.string.heartrate;
    }

    @Override
    protected int getLoaderId() {
        return 2;
    }

    @Override
    public Loader<ResourceLoaderResult<HeartRate>> onCreateLoader(int id, Bundle args) {
        return HeartRateService.getHeartRateLoader(getActivity());
    }

    @Override
    public void onLoadFinished(Loader<ResourceLoaderResult<HeartRate>> loader, ResourceLoaderResult<HeartRate> data) {
        super.onLoadFinished(loader, data);
        if (data.isSuccessful()) {
            bindActivityData(data.getResult());
        }
    }

    public void bindActivityData(HeartRate heartRate) {
        StringBuilder stringBuilder = new StringBuilder();

        Value value = heartRate.getValue();

        if (value == null) {
            stringBuilder.append("Missing Today's Heartrate Data");
        } else {
            stringBuilder.append("<b>INFORMATION</b> ");
            stringBuilder.append("<br />");
            printKeys(stringBuilder, heartRate.getDateTime());
            printKeys(stringBuilder, heartRate.getRestingHeartRate());

            HeartRateZones[] heartRateZones = value.getHeartRateZones();

            stringBuilder.append("<br /><br />");
            stringBuilder.append("<b>HEARTRATE ZONES</b> ");
            stringBuilder.append("<br />");
            for (HeartRateZones heartRateZone : heartRateZones) {
                printKeys(stringBuilder, heartRateZone);
            }
        }

        setMainText(stringBuilder.toString());
    }
}
