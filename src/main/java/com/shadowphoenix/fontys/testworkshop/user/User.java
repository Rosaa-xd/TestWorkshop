package com.shadowphoenix.fontys.testworkshop.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class User {
    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    private String streetAddress;
    private Number streetNumber;
    private String postalCode;
    private String city;
    private List<Interest> interests;
    // private List<User> matches;

    public User(
            @JsonProperty(value = "firstName") String firstName,
            @JsonProperty(value = "lastName") String lastName,
            @JsonProperty(value = "gender") String gender,
            @JsonProperty(value = "age") int age,
            @JsonProperty(value = "streetAddress") String streetAddress,
            @JsonProperty(value = "streetNumber") Number streetNumber,
            @JsonProperty(value = "postalCode") String postalCode,
            @JsonProperty(value = "city") String city,
            @JsonProperty(value = "interests") List<Interest> interests) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = determineGender(gender);
        this.age = age;
        this.streetAddress = streetAddress;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
        this.city = city;
        this.interests = interests;
    }

    private String determineGender(String gender) {
        if (gender.equals("male")) return "female";
        else if (gender.equals("female")) return "male";
        else return "other";
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public Number getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Number streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Interest> getInterests() {
        return interests;
    }

    public void setInterests(List<Interest> interests) {
        this.interests = interests;
    }
}
