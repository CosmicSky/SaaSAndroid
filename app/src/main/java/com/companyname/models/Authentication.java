//
//  Authentication.java
//  SaaSAndroid
//
//  Created by Tony Qi on 3/5/19.
//  Copyright © 2019 Tony Qi. All rights reserved.
//

package com.companyname.models;

public interface Authentication {
    void signIn(String email, String password);

    void signOut();

    void createStudyParticipant(String email, String password);

    boolean isSignedIn();

    boolean isVerified();

    void resetPassword(String email);

    boolean sendVerificationLink();

    String getUserId();
}
