/**********************************************************************
Config Reader class is used to read values from Config.Properties 
file and assign those read values to constants variables.
Values are stored in Constants variables as ThreadLocal values 
to make use of it globally and thread safe during parallel test execution.
*************************************************************************/
package com.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.constants.EnvironmentConstants;

public class ConfigReader {
	private Properties properties = new Properties();
	private EnvironmentConstants constants = new EnvironmentConstants();

	// Load configuration data from properties file
	public void load() {
		try (FileInputStream inputStream = new FileInputStream(constants.PROPERTIES_FILE_PATH)) {
			properties.load(inputStream);

			// Set environment constants by calling helper method
			loadConfigProperty("browser", (value) -> constants.setBrowserType(ThreadLocal.withInitial(() -> value)));
			loadConfigProperty("appurl", (value) -> constants.setAppUrl(ThreadLocal.withInitial(() -> value)));
			loadConfigProperty("username", (value) -> constants.setUsername(ThreadLocal.withInitial(() -> value)));
			loadConfigProperty("password", (value) -> constants.setPassword(ThreadLocal.withInitial(() -> value)));
			loadConfigProperty("role", (value) -> constants.setRole(ThreadLocal.withInitial(() -> value)));
			loadConfigProperty("os", (value) -> constants.setOsType(ThreadLocal.withInitial(() -> value)));

		} catch (IOException exception) {
			exception.printStackTrace();
			throw new RuntimeException("Failed to load configuration file", exception);
		}
	}

	// Helper method to load and set property values to constants
	private void loadConfigProperty(String key, PropertySetter setter) {
		String value = properties.getProperty(key);
		if (value != null) {
			setter.set(value);
		} else {
			throw new RuntimeException(key + " Not Specified in Config.Properties file");
		}
	}

	// Functional interface to set the property in constants
	@FunctionalInterface
	private interface PropertySetter {
		void set(String value);
	}
}
