package edu.xidian.boot.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import edu.xidian.boot.Enum.Marital;

public class Person implements Serializable {
    private static final long serialVersionUID = -8581120389973521772L;
    private Integer id;
    private String name;
    private Integer age;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birth;
    private String address;
    /**
     * gender true:男 -> 1 false:女 -> 2
     */
    private Boolean gender;
    private Marital marital;

    public Person() {
        super();
    }

    public Person(Integer id, String name, Integer age, Date birth, String address, Boolean gender, Marital marital) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.birth = birth;
        this.address = address;
        this.gender = gender;
        this.marital = marital;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Marital getMarital() {
        return marital;
    }

    public void setMarital(Marital marital) {
        this.marital = marital;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", age=" + age + ", birth=" + birth + ", address=" + address
                + ", gender=" + gender + ", marital=" + marital + "]";
    }

}
