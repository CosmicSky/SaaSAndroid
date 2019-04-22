# SaaSAndroid
SaaS Android App

# Release Notes

## New Software Features

1. Viewing the data in the Data Tab pulls Fitbit data for weight, activity, nutrition, heart rate, and sleep, into Firebase.

2. Connect and Disconnect Fitbit with specific permission requests have been added.

3. 'Welcome [name]' message exists on the Studies screen, in place of the former 'My Studies' label.

## Bug Fixes

1. Joining and viewing studies has been fixed.

2. Viewing data while not connected no longer crashes the app. Instead shows blank page.

## Known Bugs

1. Possible that some specific Fitbit data are not displayed/pulled correctly. Every single tab needs to be tested. Refer to activity, heartrate, sleep, nutrition, and weight API on the Fitbit Developement website for reference.

2. Welcome [name] message on Studies screen does not display after initial login due to screen loading faster than Firebase Authentication processing realtime data. Firebase Authentication needs time to load all of the data.

3. Older emulator/devices may have trouble loading Fitbit data.

## Known Defects

N/A

# Install Guide

## Pre-requisites

Hardware: Any compatible with Android Studio
Software: Android Studio (https://developer.android.com/studio)

## Dependent Libraries

Check under the build.gradle of the app and custom libraries for the list of libraries used. This should be under dependencies with the implementation tag.

## Download Instructions

Refer to an Android Studio setup for specific instructions.

1. Pull the github code into any directory: https://github.com/CosmicSky/SaaSAndroid

2. Open Android Studio and open the directory of the project

3. FIRST TIME SETUP: Make sure minSdkVersion and targetSdkVersion are correct under the build.gradle of the app. Installing library dependencies may occur. Open the SDK Manager under tools and install API levels that fall between the minimum and target SDK version. Under SDK Tools, make sure to install Android Emulator, Android SDK Platform-Tools, Android SDK Tools, Google Play services, and Intel Emulator Accelerator.

4. To create an emulator, open the AVD Manager under tools and create an android device. Make sure the SDK Version is between the minimum and target version.

5. To run the application, make sure that app is selected as the target deployment next to the build button (the hammer) and then click on the run button (the play icon). Select either an emulator or a device.

## References

Fitbit connection and data display: https://github.com/Stasonis/fitbit-api-example-android

Firebase database: https://firebase.google.com/docs/database/android/start

Firebase authentication: https://firebase.google.com/docs/auth/android/start
