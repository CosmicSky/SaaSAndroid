//
//  CurrentState.java
//  SaaSAndroid
//
//  Created by Tony Qi on 3/5/19.
//  Copyright © 2019 Tony Qi. All rights reserved.
//

package com.companyname.models;

import com.google.firebase.database.FirebaseDatabase;

public class CurrentState {
    private static Authentication authentication = new FirebaseAuthentication();
    private static DatabaseService database = new FirebaseDatabaseService();
    private static StudyParticipant studyParticipant;
    private static Study[] globalStudyList;

    public static Authentication getAuthentication() {
        return authentication;
    }

    public static DatabaseService getDatabase() {
        return database;
    }

    public static StudyParticipant getStudyParticipant() {
        return studyParticipant;
    }

    public static void setStudyParticipant(StudyParticipant studyParticipant) {
        CurrentState.studyParticipant = studyParticipant;
    }

    public static Study[] getGlobalStudyList() {
        return globalStudyList;
    }

    public static void setGlobalStudyList(Study[] globalStudyList) {
        CurrentState.globalStudyList = globalStudyList;
    }
}
