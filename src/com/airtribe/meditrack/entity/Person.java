package com.airtribe.meditrack.entity;

public class Person {

    private String name;
    private String password;
    private String address;
    private String phone;
    private String email;
    private String personType;
    private int age;

    public Person(String name, String password, String address, String phone, String email, String personType,
            int age) {

        this.name = name;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.personType = personType;
        this.age = age;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
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

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
