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
import com.saasandroid.api.models.HeartRateLogs;
import com.saasandroid.api.models.HeartRateZones;
import com.saasandroid.activities.R;
import com.saasandroid.api.models.Value;
import com.saasandroid.api.services.HeartRateService;

import java.util.List;

public class HeartRateFragment extends InfoFragment<HeartRateLogs> {

    @Override
    public int getTitleResourceId() {
        return R.string.heartrate;
    }

    @Override
    protected int getLoaderId() {
        return 2;
    }

    @Override
    public Loader<ResourceLoaderResult<HeartRateLogs>> onCreateLoader(int id, Bundle args) {
        return HeartRateService.getHeartRateLoader(getActivity());
    }

    @Override
    public void onLoadFinished(Loader<ResourceLoaderResult<HeartRateLogs>> loader, ResourceLoaderResult<HeartRateLogs> data) {
        super.onLoadFinished(loader, data);
        if (data.isSuccessful()) {
            bindActivityData(data.getResult());
        }
    }

    public void bindActivityData(HeartRateLogs heartRate) {
        StringBuilder stringBuilder = new StringBuilder();

        List<HeartRate> heartRates = heartRate.getHeartRate();
        if (heartRates.isEmpty()) {
            stringBuilder.append("Missing Today's Heartrate Data");
        } else {
            for (HeartRate currentHeartRate : heartRates) {
                stringBuilder.append("<b>INFORMATION</b> ");
                stringBuilder.append("<br />");
                printKeys(stringBuilder, currentHeartRate.getDateTime());

                Value currentValue = currentHeartRate.getValue();
                Integer restingHeartRate = currentValue.getRestingHeartRate();
                stringBuilder.append("<br /><br />");
                stringBuilder.append("<b>RESTING HEARTRATE</b> ");
                stringBuilder.append("<br />");
                printKeys(stringBuilder, restingHeartRate);

                List<HeartRateZones> heartRateZones = currentValue.getHeartRateZones();
                stringBuilder.append("<br /><br />");
                stringBuilder.append("<b>HEARTRATE ZONES</b> ");
                stringBuilder.append("<br />");
                for (HeartRateZones heartRateZone : heartRateZones) {
                    printKeys(stringBuilder, heartRateZone);
                }
            }
        }

        setMainText(stringBuilder.toString());
    }
}
