package com.stepDefinitions;

import org.testng.Assert;

import com.driverManager.DriverFactory;
import com.pages.LoginPage;
import com.pages.LogoutPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class LogoutSteps {
	
	
	DriverFactory driver = new DriverFactory();
	LoginPage login = new LoginPage(driver.getDriver());

	LogoutPage logoutpage= new LogoutPage(driver.getDriver());
	
	@Given("Admin is in dashboard page")
	public void admin_is_in_dashboard_page() {
	      	
    	
	}

	@When("Admin clicks on the logout in the menu bar")
	public void admin_clicks_on_the_logout_in_the_menu_bar() {
	    
		logoutpage.clickLogout();
	}

	@Then("Admin should be redirected to login page")
	public void admin_should_be_redirected_to_login_page() {
	   Assert.assertEquals(logoutpage.logoutvalidation(), true);
	}
	
	// Verify back button
	
	@Given("Admin is logged out of the application")
	public void admin_is_logged_out_of_the_application() {
		login.enterLoginDetails();
	    logoutpage.clickLogout();
	}	
	
	@When("Admin is in login page and clicks the back button")
	public void admin_is_in_login_page_and_clicks_the_back_button() {
		Assert.assertEquals(logoutpage.logoutvalidation(), true);
		DriverFactory.getDriver().navigate().back();
	}

	@Then("Admin should receive error message")
	public void admin_should_receive_error_message() {
		Assert.assertEquals(null, "ErrorMessage");
	}

}
