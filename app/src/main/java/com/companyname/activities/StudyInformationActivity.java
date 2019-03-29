//
//  StudyInformationActivity.java
//  SaaSAndroid
//
//  Created by Tony Qi on 3/20/19.
//  Copyright © 2019 Tony Qi. All rights reserved.
//

package com.companyname.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.companyname.models.CurrentState;
import com.companyname.models.Researcher;
import com.companyname.models.Study;
import com.companyname.utilities.BottomNavigationViewHelper;

public class StudyInformationActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studies);

        setContentView(R.layout.activity_studyinformation);

        TextView mTitle = findViewById(R.id.studyTitle);
        TextView mDescription = findViewById(R.id.studyDescription);
        TextView mName = findViewById(R.id.studyName);
        TextView mEmail = findViewById(R.id.studyEmail);
        TextView mJobTitle = findViewById(R.id.studyJobTitle);
        TextView mAffiliation = findViewById(R.id.studyAffiliation);

        final String id = getIntent().getStringExtra("studyId");

        for (Study study: CurrentState.getIndividualStudyList()) {
            if (study.getId().equals(id)) {
                mTitle.setText(study.getName());
                mDescription.setText(study.getDescription());
                Researcher owner = study.getOwner();
                mName.setText(owner.getFirstName() + " " + owner.getLastName());
                mEmail.setText(owner.getEmail());
                mJobTitle.setText(owner.getJobTitle());
                mAffiliation.setText(owner.getAffiliation());
                break;
            }
        }
    }
}
