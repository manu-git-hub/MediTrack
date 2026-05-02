package com.airtribe.meditrack.util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator {

	public static final String PREFIX_DOCTOR = "dr.";
	public static final String PREFIX_PAITENT = "pt.";
	public static final String PREFIX_APPOINTMENT = "ap.";

	private static final Map<String, AtomicInteger> atomicCounter = new HashMap<>();

	static {
		atomicCounter.put(PREFIX_DOCTOR, new AtomicInteger(1));
		atomicCounter.put(PREFIX_PAITENT, new AtomicInteger(1));
		atomicCounter.put(PREFIX_APPOINTMENT, new AtomicInteger(1));

	}

	private static String generate(String prefix) {
		AtomicInteger counter = atomicCounter.get(prefix);

		if (counter == null) {
			counter = new AtomicInteger(1);
			atomicCounter.put(prefix, counter);
		}

		int id = counter.getAndIncrement();
		return String.format("%s%06d", prefix, id);
	}

	public static String generateForDoctor() {
		return generate(PREFIX_DOCTOR);
	}

	public static String generateForPatient() {
		return generate(PREFIX_PAITENT);
	}

	public static String generateForAppointment() {
		return generate(PREFIX_APPOINTMENT);
	}

	public static String generateGeneric(String prefix) {
		return generate(prefix);
	}

	public static void initializeCounters(Map<String, Integer> initialValues) {
		for (Map.Entry<String, Integer> entry : initialValues.entrySet()) {
			atomicCounter.put(entry.getKey(), new AtomicInteger(entry.getValue() + 1));
		}
	}

	public static void initializeCounters(String key, int value) {
		atomicCounter.put(key, new AtomicInteger(value + 1));

	}
}