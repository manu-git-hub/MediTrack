package com.airtribe.meditrack.test;

import com.airtribe.meditrack.util.IdGenerator;

public class TestRunner {

	public static void main(String[] args) {

		TestRunner.testIdGenerator();
	}

	private static boolean testIdGenerator() {
		System.out.println("testIdGenerator : generateForDoctor : " + IdGenerator.generateForDoctor());
		System.out.println("testIdGenerator : generateForpatient : " + IdGenerator.generateForPatient());
		System.out.println("testIdGenerator : generateForAppointment : " + IdGenerator.generateForAppointment());
		System.out.println("testIdGenerator : generateGeneric : " + IdGenerator.generateGeneric("test."));
		System.out.println("testIdGenerator : status : success");
		return true;

	}

}
