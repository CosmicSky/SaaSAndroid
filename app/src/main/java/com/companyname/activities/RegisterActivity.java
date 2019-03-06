//
//  RegisterActivity.java
//  SaaSAndroid
//
//  Created by Tony Qi on 3/5/19.
//  Copyright © 2019 Tony Qi. All rights reserved.
//

package com.companyname.activities;

import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.support.annotation.NonNull;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class RegisterActivity extends AppCompatActivity{
    private EditText mFirstName;
    private EditText mLastName;
    private EditText mDateOfBirth;
    private Date mDateOfBirthDate;
    private EditText mZipCode;
    private EditText mCountry;
    private EditText mEmail;
    private EditText mPassword;
    private EditText mReEnterPassword;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        Button mRegister = findViewById(R.id.registeringButton);

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFirstName = findViewById(R.id.firstNameRegisterText);
                String firstName = mFirstName.getText().toString().substring(0, 1) + mFirstName.getText().toString().substring(1);
                mLastName = findViewById(R.id.lastNameRegisterText);
                String lastName = mLastName.getText().toString().substring(0, 1) + mLastName.getText().toString().substring(1);
                mDateOfBirth = findViewById(R.id.dateOfBirthRegisterText);
                mZipCode = findViewById(R.id.zipCodeRegisterText);
                mCountry = findViewById(R.id.countryRegisterText);
                mEmail = findViewById(R.id.emailRegisterText);
                mPassword = findViewById(R.id.passwordRegisterText);
                mReEnterPassword = findViewById(R.id.reEnterPasswordRegisterText);

                if (HasMissingFields())
                {
                    AlertDialog.Builder alert = new AlertDialog.Builder(getApplicationContext());
                    alert.setTitle("Missing One Or More Fields");
                    alert.setMessage("You are missing some fields. Please enter all of the information and try again.");
                    alert.show();
                }
                else if (!EmailContainsAtSign())
                {
                    AlertDialog.Builder alert = new AlertDialog.Builder(getApplicationContext());
                    alert.setTitle("Email Does Not Contain @");
                    alert.setMessage("The email you have entered does not contain an @ sign. Please try again.");
                    alert.show();
//                }
//                else if (IsEmailRegistered())
//                {
//                    AlertDialog.Builder alert = new AlertDialog.Builder(getApplicationContext());
//                    alert.SetTitle("Email In Use");
//                    alert.SetMessage("The email you have entered is already registered. Please try again with a different email.");
//                    alert.Show();
                } else if (DateOfBirthIncorrectFormat())
                {
                    AlertDialog.Builder alert = new AlertDialog.Builder(getApplicationContext());
                    alert.setTitle("Date Of Birth Incorrect Format");
                    alert.setMessage("The date of birth that you have entered is not in the correct format. Please use mm/dd/yyyy.");
                    alert.show();
                }
                else if (!PasswordsMatch())
                {
                    AlertDialog.Builder alert = new AlertDialog.Builder(getApplicationContext());
                    alert.setTitle("Passwords Do Not Match");
                    alert.setMessage("The passwords that you have entered do not match. Please try again.");
                    alert.show();
                }
                else
                {
//                    StudyParticipant newUser = new StudyParticipant(FirstName, LastName, DateOfBirth, ZipCode, Country, Email, Password);
//                    MockStudyParticipantTable.AddParticipant(newUser);
                    mAuth.createUserWithEmailAndPassword(mEmail.getText().toString(), mPassword.getText().toString())
                            .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                    } else {
                                        Toast.makeText(getApplicationContext(),
                                                "Authentication failed.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
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

    private boolean DateOfBirthIncorrectFormat() {
        SimpleDateFormat objSDF = new SimpleDateFormat("mm/dd/yyyy");
        if (!mDateOfBirth.getText().toString().contains("/"))
        {
            return true;
        } else
        {
            String[] monthDateYear = mDateOfBirth.getText().toString().split("/");
            if (monthDateYear.length != 3 || monthDateYear[0].length() != 2
                    || monthDateYear[1].length() != 2 || monthDateYear[2].length() != 4)
            {
                return true;
            } else
            {
                try {
                    mDateOfBirthDate = objSDF.parse(mDateOfBirth.getText().toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return false;
            }
        }
    }

    private boolean EmailContainsAtSign()
    {
        return mEmail.getText().toString().contains("@");
    }

//    private boolean IsEmailRegistered()
//    {
//        foreach (StudyParticipant sp in MockStudyParticipantTable.getTable())
//        {
//            if (Email.Equals(sp.Email))
//            {
//                return true;
//            }
//        }
//        return false;
//    }

    private boolean PasswordsMatch()
    {
        return mPassword.getText().toString().equals(mReEnterPassword.getText().toString());
    }
}
