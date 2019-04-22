//
//  Authentication.java
//  SaaSAndroid
//
//  Created by Tony Qi on 3/5/19.
//  Copyright © 2019 Tony Qi. All rights reserved.
//

package com.saasandroid.saasandroidlibrary.models;

import android.content.Context;

public interface Authentication {
    /**
     * Signs in the study participant into the app.
     * @param mContext the context from which the method is calling
     * @param studies the studies class
     * @param accountVerification the account verification class
     * @param email the email
     * @param password the password
     */
    void signIn(Context mContext, final Class studies, final Class accountVerification, String email, String password);

    /**
     * Registers the study participant for the app.
     * @param mContext the context from which the method is calling
     * @param accountVerification the account verification class
     * @param newUser the study participant object
     * @param email the email
     * @param password the password
     */
    void register(Context mContext, final Class accountVerification,  StudyParticipant newUser, String email, String password);

    /**
     * Signs out the study participant from the app.
     */
    void signOut();

    /**
     * Determines whether or not the study participant is signed into the app.
     * @return true if study participant is signed in, false if not
     */
    boolean isSignedIn();

    /**
     * Determines whether or not the study participant has verified his or her account.
     * @return true if study participant has verified his or her account, false if not
     */
    boolean isVerified();

    /**
     * Resets the password for the study participant.
     * @param email the email
     */
    void resetPassword(String email);

    /**
     * Sends verification link to the study participant's email
     */
    void sendVerificationLink();

    /**
     * Retrieves the user id of the study participant
     * @return user id
     */
    String getUserId();
}
