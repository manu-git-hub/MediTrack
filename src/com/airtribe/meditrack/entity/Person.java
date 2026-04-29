package com.airtribe.meditrack.entity;

public class Person {

    private String name;
    private String address;
    private String phone;
    private String email;
    private String personType;

    public Person(String name, String address, String phone, String email, String personType) {
        
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.personType = personType;
    }

    //Getters
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPersonType() {
        return personType;
    }
}
