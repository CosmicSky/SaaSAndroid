//
//  DataActivity.java
//  SaaSAndroid
//
//  Created by Tony Qi on 3/20/19.
//  Copyright © 2019 Tony Qi. All rights reserved.
//

package com.saasandroid.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.saasandroid.utilities.BottomNavigationViewHelper;

public class DataActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        TextView mTextMessage = findViewById(R.id.dataMessage);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        BottomNavigationViewHelper.disableShiftMode(navigation);
        Menu menu = navigation.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigationStudies:
                        startActivity(new Intent(getApplicationContext(), StudiesActivity.class));
                        return true;
                    case R.id.navigationData:
                        return true;
                    case R.id.navigationProfile:
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        return true;
                    case R.id.navigationSettings:
                        startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
                        return true;
                }
                return false;
            }
        });
    }
}
