package com.shadowphoenix.fontys.testworkshop.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class User {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    private String streetAddress;
    private Number streetNumber;
    private String postalCode;
    private String city;
    private long phoneNumber;
    private List<String> interests;
    private List<User> matches;

    public User(
            @JsonProperty(value = "email") String email,
            @JsonProperty(value = "password") String password,
            @JsonProperty(value = "firstName") String firstName,
            @JsonProperty(value = "lastName") String lastName,
            @JsonProperty(value = "gender") String gender,
            @JsonProperty(value = "age") int age,
            @JsonProperty(value = "streetAddress") String streetAddress,
            @JsonProperty(value = "streetNumber") Number streetNumber,
            @JsonProperty(value = "postalCode") String postalCode,
            @JsonProperty(value = "city") String city,
            @JsonProperty(value = "phoneNumber") long phoneNumber,
            @JsonProperty(value = "interests") List<String> interests,
            @JsonProperty(value = "matches") List<User> matches) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = determineGender(gender);
        this.age = age;
        this.streetAddress = streetAddress;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.interests = interests;
        this.matches = matches;
    }

    private String determineGender(String gender) {
        if (gender.equals("male")) return "female";
        else if (gender.equals("female")) return "male";
        else return "other";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<String> getInterests() {
        return interests;
    }

    public List<User> getMatches() {
        return matches;
    }

    public void addInterest(String interest) { this.interests.add(interest); }

    public void addMatch(User match) {this.getMatches().add(match); }
}
