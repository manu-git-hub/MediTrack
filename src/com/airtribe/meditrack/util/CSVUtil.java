package com.airtribe.meditrack.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVUtil {

	public static void write(String filePath, List<String> lines) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
			for (String line : lines) {
				writer.write(line);
				writer.newLine();
			}
		} catch (IOException e) {
			throw new RuntimeException("Error writing CSV: " + filePath, e);
		}
	}

	public static List<String[]> read(String filePath) {
		List<String[]> data = new ArrayList<>();

		File file = new File(filePath);
		if (!file.exists())
			return data;

		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = reader.readLine()) != null) {
				data.add(line.split(",")); // as required
			}
		} catch (IOException e) {
			throw new RuntimeException("Error reading CSV: " + filePath, e);
		}

		return data;
	}

}