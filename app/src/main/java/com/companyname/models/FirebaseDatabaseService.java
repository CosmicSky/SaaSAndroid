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
        DatabaseReference dbReference = mDatabase.getReference();
        dbReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<Study> globalStudyArrayList = new ArrayList<>();
                DataSnapshot studySnapshot = dataSnapshot.child("study");
                DataSnapshot researcherSnapshot = dataSnapshot.child("researchers");
                DataSnapshot participantSnapshot = dataSnapshot.child("study_participant");
                DataSnapshot userSnapshot = participantSnapshot.child(CurrentState.getAuthentication().getUserId());

                inner:
                for (DataSnapshot currentStudySnapshot: studySnapshot.getChildren()) {
                    if (userSnapshot.hasChild("studies")) {
                        DataSnapshot userStudySnapshot = userSnapshot.child("studies");
                        for (DataSnapshot currentIndividualStudy: userStudySnapshot.getChildren()) {
                            Log.w(TAG, "hehe");
                            Log.w(TAG, currentStudySnapshot.getKey());
                            Log.w(TAG, currentIndividualStudy.getValue().toString());
                            if (currentStudySnapshot.getKey().equals(currentIndividualStudy.getValue().toString())){
                                continue inner;
                            }
                        }
                    }

                    if (currentStudySnapshot.child("status").getValue().toString().equals("active")) {
                        DataSnapshot currentStudyReference = studySnapshot.child(currentStudySnapshot.getKey());
                        String name = currentStudyReference.child("name").getValue().toString();
                        String description = currentStudyReference.child("desc").getValue().toString();
                        String ownerId = currentStudyReference.child("owner").getValue().toString();

                        DataSnapshot currentResearcherReference = researcherSnapshot.child(ownerId);
//                        Researcher owner = researcherSnapshot.getValue(Researcher.class);
                        String firstName = currentResearcherReference.child("firstName").getValue().toString();
                        String lastName = currentResearcherReference.child("lastName").getValue().toString();
                        String email = currentResearcherReference.child("email").getValue().toString();
                        String affiliation = "place holder";
                        String jobTitle = "place holder";

                        Researcher owner = new Researcher(firstName, lastName, email, affiliation, jobTitle);
                        Study study = new Study(name, description, owner, currentStudySnapshot.getKey());

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
        DatabaseReference dbReference = mDatabase.getReference();
        dbReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                DataSnapshot participantSnapshot = dataSnapshot.child("study_participant");
                DataSnapshot researcherSnapshot = dataSnapshot.child("researchers");
                DataSnapshot studySnapshot = dataSnapshot.child("study");
                DataSnapshot userSnapshot = participantSnapshot.child(CurrentState.getAuthentication().getUserId());

                if (userSnapshot.hasChild("studies")) {
                    DataSnapshot userStudySnapshot = userSnapshot.child("studies");
                    ArrayList<Study> individualStudyArrayList = new ArrayList<>();
                    for (DataSnapshot currentStudySnapshot: userStudySnapshot.getChildren()) {
                        DataSnapshot currentStudyReference = studySnapshot.child(currentStudySnapshot.getValue().toString());
                        String name = currentStudyReference.child("name").getValue().toString();
                        String description = currentStudyReference.child("desc").getValue().toString();
                        String ownerId = currentStudyReference.child("owner").getValue().toString();

                        DataSnapshot currentResearcherReference = researcherSnapshot.child(ownerId);
//                        Researcher owner = researcherSnapshot.getValue(Researcher.class);
                        String firstName = currentResearcherReference.child("firstName").getValue().toString();
                        String lastName = currentResearcherReference.child("lastName").getValue().toString();
                        String email = currentResearcherReference.child("email").getValue().toString();
                        String affiliation = "place holder";
                        String jobTitle = "place holder";

                        Researcher owner = new Researcher(firstName, lastName, email, affiliation, jobTitle);
                        Study study = new Study(name, description, owner, currentStudySnapshot.getValue().toString());

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
}
