
package com.stepDefinitions;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.picocontainer.annotations.Inject;
import org.testng.Assert;

import com.driverManager.DriverFactory;
import com.pages.LoginPage;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.sourceforge.tess4j.TesseractException;


public class LoginStepDefinition {

	DriverFactory driver = new DriverFactory();
	LoginPage login = new LoginPage(driver.getDriver());

	@Before("@Login")
	public void dologin() {
		login.enterLoginDetails();
	}

	//// universal Given scenarios

	@Given("The browser is open")
	public void the_browser_is_open() {

	}

	@Given("Admin is on login Page")
	public void admin_is_on_login_page() {

	}

	// Perform login operation

	@When("Admin enter valid data in all field and clicks login button")
	public void admin_enter_valid_data_in_all_field_and_clicks_login_button() {
		login.enterLoginDetails();
	}

	@When("Admin gives the correct LMS portal URL")
	public void admin_gives_the_correct_lms_portal_url() {
		login.loadLMSapp();
	}

	// Assertions //1

	@Then("Admin should land on home page")
	public void admin_should_land_on_home_page() {
		Assert.assertTrue(login.validateLoginfunction());
	}

	// 2

	@Then("Admin should land on the login page")
	public void admin_should_land_on_the_login_page() {
		Assert.assertTrue(login.validateCurrentPageURL("Login"));
	}

	// Assertions

	// 3

	@Then("Admin should receive application error")
	public void admin_should_receive_application_error() {
		Assert.assertTrue(login.validateAppErrorMsg());
	}

	// 4

	@Then("HTTP response >= {int} then the link is broken")
	public void http_response_then_the_link_is_broken(Integer int1) {
		Assert.assertTrue(login.validateResponseStatusCode());
	}

	// 5

	@Then("Admin should see correct spellings in all fields")
	public void admin_should_see_correct_spellings_in_all_fields() {
		try {
			Assert.assertTrue(login.appPageTextValidation());
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	// 6

	@Then("Admin should see  LMS - Learning Management System")
	public void admin_should_see_lms_learning_management_system() throws FileNotFoundException, IOException, TesseractException {
		String text = login.extractTextFromImg();
		System.out.println("text from OCR" +text);
		boolean result=login.appicationNameValidation("LMS - Learning Management System", true);
		Assert.assertTrue(result);
	}

	// 7

	@Then("Admin should see company name below the app name")
	public void admin_should_see_company_name_below_the_app_name() throws IOException, TesseractException {
		String text = login.extractTextFromImg();
		Assert.assertTrue(login.appicationNameValidation("LMS - Learning Management System", true));
	}

	// 8

	@Then("Admin should see {string}")
	public void admin_should_see(String string) {
		Assert.assertTrue(login.pleaseLoginTextValidation(string));
	}

	// 9

	@Then("Admin should see two text field")
	public void admin_should_see_two_text_field() {
		Assert.assertTrue(login.VerifyingTextfieldCount());
	}

	// 10

	@Then("Admin should {string} in the first text field")
	public void admin_should_in_the_first_text_field(String string) {
		Assert.assertTrue(login.validateTextField(string));
	}

	// 11

	@Then("Admin should see one dropdown")
	public void admin_should_see_one_dropdown() {
		Assert.assertTrue(login.validateDrodownCount());
	}

	// 12

	@Then("Admin should see asterisk mark symbol next to text for mandatory fields")
	public void admin_should_see_asterisk_mark_symbol_next_to_text_for_mandatory_fields() {
		Assert.assertTrue(login.validateAsterisk());
	}

	// 13

	@Then("Admin should {string} in the second text field")
	public void admin_should_in_the_second_text_field(String string) {
		Assert.assertTrue(login.validateTextField(string));
	}

	// 14

	@Then("Admin should see asterisk mark symbol next to password text")
	public void admin_should_see_asterisk_mark_symbol_next_to_password_text() {
		Assert.assertTrue(login.validateAsterisk());
	}

	// 15

	@Then("Admin should see {string} placeholder in dropdown")
	public void admin_should_see_placeholder_in_dropdown(String string) {
		Assert.assertTrue(login.validateTextDisplayed(string));
	}

	// 16

	@Then("Admin should see {string} options in dropdown")
	public void admin_should_see_options_in_dropdown(String string) {
		Assert.assertTrue(login.validateTextDisplayed(string));
	}

	// 17

	@Then("Admin should see input field on the centre of the page")
	public void admin_should_see_input_field_on_the_centre_of_the_page() {
		Assert.assertTrue(login.inputFieldAllignment());
	}

	// 18

	@Then("Admin should see login button")
	public void admin_should_see_login_button() {
		Assert.assertTrue(login.validateloginBtnEnable());
	}

	// 19,20

	@Then("Admin should see {string} in gray color")
	public void admin_should_see_user_in_gray_color(String string) {
		Assert.assertTrue(login.adminTextColorValidation(string));
	} // 21,22,23

	@Then("Error message {string}")
	public void error_message(String string) {
		Assert.assertTrue(login.validateTextDisplayed(string));
	}

	////// Negative operations

	@When("Admin gives the invalid LMS portal URL")
	public void admin_gives_the_invalid_lms_portal_url() {
		login.looadInvalidLMSurl();
	}



	@When("Admin enter invalid data and clicks login button")
	public void admin_enter_invalid_data_and_clicks_login_button() throws FileNotFoundException, IOException {
		login.loginUsingInvalid();
	}

	@When("Admin enter value only in password and clicks login button")
	public void admin_enter_value_only_in_password_and_clicks_login_button() {
		login.loginUsingPswd();
	}

	

	@When("Admin enter value only in user name and clicks login button")
	public void admin_enter_value_only_in_user_name_and_clicks_login_button() {
		login.loginUsingUsername();
	}

	

	@When("Admin enter valid credentials  and clicks login button through keyboard")
	public void admin_enter_valid_credentials_and_clicks_login_button_through_keyboard() {
		login.login_usingKeyBoardAction();
	}

	@When("Admin enter valid credentials  and clicks login button through mouse")
	public void admin_enter_valid_credentials_and_clicks_login_button_through_mouse() {
		login.login_UsingmouseActions();
	}

}
