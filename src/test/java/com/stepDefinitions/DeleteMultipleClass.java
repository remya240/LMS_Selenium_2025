package com.stepDefinitions;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.driverManager.DriverFactory;
import com.pages.ClassPages;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utilities.LoggerLoad;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteMultipleClass {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private ClassPages classPage;
    private WebDriverWait wait;
    private String selectedClassName;
    private List<String> selectedClassNames; 

    public DeleteMultipleClass() {
        driver = DriverFactory.getDriver();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        classPage = new ClassPages(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

	/*
	 * @Given("Admin gives the correct LMS portal URL") public void
	 * admin_gives_the_correct_lms_portal_url() { // Implement the logic to navigate
	 * to the LMS portal URL }
	 */

    @When("Admin enters valid data in all fields and clicks the login button")
    public void admin_enters_valid_data_in_all_fields_and_clicks_the_login_button() {
        loginPage.enterLoginDetails();
    }

    @Given("Admin is on the home page")
    public void admin_is_on_the_home_page() {
        LoggerLoad.logInfo("Admin is on the home page");
    }

  
    @Then("Admin should land on the Manage Class page")
    public void admin_should_land_on_the_manage_class_page() {
        LoggerLoad.logInfo("Admin is on Manage Class page");
    }

//    @Given("Admin is in Manage Class page")
//    public void admin_is_in_manage_class_page() {
//        classPage.clickClass(); // Assuming clickClass navigates to the Class page
//        Assert.assertTrue(classPage.isManageClassPageDisplayed(), "Manage Class page is not displayed");
//    }

    @When("Admin clicks any checkbox in the data table")
    public void admin_clicks_any_checkbox_in_the_data_table() {
        try {
            WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='p-checkbox-box']")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
            LoggerLoad.logInfo("Checkbox clicked in the data table.");
        } catch (Exception e) {
            LoggerLoad.error("Failed to click checkbox: " + e.getMessage());
            throw new io.cucumber.java.PendingException("Failed to click checkbox: " + e.getMessage());
        }
    }

    @Then("Admin should see the common delete option enabled under the header Manage Class")
    public void admin_should_see_the_common_delete_option_enabled_under_the_header_manage_class() {
        boolean isDeleteButtonEnabled = classPage.isDeleteButtonEnabled();
        Assert.assertTrue(isDeleteButtonEnabled, "Common delete option is not enabled");
    }

    @When("Admin clicks the checkbox for the class named {string}")
    public void admin_clicks_the_checkbox_for_the_class_named(String classTopic) {
        LoggerLoad.logInfo("Admin clicks the checkbox for the class named: " + classTopic);
        classPage.selectClassCheckbox(classTopic, 3);
        selectedClassName = classTopic;
        LoggerLoad.logInfo("Admin clicked the checkbox for the class named: " + classTopic);

    }

    @When("Admin clicks the common delete button")
    public void admin_clicks_the_common_delete_button() {
        LoggerLoad.logInfo("Admin clicks the common delete button.");
        classPage.clickDeleteButton();
    }

    @Given("Admin is on Confirm Deletion alert")
    public void admin_is_on_confirm_deletion_alert() {
        LoggerLoad.logInfo("Admin is on the Confirm Deletion alert.");
        WebElement confirmAlert = classPage.getConfirmAlert();
        Assert.assertTrue(confirmAlert.isDisplayed(), "Confirm Deletion alert is not displayed.");
    }

    @When("Admin clicks <YES> button on the alert")
    public void admin_clicks_yes_button_on_the_alert() {
        classPage.clickYesButton();
    }

    @Then("Admin should land on Manage Class page and can see the class {string} is deleted from the data table")
    public void admin_should_land_on_manage_class_page_and_can_see_the_class_is_deleted_from_the_data_table(String classTopic) {
        LoggerLoad.logInfo("Admin should land on Manage Class page and can see the class " + classTopic + " is deleted from the data table.");
        Assert.assertTrue(classPage.isManageClassPageDisplayed(), "Manage Class page is not displayed.");
        Assert.assertFalse(classPage.isClassPresentInTable(classTopic), "Class " + classTopic + " is still present in the data table.");
    }
       
    @When("Admin clicks {string} button on the alert")
    public void admin_clicks_button_on_the_alert(String buttonText) {
    	if ("No".equals(buttonText)) {
            classPage.clickNoButton();
        } else if ("Yes".equals(buttonText)) {
            classPage.clickYesButton();
        } else {
            throw new IllegalArgumentException("Invalid button text: " + buttonText);
        }
        LoggerLoad.logInfo("Admin clicked the " + buttonText + " button on the alert.");
    }
    
    
   @Then("Admin should land on Manage Class page and can see the selected class is not deleted from the data table")
   public void admin_should_land_on_manage_class_page_and_can_see_the_selected_class_is_not_deleted_from_the_data_table() {
	   Assert.assertTrue(classPage.isManageClassPageDisplayed(), "Admin did not land on the Manage Class page.");
       Assert.assertTrue(classPage.isClassPresentInTable(selectedClassName), "Selected class " + selectedClassName + " is deleted from the data table.");
       LoggerLoad.logInfo("Admin landed on the Manage Class page and verified that the selected class is not deleted.");
   }
    
   
   @When("Admin selects the checkboxes for the classes {string}")
   public void admin_selects_the_checkboxes_for_the_classes(String classNames) {
	   List<String> classes = Arrays.asList(classNames.split(","));
       selectedClassNames = classes; // Store the selected class names for verification

       // Select checkboxes for each class
       for (String className : classes) {
           classPage.selectClassCheckbox(className.trim(), 3); // Trim to remove any extra spaces
       }
       LoggerLoad.logInfo("Admin selected checkboxes for the classes: " + classNames);
   }
   
   @Then("Admin should land on Manage Class page and can see the selected classes are deleted from the data table")
   public void admin_should_land_on_manage_class_page_and_can_see_the_selected_classes_are_deleted_from_the_data_table() {
	   Assert.assertTrue(classPage.isManageClassPageDisplayed(), "Admin did not land on the Manage Class page.");
       for (String className : selectedClassNames) {
           Assert.assertFalse(classPage.isClassPresentInTable(className.trim()), "Class " + className + " is still present in the data table.");
       }
       LoggerLoad.logInfo("Admin landed on the Manage Class page and verified that the selected classes are deleted.");
   }
   
   @Then("Admin should land on Manage Class page and can see the selected classes are not deleted from the data table")
   public void admin_should_land_on_manage_class_page_and_can_see_the_selected_classes_are_not_deleted_from_the_data_table() {
       // Verify landing on the Manage Class page
       Assert.assertTrue(classPage.isManageClassPageDisplayed(), "Admin did not land on the Manage Class page.");

       // Verify the selected classes are still present in the data table
       for (String className : selectedClassNames) {
           Assert.assertTrue(classPage.isClassPresentInTable(className.trim()), "Class " + className + " is deleted from the data table.");
       }
       LoggerLoad.logInfo("Admin landed on the Manage Class page and verified that the selected classes are not deleted.");
   }  
   
   
   
   
   
}
   
   
   
    

    
    
    
    
    
    
    
    
    

