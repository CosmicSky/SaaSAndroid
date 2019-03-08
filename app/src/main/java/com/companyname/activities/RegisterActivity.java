//
//  RegisterActivity.java
//  SaaSAndroid
//
//  Created by Tony Qi on 3/5/19.
//  Copyright © 2019 Tony Qi. All rights reserved.
//

package com.companyname.activities;

import com.companyname.models.CurrentState;
import com.companyname.models.StudyParticipant;

import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity{
    private EditText mFirstName;
    private EditText mLastName;
    private EditText mDateOfBirth;
    private EditText mZipCode;
    private EditText mCountry;
    private EditText mEmail;
    private EditText mPassword;
    private EditText mReEnterPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button mRegister = findViewById(R.id.registeringButton);

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFirstName = findViewById(R.id.firstNameRegisterText);
                mLastName = findViewById(R.id.lastNameRegisterText);
                mDateOfBirth = findViewById(R.id.dateOfBirthRegisterText);
                mZipCode = findViewById(R.id.zipCodeRegisterText);
                mCountry = findViewById(R.id.countryRegisterText);
                mEmail = findViewById(R.id.emailRegisterText);
                mPassword = findViewById(R.id.passwordRegisterText);
                mReEnterPassword = findViewById(R.id.reEnterPasswordRegisterText);

                if (HasMissingFields()) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(RegisterActivity.this);
                    alert.setTitle("Missing One Or More Fields");
                    alert.setMessage("You are missing some fields. Please enter all of the" +
                            " information and try again.");
                    alert.show();
                } else if (!EmailContainsAtSign()) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(getApplicationContext());
                    alert.setTitle("Email Does Not Contain @");
                    alert.setMessage("The email you have entered does not contain an @ sign. Please try again.");
                    alert.show();
                } else if (DateOfBirthIncorrectFormat()) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(RegisterActivity.this);
                    alert.setTitle("Date Of Birth Incorrect Format");
                    alert.setMessage("The date of birth that you have entered is not in the" +
                            " correct format. Please use mm/dd/yyyy.");
                    alert.show();
                } else if (!PasswordsMatch()) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(RegisterActivity.this);
                    alert.setTitle("Passwords Do Not Match");
                    alert.setMessage("The passwords that you have entered do not match.");
                    alert.show();
                } else if (WeakPassword()) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(RegisterActivity.this);
                    alert.setTitle("Passwords Too Short");
                    alert.setMessage("The passwords that you have entered must be at least 6" +
                            " characters");
                    alert.show();
                } else {
                    CurrentState.getAuthentication().createStudyParticipant(mEmail.getText().toString(), mPassword.getText().toString());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (CurrentState.getAuthentication().isSignedIn()) {
                        CurrentState.getAuthentication().sendVerificationLink();

                        String firstName = mFirstName.getText().toString().substring(0, 1).toUpperCase()
                                + mFirstName.getText().toString().substring(1);
                        String lastName = mLastName.getText().toString().substring(0, 1).toUpperCase()
                                + mLastName.getText().toString().substring(1);
                        StudyParticipant newUser = new StudyParticipant(firstName, lastName,
                                mDateOfBirth.getText().toString(), mZipCode.getText().toString(),
                                mCountry.getText().toString(), mEmail.getText().toString(),
                                mPassword.getText().toString());
                        String userId = CurrentState.getAuthentication().getUserId();
                        CurrentState.getDatabase().addStudyParticipant(newUser, userId);

                        CurrentState.getAuthentication().signOut();
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    } else {
                        AlertDialog.Builder alert = new AlertDialog.Builder(RegisterActivity.this);
                        alert.setTitle("Email Is Registered");
                        alert.setMessage("The email you have entered is already registered." +
                                " Please check to see if you have already created an account.");
                        alert.show();
                    }
                }
            }
        });
    }

    private boolean HasMissingFields()
    {
        return mFirstName.getText().toString().isEmpty() || mLastName.getText().toString().isEmpty() ||
                mDateOfBirth.getText().toString().isEmpty() || mZipCode.getText().toString().isEmpty() ||
                mCountry.getText().toString().isEmpty() || mEmail.getText().toString().isEmpty() ||
                mPassword.getText().toString().isEmpty() || mReEnterPassword.getText().toString().isEmpty();
    }

    private boolean EmailContainsAtSign() {
        return mEmail.getText().toString().contains("@");
    }

    private boolean DateOfBirthIncorrectFormat() {
        if (!mDateOfBirth.getText().toString().contains("/"))
        {
            return true;
        } else
        {
            String[] monthDateYear = mDateOfBirth.getText().toString().split("/");
            return monthDateYear.length != 3 || monthDateYear[0].length() != 2
                    || monthDateYear[1].length() != 2 || monthDateYear[2].length() != 4;
        }
    }

    private boolean PasswordsMatch()
    {
        return mPassword.getText().toString().equals(mReEnterPassword.getText().toString());
    }

    private boolean WeakPassword()
    {
        return mPassword.getText().toString().length() < 6;
    }
}
