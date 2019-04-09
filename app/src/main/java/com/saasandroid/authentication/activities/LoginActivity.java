//
//  LoginActivity.java
//  SaaSAndroid
//
//  Created by Tony Qi on 3/5/19.
//  Copyright © 2019 Tony Qi. All rights reserved.
//

package com.saasandroid.authentication.activities;

import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.saasandroid.models.CurrentState;

public class LoginActivity extends AppCompatActivity {
    private TextView mEmail;
    private EditText mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail = findViewById(R.id.emailLoginText);
        mPassword = findViewById(R.id.passwordLoginText);
        mEmail.setText(getIntent().getStringExtra("email"));
        Button mLogin = findViewById(R.id.loginAtLoginButton);
        Button mForgotPassword = findViewById(R.id.forgotPasswordButton);

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPassword.getText().toString().isEmpty()) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(LoginActivity.this);
                    alert.setTitle("Password is Empty");
                    alert.setMessage("Password is empty. Please try again.");
                    alert.show();
                } else {
                    CurrentState.getAuthentication().signIn(mEmail.getText().toString(), mPassword.getText().toString());
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (CurrentState.getAuthentication().isSignedIn()) {
                        CurrentState.getDatabase().retrieveStudyParticipant(CurrentState.getAuthentication().getUserId());
                        if (CurrentState.getAuthentication().isVerified()) {
                            CurrentState.getDatabase().retrieveIndividualStudyList();
                            CurrentState.getDatabase().retrieveGlobalStudyList();
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            startActivity(new Intent(getApplicationContext(), StudiesActivity.class));
                        } else {
                            startActivity(new Intent(getApplicationContext(), AccountVerificationActivity.class));
                        }
                    } else {
                        AlertDialog.Builder alert = new AlertDialog.Builder(LoginActivity.this);
                        alert.setTitle("Incorrect Credentials");
                        alert.setMessage("Incorrect Credentials Entered. Please try again.");
                        alert.show();
                    }
                }
            }
        });

        mForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PasswordResetActivity.class);
                intent.putExtra("email", mEmail.getText().toString());
                startActivity(intent);
            }
        });
    }
}
