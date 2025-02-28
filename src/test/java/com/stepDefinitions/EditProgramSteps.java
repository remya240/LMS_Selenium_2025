package com.stepDefinitions;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;

import com.driverManager.DriverFactory;
import com.pages.EditProgramPage;
import com.pages.ProgramAddPage;
import io.cucumber.java.en.*;

public class EditProgramSteps {
	ProgramAddPage programadd = new ProgramAddPage(DriverFactory.getDriver());
	EditProgramPage editprogram =new EditProgramPage(DriverFactory.getDriver());
	
	@When("Admin clicks on Edit option for particular program")
	public void admin_clicks_on_edit_option_for_particular_program() throws FileNotFoundException, IOException {
		//programadd.clearSearchText();
		
		programadd.searchProgram();
		
		editprogram.editButtonInManageprogram();
		System.out.println("edit program window");
	}

	@Then("Admin lands on Program details form")
	public void admin_lands_on_program_details_form() {
		boolean editProgwindow= editprogram.landedOnEditProgramWindow();
		Assert.assertTrue(true, editProgwindow+" :is Displayed");
	}

	@Then("Admin should see red asterisk mark beside mandatory field {string}")
	public void admin_should_see_red_asterisk_mark_beside_mandatory_field(String string) {
		editprogram.isRedAsteriskDisplayed();
	}

	@When("Admin edits the program name and click on save button")
	public void admin_edits_the_program_name_and_click_on_save_button() throws FileNotFoundException, IOException, InterruptedException   {
		
		programadd.clearSearchText();
		//editprogram.openEditwindow();
		programadd.searchProgram();
		editprogram.editButtonInManageprogram();
		editprogram.editProgramNameField();
		programadd.clickSavebutton();
		
	}

	@Then("Updated program name is seen by the Admin")
	public void updated_program_name_is_seen_by_the_admin() throws FileNotFoundException, IOException, InterruptedException {
		String text =editprogram.geteditedProgramName();
		System.out.println(text);
		//editprogram.geteditedProgramName();
	}

	@When("Admin edits the description text and click on save button")
	public void admin_edits_the_description_text_and_click_on_save_button() throws FileNotFoundException, IOException, InterruptedException {
		//editprogram.programMenudoubleclick();
		programadd.clearSearchText();
		programadd.searchDescription();
		editprogram.editButtonInManageprogram();
		//editprogram.openEditwindow();
		editprogram.editProgramDescription();
		programadd.clickSavebutton();
	}

	@Then("Admin can see the description is updated")
	public void admin_can_see_the_description_is_updated() throws FileNotFoundException, IOException {
		
		String updatedDescription= editprogram.geteditedDescription();
		
		System.out.println(updatedDescription);
	}

@When("Admin can change the status of the program and click on save button")
public void admin_can_change_the_status_of_the_program_and_click_on_save_button() throws FileNotFoundException, IOException {
	
	programadd.clearSearchText();
	programadd.searchProgram();
	editprogram.editButtonInManageprogram();
	editprogram.changeStatusOfRadioButton();
	programadd.clickSavebutton();
}

@Then("Status updated can be viewed by the Admin")
public void status_updated_can_be_viewed_by_the_admin() throws FileNotFoundException, IOException{
	programadd.clearSearchText();
	programadd.searchProgram();
	editprogram.editButtonInManageprogram();
	programadd.getSelectedStatus();
}

@When("Admin click on save button")
public void admin_click_on_save_button() throws FileNotFoundException, IOException {
	programadd.clearSearchText();
	programadd.searchProgram();
	editprogram.editButtonInManageprogram();
	programadd.clickSavebutton();
}

@Then("Admin can see the updated program details")
public void admin_can_see_the_updated_program_details() {
    
}

@When("Admin searches with newly updated {string}")
public void admin_searches_with_newly_updated(String string) throws FileNotFoundException, IOException {
	editprogram.programMenudoubleclick();
	programadd.clearSearchText();
	programadd.searchProgram();
}

@Then("Admin verifies that the details are correctly updated.")
public void admin_verifies_that_the_details_are_correctly_updated() {
	
    
}

	
	////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////----DELETE MODULE-----/////////////////////
	
	@When("Admin clicks on delete button for a program")
	public void admin_clicks_on_delete_button_for_a_program() throws FileNotFoundException, IOException {
		
		editprogram.clickDeleteButton();
	}

	
	@Then("Admin will get confirm deletion popup")
	public void admin_will_get_confirm_deletion_popup() {
	    
		String confirm =editprogram.deletePopupWindow();
		System.out.println(confirm+ ":popup window opened");
	}
	

		@When("Admin clicks on {string} button")
		public void admin_clicks_on_button(String string) throws FileNotFoundException, IOException {
			programadd.clearSearchText();
			programadd.searchProgram();
			editprogram.deleteProgram();
			
		}

		@Then("Admin can see {string} message")
		public void admin_can_see_message(String string) {
			editprogram.programdeletePopup1();
			
		}

		@When("Admin Searches for {string}")
		public void admin_searches_for(String string) throws IOException, IOException {
			programadd.clearSearchText();
			programadd.searchProgram();
		}

		@Then("There should be zero results.")
		public void there_should_be_zero_results() throws FileNotFoundException, IOException {
		    editprogram.gettextOfZeroResults();
		    
		}

		@Given("Admin is on Program Confirm Deletion Page after selecting a program to delete")
		public void admin_is_on_program_confirm_deletion_page_after_selecting_a_program_to_delete() {
		    
		    
		}

		@Then("Admin can see Confirmation form disappears")
		public void admin_can_see_confirmation_form_disappears() {
		    
		    
		}

		@Then("Admin can see Confirm Deletion form disappear")
		public void admin_can_see_confirm_deletion_form_disappear() {
		    
		    
		}

		@When("Admin selects more than one program by clicking on the checkbox")
		public void admin_selects_more_than_one_program_by_clicking_on_the_checkbox() {
			editprogram.multipleDelete_checkbox();
		    
		}

		@Then("Programs get selected")
		public void programs_get_selected() {
		    
			editprogram.MultipleDeleteProg();
		}

		@When("Admin clicks on the delete button on the left top of the program page")
		public void admin_clicks_on_the_delete_button_on_the_left_top_of_the_program_page() {
		    
		    
		}

		@Then("Admin lands on Confirmation form")
		public void admin_lands_on_confirmation_form() {
		    
		    
		}

		@Then("Admin can see Programs are still selected and not deleted")
		public void admin_can_see_programs_are_still_selected_and_not_deleted() {
		    
		    
		}
		
		///////////////////////////////////PAGINATION/////////////////////////////////////////

}
