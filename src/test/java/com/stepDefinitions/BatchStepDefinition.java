package com.stepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.driverManager.DriverFactory;
import com.pages.BatchModulePage;
import com.pages.ProgramPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BatchStepDefinition {
	BatchModulePage batchObject=new BatchModulePage(DriverFactory.getDriver());
	@Given("Admin successfully Logged on to the LMS Portal")
	public void admin_successfully_logged_on_to_the_lms_portal() {
	    
	}

	/*
	 * @Given("Admin is on the home page") public void admin_is_on_the_home_page() {
	 * //assertTrue(batchObject.isHomePageDisplayed(),
	 * "Admin is not on the home page."); if ( batchObject.isHomePageDisplayed() ) {
	 * System.out.println("Admin is on the home page"); }
	 * System.out.println("Admin is not on the home page");
	 * //batchObject.navigateToHomePage(); }
	 */

	@When("Admin Clicks on the {string} menu from the header")
	public void admin_clicks_on_the_batch_menu_from_the_header(String menuName) {
		System.out.println("Inside when of batch");
		//batchObject.clickHeaderBar(string);
		batchObject.clickOnMenu(menuName);
 }

	@Then("Admin should be in the Manage {string} Page")
	public void admin_should_be_in_the_manage_batch_page(String string) {
		System.out.println("Inside when of batch");
		boolean result = batchObject.validate_manage_page(string);
		Assert.assertTrue(result);
	}

	
	@Then("Admin should see the {string} Title")
	public void admin_should_see_the_title(String expectedTitle) {
		 //String actualTitle = batchObject.getPageTitle();
	       // Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match");
	        Assert.assertTrue(batchObject.isToolbarTextCorrect("LMS - Learning Management System"));
	   
	}@Then("Admin should see the {string} Heading")
	public void admin_should_see_the_heading(String expectedHeading) {
		 Assert.assertTrue(batchObject.isManageBatchHeadingDisplayed(), 
		            "The heading is not displayed on the Batch page");
		        
		        String actualHeading = batchObject.getManageBatchHeadingText();
		        Assert.assertEquals(actualHeading, expectedHeading, 
		            "The heading text does not match the expected value");
	}
	/*@Then("Admin should see the disabled Delete Icon under the header")
	public void admin_should_see_the_disabled_delete_icon_under_the_header() {
	//@Then("Admin should see the disabled under the header")
	//public void admin_should_see_the_disabled_under_the_header() {
		//System.out.println("See the disable button");
		 //Assert.assertTrue(batchObject.isDeleteIconDisabled(),
		   //         iconName + " should be disabled under the header.");
		 Assert.assertTrue(batchObject.isButtonLabelVisible(), "Button label should be visible but empty.");
	}*/

	@Then("Admin should see the disabled {string} under the header")
	public void admin_should_see_the_disabled_under_the_header(String iconName) {
		System.out.println("See the disable button");
		// Assert.assertTrue(batchObject.isDeleteIconDisabled(),
		 // iconName + " should be disabled under the header.");
		 Assert.assertTrue(batchObject.isMultipleDeleteIconDisabled());
	}
	@Then("Admin should see the enabled pagination controls under the data table")
	public void admin_should_see_the_enabled_pagination_controls_under_the_data_table() {
		Assert.assertTrue(batchObject.isPaginationEnabled(),"Pagination controls are not enabled or visible");
		//Assert.assertTrue(batchObject.isPaginationEnabled() == true, "Pagination controls are not enabled or visible");
	    }
	@Then("Admin should see the edit icon in each row")
	public void admin_should_see_the_edit_icon_in_each_row() {
		 boolean iconsVisible = batchObject.areEditIconsVisibleInEachRow();
	        Assert.assertTrue(iconsVisible, "Edit icons are not visible in all rows");
	}
	@Then("Admin should see the delete icon in each row")
	public void admin_should_see_the_delete_icon_in_each_row() {
		 Assert.assertTrue(batchObject.areDeleteIconsDisplayed(), "Delete icon is not visible in all rows");
	}
	@Then("Admin should see the checkbox in each row")
	public void admin_should_see_the_checkbox_in_each_row() {
		Assert.assertTrue(batchObject.areCheckboxesDisplayedInEachRow(), "Not all rows have checkboxes visible");
    }
	

@Then("Admin should see the datatable headers Batch name, Batch Description,Batch Status, No Of classes, Program Name, Edit\\/Delete")
public void admin_should_see_the_datatable_headers_batch_name_batch_description_batch_status_no_of_classes_program_name_edit_delete() {
	 List<String> expectedHeaders = Arrays.asList(
	"Batch Name",
    "Batch Description",
    "Batch Status",
    "No Of Classes",
    "Program Name",
    "Edit / Delete"
);

// Fetch actual headers from the page
List<WebElement> actualHeaders = batchObject.getTableHeaders();

// Validate headers
for (String expectedHeader : expectedHeaders) {
    Assert.assertTrue(batchObject.isHeaderPresent(expectedHeader),
            "Header missing: " + expectedHeader);
}
}
@Then("Admin should see the checkbox  in the datatable header row")
public void admin_should_see_the_checkbox_in_the_datatable_header_row() {
	 Assert.assertTrue(batchObject.isHeaderCheckboxDisplayed(), "Checkbox in header is not displayed");
}
@Then("Admin should see the sort icon next to all Datatable headers")
public void admin_should_see_the_sort_icon_next_to_all_datatable_headers() {
	 /*int expectedHeaders = 6;
	Assert.assertEquals(batchObject.getSortIconCount(), expectedHeaders,  "Not all sort icons are present next to the headers.");
	 // Check if all sort icons are visible
    Assert.assertTrue(batchObject.areAllSortIconsVisible(), 
        "Some sort icons are not visible next to the headers.");*/
	 //Assert.assertTrue(batchObject.areAllSortIconsPresent());
	 //Assert.assertTrue(sortIcon.isDisplayed(), "Sort icon is not displayed");
     //driver.quit();
	 Assert.assertTrue(batchObject.areAllSortIconsDisplayed());
}

@Given("Admin is on batch page")
public void admin_is_on_batch_page() {

    
}
@When("Admin clicks Batch on the navigation bar")
public void admin_clicks_batch_on_the_navigation_bar() {
	 batchObject.clickBatchMenu();
}


/*
 * @Then("Admin should see sub menu in menu bar as {string}") public void
 * admin_should_see_sub_menu_in_menu_bar_as(String submenu) {
 * Assert.assertTrue(batchObject.isSubMenuDisplayed(submenu), submenu +
 * " submenu is not displayed."); }
 */
/*Add New Batch*/
/* Background Step Definition */
@Then("Admin is on the Batch page")
public void admin_is_on_the_batch_page() {
	 batchObject.navigateToBatchPage();
       // Assert.assertTrue(batchObject.isBatchPageDisplayed(), "Batch page is not displayed.");
    }
@When("Admin clicks on {string} under the {string} menu bar")
public void admin_clicks_on_under_the_menu_bar(String submenu, String menu) {
	batchObject.clickBatchMenu();  // Click on "Batch" menu
    batchObject.clickAddNewBatch(); // Click on "Add New Batch" submenu
}

@Then("Admin should see the Batch Details pop up window")
public void admin_should_see_the_batch_details_pop_up_window() {
	 //Log.debug("pop label.");

	// Assert.assertTrue(batchObject.isBatchDetailsPopupDisplayed(), "Batch Details pop-up is not displayed.");
	assertTrue(batchObject.isBatchDetailsPopupDisplayed());

}
/*AddNewBatchDetailsPopup*/
/* Background for add new batch details popup*/ 
@Then("Admin is on the Add new batch pop up")
public void admin_is_on_the_add_new_batch_pop_up() {
	//Assert.assertTrue(batchObject.isDisplayed(),"Batch Details pop-up is not visible.");
	//BatchModulePage batchObject=new BatchModulePage(DriverFactory.getDriver());
	

}

@Given("Admin is on the Batch Details Pop Up WIndow")
public void admin_is_on_the_batch_details_pop_up_w_indow() {
	System.out.println("Admin is on the Batch details");
	/*batchObject.pdriver.navigate().refresh();
	batchObject.classClick();
	batchObject.clickAddNewClass();
	 assertNotNull(batchObject);*/
	// batchObject.navigateToBatchDetailsPopup();
	batchObject.clickBatchMenu();
    batchObject.clickAddNewBatch();
	
    assertTrue(batchObject.isBatchDetailsPopupDisplayed());
}

@When("Admin checks all the fields are enabled")
public void admin_checks_all_the_fields_are_enabled() {
	Assert.assertTrue(batchObject.isProgramNameDropdownDisplayed());
     Assert.assertTrue(batchObject.isBatchNameTextboxDisplayed());
     Assert.assertTrue(batchObject.isDescriptionTextboxDisplayed());
     Assert.assertTrue(batchObject.isActiveRadioButtonDisplayed());
     Assert.assertTrue(batchObject.isInactiveRadioButtonDisplayed());
     Assert.assertTrue(batchObject.isNumberOfClassesTextboxDisplayed());
}
	 //assertTrue(batchObject.areAllFieldsEnabled());

 

@Then("The pop up should include the fields Batch Name,Number of classes and Description as text box,Program Name as drop downStatus as radio button")
public void the_pop_up_should_include_the_fields_batch_name_number_of_classes_and_description_as_text_box_program_name_as_drop_down_status_as_radio_button() {
	System.out.println("All required fields are present and enabled.");
	 // Validate elements exist
    Assert.assertTrue(batchObject.isBatchNameFieldPresent());
    Assert.assertTrue(batchObject.isNumberOfClassesFieldPresent());
  ////  Assert.assertTrue(batchObject.isDescriptionFieldPresent());
    Assert.assertTrue(batchObject.isProgramNameDropdownPresent());
	// assertTrue(batchObject.verifyPopupFields());
}

/*@When("Admin selects program name present in the dropdown")
public void admin_selects_program_name_present_in_the_dropdown() {
	  batchObject.selectProgramName("testProgramOne"); 
}*/

@Then("Admin should see selected program name in the batch name prefix box")
public void admin_should_see_selected_program_name_in_the_batch_name_prefix_box() {
	 /*String expectedPrefix = "testProgramOne";
	    String actualPrefix = batchObject.getBatchNamePrefix();
	    assertTrue(actualPrefix.startsWith(expectedPrefix), "The batch name prefix does not match the selected program name.");
}*/
	assertTrue(batchObject.isBatchNamePrefixedWithProgram());
}
@When("Admin enters alphabets in batch name suffix box")
public void admin_enters_alphabets_in_batch_name_suffix_box() {
	 batchObject.enterBatchSuffix("abc");
}

@Then("Admin should get error message below the text box of respective field")
public void admin_should_get_error_message_below_the_text_box_of_respective_field() {
	 String errorMessage = batchObject.getBatchSuffixErrorMessage();
	    assertEquals("Only numbers are allowed", errorMessage);  // Assuming this is the validation message
	}
   
@When("Admin enters alphabets in batch name prefix box")
public void admin_enters_alphabets_in_batch_name_prefix_box() {
	 batchObject.tryToEnterBatchPrefix("ABC");  // Attempt to enter alphabets
}

@Then("Admin should see empty text box")
public void admin_should_see_empty_text_box() {
	 String prefixValue = batchObject.getBatchPrefixValue();
	    assertEquals("", prefixValue);  // Assert that the text box remains empty
	}
    
@When("Admin enters the data only to the mandatory fields and clicks save button")
public void admin_enters_the_data_only_to_the_mandatory_fields_and_clicks_save_button() {
	 batchObject.fillMandatoryFields("Batch 101", "10", "Java Program");  // Example data
	    batchObject.clickSaveButton();
}

@Then("Admin should get a successful message")
public void admin_should_get_a_successful_message() {
	String successMessage = batchObject.getSuccessMessage();
    assertEquals("Batch created successfully", successMessage);
}
@When("Admin leaves blank one of the mandatory fields")
public void admin_leaves_blank_one_of_the_mandatory_fields() {
    
}

@Then("Admin should get a error message on the respective mandatory field")
public void admin_should_get_a_error_message_on_the_respective_mandatory_field() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("Admin can see the batch details popup closes without creating any batch")
public void admin_can_see_the_batch_details_popup_closes_without_creating_any_batch() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@When("Admin clicks on the close icon")
public void admin_clicks_on_the_close_icon() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("batch details pop up closes")
public void batch_details_pop_up_closes() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

/*Edit Icon Validation*/

@When("Admin clicks the edit icon")
public void admin_clicks_the_edit_icon() {
	 batchObject.clickEditIcon();
}

@Then("Admin should see Program name value field is disabled for editing")
public void admin_should_see_program_name_value_field_is_disabled_for_editing() {
	Assert.assertTrue(batchObject.isProgramNameDisabled());
}
@Then("Admin should see batch name value field is disabled for editing")
public void admin_should_see_batch_name_value_field_is_disabled_for_editing() {
	// Assert.assertTrue(batchObject.isBatchNameDisabled(), "Batch name field should be disabled for editing");
	}

@Given("Admin is on the Batch Details Page")
public void admin_is_on_the_batch_details_page() {
	batchObject.navigateToBatchDetailsPage();
}

@When("Admin Updates any fields with invalid data and click save button")
public void admin_updates_any_fields_with_invalid_data_and_click_save_button() {
	batchObject.enterInvalidDataInDescription("Invalid@123");
    batchObject.enterInvalidDataInNoOfClasses("-5");
    batchObject.clickSaveButton();
	
}

@Then("Admin should get a error message under the respective field")
public void admin_should_get_a_error_message_under_the_respective_field() {
	 assertTrue(batchObject.isDescriptionErrorVisible(), "Error message for Description is not visible");
	    assertTrue(batchObject.isNoOfClassesErrorVisible(), "Error message for No. of Classes is not visible");
	}

@When("Admin enters the valid data to all the mandatory fields and click save button")
public void admin_enters_the_valid_data_to_all_the_mandatory_fields_and_click_save_button() {
	batchObject.enterBatchName("Batch Alpha");
    batchObject.enterNumberOfClasses("12");
    batchObject.enterBatchDescription("This is a valid description for Batch Alpha.");
    batchObject.selectProgramName("Java Program");
    batchObject.selectStatus("Active");
}

@Then("Admin should get a successful message for editing the batch")
public void admin_should_get_a_successful_message_for_editing_the_batch() {
	 String successMessage = batchObject.getSuccessMessage();
	    Assert.assertTrue(successMessage.contains("Batch updated successfully"));
	}

@When("Admin enters the valid data to all the mandatory fields and click cancel button")
public void admin_enters_the_valid_data_to_all_the_mandatory_fields_and_click_cancel_button() {
	 batchObject.enterBatchName("Batch Alpha");
	    batchObject.enterNumberOfClasses("10");
	    batchObject.enterBatchDescription("This is a valid batch description.");
	    batchObject.selectProgramName("Python Program");
	    batchObject.selectStatus("Active");
	    batchObject.clickCancelButton();
}

@Then("Admin can see the batch details popup closes without editing the batch")
public void admin_can_see_the_batch_details_popup_closes_without_editing_the_batch() {
	Assert.assertNotSame("Batch details pop-up is still visible", batchObject.isBatchPopupVisible());
}
/*Delete batch validation*/
@When("Admin clicks the delete Icon on any row")
public void admin_clicks_the_delete_icon_on_any_row() {
	batchObject.clickDeleteIconOnRow(1);
}

@Then("Admin should see the confirm alert box with yes and no button")
public void admin_should_see_the_confirm_alert_box_with_yes_and_no_button() {
	//assertTrue(batchObject.isDeleteConfirmationDisplayed(), "Delete confirmation alert is not displayed");
    //assertTrue(batchObject.isYesButtonPresent(), "Yes button is missing in the alert box");
    //assertTrue(batchObject.isNoButtonPresent(), "No button is missing in the alert box");
}

/*Delete MultipleCeckbox */
@When("Admin clicks on the delete icon under the Manage batch header")
public void admin_clicks_on_the_delete_icon_under_the_manage_batch_header() {
    
}

@Then("The respective row in the table should be deleted")
public void the_respective_row_in_the_table_should_be_deleted() {
   
}

/*  Pagination   */

 @When("Admin clicks next page link on the data table")
public void admin_clicks_next_page_link_on_the_data_table() {
	 batchObject.clickNextPage();
}

@Then("Admin should see the Next enabled link")
public void admin_should_see_the_next_enabled_link() {
	 Assert.assertTrue(batchObject.isNextButtonEnabled());
}

@When("Admin clicks last page link on the data table")
public void admin_clicks_last_page_link_on_the_data_table() {
	batchObject.clickLastPage();
    
}
@Then("Admin should see the last page link with next page link disabled on the table")
public void admin_should_see_the_last_page_link_with_next_page_link_disabled_on_the_table() {
    
}


@When("Admin clicks previous page link on the data table")
public void admin_clicks_previous_page_link_on_the_data_table() {
  batchObject.clickPreviousPage();
}

@Then("Admin should see the previous page on the table")
public void admin_should_see_the_previous_page_on_the_table() {
    
}
@When("Admin clicks first page link on the data table")
public void admin_clicks_first_page_link_on_the_data_table() {
	batchObject.clickFirstPage() ;
}

@Then("Admin should see the very first page on the data table")
public void admin_should_see_the_very_first_page_on_the_data_table() {
    
}
/* Search and Logout */
@When("Admin enters the batch name in the search text box")
public void admin_enters_the_batch_name_in_the_search_text_box() {
    
}

@Then("Admin should see the filtered batches in the data table")
public void admin_should_see_the_filtered_batches_in_the_data_table() {
   
}

@When("Admin clicks on the logout button")
public void admin_clicks_on_the_logout_button() {
    
}

@Then("Admin should see the Login screen Page")
public void admin_should_see_the_login_screen_page() {
  
}
}























 




	



