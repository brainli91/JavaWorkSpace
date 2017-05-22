package com.fdmgroup.tradingplatform.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SQLProperties {
	private static Properties properties = null;

	public static Properties getProperties(String filename) {

		FileInputStream sqlProperties = null;

		try {
			properties = new Properties();
			sqlProperties = new FileInputStream(filename);
			properties.load(sqlProperties);
			sqlProperties.close();
		} catch (IOException ioe) {

		}

		return properties;
	}
}
