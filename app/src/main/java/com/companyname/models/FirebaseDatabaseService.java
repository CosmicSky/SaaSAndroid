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

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class FirebaseDatabaseService implements DatabaseService {
    private FirebaseDatabase mDatabase;
    private Researcher owner;
    private Study study;

    FirebaseDatabaseService(){
        mDatabase = FirebaseDatabase.getInstance();
    }

    @Override
    public void addStudyParticipant(StudyParticipant studyParticipant, String userId) {
        DatabaseReference dbReference = mDatabase.getReference("study_participant");
        dbReference.child(userId).child("firstName").setValue(studyParticipant.getFirstName());
        dbReference.child(userId).child("lastName").setValue(studyParticipant.getLastName());
        dbReference.child(userId).child("birthDate").setValue(studyParticipant.getBirthDate());
        dbReference.child(userId).child("zipCode").setValue(studyParticipant.getZipCode());
        dbReference.child(userId).child("country").setValue(studyParticipant.getCountry());
        dbReference.child(userId).child("email").setValue(studyParticipant.getEmail());
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
    public void joinStudy(String studyId) {
        DatabaseReference dbReference = mDatabase.getReference("study_participant");
        dbReference.child(CurrentState.getAuthentication().getUserId()).child("studies").push().setValue(studyId);
    }

    @Override
    public void retrieveGlobalStudyList() {
        DatabaseReference dbReference = mDatabase.getReference("study");
        dbReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<Study> globalStudyArrayList = new ArrayList<>();
                for (DataSnapshot studySnapshot: dataSnapshot.getChildren()) {
                    if (studySnapshot.child("status").getValue().toString().equals("active")) {
                        Study currentStudy = retrieveStudy(studySnapshot.getKey());
                        globalStudyArrayList.add(study);
                    }
                }
                CurrentState.setGlobalStudyList(globalStudyArrayList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
            }
        });
    }

    @Override
    public void retrieveIndividualStudyList() {
        DatabaseReference dbReference = mDatabase.getReference("study_participant");
        dbReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                DataSnapshot userSnapshot = dataSnapshot.child(CurrentState.getAuthentication().getUserId());
                if (userSnapshot.hasChild("studies")) {
                    DataSnapshot studiesSnapshot = userSnapshot.child("studies");
                    ArrayList<Study> individualStudyArrayList = new ArrayList<>();
                    for (DataSnapshot studySnapshot: studiesSnapshot.getChildren()) {
                        Study currentStudy = retrieveStudy(studySnapshot.getKey());
                        individualStudyArrayList.add(study);
                    }
                    CurrentState.setIndividualStudyList(individualStudyArrayList);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
            }
        });
    }

    private Study retrieveStudy(final String studyId) {
        DatabaseReference dbReference = mDatabase.getReference("study");
        dbReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                DataSnapshot studySnapshot = dataSnapshot.child(studyId);
                String name = studySnapshot.child("name").getValue().toString();
                String description = studySnapshot.child("desc").getValue().toString();
                String ownerId = studySnapshot.child("owner").getValue().toString();
                Researcher owner = retrieveOwner(ownerId);
                study = new Study(name, description, owner, studyId);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
            }
        });
        return study;
    }

    private Researcher retrieveOwner(final String ownerId) {
        DatabaseReference dbReference = mDatabase.getReference("researchers");
        dbReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                DataSnapshot researcherSnapshot = dataSnapshot.child(ownerId);
//                Researcher owner = researcherSnapshot.getValue(Researcher.class);
                String firstName = researcherSnapshot.child("firstName").getValue().toString();
                String lastName = researcherSnapshot.child("lastName").getValue().toString();
                String email = researcherSnapshot.child("email").getValue().toString();
                String affiliation = "place holder";
                String jobTitle = "place holder";
                owner = new Researcher(firstName, lastName, email, affiliation, jobTitle);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
            }
        });
        return owner;
    }
}
