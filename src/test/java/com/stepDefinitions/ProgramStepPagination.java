package com.stepDefinitions;

import static org.junit.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.junit.Assert;

import com.driverManager.DriverFactory;
import com.pages.ProgramPaginationPage;

import io.cucumber.java.en.*;

public class ProgramStepPagination {
	
	ProgramPaginationPage pagination = new ProgramPaginationPage (DriverFactory.getDriver());
	
	@When("Admin clicks Next page link on the program table")
	public void admin_clicks_next_page_link_on_the_program_table() throws InterruptedException {
		pagination.clickOnNextPagelink();   
	    
	}

	@Then("Admin should see the Pagination has {string} active link")
	public void admin_should_see_the_pagination_has_active_link(String string) {
	    
		 Assert.assertTrue(pagination.ValidateNextLinkEnabled());
	}

	@When("Admin clicks Last page link")
	public void admin_clicks_last_page_link() throws InterruptedException {
	    
		pagination.clicklastpagelink();
	}

	@Then("Admin should see the last page record on the table with Next page link are disabled")
	public void admin_should_see_the_last_page_record_on_the_table_with_next_page_link_are_disabled() throws InterruptedException {
	    
		 boolean[] results= pagination.nextandlastlinksdisabled();
		  assertFalse("disabled double arrow right button", results[0]);
	        assertFalse("disabled next button", results[1]);
	}

	@Given("Admin is on last page of Program page table")
	public void admin_is_on_last_page_of_program_page_table() throws InterruptedException {
	    
		pagination.clicklastpagelink();
	}

	@When("Admin clicks Previous page link")
	public void admin_clicks_previous_page_link() {
		pagination.clickPreviousLink();
	    
	}

	@Then("Admin should see the previous page record on the table with pagination has previous page link")
	public void admin_should_see_the_previous_page_record_on_the_table_with_pagination_has_previous_page_link() throws InterruptedException {
	    
		 boolean[] results= pagination.enabledactivepageAndPreviousLink();
		  Assert.assertTrue("active page", results[0]);
		  Assert.assertTrue("previous link enabled", results[1]);
	}

	@Given("Admin is on Previous Program page")
	public void admin_is_on_previous_program_page() {
	    
	    pagination.clickPreviousLink();
	}

	@When("Admin clicks First page link")
	public void admin_clicks_first_page_link() {
	    
		pagination.clickOnFirstPageLink();
	}

	@Then("Admin should see the very first page record on the table with Previous page link are disabled")
	public void admin_should_see_the_very_first_page_record_on_the_table_with_previous_page_link_are_disabled() throws InterruptedException {
	    
		pagination.previouslinksdisabled();
	}

	@Then("Admin should not see any pagination icons and message {string}")
	public void admin_should_not_see_any_pagination_icons_and_message(String string) {
	    
	    
	}

	@Then("Admin should see pagination icons disabled")
	public void admin_should_see_pagination_icons_disabled() {
	    
	    String noentriesText =pagination.getNoEntriesPagination();
	    System.out.println(noentriesText);
	}

}
