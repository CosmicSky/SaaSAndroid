//
//  RegisterActivity.java
//  SaaSAndroid
//
//  Created by Tony Qi on 3/5/19.
//  Copyright © 2019 Tony Qi. All rights reserved.
//

package com.saasandroid.activities;

import com.saasandroid.saasandroidlibrary.models.CurrentState;
import com.saasandroid.saasandroidlibrary.models.StudyParticipant;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends Activity {
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
                } else if (DoesNotMatchEmailFormat(mEmail.getText().toString())) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(RegisterActivity.this);
                    alert.setTitle("Invalid Email Format");
                    alert.setMessage("The email you have entered is not in the correct format. Please try again.");
                    alert.show();
                } else if (DateOfBirthIncorrectFormat()) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(RegisterActivity.this);
                    alert.setTitle("Date Of Birth Incorrect Format");
                    alert.setMessage("The date of birth that you have entered is not in the" +
                            " correct format. Please use mm/dd/yyyy.");
                    alert.show();
                } else if (AgeCheck(19)) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(RegisterActivity.this);
                    alert.setTitle("Age Requirement Failed");
                    alert.setMessage("You must be 19 or older to participate in study programs.");
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
                    String firstName = mFirstName.getText().toString().substring(0, 1).toUpperCase()
                            + mFirstName.getText().toString().substring(1);
                    String lastName = mLastName.getText().toString().substring(0, 1).toUpperCase()
                            + mLastName.getText().toString().substring(1);
                    StudyParticipant newUser = new StudyParticipant(firstName, lastName,
                            mDateOfBirth.getText().toString(), mZipCode.getText().toString(),
                            mCountry.getText().toString(), mEmail.getText().toString());
                    CurrentState.getAuthentication().register(RegisterActivity.this, AccountVerificationActivity.class,
                            newUser, mEmail.getText().toString(), mPassword.getText().toString());
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

    public static boolean DoesNotMatchEmailFormat(String email) {
        String regex = "^[\\w-+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        Matcher matcher = pattern.matcher(email);
        return !matcher.matches();
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

    private boolean AgeCheck(int ageRequirement) {
        String[] monthDateYear = mDateOfBirth.getText().toString().split("/");

        Calendar today = Calendar.getInstance();
        today.setTimeInMillis(System.currentTimeMillis());

        //create calendar object for birth day
        Calendar dob = Calendar.getInstance();
        dob.setTime(new Date(Integer.parseInt(monthDateYear[2]) - 1900, Integer.parseInt(monthDateYear[0]), Integer.parseInt(monthDateYear[1])));

        int curYear = today.get(Calendar.YEAR);
        int dobYear = dob.get(Calendar.YEAR);

        int age = curYear - dobYear;

        int curMonth = today.get(Calendar.MONTH);
        int dobMonth = dob.get(Calendar.MONTH);
        if (dobMonth > curMonth) {
            age--;
        } else if (dobMonth == curMonth) {
            int curDay = today.get(Calendar.DAY_OF_MONTH);
            int dobDay = dob.get(Calendar.DAY_OF_MONTH);
            if (dobDay > curDay) {
                age--;
            }
        }

        return age <= ageRequirement;
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
