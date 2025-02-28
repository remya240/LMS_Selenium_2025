package com.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.driverManager.DriverFactory;
import com.pages.ClassDeletePage;

import io.cucumber.java.en.*;

public class ClassDeleteStepDefinition {
    ClassDeletePage cdp = new ClassDeletePage(DriverFactory.getDriver());
   
    @Then("Admin clicks on Delete option for particular class")
    public void admin_clicks_on_delete_option_for_particular_program() {
    	System.out.println("Admin clicks the delete icon");
    	 cdp.clickOnDeleteIcon();
    }

    @Then("Admin should see an alert open with heading {string} along with {string} and {string} buttons for deletion")
    public void admin_should_see_alert_with_buttons(String heading, String yes, String no) {
        System.out.println("Admin should see an alert open");
        Assert.assertTrue("Confirm alert is not displayed", cdp.waitForConfirmAlert());
        Assert.assertTrue("YES button is missing", cdp.isYesButtonDisplayed());
        Assert.assertTrue("NO button is missing", cdp.isNoButtonDisplayed());
    }
    @When("Admin clicks yes option")
    public void admin_clicks_yes_option() { 
    	  System.out.println("Admin click yes Option");
    	cdp.confirmDeletion();
    	System.out.println("Admin clicked yes Option");
    }


    @Given("Admin is on Confirm Deletion alert")
    public void admin_is_on_confirm_deletion_alert() {
        Assert.assertTrue("Confirm deletion alert is not displayed", cdp.isConfirmAlertDisplayed());
    }

    @When("Admin clicks the {string} option")
    public void admin_clicks_option(String option) {
    	cdp.cddriver.navigate().refresh();
    	System.out.println("Admin clicks on YES ");
        if (option.equalsIgnoreCase("YES")) {
            cdp.confirmDeletion();
        } else if (option.equalsIgnoreCase("NO")) {
        	System.out.println("Admin clicks on NO ");
            cdp.cancelDeletion();
            System.out.println("Admin clicked on NO ");
        }
    }

    @Then("Admin gets a message {string} alert")
    public void admin_sees_successful_deletion_alert(String expectedMessage) {
        System.out.println("Admin gets Success message");
        Assert.assertTrue(cdp.isSuccessAlertDisplayed());
        String actualMessage = cdp.getSuccessAlertText();
        Assert.assertEquals(actualMessage, expectedMessage, "Successful");
        System.out.println("Admin got Success message: " + actualMessage);
    }


    @Then("Admin can see the deletion alert disappears without deleting")
    public void admin_sees_alert_disappears_without_deleting() {
    	System.out.println("Admin can see the deletion alert disappears");
        Assert.assertFalse("Deletion alert is still visible", cdp.isConfirmAlertDisplayed());
        System.out.println("Admin can see the deletion alert disappeared");
    }

    @When("Admin clicks on the close button")
    public void admin_clicks_on_close_button() {
        cdp.closeDeletionAlert();
    }

    @Then("Admin can see the deletion alert disappears without any changes")
    public void admin_sees_alert_disappears_without_changes() {
        Assert.assertFalse("Deletion alert is still visible", cdp.isConfirmAlertDisplayed());
  
    }
}
