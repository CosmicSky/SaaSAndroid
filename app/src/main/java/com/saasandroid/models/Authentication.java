//
//  Authentication.java
//  SaaSAndroid
//
//  Created by Tony Qi on 3/5/19.
//  Copyright © 2019 Tony Qi. All rights reserved.
//

package com.saasandroid.models;

public interface Authentication {
    void signIn(String email, String password);

    void register(String email, String password);

    void signOut();

    boolean isSignedIn();

    boolean isVerified();

    void resetPassword(String email);

    boolean sendVerificationLink();

    String getUserId();
}
