package com.stepDefinitions;

import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.driverManager.DriverFactory;
import com.pages.ClassAddNewPage;
import com.utilities.ExcelReader;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ClassAddNewStepDefinition {
	ClassAddNewPage canp = new ClassAddNewPage(DriverFactory.getDriver());
	boolean status;
	
	@Then("clicks add new class under the class menu bar")
	public void clicks_add_new_class_under_the_class_menu_bar() throws InterruptedException {
		System.out.println("It is on the class stepdefination ");
		canp.clickAddNewClass();
	}
	@Then("Admin should see a popup open for class details with empty form along with <SAVE> and <CANCEL> button and Close\\(X) Icon on the top right corner of the window")
	public void admin_should_see_a_popup_open_for_class_details_with_empty_form_along_with_SAVE_and_CANCEL_button_and_Close_X_Icon_on_the_top_right_corner_of_the_window() {
		assertTrue(canp.cancelDisp());
		System.out.println("Cancel button is visible");
		assertTrue(canp.saveDisp());
		System.out.println("Save button is visible");
		assertTrue(canp.crossBtnDisp());
		System.out.println("Save button is visible");	
	}
	@Then("Admin should see few input fields and their respective text boxes in the class details window")
	public void admin_should_see_few_input_fields_and_their_respective_text_boxes_in_the_class_details_window() {
		assertTrue(canp.batchNameOnPopupDisp());
		System.out.println("Batch Name is visible");
		assertTrue(canp.classTopicOnPopupDisp());
		System.out.println("Class Topic is visible");
	}
	@When("Admin clicks Cancel Icon on class Details form")
    public void admin_clicks_cancel_icon() {
		canp.clickCancelBtn();
  }
	@Then("Class Details popup window should be closed without saving")
	public void class_details_popup_window_should_be_closed_without_saving() {
		canp.backOnManagePage();
		assertTrue(canp.backOnManagePage());
		System.out.println("Admin is back on manage class page after closing witout saving"); 
	}

	@Then("Admin gets message Class added Successfully")
	public void admin_gets_message_class_added_successfully() {
		System.out.println(" Class Created Successfully ");
	}
	@When("Admin enters mandatory fields {string} {string} {string} {string} {string} {string} {string} {string} {string} in the form and clicks on save button")
	public void admin_enters_mandatory_fields_in_the_form_and_clicks_on_save_button(String batchName, String classTopic, String classDescription, String month, String date1, String date2, String staffName, String Status, String expectedMsg) throws InterruptedException {
		assertTrue(canp.addingMandatoryFields(batchName ,classTopic ,classDescription ,month ,date1, date2 ,staffName ,Status).equals(expectedMsg));
	}
	@When("Admin selects class {string} {string} {string} in date picker")
	public void admin_selects_class_date_in_date_picker(String month,String date1,String date2) {
		canp.noOfClasses(month,date1,date2);
	}
		@Then("Admin should see no of class value is added automatically")
		public void admin_should_see_no_of_class_value_is_added_automatically() {
		   canp.checkUpdatedClasses();
		}

		@When("Admin skips adding values in mandatory fields and enters only the optional fields {string} {string} {string}")
		public void admin_skips_adding_values_in_mandatory_fields_and_enters_only_the_optional_fields(String comments, String notes, String recording) {
		   canp.selectOptionalFields(comments,notes,recording);
		}

		@Then("Admin should see error messages below the test fields, and the fields will be highlighted in red color {string} {string} {string} {string} {string}")
		public void admin_should_see_error_messages_below_the_test_fields_and_the_fields_will_be_highlighted_in_red_color(String expectedBatchNameText, String expectedClassTopicText, String expectedClassDateText, String expectedStaffNameText, String expectedNoOfClassesText) {
                
			Assert.assertEquals("Batch Name is required", expectedBatchNameText, canp.getBatchNameReqText());
	        Assert.assertEquals("Class Topic is required", expectedClassTopicText, canp.getClassTopicReqText());
	        Assert.assertEquals("Class Date is required", expectedClassDateText, canp.getClassDateReqText());
	        Assert.assertEquals("Staff Name is required", expectedStaffNameText, canp.getStaffNameReqText());
	        Assert.assertEquals("No. of Classes is required", expectedNoOfClassesText, canp.getNoOfClassesReqText());
		}
		@When("Admin clicks on save button without entering data")
		public void admin_clicks_on_save_button_without_entering_data() {
		    	canp.clickOnSave();    	
		    }

		   


		@Then("Admin should see error message below the test field and the field will be highlighed in red color {string} {string} {string} {string} {string}")
		public void admin_should_see_error_message_below_the_test_field_and_the_field_will_be_highlighed_in_red_color(String string, String string2, String string3, String string4, String string5) {
		  
		}




}
