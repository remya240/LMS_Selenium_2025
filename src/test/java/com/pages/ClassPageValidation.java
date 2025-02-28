package com.pages;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClassPageValidation {
	 public WebDriver cpvdriver;
	 Actions action;
	 WebDriverWait wait = new WebDriverWait(cpvdriver, Duration.ofSeconds(20));
	 
	 public ClassPageValidation(WebDriver driver) {
		 cpvdriver=driver;
		  PageFactory.initElements(driver, this);
			this.action = new Actions(driver);
		}
	 @FindBy(xpath= "//span[text()='Class']")
	 @CacheLookup
	 private WebElement classBtnOnManagePage;
	 @FindBy(xpath="//div[text()=' Manage Class']")
	 @CacheLookup
	 private WebElement ManageClassText;

	 private String ClassUrl="https://feb-ui-hackathon-bbfd38d67ea9.herokuapp.com/session";

	 public void clickNavigationBarClass(String moduleName) {
		    if ("Class".equalsIgnoreCase(moduleName)) {
		    	classBtnOnManagePage.click();
		    }
		}

	 public boolean validateNavBarClassNav(String moduleName) {
		 boolean result=false;
			switch(moduleName) {
			case"Program":
				result=cpvdriver.getCurrentUrl().equalsIgnoreCase(ClassUrl);
				break;
			}
			return result;
		}
	
	 @FindBy (xpath="//button[contains(@class, 'mat-menu-trigger')]")
	 @CacheLookup
	 private WebElement classclickbtn;	 
	 @FindBy(xpath="//span[text()='Class']")
	 @CacheLookup
	 private WebElement classBtn;
	 @FindBy(xpath = "//span[text()=' LMS - Learning Management System ']")
	 @CacheLookup
		private WebElement appHeader;
	 @FindBy(xpath="//div[text()=' Manage Class']")
	 @CacheLookup
	 private WebElement manageClassHeader;
	 @FindBy(xpath = "//th[text()=' Batch Name ']")
	 @CacheLookup
		private WebElement batchNameHeader;
	 @FindBy(xpath = "//th[text()='Class Topic ']")
	 @CacheLookup
		private WebElement classTopicHeader;
	 @FindBy(xpath = "//th[text()='Class Description ']")
	 @CacheLookup
		private WebElement classDescriptionHeader;
	 @FindBy(xpath = "//th[text()=' Status ']")
	 @CacheLookup
		private WebElement statusHeader;
	 @FindBy(xpath = "//th[text()=' Class Date ']")
	 @CacheLookup
		private WebElement classDateHeader;
	 @FindBy(xpath = "//th[text()=' Staff Name ']")
	 @CacheLookup
		private WebElement staffNameHeader;
	 @FindBy (xpath= "//th[contains(text(),'Edit / Delete')]")
	 @CacheLookup
	 private WebElement editDeleteHeader;
	 @FindBy(css = ".p-paginator-current.ng-star-inserted")
	 @CacheLookup
		private WebElement showingEnteries;
	 @FindBy(xpath = "//p-sorticon[@field='batchName']")
	 @CacheLookup
		private WebElement sortBatchNameBtn;
	 @FindBy(className = "p-sortable-column-icon")
	 @CacheLookup
		private List<WebElement> sortingBtn;
	 @FindBy(css = "button[class='p-button-danger p-button p-component p-button-icon-only']")
	 @CacheLookup
		private WebElement deleteAllBtn;
	 @FindBy(css = ".p-datatable-footer.ng-star-inserted")
	 @CacheLookup
		private WebElement footer;
	 
	 public void classClick() {
		 wait =new WebDriverWait(cpvdriver, Duration.ofSeconds(20));
		 System.out.println("It is on click class btn");
		 classBtn.click();
		 System.out.println("It clicked class btn");
	 }

	 public WebElement getHeaderElement(String headerName) {
			switch (headerName) {
			case "LMS - Learning Management System":
				return appHeader;
			case "Manage class":
				return manageClassHeader;
			case "Batch Name":
				return batchNameHeader;
			case "Class Topic":
				return classTopicHeader;
			case "Class Description":
				return classDescriptionHeader;
			case "Status":
				return statusHeader;
			case "Class Date":
				return classDateHeader;
			case "Staff Name":
				return staffNameHeader;
			case "Edit / Delete":
				return editDeleteHeader;
			default:
				 throw new IllegalArgumentException("Invalid header name: " + headerName);
			}		
		}
	 public boolean validateShowingEnteries() {
			return showingEnteries.isDisplayed();
		}
	 public boolean validateFooter() {
			return footer.isDisplayed();
	 }
	 public boolean validateSortingBtn() {
		    return sortingBtn.stream().anyMatch(WebElement::isDisplayed);
		}
	 public boolean deleteBtnDisplayed() {
			return deleteAllBtn.isDisplayed();
		}
	 public boolean validateHeader(WebElement headerElement, String expectedHeader) {
		    if (headerElement == null) {
		        throw new IllegalArgumentException("Header element is null for: " + expectedHeader);
		    }
		    
		    if (!headerElement.isDisplayed()) {
		        System.out.println("Header element is not displayed: " + expectedHeader);
		        return false;
		    }
		    
		    String actualHeaderText = headerElement.getText().trim();
		    return actualHeaderText.equals(expectedHeader);
		}
				
			
}



