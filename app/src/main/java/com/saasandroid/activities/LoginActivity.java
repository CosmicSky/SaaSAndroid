//
//  LoginActivity.java
//  SaaSAndroid
//
//  Created by Tony Qi on 3/5/19.
//  Copyright © 2019 Tony Qi. All rights reserved.
//

package com.saasandroid.activities;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.saasandroid.saasandroidlibrary.models.CurrentState;

public class LoginActivity extends Activity {
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
                    CurrentState.getAuthentication().signIn(LoginActivity.this, StudiesActivity.class,
                            AccountVerificationActivity.class, mEmail.getText().toString(), mPassword.getText().toString());
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
