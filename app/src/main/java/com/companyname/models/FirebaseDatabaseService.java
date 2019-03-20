//
//  FirebaseDatabaseService.java
//  SaaSAndroid
//
//  Created by Tony Qi on 3/5/19.
//  Copyright © 2019 Tony Qi. All rights reserved.
//

package com.companyname.models;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseDatabaseService implements DatabaseService {
    private FirebaseDatabase mDatabase;

    FirebaseDatabaseService(){
        mDatabase = FirebaseDatabase.getInstance();
    }

    @Override
    public void addStudyParticipant(StudyParticipant studyParticipant, String userId) {
        DatabaseReference dbReference = mDatabase.getReference("study_participant");
        dbReference.child(userId).setValue(studyParticipant);
    }

    @Override
    public boolean retrieveStudyParticipant(String userId) {
        return false;
    }

    @Override
    public void resetStudyParticipant() {
        CurrentState.setStudyParticipant(null);
    }

    @Override
    public boolean retrieveGlobalStudyList() {
        return false;
    }

    private boolean retrieveOwner(String ownerId) {
        return false;
    }

    @Override
    public void joinStudy(String userId, String studyId) {

    }

    @Override
    public boolean retrieveIndividualStudyList(String userId) {
        return false;
    }
}
