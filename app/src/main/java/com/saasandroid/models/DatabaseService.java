//
//  DatabaseService.java
//  SaaSAndroid
//
//  Created by Tony Qi on 3/5/19.
//  Copyright © 2019 Tony Qi. All rights reserved.
//

package com.saasandroid.models;

public interface DatabaseService {
    void addStudyParticipant(StudyParticipant studyParticipant, String userId);

    void retrieveStudyParticipant(String userId);

    void resetStudyParticipant();

    void joinStudy(String studyId);

    void retrieveGlobalStudyList();

    void retrieveIndividualStudyList();
}
