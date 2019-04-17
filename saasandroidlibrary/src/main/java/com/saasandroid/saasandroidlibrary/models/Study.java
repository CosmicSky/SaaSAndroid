//
//  Study.java
//  SaaSAndroid
//
//  Created by Tony Qi on 3/5/19.
//  Copyright © 2019 Tony Qi. All rights reserved.
//

package com.saasandroid.saasandroidlibrary.models;

public class Study {
    private String name;
    private String description;
    private Researcher owner;
    private String id;

    Study(String name, String description, Researcher owner, String id){
        this.name = name;
        this.description = description;
        this.owner = owner;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Researcher getOwner() {
        return owner;
    }

    public String getId() {
        return id;
    }

    public String toString() {
        return name;
    }
}
