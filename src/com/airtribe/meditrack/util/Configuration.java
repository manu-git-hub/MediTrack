package com.airtribe.meditrack.util;

import java.io.InputStream;
import java.util.Properties;

public class Configuration {
	public String getProperty(String key) {
		try {
			Properties props = new Properties();

			try (InputStream is = getClass().getClassLoader().getResourceAsStream("config.properties")) {

				if (is == null)
					throw new RuntimeException("File not found");
				props.load(is);
			}

			return props.getProperty(key);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public int getPropertyAsInt(String key) {
		return Integer.valueOf(getProperty(key));
	}
}
