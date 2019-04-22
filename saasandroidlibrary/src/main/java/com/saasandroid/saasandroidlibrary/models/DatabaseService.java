//
//  DatabaseService.java
//  SaaSAndroid
//
//  Created by Tony Qi on 3/5/19.
//  Copyright © 2019 Tony Qi. All rights reserved.
//

package com.saasandroid.saasandroidlibrary.models;

public interface DatabaseService {
    /**
     * Adds a study participant to the database.
     * @param studyParticipant the participant object
     * @param userId the user id
     */
    void addStudyParticipant(StudyParticipant studyParticipant, String userId);

    /**
     * Retrieves the study participant from the database.
     * @param userId the user id
     */
    void retrieveStudyParticipant(String userId);

    /**
     * Resets the study participant using the current instance of the app.
     */
    void resetStudyParticipant();

    /**
     * This method retrieves the list of all studies that a study participant can join from the database.
     * @param studyId the study id
     */
    void joinStudy(String studyId);

    /**
     * This method allows a study participant to join a study.
     */
    void retrieveGlobalStudyList();

    /**
     * This method adds a study participant to the database.
     */
    void retrieveIndividualStudyList();

    /**
     * This method adds fitbit data to the database.
     * @param type the type of data (weight, nutrition, etc.)
     * @param data the data
     * @param <T> the class type
     */
    <T> void addFitbitData(String type, T data);
}
