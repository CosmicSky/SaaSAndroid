//
//  WeightLogFragment.java
//  SaaSAndroid
//
//  Created by Tony Qi on 4/15/19.
//  Copyright © 2019 Tony Qi. All rights reserved.
//

package com.saasandroid.activities.fragments;

import android.content.Loader;
import android.os.Bundle;

import com.saasandroid.api.loaders.ResourceLoaderResult;
import com.saasandroid.api.models.Weight;
import com.saasandroid.api.models.WeightLogs;
import com.saasandroid.api.services.WeightService;
import com.saasandroid.activities.R;
import java.util.List;

public class WeightLogFragment extends InfoFragment<WeightLogs> {

    @Override
    public int getTitleResourceId() {
        return R.string.weight;
    }

    @Override
    protected int getLoaderId() {
        return 3;
    }

    @Override
    public Loader<ResourceLoaderResult<WeightLogs>> onCreateLoader(int id, Bundle args) {
        return WeightService.getWeightLogLoader(getActivity());
    }

    @Override
    public void onLoadFinished(Loader<ResourceLoaderResult<WeightLogs>> loader, ResourceLoaderResult<WeightLogs> data) {
        super.onLoadFinished(loader, data);
        if (data.isSuccessful()) {
            bindWeightLogs(data.getResult());
        }
    }

    public void bindWeightLogs(WeightLogs weightLogs) {
        StringBuilder stringBuilder = new StringBuilder();

        List<Weight> weights = weightLogs.getWeight();
        for (Weight weight : weights) {
            printKeys(stringBuilder, weight);
            stringBuilder.append("<br /><br />");
        }

        setMainText(stringBuilder.toString());
    }
}
