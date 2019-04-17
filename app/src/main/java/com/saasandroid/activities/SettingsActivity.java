//
//  SettingsActivity.java
//  SaaSAndroid
//
//  Created by Tony Qi on 3/20/19.
//  Copyright © 2019 Tony Qi. All rights reserved.
//

package com.saasandroid.activities;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.saasandroid.activities.databinding.ActivitySettingsBinding;
import com.saasandroid.authentication.AuthenticationHandler;
import com.saasandroid.authentication.AuthenticationManager;
import com.saasandroid.authentication.AuthenticationResult;
import com.saasandroid.authentication.Scope;
import com.saasandroid.saasandroidlibrary.models.FitbitAuthentication;
import com.saasandroid.utilities.BottomNavigationViewHelper;

import java.util.Set;

import static com.saasandroid.saasandroidlibrary.models.FitbitAuthentication.generateAuthenticationConfiguration;

public class SettingsActivity extends Activity implements AuthenticationHandler {

    private ActivitySettingsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AuthenticationManager.configure(this, generateAuthenticationConfiguration(this, SettingsActivity.class));
        binding = DataBindingUtil.setContentView(this, R.layout.activity_settings);

        Button mConnectFitbit = findViewById(R.id.connectFitbitButton);
        Button mDisconnectFitbit = findViewById(R.id.disconnectFitbitButton);
        Button mLogout = findViewById(R.id.logoutButton);

        mConnectFitbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.setLoading(true);
                AuthenticationManager.login(SettingsActivity.this);
            }
        });

        mDisconnectFitbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AuthenticationManager.logout(SettingsActivity.this);
            }
        });

        mLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), WelcomeActivity.class));
            }
        });

        BottomNavigationView navigation = findViewById(R.id.navigation);
        BottomNavigationViewHelper.disableShiftMode(navigation);
        Menu menu = navigation.getMenu();
        MenuItem menuItem = menu.getItem(3);
        menuItem.setChecked(true);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigationStudies:
                        startActivity(new Intent(getApplicationContext(), StudiesActivity.class));
                        return true;
                    case R.id.navigationData:
                        startActivity(new Intent(getApplicationContext(), DataActivity.class));
                        return true;
                    case R.id.navigationProfile:
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        return true;
                    case R.id.navigationSettings:
                        return true;
                }
                return false;
            }
        });
    }

    private void onLoggedIn() {
        new AlertDialog.Builder(this)
                .setTitle("Fitbit Login Successful")
                .setMessage("You have successfully connected and synchronized your Fitbit device.")
                .create()
                .show();
        binding.setLoading(false);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (!AuthenticationManager.onActivityResult(requestCode, resultCode, data, this)) {
            // Handle other activity results, if needed
        }
    }

    @Override
    public void onAuthFinished(AuthenticationResult authenticationResult) {
        binding.setLoading(false);
        if (authenticationResult.isSuccessful()) {
            onLoggedIn();
        } else {
            displayAuthError(authenticationResult);
        }
    }

    private void displayAuthError(AuthenticationResult authenticationResult) {
        String message = "";

        switch (authenticationResult.getStatus()) {
            case dismissed:
                message = "Login dismissed or no scopes selected";
                break;
            case error:
                message = authenticationResult.getErrorMessage();
                break;
            case missing_required_scopes:
                Set<Scope> missingScopes = authenticationResult.getMissingScopes();
                String missingScopesText = TextUtils.join(", ", missingScopes);
                message = "Error logging in. Missing the following required scopes: " + missingScopesText;
                break;
        }

        new AlertDialog.Builder(this)
                .setTitle("Login")
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                })
                .create()
                .show();
    }
}
