package com.stepDefinitions;

import static org.testng.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.driverManager.DriverFactory;
import com.pages.ClassPageValidation;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ClassPageValidationStepDefinition {
	ClassPageValidation cpv = new ClassPageValidation(DriverFactory.getDriver());
	boolean status;
	
	@Given("Admin is on the home page after login")
	public void admin_is_on_the_home_page_after_login() {
		 System.out.println("I am inside class feature scenrio1 - Given");
	}

	@When("Admin clicks the {string} Navigation bar in the Header")
	public void admin_clicks_the_class_navigation_bar_in_the_header(String  string) {
	   System.out.println("I am inside class feature scenrio1 - when");
	   cpv.clickNavigationBarClass(string);
	}

	@Then("Admin should see the headers heading like {string}")
	public void admin_should_see_the_datatable_heading_like(String header) {		
	    WebElement headerElement = cpv.getHeaderElement(header);
	    Assert.assertNotNull(headerElement);
	    Assert.assertEquals(header, headerElement.getText().trim());
	}
	
	@Then("Admin should see the showing entries and enabled pagination controls under the data table")
	public void admin_should_see_the_showing_entries_and_enabled_pagination_controls_under_the_data_table() {
		 assertTrue(cpv.validateShowingEnteries());
		  System.out.println("showing entries is displayed");
	}
	@Then("Admin should see the Sort icon of all the field in the datatable")
	public void admin_should_see_the_sort_icon_of_all_the_field_in_the_datatable() {
		assertTrue(cpv.validateSortingBtn());
		System.out.println("Sort icon is displayed");
}
	@Then("Admin should see the Delete button under the Manage class page header")
	public void admin_should_see_the_delete_button_under_the_manage_class_page_header() {
		assertTrue(cpv.deleteBtnDisplayed());
		System.out.println("Delete button is visible");
	}
	@Then("Admin should see Total no of classes in below of the data table")
	public void admin_should_see_total_no_of_classes_in_below_of_the_data_table() {
		assertTrue(cpv.validateFooter());
	}
	
	}



	
