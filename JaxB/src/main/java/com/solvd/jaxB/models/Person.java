package com.solvd.jaxB.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Person extends AbstractEntity{
    @XmlElement(name = "fname")
    private String fname;
    @XmlElement(name = "lname")
    private String lname;
    @XmlElement(name = "age")
    private int age;
    @XmlElement(name = "gender")
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
