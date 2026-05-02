package com.airtribe.meditrack.entity;

import com.airtribe.meditrack.enums.PersonType;

public class Person {

	private String name;
	private String address;
	private String phone;
	private String email;
	private PersonType type;
	private int age;

	public Person(String name, String address, String phone, String email, PersonType type, int age) {

		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.type = type;
		this.age = age;
	}

	public PersonType getType() {
		return type;
	}

	public void setType(PersonType type) {
		this.type = type;
	}

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

	public PersonType getPersonType() {
		return type;
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
