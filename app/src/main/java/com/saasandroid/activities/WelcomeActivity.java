//
//  WelcomeActivity.java
//  SaaSAndroid
//
//  Created by Tony Qi on 3/5/19.
//  Copyright © 2019 Tony Qi. All rights reserved.
//

package com.saasandroid.activities;

import com.saasandroid.models.CurrentState;

import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class WelcomeActivity extends AppCompatActivity {
    private EditText mEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        CurrentState.getAuthentication().signOut();
        CurrentState.getDatabase().resetStudyParticipant();

        mEmail = findViewById(R.id.emailText);
        Button mLogin = findViewById(R.id.loginButton);
        Button mRegister = findViewById(R.id.registerButton);

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEmail.getText().toString().isEmpty()) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(WelcomeActivity.this);
                    alert.setTitle("Email is Empty");
                    alert.setMessage("Email is empty. Please try again.");
                    alert.show();
                } else {
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    intent.putExtra("email", mEmail.getText().toString());
                    startActivity(intent);
                }
            }
        });

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
            }
        });
    }
}
