package com.saasandroid.activities.fragments;


import android.content.Loader;
import android.os.Bundle;

import com.saasandroid.api.loaders.ResourceLoaderResult;
import com.saasandroid.api.models.User;
import com.saasandroid.api.models.UserContainer;
import com.saasandroid.api.services.UserService;
import com.saasandroid.activities.R;

/**
 * Created by jboggess on 10/17/16.
 */

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
