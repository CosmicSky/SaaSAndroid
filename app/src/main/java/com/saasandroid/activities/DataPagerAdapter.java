//
//  DataPagerAdapter.java
//  SaaSAndroid
//
//  Created by Tony Qi on 4/15/19.
//  Copyright © 2019 Tony Qi. All rights reserved.
//

package com.saasandroid.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;

import com.saasandroid.authentication.AuthenticationManager;
import com.saasandroid.authentication.Scope;
import com.saasandroid.activities.fragments.ActivitiesFragment;
import com.saasandroid.activities.fragments.DeviceFragment;
import com.saasandroid.activities.fragments.InfoFragment;
import com.saasandroid.activities.fragments.ProfileFragment;
import com.saasandroid.activities.fragments.WeightLogFragment;

import java.util.ArrayList;
import java.util.List;

public class DataPagerAdapter extends FragmentPagerAdapter {

    private final List<InfoFragment> fragments = new ArrayList<>();

    public DataPagerAdapter(FragmentManager fm) {
        super(fm);

        fragments.clear();
        if (containsScope(Scope.profile)) {
            fragments.add(new ProfileFragment());
        }
        if (containsScope(Scope.settings)) {
            fragments.add(new DeviceFragment());
        }
        if (containsScope(Scope.activity)) {
            fragments.add(new ActivitiesFragment());
        }
        if (containsScope(Scope.weight)) {
            fragments.add(new WeightLogFragment());
        }
    }

    private boolean containsScope(Scope scope) {
        return AuthenticationManager.getCurrentAccessToken().getScopes().contains(scope);
    }

    @Override
    public Fragment getItem(int position) {
        if (position >= fragments.size()) {
            return null;
        }

        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    public int getTitleResourceId(int index) {
        return fragments.get(index).getTitleResourceId();
    }
}
