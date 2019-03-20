//
//  StudyParticipant.java
//  SaaSAndroid
//
//  Created by Tony Qi on 3/5/19.
//  Copyright © 2019 Tony Qi. All rights reserved.
//

package com.companyname.models;

public class StudyParticipant {
    private String firstName;
    private String lastName;
    private String birthDate;
    private String zipCode;
    private String country;
    private String email;

    public StudyParticipant() {
        this.firstName = "default";
        this.lastName = "default";
        this.birthDate = "default";
        this.zipCode = "default";
        this.country = "default";
        this.email = "default";
    }

    public StudyParticipant(String firstName, String lastName, String birthDate, String zipCode,
                     String country, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.zipCode = zipCode;
        this.country = country;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
