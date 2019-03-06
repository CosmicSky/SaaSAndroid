//
//  Study.java
//  SaaSAndroid
//
//  Created by Tony Qi on 3/5/19.
//  Copyright © 2019 Tony Qi. All rights reserved.
//

package com.companyname.models;

public class Study {
    private String name;
    private String description;
    private String owner;
    private String ownerEmail;
    private String affiliation;
    private String jobTitle;

    Study(String name, String description, String owner, String ownerEmail, String affiliation,
          String jobTitle){
        this.name = name;
        this.description = description;
        this.owner = owner;
        this.ownerEmail = ownerEmail;
        this.affiliation = affiliation;
        this.jobTitle = jobTitle;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getOwner() {
        return owner;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public String getJobTitle() {
        return jobTitle;
    }
}
