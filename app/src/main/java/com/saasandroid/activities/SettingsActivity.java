//
//  SettingsActivity.java
//  SaaSAndroid
//
//  Created by Tony Qi on 3/20/19.
//  Copyright © 2019 Tony Qi. All rights reserved.
//

package com.saasandroid.activities;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.saasandroid.utilities.BottomNavigationViewHelper;

public class SettingsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        String status = getIntent().getStringExtra("status");
        if (status != null && status.equals("success")) {
            new AlertDialog.Builder(this)
                    .setTitle("Fitbit Login Successful")
                    .setMessage("You have successfully connected and synchronized your Fitbit device.")
                    .create()
                    .show();
        }

        Button mManageFitbit = findViewById(R.id.manageFitbitButton);
        Button mLogout = findViewById(R.id.logoutButton);

        mManageFitbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ManageFitbitActivity.class));
            }
        });

        mLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), WelcomeActivity.class));
            }
        });

        BottomNavigationView navigation = findViewById(R.id.navigation);
        BottomNavigationViewHelper.disableShiftMode(navigation);
        Menu menu = navigation.getMenu();
        MenuItem menuItem = menu.getItem(3);
        menuItem.setChecked(true);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigationStudies:
                        startActivity(new Intent(getApplicationContext(), StudiesActivity.class));
                        return true;
                    case R.id.navigationData:
                        startActivity(new Intent(getApplicationContext(), DataActivity.class));
                        return true;
                    case R.id.navigationProfile:
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        return true;
                    case R.id.navigationSettings:
                        return true;
                }
                return false;
            }
        });
    }
}
