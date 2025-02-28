package com.driverManager;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
	private static WebDriver driver;

	public static WebDriver initialiseBrowser(String browserName) {
		if (driver == null) {
			switch (browserName.toLowerCase()) {
			case "chrome":

				driver = new ChromeDriver();
				break;
			case "firefox":

				driver = new FirefoxDriver();
				break;
			case "edge":

				driver = new EdgeDriver();
				break;
			case "safari":

				driver = new SafariDriver();
				break;
			default:
				throw new IllegalArgumentException("Browser not supported: " + browserName);
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		return driver;
	}

	// Get the WebDriver instance
	public static WebDriver getDriver() {

		if (driver == null) {

			throw new RuntimeException("WebDriver is not initialized. Please call initializeWebDriver() first.");
		}
		return driver;
	}

	// Close the WebDriver
	public void closeDriver() {
		if (driver != null) {
			driver.close();
		} else {
			throw new RuntimeException("WebDriver is not initialized. Cannot close null Webdriver");
		}
	}

}
