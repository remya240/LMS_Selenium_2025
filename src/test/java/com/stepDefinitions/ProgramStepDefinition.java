
package com.stepDefinitions;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;

import com.driverManager.DriverFactory;
import com.pages.LoginPage;
import com.pages.ProgramPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProgramStepDefinition {

	DriverFactory driver = new DriverFactory();
	LoginPage login = new LoginPage(driver.getDriver());
	ProgramPage programObject = new ProgramPage(driver.getDriver());

	@Given("Admin is on home page after Login")
	public void admin_is_on_home_page_after_login() {

	}

	@When("Admin clicks {string} on the navigation bar")
	public void admin_clicks_on_the_navigation_bar(String string) {

		programObject.clickNavigationBar(string);
	}

	
	
	// Assertions
	
	//1
	@Then("Admin should be navigated to {string} page")
	public void admin_should_be_navigated_to_program_page(String string) {
		boolean result = programObject.validate_navbar_pagenav(string);
		Assert.assertTrue(result);
	}

	
	//2
    @Then("Admin should see Logout in menu bar")
	public void admin_should_see_logout_in_menu_bar() {Assert.assertTrue(programObject.validateLogoutDisplayed());}

    
  //3
    @Then("Admin should see the heading {string}")
    public void admin_should_see_the_heading(String string) throws FileNotFoundException, IOException { Assert.assertTrue(programObject.validateAppName(string));}

  //4
    @Then("Admin should see the page names as in order {string}")
    public void admin_should_see_the_page_names_as_in_order(String string) { Assert.assertTrue(programObject.validateMenuHeaderNames(string));}

    
  //5
    @Then("Admin should see sub menu in menu bar as {string}")
    public void admin_should_see_sub_menu_in_menu_bar_as(String string) {Assert.assertTrue(programObject.AddNewProgram(string));}

    
  //7
    @Then("Admin should able to see Program name, description, and status for each program")
    public void admin_should_able_to_see_program_name_description_and_status_for_each_program() {
        Assert.assertTrue(programObject.validateColheaders());
    }

    
  //8
    @Then("Admin should see a Delete button in left top is disabled")
    public void admin_should_see_a_delete_button_in_left_top_is_disabled() {
        Assert.assertTrue(programObject.validatDelDisabled());
    }
    
  //9
    @Then("Admin should see Search bar with text as {string}")
    public void admin_should_see_search_bar_with_text_as(String string) { Assert.assertTrue(programObject.validatesearchBar(string));}

  //10
    @Then("Admin should see data table with column header on the Manage Program Page as  Program Name, Program Description, Program Status, Edit\\/Delete")
    public void admin_should_see_data_table_with_column_header_on_the_manage_program_page_as_program_name_program_description_program_status_edit_delete() {
        Assert.assertTrue(programObject.validateDataTableHead());
    }
    
    //11
    @Then("Admin should see checkbox default state as unchecked beside Program Name column header")
    public void admin_should_see_checkbox_default_state_as_unchecked_beside_program_name_column_header() {
        Assert.assertTrue(programObject.validateheaderCheckBoxUnchecked());
    }
    
  //12
    @Then("Admin should see check box default state as unchecked on the left side in all rows against program name")
    public void admin_should_see_check_box_default_state_as_unchecked_on_the_left_side_in_all_rows_against_program_name() {
        Assert.assertTrue(programObject.validateAllCheckBoxesUnchecked());
    }

  //13
    @Then("Admin should see the sort arrow icon beside to each column header except Edit and Delete")
    public void admin_should_see_the_sort_arrow_icon_beside_to_each_column_header_except_edit_and_delete() {
       Assert.assertTrue(programObject.validateSortIcons());
    }
    
  //14
    @Then("Admin should see the Edit and Delete buttons on each row of the data table")
    public void admin_should_see_the_edit_and_delete_buttons_on_each_row_of_the_data_table() {
       Assert.assertTrue(programObject.validateEditDelIcons());
    }

  //15
    @Then("Admin should see the text as {string} along with Pagination icon below the table.")
    public void admin_should_see_the_text_as_along_with_pagination_icon_below_the_table(String string) throws InterruptedException {
    	Assert.assertTrue(programObject.validatePaginationTextandIcons());
    }
    
  //16
    @Then("Admin should see the footer as {string}.")
    public void admin_should_see_the_footer_as(String string) {
    	
        Assert.assertTrue(programObject.getTotalProgramCountFromFooter(string));
    }

    
  //17
    @Then("Admin See the Program Name is sorted in {string}")
    public void admin_see_the_program_name_is_sorted_in_ascending_order(String string) {Assert.assertTrue(programObject.verifyingProgrameNameSorting(string));}
       
    
  //18
    @Then("Admin See the program Description is sorted in {string}")
    public void admin_see_the_program_description_is_sorted_in_ascending_order(String string) { Assert.assertTrue(programObject.verifyingProgramDescriptionSorting(string));}

  //19
    @Then("Use See the  Program Status is sorted in {string}")
    public void use_see_the_program_status_is_sorted_in_ascending_order(String string) { Assert.assertTrue(programObject.verifyingProgramStatusSorting(string));}

    
    //
	@When("go to homepage")
	public void go_to_homepage() {

		System.out.println("I am inside Program Scenaario 2 in Program feature - when");
		driver.getDriver().get(login.HOMEPAGE_URL);
	}

	@Then("validatehomepage")
	public void validatehomepage() {
		System.out.println("I am inside Program Scenaario 2 in Program feature - Then");
		boolean result = login.validateLoginfunction();
		Assert.assertTrue(result);
	}
	
	
	








@Given("Admin is on program page")
public void admin_is_on_program_page() {
    
}


@When("Admin clicks on Arrow next to programName")
public void admin_clicks_on_arrow_next_to_program_name() throws InterruptedException {
    programObject.ProgramNameSortClick();
}



@When("Admin clicks on Arrow next to ProgramDescription")
public void admin_clicks_on_arrow_next_to_program_description() throws InterruptedException {
    programObject.ProgramDescriptionSortClick();
}



@When("Admin clicks on Arrow next to Program status")
public void admin_clicks_on_arrow_next_to_program_status() throws InterruptedException {
    programObject.ProgramStatusSortClick();
}





}
