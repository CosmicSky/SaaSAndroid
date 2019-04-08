//
//  PasswordResetActivity.java
//  SaaSAndroid
//
//  Created by Tony Qi on 3/19/19.
//  Copyright © 2019 Tony Qi. All rights reserved.
//

package com.saasandroid.activities;

import com.saasandroid.models.CurrentState;

import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PasswordResetActivity extends AppCompatActivity {
    private EditText mEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passwordreset);

        Button mReset = findViewById(R.id.resetPasswordButton);
        mEmail = findViewById(R.id.resetPasswordEmailText);
        mEmail.setText(getIntent().getStringExtra("email"));

        mReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CurrentState.getAuthentication().resetPassword(mEmail.getText().toString());
                startActivity(new Intent(getApplicationContext(), WelcomeActivity.class));
            }
        });
    }
}
