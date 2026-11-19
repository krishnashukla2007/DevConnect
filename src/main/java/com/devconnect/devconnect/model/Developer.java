package com.devconnect.devconnect.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Developer {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String bio;
    private String city;
    private String linkedInURL;
    private String gitHubURL;
    private List<String> skills;
    private String organization;
    private Double yearsOfExperience;
    private final LocalDateTime createdAt;

    public Developer() {
        this.skills = new ArrayList<>();
        this.createdAt = LocalDateTime.now();
    }
    
    public Developer(long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        skills = new ArrayList<>();
        createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBio() {
        return bio;
    }
    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getLinkedInURL() {
        return linkedInURL;
    }
    public void setLinkedInURL(String linkedInURL) {
        this.linkedInURL = linkedInURL;
    }

    public String getGitHubURL() {
        return gitHubURL;
    }
    public void setGitHubURL(String gitHubURL) {
        this.gitHubURL = gitHubURL;
    }

    public List<String> getSkills() {
        return skills;
    }
    public void setSkills(List<String> skills) {
        if(skills == null) {
            skills = new ArrayList<>();
        }

        this.skills.addAll(skills);
    }

    public String getOrganization() {
        return organization;
    }
    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public Double getYearsOfExperience() {
        return yearsOfExperience;
    }
    public void setYearsOfExperience(Double yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
}
