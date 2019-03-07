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
    private Researcher owner;
    Study(String name, String description, Researcher owner){
        this.name = name;
        this.description = description;
        this.owner = owner;
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
}
