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
import com.saasandroid.api.models.FoodGoals;
import com.saasandroid.api.models.FoodLogs;
import com.saasandroid.activities.R;
import com.saasandroid.api.models.FoodSummary;
import com.saasandroid.api.services.FoodSummaryService;

import java.util.List;

public class NutritionFragment extends InfoFragment<FoodLogs> {

    @Override
    public int getTitleResourceId() {
        return R.string.nutrition;
    }

    @Override
    protected int getLoaderId() {
        return 4;
    }

    @Override
    public Loader<ResourceLoaderResult<FoodLogs>> onCreateLoader(int id, Bundle args) {
        return FoodSummaryService.getFoodLoader(getActivity());
    }

    @Override
    public void onLoadFinished(Loader<ResourceLoaderResult<FoodLogs>> loader, ResourceLoaderResult<FoodLogs> data) {
        super.onLoadFinished(loader, data);
        if (data.isSuccessful()) {
            bindActivityData(data.getResult());
        }
    }

    public void bindActivityData(FoodLogs foodLogs) {
        StringBuilder stringBuilder = new StringBuilder();

        FoodSummary foodSummary = foodLogs.getSummary();
        FoodGoals foodGoals = foodLogs.getGoals();
        List<Object> foods = foodLogs.getFoods();

        stringBuilder.append("<b>SUMMARY</b> ");
        stringBuilder.append("<br />");
        printKeys(stringBuilder, foodSummary);

        stringBuilder.append("<br /><br />");
        stringBuilder.append("<b>GOALS</b> ");
        stringBuilder.append("<br />");
        printKeys(stringBuilder, foodGoals);

        for (Object food : foods) {
            stringBuilder.append("<br /><br />");
            stringBuilder.append("<b>FOOD</b> ");
            stringBuilder.append("<br />");
            printKeys(stringBuilder, food);
        }

        setMainText(stringBuilder.toString());
    }
}
