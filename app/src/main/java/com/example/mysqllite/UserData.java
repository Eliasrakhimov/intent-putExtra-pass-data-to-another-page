package com.example.mysqllite;


import androidx.annotation.NonNull;

public class UserData {
    private final String name;
    private final String lastname;
    private final String gender;
    private final String cityFrom;

    private UserData(String name, String lastname, String gender, String cityFrom) {
        this.name = name;
        this.lastname = lastname;
        this.gender = gender;
        this.cityFrom = cityFrom;
    }

    public static UserData getUserData(String name, String lastName, String gender, String city) {
        return new UserData(name, lastName, gender, city);
    }

    @NonNull
    public String toString() {
        return name + "\n" + lastname + "\n" + gender + "\n" + cityFrom;
    }
}
