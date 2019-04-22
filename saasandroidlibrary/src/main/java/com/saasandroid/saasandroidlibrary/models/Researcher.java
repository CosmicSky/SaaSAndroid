//
//  Researcher.java
//  SaaSAndroid
//
//  Created by Tony Qi on 3/7/19.
//  Copyright © 2019 Tony Qi. All rights reserved.
//

package com.saasandroid.saasandroidlibrary.models;

public class Researcher {
    private String firstName;
    private String lastName;
    private String email;
    private String affiliation;
    private String jobTitle;

    public Researcher() {
        this.firstName = "default";
        this.lastName = "default";
        this.email = "default";
        this.affiliation = "default";
        this.jobTitle = "default";
    }

    Researcher(String firstName, String lastName, String email, String affiliation, String jobTitle){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.affiliation = affiliation;
        this.jobTitle = jobTitle;
    }

    /**
     * @return first name of researcher
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return last name of researcher
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return email of researcher
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return affiliation of researcher
     */
    public String getAffiliation() {
        return affiliation;
    }

    /**
     * @return job title of researcher
     */
    public String getJobTitle() {
        return jobTitle;
    }
}
