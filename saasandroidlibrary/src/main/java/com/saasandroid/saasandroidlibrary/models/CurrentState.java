//
//  CurrentState.java
//  SaaSAndroid
//
//  Created by Tony Qi on 3/5/19.
//  Copyright © 2019 Tony Qi. All rights reserved.
//

package com.saasandroid.saasandroidlibrary.models;

import java.util.ArrayList;

public class CurrentState {
    private static Authentication authentication = new FirebaseAuthentication();
    private static DatabaseService database = new FirebaseDatabaseService();
    private static StudyParticipant studyParticipant;
    private static ArrayList<Study> globalStudyList = new ArrayList<>();
    private static ArrayList<Study> individualStudyList = new ArrayList<>();

    /**
     * Retrieves the Authentication instance used by current instance of app.
     * @return the authentication instance
     */
    public static Authentication getAuthentication() {
        return authentication;
    }

    /**
     * Retrieves the DatabaseService instance used by current instance of app.
     * @return the database instance
     */
    public static DatabaseService getDatabase() {
        return database;
    }

    /**
     * Retrieves the StudyParticipant currently using the app.
     * @return the study particant who is using the app
     */
    public static StudyParticipant getStudyParticipant() {
        return studyParticipant;
    }

    /**
     * Saves the StudyParticipant currently using the app.
     * @param studyParticipant the current study participant
     */
    public static void setStudyParticipant(StudyParticipant studyParticipant) {
        CurrentState.studyParticipant = studyParticipant;
    }

    /**
     * Retrieves the list of all studies that the current StudyParticipant can join.
     * @return the list of all studies available to join
     */
    public static ArrayList<Study> getGlobalStudyList() {
        return globalStudyList;
    }

    /**
     * Saves the list of all studies that the current StudyParticipant can join.
     * @param globalStudyList the list of all studies that the current StudyParticipant can join
     */
    static void setGlobalStudyList(ArrayList<Study> globalStudyList) {
        CurrentState.globalStudyList = globalStudyList;
    }

    /**
     * Retrieves the list of all studies that the current StudyParticipant has already joined.
     * @return the list of all studies that the current StudyParticipant has already joined.
     */
    public static ArrayList<Study> getIndividualStudyList() {
        return individualStudyList;
    }

    /**
     * Saves the list of all studies that the current StudyParticipant has already joined.
     * @param individualStudyList list of all studies that the current StudyParticipant has already joined
     */
    static void setIndividualStudyList(ArrayList<Study> individualStudyList) {
        CurrentState.individualStudyList = individualStudyList;
    }
}
