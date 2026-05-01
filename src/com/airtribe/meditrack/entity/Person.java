package com.airtribe.meditrack.entity;

public class Person extends MedicalEntity{

    private String name;
    private String address;
    private String phone;
    private String email;
    private String personType;
    private int age;

    public Person(int id,String name, String address, String phone, String email, String personType, int age) {
        super(id);
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.personType = personType;
        this.age = age;
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

    public int getAge()
    {
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

    @Override
    public void displayDetails() {
        System.out.println("[" + personType + "] ID: " + getMedicalEntityId() + " | Name: " + name + " | Age: " + age);
    }

    @Override
    public boolean matchesSearchTerm(String keyword) {
        return this.name.toLowerCase().contains(keyword.toLowerCase());
    }
}
