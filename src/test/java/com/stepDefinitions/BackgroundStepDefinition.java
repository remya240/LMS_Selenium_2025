
package com.stepDefinitions;

import com.driverManager.DriverFactory;
import com.pages.LoginPage;
import com.pages.ProgramPage;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class BackgroundStepDefinition {

	DriverFactory driver = new DriverFactory();
	LoginPage login = new LoginPage(driver.getDriver());
	ProgramPage program = new ProgramPage(driver.getDriver());
	
	@Before("@ProgramLogin")
	public void logInLMSPortal() {

	}

	@Given("The Browser is open")
	public void the_browser_is_open() {

	}

	@When("Log into LMS Portal as Admin")
	public void log_into_lms_portal_as_admin() {

		
		login.enterLoginDetails();
	}
	
	
	@And("Click Program option in menubar")
	public void click_program_option_in_menubar() {

		program.clickProgrammenu();
		
	}
	
}
