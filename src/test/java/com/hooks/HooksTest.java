
package com.hooks;

import java.time.Duration;

import com.constants.EnvironmentConstants;
import com.driverManager.DriverFactory;
import com.pages.LoginPage;
import com.utilities.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

public class HooksTest {

	private static EnvironmentConstants constants = new EnvironmentConstants();
	private static ConfigReader propertiesConfig = new ConfigReader(); // static
	DriverFactory d = new DriverFactory();
	static DriverFactory driver = new DriverFactory();

	// Executed once before any scenarios in all feature files

	@BeforeAll public static void beforeScenario() {
  System.out.println("I am inside Before All");
  
  try { propertiesConfig.load(); // To read values from Config.properties file
  DriverFactory.initialiseBrowser(constants.getBrowserType()); 
  // sets driverValue 
  } catch (Exception exception) { exception.printStackTrace();
  throw new RuntimeException("Failed to initialize browser", exception); } }

	// Executed before each scenario in any feature file

	@Before public void loadApplicationURL() {
  System.out.println("I am inside Before");
  
  try { driver.getDriver().get(constants.getAppUrl()); 
  // Loads the applicationURL
  driver.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30)
  ); // Sets page load timeout
} 
  catch (Exception exception) {
  exception.printStackTrace(); throw new
  RuntimeException("Failed to load application URL", exception); } }

	// Executed after each scenario

	@After public void tearDown() { System.out.println("I am inside After");
  
  try { LoginPage login = new LoginPage(driver.getDriver());
  driver.getDriver().get(login.HOMEPAGE_URL); login.click_logout(); 
  // Assuming`click_logout` performs the logout action 
  } catch (Exception exception) {
  exception.printStackTrace(); } }

	// Executed once after all scenarios in all feature files

	@AfterAll
  
  public static void closeDriver() {
  System.out.println("I am inside After quit"); if (driver.getDriver() != null)
  { driver.getDriver().close(); driver.getDriver().quit(); 
  // Close the browser session 
  } else { throw new
  RuntimeException("WebDriver instance is null, cannot close null WebDriver");
  } }
}
