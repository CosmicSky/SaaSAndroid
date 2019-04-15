//
//  ProfileFragment.java
//  SaaSAndroid
//
//  Created by Tony Qi on 4/15/19.
//  Copyright © 2019 Tony Qi. All rights reserved.
//

package com.saasandroid.activities.fragments;

import android.content.Loader;
import android.os.Bundle;

import com.saasandroid.api.loaders.ResourceLoaderResult;
import com.saasandroid.api.models.User;
import com.saasandroid.api.models.UserContainer;
import com.saasandroid.api.services.UserService;
import com.saasandroid.activities.R;

public class ProfileFragment extends InfoFragment<UserContainer> {

    @Override
    public int getTitleResourceId() {
        return R.string.user_info;
    }

    @Override
    protected int getLoaderId() {
        return 1;
    }

    @Override
    public Loader<ResourceLoaderResult<UserContainer>> onCreateLoader(int id, Bundle args) {
        return UserService.getLoggedInUserLoader(getActivity());
    }

    @Override
    public void onLoadFinished(Loader<ResourceLoaderResult<UserContainer>> loader, ResourceLoaderResult<UserContainer> data) {
        super.onLoadFinished(loader, data);
        if (data.isSuccessful()) {
            bindProfileInfo(data.getResult().getUser());
        }
    }

    public void bindProfileInfo(User user) {
        StringBuilder stringBuilder = new StringBuilder();
        printKeys(stringBuilder, user);
        setMainText(stringBuilder.toString());
    }


}
