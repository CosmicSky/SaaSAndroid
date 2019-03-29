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
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.companyname.models.CurrentState;
import com.companyname.models.Researcher;
import com.companyname.models.Study;

public class StudyRepositoryInformationActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studyrepositoryinformation);

        TextView mTitle = findViewById(R.id.studyRepositoryTitle);
        TextView mDescription = findViewById(R.id.studyRepositoryDescription);
        TextView mName = findViewById(R.id.studyRepositoryName);
        TextView mEmail = findViewById(R.id.studyRepositoryEmail);
        TextView mJobTitle = findViewById(R.id.studyRepositoryJobTitle);
        TextView mAffiliation = findViewById(R.id.studyRepositoryAffiliation);

        final String id = getIntent().getStringExtra("studyId");

        for (Study study: CurrentState.getGlobalStudyList()) {
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

        Button mJoin = findViewById(R.id.studyJoinButton);

        mJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CurrentState.getDatabase().joinStudy(id);
                CurrentState.getDatabase().retrieveIndividualStudyList();
                CurrentState.getDatabase().retrieveGlobalStudyList();
                startActivity(new Intent(getApplicationContext(), StudiesActivity.class));
            }
        });
    }
}
