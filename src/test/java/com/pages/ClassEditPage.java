package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClassEditPage {
	public WebDriver cepdriver;
	 Actions action;
	 WebDriverWait wait = new WebDriverWait(cepdriver, Duration.ofSeconds(20));
	public ClassEditPage(WebDriver driver) {
		cepdriver=driver;
		PageFactory.initElements(driver, this);
		this.action = new Actions(driver);
	}
	//Edit Window
	@FindBy(xpath = "//button[@icon='pi pi-pencil']")
	private WebElement editBtn;
	 @FindBy(xpath = "//span[text()='Class Details']")  
	    private WebElement dialogHeader;
		@FindBy(xpath = "//input[@placeholder='Select a Batch Name']")
		private WebElement batchName;
		@FindBy(xpath = "//input[@id='classTopic']")
		private WebElement classTopic;
		@FindBy(xpath = "//input[@id='classDescription']")
		private WebElement classDescription;
		@FindBy(id = "saveClass")
		private WebElement saveAddClass;
		@FindBy(xpath = "//div[text()='Successful']")
		private WebElement classCreated;
		@FindBy(xpath = "//button[@label='Cancel']")
		@CacheLookup
		private WebElement cancelBtn;
		@FindBy(xpath = "//div[normalize-space()='Manage Class']")
		@CacheLookup
		private WebElement managePage;
		//Optional Field 
		@FindBy(id = "Inactive") 
		private WebElement radioStatusInActive;
		@FindBy(xpath = "//input[@id='classComments']")
		private WebElement classComments;
		@FindBy(xpath = "//input[@id='classNotes']")
		private WebElement notes;
		@FindBy(xpath = "//input[@id='classRecordingPath']")
		private WebElement recording;
					
	 public void clickOnEdit() { 
		    wait.until(ExpectedConditions.elementToBeClickable(editBtn));
		    Actions actions = new Actions(cepdriver);
		    actions.moveToElement(editBtn).click().perform();
		    System.out.println("Edit button clicked in Edit page");
		}
	 public boolean editPopup() {
		    try {
		        WebDriverWait wait = new WebDriverWait(cepdriver, Duration.ofSeconds(10));
		        wait.until(ExpectedConditions.visibilityOf(dialogHeader));
		        return dialogHeader.isDisplayed();
		    } catch (Exception e) {
		        System.out.println("Popup did not appear: " + e.getMessage());
		        return false;
		    }
		}

	public boolean batchNameDisabled() {
		return batchName.isEnabled();
	}

	public boolean classTopicDisabled() {
		return classTopic.isEnabled();
	}

	public void editClassDetails(String editClassDescription) {
	    System.out.println("Editing class description");

	    wait = new WebDriverWait(cepdriver, Duration.ofSeconds(10));

	    WebElement classDescription = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("classDescription")));
	    classDescription.clear();
	    classDescription.sendKeys(editClassDescription);

	    System.out.println("Edited class description");
	}

	public String saveEditClass() {
	    System.out.println("Saving Edited class");
	    WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(saveAddClass));
	    saveButton.click();
	    System.out.println("Saved Edited class");
	    WebElement successMessage = wait.until(ExpectedConditions.visibilityOf(classCreated));
	    return successMessage.getText();
	}

	public void updateOptionalFields(String comments, String Notes, String Recording) {
	    JavascriptExecutor js = (JavascriptExecutor) cepdriver;
	    js.executeScript("arguments[0].scrollIntoView(true);", radioStatusInActive);
	    WebElement inactiveRadioButton = cepdriver.findElement(By.id("Inactive"));
	    	    if (inactiveRadioButton.isDisplayed() && inactiveRadioButton.isEnabled()) {
	        inactiveRadioButton.click();
	    } else {
	        js.executeScript("arguments[0].click();", inactiveRadioButton); 
	    }
	    classComments.clear();
	    classComments.sendKeys(comments);
	    notes.clear();
	    notes.sendKeys(Notes);
	    recording.clear();
	    recording.sendKeys(Recording);
	    saveAddClass.click();
	}
	public boolean cancelDisp() {
		return cancelBtn.isDisplayed();
	}
	public void clickCancelBtn() {
		cancelBtn.click();
	}
	public boolean backOnManagePage() {
		return managePage.isDisplayed();
	}

}
