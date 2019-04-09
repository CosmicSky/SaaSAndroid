//
//  ProfileActivity.java
//  SaaSAndroid
//
//  Created by Tony Qi on 3/20/19.
//  Copyright © 2019 Tony Qi. All rights reserved.
//

package com.saasandroid.authentication.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.saasandroid.models.CurrentState;
import com.saasandroid.models.StudyParticipant;
import com.saasandroid.utilities.BottomNavigationViewHelper;

public class ProfileActivity extends Activity {
    private StudyParticipant currentUser;
    private EditText mZipCode;
    private EditText mCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        currentUser = CurrentState.getStudyParticipant();
        TextView mFirstName = findViewById(R.id.firstNameUpdateText);
        mFirstName.setText(currentUser.getFirstName());
        TextView mLastName = findViewById(R.id.lastNameUpdateText);
        mLastName.setText(currentUser.getLastName());
        TextView mDateOfBirth = findViewById(R.id.dateOfBirthUpdateText);
        mDateOfBirth.setText(currentUser.getBirthdate());
        TextView mEmail = findViewById(R.id.emailUpdateText);
        mEmail.setText(currentUser.getEmail());

        mZipCode = findViewById(R.id.zipCodeUpdateText);
        mZipCode.setText(currentUser.getZipCode());
        mCountry = findViewById(R.id.countryUpdateText);
        mCountry.setText(currentUser.getCountry());

        Button mUpdate = findViewById(R.id.updateProfileButton);

        mUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newZip = mZipCode.getText().toString();
                String newCountry = mCountry.getText().toString();
                StudyParticipant newUser = new StudyParticipant(currentUser.getFirstName(),
                        currentUser.getLastName(), currentUser.getBirthdate(),
                        newZip, newCountry, currentUser.getEmail());
                CurrentState.getDatabase().addStudyParticipant(newUser, CurrentState.getAuthentication().getUserId());
                CurrentState.getDatabase().retrieveStudyParticipant(CurrentState.getAuthentication().getUserId());
                try {
                    Thread.sleep(1200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
            }
        });

        BottomNavigationView navigation = findViewById(R.id.navigation);
        BottomNavigationViewHelper.disableShiftMode(navigation);
        Menu menu = navigation.getMenu();
        MenuItem menuItem = menu.getItem(2);
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
