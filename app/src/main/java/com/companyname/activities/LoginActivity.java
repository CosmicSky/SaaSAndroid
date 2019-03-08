//
//  LoginActivity.java
//  SaaSAndroid
//
//  Created by Tony Qi on 3/5/19.
//  Copyright © 2019 Tony Qi. All rights reserved.
//

package com.companyname.activities;

import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.companyname.models.CurrentState;

public class LoginActivity extends AppCompatActivity {
    private EditText mEmail;
    private EditText mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail = findViewById(R.id.emailLoginText);
        mPassword = findViewById(R.id.passwordLoginText);
        mEmail.setText(getIntent().getStringExtra("email"));
        Button mLogin = findViewById(R.id.loginAtLoginButton);

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CurrentState.getAuthentication().signIn(mEmail.getText().toString(), mPassword.getText().toString());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (CurrentState.getAuthentication().isSignedIn()) {
                    //todo retrieve studyparticipant info
                    startActivity(new Intent(getApplicationContext(), StudyActivity.class));
                } else {
                    AlertDialog.Builder alert = new AlertDialog.Builder(getApplicationContext());
                    alert.setTitle("Incorrect Credentials");
                    alert.setMessage("Incorrect Credentials Entered. Please try again.");
                    alert.show();
                }
            }
        });
    }
}
