//
//  Authentication.java
//  SaaSAndroid
//
//  Created by Tony Qi on 3/5/19.
//  Copyright © 2019 Tony Qi. All rights reserved.
//

package com.saasandroid.models;

import android.content.Context;

public interface Authentication {
    void signIn(Context mContext, String email, String password);

    void register(Context mContext, StudyParticipant newUser, String email, String password);

    void signOut();

    boolean isSignedIn();

    boolean isVerified();

    void resetPassword(String email);

    boolean sendVerificationLink();

    String getUserId();
}
