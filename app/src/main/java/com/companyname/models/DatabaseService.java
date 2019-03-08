//
//  DatabaseService.java
//  SaaSAndroid
//
//  Created by Tony Qi on 3/5/19.
//  Copyright © 2019 Tony Qi. All rights reserved.
//

package com.companyname.models;

public interface DatabaseService {
    void addStudyParticipant(StudyParticipant studyParticipant, String userId);

    boolean retrieveStudyParticipant(String userId);

    void resetStudyParticipant();

    boolean retrieveGlobalStudyList();

    void joinStudy(String userId, Study study);

    boolean retrieveIndividualStudyList(String userId);
}
