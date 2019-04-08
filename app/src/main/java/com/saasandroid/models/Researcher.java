//
//  Researcher.java
//  SaaSAndroid
//
//  Created by Tony Qi on 3/7/19.
//  Copyright © 2019 Tony Qi. All rights reserved.
//

package com.saasandroid.models;

public class Researcher {
    private String firstName;
    private String lastName;
    private String email;
    private String affiliation;
    private String jobTitle;

    Researcher(String firstName, String lastName, String email, String affiliation, String jobTitle){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.affiliation = affiliation;
        this.jobTitle = jobTitle;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public String getJobTitle() {
        return jobTitle;
    }
}
