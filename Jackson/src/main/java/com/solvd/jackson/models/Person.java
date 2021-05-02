package com.solvd.jackson.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person extends AbstractEntity{
    @JsonProperty
    private String fname;
    @JsonProperty
    private String lname;
    @JsonProperty
    private int age;
    @JsonProperty
    private String gender;

    public Person() {
    }

    public Person(int id, String fname, String lname, int age, String gender) {
        super(id);
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.gender = gender;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + getId() +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
