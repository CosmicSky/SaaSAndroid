//
//  AccountVerificationActivity.java
//  SaaSAndroid
//
//  Created by Tony Qi on 3/19/19.
//  Copyright © 2019 Tony Qi. All rights reserved.
//

package com.saasandroid.activities;

import com.saasandroid.saasandroidlibrary.models.CurrentState;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AccountVerificationActivity extends Activity {
    private TextView mVerifyText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountverification);

        Button mVerify = findViewById(R.id.verificationLinkButton);
        Button mLogout = findViewById(R.id.logoutAtVerificationButton);
        mVerifyText = findViewById(R.id.verificationText);

        mVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CurrentState.getAuthentication().sendVerificationLink();
                mVerifyText.setText("Verification Sent.");
            }
        });

        mLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), WelcomeActivity.class));
            }
        });
    }
}
