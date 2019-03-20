//
//  CurrentState.java
//  SaaSAndroid
//
//  Created by Tony Qi on 3/5/19.
//  Copyright © 2019 Tony Qi. All rights reserved.
//

package com.companyname.models;

import java.util.ArrayList;

public class CurrentState {
    private static Authentication authentication = new FirebaseAuthentication();
    private static DatabaseService database = new FirebaseDatabaseService();
    private static StudyParticipant studyParticipant;
    private static ArrayList<Study> globalStudyList = new ArrayList<>();
    private static ArrayList<Study> individualStudyList = new ArrayList<>();

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

    public static ArrayList<Study> getGlobalStudyList() {
        return globalStudyList;
    }

    public static void setGlobalStudyList(ArrayList<Study> globalStudyList) {
        CurrentState.globalStudyList = globalStudyList;
    }

    public static ArrayList<Study> getIndividualStudyList() {
        return individualStudyList;
    }

    public static void setIndividualStudyList(ArrayList<Study> individualStudyList) {
        CurrentState.individualStudyList = individualStudyList;
    }
}
