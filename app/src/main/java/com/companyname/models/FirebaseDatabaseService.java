//
//  FirebaseDatabaseService.java
//  SaaSAndroid
//
//  Created by Tony Qi on 3/5/19.
//  Copyright © 2019 Tony Qi. All rights reserved.
//

package com.companyname.models;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.content.ContentValues.TAG;

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
    public void retrieveStudyParticipant(final String userId) {
        DatabaseReference dbReference = mDatabase.getReference("study_participant");
        dbReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                DataSnapshot userSnapshot = dataSnapshot.child(userId);
                StudyParticipant studyParticipant = userSnapshot.getValue(StudyParticipant.class);
                CurrentState.setStudyParticipant(studyParticipant);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
            }
        });
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
