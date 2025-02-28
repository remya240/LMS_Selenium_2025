package com.stepDefinitions;

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.driverManager.*;
import com.pages.LoginPage;
import com.pages.ProgramAddPage;
import com.utilities.ConfigReader;
import com.utilities.LoggerLoad;
//import com.utilities.TestContext;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;



public class ProgramAddSteps {
    //private WebDriver pdriver;
    //private TestContext testcontext;
       private WebDriverWait wait;
       
    //private final ConfigReader configreader;
    //private ProgramAddPage programadd ;

//    public ProgramAddSteps(TestContext testcontext) {
//        this.testcontext = testcontext;
//        this.pdriver = testcontext.getDriver();
//        this.wait = new WebDriverWait(pdriver, Duration.ofSeconds(30));
//        this.configreader = new ConfigReader();
//        this.programadd = new ProgramAddPage(pdriver,testcontext);
//    }
    
    ProgramAddPage programadd = new ProgramAddPage(DriverFactory.getDriver());
    //Actions action=new Actions(pdriver);
    
    @And("admin clicks on {string} in menubar")
    public void admin_clicks_on_in_menubar(String string) {
    	programadd.clickOnProgrammenu(string);
    	LoggerLoad.logInfo("am in program page");
         
    }
    
//    @Given("admin clicks on {string} in menubar")
//    public void	Given_admin_clicks_on_in_menubar(String string) {
//    	programadd.clickOnProgrammenu(string);
//    }

	@Then("admin clicks on {string} submenu")
    public void admin_clicks_on_submenu(String submenu) {
		programadd.clickOnsubmenu(submenu);  
		System.out.println("Clicked on submenu: " + submenu);
		
	  // LoggerLoad.logInfo("Clicked on submenu: " + submenu);
	    
//		boolean result = programadd.addnewProgram(submenu);  
//	    Assert.assertTrue(result, "Failed to navigate to: " + submenu);
//	    LoggerLoad.logInfo("Clicked on submenu: " + submenu);
    }
	
	@Then("Admin should see window title as {string}")
	public void admin_should_see_window_title_as(String expectedTitle) {
		String actualTitle = programadd.getPopupWindowTitle();
	    Assert.assertEquals(actualTitle, expectedTitle, "Window title mismatch!");
	   	System.out.println("Verified window title: " + actualTitle);
	
	   
	}

	@Then("Admin should see red  asterisk mark  beside mandatory field {string}")
	public void admin_should_see_red_asterisk_mark_beside_mandatory_field(String string) {
		
		
	}

	@When("Admin clicks save button without entering mandatory")
	public void admin_clicks_save_button_without_entering_mandatory() {
	//programadd.clickSavebutton();	
	   
	}
	

	@Then("Admin gets message <field> is required")
	public void admin_gets_message_field_is_required(io.cucumber.datatable.DataTable dataTable) {
	    List<String> fields = dataTable.asList();
	    
	    for (int i = 0; i < fields.size(); i++) {
	        String fieldName = fields.get(i);
	        String actualMessage = programadd.getRequiredFieldMessage(fieldName);
	        String expectedMessage = fieldName ;
	        
	        Assert.assertEquals(actualMessage, expectedMessage, 
	            "Validation message mismatch for: " + fieldName);
	        System.out.println("Verified required field message for: " + fieldName + " - Actual: " + actualMessage);

	    	    }
	}

	@When("Admin enters ProgramName in textbox")
	public void admin_enters_program_name_in_textbox() throws FileNotFoundException, IOException {
    String programName =programadd.enterProgramName();
	System.out.println(programName + " program name entered");	
	    
	}

	@Then("Admin can see text entered")
	public void admin_can_see_text_entered() throws FileNotFoundException, IOException {
		String programName =programadd.getProgramName();
		System.out.println(programName + " program name text"); 
		
		String programDescription = programadd.getprogramDescription();
		System.out.println(programDescription + " Description text");
	}

	@When("Admin enters Description in textbox")
	public void admin_enters_description_in_textbox() throws FileNotFoundException, IOException {

		String programDescription = programadd.enterDescription();
		System.out.println(programDescription + " Description entered");
	}

	@When("Admin selects status by clicking on radiobutton {string}")
	public void admin_selects_status_by_clicking_on_radiobutton(String status) {
		programadd.selectStatusRadioButton(status);
		Assert.assertEquals(programadd.getInactiveStatus(),"Inactive");
		programadd.selectStatusRadioButton(status);
		Assert.assertEquals(programadd.getActiveStatus(),"Active");
//		programadd.selectStatusRadioButton(status);	
//		System.out.println("selected status :"+status);
	   
	}

	@Then("Admin can see {string} status selected")
	public void admin_can_see_status_selected(String expected) {
		
		programadd.getActiveStatus();
		
	}

	@When("Admin enter valid details for mandatory fields and Click on save button")
	public void admin_enter_valid_details_for_mandatory_fields_and_click_on_save_button() throws FileNotFoundException, IOException {
		
		programadd.enterProgramName();
		programadd.enterDescription();
		programadd.selectstatusActive();
		programadd.clickSavebutton();
		System.out.println("new program created");
	}
	

	@Then("Admin gets message {string}")
	public void admin_gets_message(String expected) {
		String actual = programadd.getsuccessMessage();
	   Assert.assertEquals(actual, expected, "successfully created");
	   System.out.println(actual+ " verified message");
	}
	
	
	@When("Admin searches with newly created {string}")
	public void admin_searches_with_newly_created_program_name(String ProgramName) throws FileNotFoundException, IOException {
		
		String actual =programadd.searchProgram();
		System.out.println(actual+ " search message");
		
	}

@Then("Records of the newly created {string} are displayed and match the data entered")
public void records_of_newly_created_program_name_are_displayed_and_match_data_entered(String programName) {

	}
@When("Admin clicks Cancel button")
public void admin_clicks_cancel_button() throws FileNotFoundException, IOException {
	programadd.enterProgramName();
	programadd.enterDescription();
	programadd.selectstatusActive();
   programadd.clickCancelButton();
}

@Then("Admin can see Program Details form disappears")
public void admin_can_see_program_details_form_disappears() {
   programadd.verifyAddProgramDisappeared();
}

@Then("Records of the newly created  {string} is displayed and match the data entered")
public void records_of_the_newly_created_is_displayed_and_match_the_data_entered(String string) {
    
}

@When("Admin Click on {string} button")
public void admin_click_on_button(String string) {
   programadd.clickXButton();
}

@Then("Admin can see program details form disappear")
public void admin_can_see_program_details_form_disappear() {
	programadd.verifyProgramDetailsFormDisappeared();
}


}
