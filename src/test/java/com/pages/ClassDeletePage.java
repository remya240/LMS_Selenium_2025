package com.pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.netty.handler.timeout.TimeoutException;

public class ClassDeletePage {
	public WebDriver cddriver;
	       WebDriverWait wait;
	
	public ClassDeletePage(WebDriver driver) {
		cddriver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath= "(//div[@class='action']//button)[2]")
	private WebElement deleteBtn;
	@FindBy(xpath = "//p-confirmdialog//button[contains(.,'Yes')]")
	private WebElement yesOption;
	@FindBy(xpath = "//p-confirmdialog//button[contains(.,'No')]")
	private WebElement noOption;
	@FindBy(xpath = "//div[text()='Successful']")
	private WebElement classDeleted;
	@FindBy(xpath = "//table/tbody/tr[1]/td[1]//p-tablecheckbox//div[2]")
	private WebElement checkbox1;
	@FindBy(xpath="//span[contains(text(),'Are you sure you want to delete')]")
	private WebElement ConfirmDialog;
	
	public void clickOnDeleteIcon() {
		Actions actions = new Actions(cddriver);
		actions.doubleClick(deleteBtn).perform();
	}
	public boolean isYesButtonDisplayed() {
		return yesOption.isDisplayed();
	}
	public boolean isNoButtonDisplayed() {
		return noOption.isDisplayed();
		}
	public void confirmDeletion() {
	    wait = new WebDriverWait(cddriver, Duration.ofSeconds(10));
	    WebElement yesBtn = wait.until(ExpectedConditions.elementToBeClickable(yesOption));
	    yesBtn.click();
	}
	public boolean waitForConfirmAlert() {
	    wait = new WebDriverWait(cddriver, Duration.ofSeconds(10));
	    try {
	        wait.until(ExpectedConditions.visibilityOf(ConfirmDialog));
	        return true;
	    } catch (TimeoutException e) {
	        return false;
	    }
	}
	public void cancelDeletion() {
		 try {
	            WebElement noButton = wait.until(ExpectedConditions.elementToBeClickable(noOption));
	            noButton.click();
	        } catch (Exception e) {
	            System.out.println("Error: 'No' button was not found or clickable - " + e.getMessage());
	        }
	}
	
	
	
	
	
	
	
	
	
	
	
	public String  getAlertHeading() {
		yesOption.click();
		String alert= classDeleted.getText();
		System.out.println(alert);
		return alert;
	}
	public void DropDeleteSingleProgram() {
		noOption.click();
	}
	public void SelectCheckBoxes() {
		Actions actions = new Actions(cddriver);
		actions.doubleClick(checkbox1).perform();
		checkbox1.click();
		System.out.println("Check box clicked");
	}
	public boolean isConfirmAlertDisplayed() {
	     wait = new WebDriverWait(cddriver, Duration.ofSeconds(10));
	    try {
	        wait.until(ExpectedConditions.visibilityOf(ConfirmDialog));
	        return ConfirmDialog.isDisplayed();
	    } catch (TimeoutException e) {
	        return false;
	    }
	}

	


	

//	public boolean isDeletionSuccessful() {
//	    try {
//	         wait = new WebDriverWait(cddriver, Duration.ofSeconds(10));
//	        WebElement successMsg = wait.until(ExpectedConditions.visibilityOf(successDelete));
//	        return successMsg.isDisplayed();
//	    } catch (TimeoutException e) {
//	        return false;
//	    }
//	}

	public void closeDeletionAlert() {
		
		
	}
	
	
    public boolean isSuccessAlertDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(classDeleted));
            return classDeleted.isDisplayed();
        } catch (NoSuchElementException e) {
            return false; 
        }
    }

   
    public String getSuccessAlertText() {
        try {
            wait.until(ExpectedConditions.visibilityOf(classDeleted));
            return classDeleted.getText();
        } catch (NoSuchElementException e) {
            return ""; 
        }
    }
	}


