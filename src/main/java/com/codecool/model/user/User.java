package com.codecool.model.user;

import java.time.LocalDate;

public abstract class User {
    private final String name;
    private final String email;
    private LocalDate startInSchool;
    private final Location location;

    public User(String name, String email, Location location) {
        this.name = name;
        this.email = email;
        this.startInSchool = null;
        this.location = location;
    }

    public String getStartInSchoolAsString() {
        return startInSchool.toString();
    }
    public LocalDate getStartInSchool() {
        return startInSchool;
    }
    public void setStartInSchool() {
        this.startInSchool = LocalDate.now();
    }
    public String getName() {
        return name;
    }

}
