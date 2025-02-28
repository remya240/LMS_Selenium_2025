package com.stepDefinitions;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.junit.Assert;

import com.driverManager.DriverFactory;
import com.pages.ClassEditPage;
import com.pages.ClassPageValidation;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ClassEditStepDefinition {
	
	ClassEditPage cep = new ClassEditPage(DriverFactory.getDriver());
	boolean status;
	
	@Then("Admin clicks on the edit icon")
	public void admin_clicks_on_the_edit_icon() {
		cep.cepdriver.navigate().refresh();
		cep.clickOnEdit();
	    System.out.println("Edit button clicked in stepdefinition"); 
	}

	@Then("A new pop up with class details appears")
	public void a_new_pop_up_with_class_details_appears() {
		assertTrue(cep.editPopup());
		 System.out.println("edit popup window opens");
	}
	@Then("Admin should see batch name field is disabled")
	public void admin_should_see_batch_name_field_is_disabled() {
			assertFalse(cep.batchNameDisabled());
			 System.out.println("Batch Name is disabled");
	}
	@Then("Admin should see class topic field is disabled")
	public void admin_should_see_class_topic_field_is_disabled() {
		status=cep.classTopicDisabled();
		assertFalse(status);
		 System.out.println("Class Topic is disabled");
	}
	@Given("Admin is on the Edit Class Popup window")
	public void admin_is_on_the_Edit_Class_Popup_window() {
		cep.cepdriver.navigate().refresh();
		cep.clickOnEdit();
	    System.out.println("Admin is on the Edit Class Popup window");
	}

	@When("Update the fields with valid data {string} and click save")
	public void update_the_fields_with_valid_data_and_click_save(String editClassDescription) {
		cep.editClassDetails(editClassDescription);			
		 System.out.println("Updated ClassDescription");
	}

	@Then("Admin gets message {string} and see the updated values in data table")
	public void admin_gets_message_and_see_the_updated_values_in_data_table(String expectedMessage) {	
		String actualMessage = cep.saveEditClass();
	    System.out.println("Expected: " + expectedMessage);
	    System.out.println("Actual: " + actualMessage);
	    Assert.assertEquals(expectedMessage, actualMessage);
	    System.out.println("Updated class Successfully");	
	}
	         
	@When("Update the optional fields with valid values {string} {string} {string} and click save")
	public void update_the_optional_fields_with_valid_values_and_click_save(String comments,String notes,String recording) {
		cep.updateOptionalFields(comments,notes,recording);
	}
	@When("Admin clicks Cancel button on edit popup")
	public void admin_clicks_cancel_button_on_edit_popup() {
		cep.cancelDisp();
		cep.clickCancelBtn();
	    System.out.println("Admin clicks Cancel button on edit popup");
	}
	@Then("Admin can see the class details popup disappears and can see nothing changed for particular Class")
	public void admin_can_see_the_class_details_popup_disappears_and_can_see_nothing_changed_for_particular_Class() {
		assertTrue(cep.backOnManagePage());
		System.out.println("Admin is back on manage class page");

}
}