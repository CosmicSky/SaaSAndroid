//
//  StudyParticipant.java
//  SaaSAndroid
//
//  Created by Tony Qi on 3/5/19.
//  Copyright © 2019 Tony Qi. All rights reserved.
//

package com.saasandroid.saasandroidlibrary.models;

public class StudyParticipant {
    private String firstName;
    private String lastName;
    private String birthdate;
    private String zipCode;
    private String country;
    private String email;

    public StudyParticipant() {
        this.firstName = "default";
        this.lastName = "default";
        this.birthdate = "default";
        this.zipCode = "default";
        this.country = "default";
        this.email = "default";
    }

    public StudyParticipant(String firstName, String lastName, String birthDate, String zipCode,
                     String country, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthDate;
        this.zipCode = zipCode;
        this.country = country;
        this.email = email;
    }

    /**
     * @return first name of study participant
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return last name of study participant
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return birth date of study participant
     */
    public String getBirthdate() {
        return birthdate;
    }

    /**
     * @return zip code of study participant
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * @return country of study participant
     */
    public String getCountry() {
        return country;
    }

    /**
     * @return email of study participant
     */
    public String getEmail() {
        return email;
    }
}
