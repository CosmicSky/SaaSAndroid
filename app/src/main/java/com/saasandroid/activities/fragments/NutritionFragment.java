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
import com.saasandroid.api.models.FoodSummary;
import com.saasandroid.activities.R;
import com.saasandroid.api.services.FoodSummaryService;

public class NutritionFragment extends InfoFragment<FoodSummary> {

    @Override
    public int getTitleResourceId() {
        return R.string.nutrition;
    }

    @Override
    protected int getLoaderId() {
        return 4;
    }

    @Override
    public Loader<ResourceLoaderResult<FoodSummary>> onCreateLoader(int id, Bundle args) {
        return FoodSummaryService.getFoodSummaryLoader(getActivity());
    }

    @Override
    public void onLoadFinished(Loader<ResourceLoaderResult<FoodSummary>> loader, ResourceLoaderResult<FoodSummary> data) {
        super.onLoadFinished(loader, data);
        if (data.isSuccessful()) {
            bindActivityData(data.getResult());
        }
    }

    public void bindActivityData(FoodSummary foodSummary) {
        StringBuilder stringBuilder = new StringBuilder();

        if (foodSummary.getCalories() == null) {
            stringBuilder.append("Missing Today's Nutrition Data");
        } else {
            stringBuilder.append("<b>SUMMARY</b> ");
            stringBuilder.append("<br />");
            printKeys(stringBuilder, foodSummary);
        }

        setMainText(stringBuilder.toString());
    }
}
