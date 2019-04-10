//
//  FirebaseAuthentication.java
//  SaaSAndroid
//
//  Created by Tony Qi on 3/5/19.
//  Copyright © 2019 Tony Qi. All rights reserved.
//

package com.saasandroid.models;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.saasandroid.activities.AccountVerificationActivity;
import com.saasandroid.activities.RegisterActivity;
import com.saasandroid.activities.StudiesActivity;

public class FirebaseAuthentication implements Authentication {
    private FirebaseAuth mAuth;

    FirebaseAuthentication() {
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void signIn(final Context mContext, String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    CurrentState.getDatabase().retrieveStudyParticipant(CurrentState.getAuthentication().getUserId());
                    if (CurrentState.getAuthentication().isVerified()) {
                        CurrentState.getDatabase().retrieveIndividualStudyList();
                        CurrentState.getDatabase().retrieveGlobalStudyList();
                        mContext.startActivity(new Intent(mContext, StudiesActivity.class));
                    } else {
                        mContext.startActivity(new Intent(mContext, AccountVerificationActivity.class));
                    }
                } else {
                    AlertDialog.Builder alert = new AlertDialog.Builder(mContext);
                    alert.setTitle("Incorrect Credentials");
                    alert.setMessage("Incorrect Credentials Entered. Please try again.");
                    alert.show();
                }
            }
        });
    }

    @Override
    public void register(final Context mContext, final StudyParticipant newUser, String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    CurrentState.getAuthentication().sendVerificationLink();
                    String userId = CurrentState.getAuthentication().getUserId();
                    CurrentState.getDatabase().addStudyParticipant(newUser, userId);
                    CurrentState.setStudyParticipant(newUser);
                    mContext.startActivity(new Intent(mContext, AccountVerificationActivity.class));
                } else {
                    AlertDialog.Builder alert = new AlertDialog.Builder(mContext);
                    alert.setTitle("Email Is In Use");
                    alert.setMessage("The email you have entered is already registered." +
                            " Please check to see if you have already created an account.");
                    alert.show();
                }
            }
        });
    }

    @Override
    public void signOut() {
        mAuth.signOut();
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
