//
//  StudiesActivity.java
//  SaaSAndroid
//
//  Created by Tony Qi on 3/5/19.
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
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.saasandroid.saasandroidlibrary.models.CurrentState;
import com.saasandroid.saasandroidlibrary.models.Study;
import com.saasandroid.utilities.BottomNavigationViewHelper;

public class StudiesActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studies);

        ListView listView = findViewById(R.id.studiesList);

        final ArrayAdapter<Study> arrayAdapter= new ArrayAdapter<>(this, R.layout.studylist, CurrentState.getIndividualStudyList());
        if (listView != null) {
            listView.setAdapter(arrayAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(getApplicationContext(), StudyInformationActivity.class);
                    Study selectedItem = (arrayAdapter).getItem(position);
                    if (selectedItem != null) {
                        intent.putExtra("studyId", selectedItem.getId());
                        startActivity(intent);
                    }
                }
            });
        }

        Button mViewStudy = findViewById(R.id.viewStudyRepositoryButton);

        mViewStudy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CurrentState.getDatabase().retrieveGlobalStudyList();
                CurrentState.getDatabase().retrieveIndividualStudyList();
                startActivity(new Intent(getApplicationContext(), StudyRepositoryActivity.class));
            }
        });

        BottomNavigationView navigation = findViewById(R.id.navigation);
        BottomNavigationViewHelper.disableShiftMode(navigation);
        Menu menu = navigation.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigationStudies:
                        return true;
                    case R.id.navigationData:
                        startActivity(new Intent(getApplicationContext(), DataActivity.class));
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
