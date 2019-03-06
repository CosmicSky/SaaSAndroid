//
//  FirebaseAuthentication.java
//  SaaSAndroid
//
//  Created by Tony Qi on 3/5/19.
//  Copyright © 2019 Tony Qi. All rights reserved.
//

package com.companyname.models;

import com.google.firebase.auth.FirebaseAuth;

public class FirebaseAuthentication implements Authentication {
    private FirebaseAuth mAuth;

    FirebaseAuthentication() {
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void signIn(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password);
    }

    @Override
    public void signOut() {
        mAuth.signOut();
    }

    @Override
    public void createStudyParticipant(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password);
    }

    @Override
    public boolean isSignedIn() {
        return mAuth.getCurrentUser() != null;
    }

    @Override
    public boolean isVerified() {
        return mAuth.getCurrentUser() != null &&
                mAuth.getCurrentUser().isEmailVerified();
    }

    @Override
    public void resetPassword(String email) {
        mAuth.sendPasswordResetEmail(email);
    }

    @Override
    public boolean sendVerificationLink() {
        if (mAuth.getCurrentUser() != null) {
            mAuth.getCurrentUser().sendEmailVerification();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getUserId() {
        if (mAuth.getCurrentUser() != null) {
            return mAuth.getCurrentUser().getUid();
        } else {
            return null;
        }
    }
}
