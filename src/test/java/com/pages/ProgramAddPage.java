package com.pages;

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.constants.EnvironmentConstants;
import com.utilities.CommonMethods;
import com.utilities.ExcelReader;
//import com.utilities.TestContext;

public class ProgramAddPage {
	public WebDriver pdriver;
	private WebDriverWait wait;
	private Actions action;
	JavascriptExecutor js;
	CommonMethods utility = new CommonMethods();
	
	//private TestContext testcontext;

//	 public ProgramAddPage(WebDriver driver,TestContext testcontext){
//	        this.driver = driver;
//	  	    this.actions= new Actions(driver);
//	        this.testcontext=testcontext;
//	        PageFactory.initElements(driver, this);
//	    }
	
	 @FindBy (id="program") public WebElement programmenu;
	 @FindBy (xpath= "//button[text()='Add New Program']") private WebElement addnewprogram;
	 @FindBy (xpath= "//span[text()=\"Program Details\"]") private WebElement programDetails;
	 @FindBy (id="saveProgram") private WebElement savebutton;
	 @FindBy (xpath= "//small[text()='"+"fieldName"+"']") private List<WebElement> allErrorMessages;
	 @FindBy (id="programName") public WebElement programNamefield;
	 
	 @FindBy (id="programDescription") public WebElement programDescription;
	 @FindBy (xpath= "//div[text()=' Active ']/p-radiobutton") public WebElement Activebutton;
	 @FindBy (xpath= "//div[text()=' Inactive ']/p-radiobutton") public WebElement Inactivebutton;
	 @FindBy (xpath= "//div//input[@value='Active']") public WebElement getactivebutton;
	 @FindBy (xpath= "//div//input[@value='Inactive']") public WebElement getInactivebutton;
	//div[text()='Successful']
	 @FindBy (xpath= "//div[text()='Program Created Successfully']") private WebElement programsuccessful;
	 @FindBy(id = "filterGlobal") public WebElement searchtextBar;
	 @FindBy(xpath = "//span[contains(@class,'p-dialog-header-close-icon')]") public WebElement xbutton;
	 

	    @FindBy(xpath = "//span[text()='Cancel']")
	    public WebElement cancelButton;
	 @CacheLookup
	ExcelReader readdata = new ExcelReader();
	EnvironmentConstants constants = new EnvironmentConstants();
	public ProgramAddPage(WebDriver driver) {
	pdriver=driver;
		PageFactory.initElements(driver, this);
		this.action=new Actions(driver);
		
	}
	
	 public void clickOnProgrammenu(String module) {
		 this.js = (JavascriptExecutor) pdriver;
//		 //utility.ClickOnWebelement(programmenu);
		 js.executeScript("arguments[0].click();", programmenu);
//       System.out.println("Clicked on Active status using JavaScript Executor.");
		 //action.moveToElement(programmenu).click();
		 
		 
	 System.out.println("entered program page");
	 
		 
	 }
	 
	 public void clickOnsubmenu(String submenu) {
	  //utility.ClickOnWebelement(addnewprogram);
     	//action.moveToElement(Activebutton);
		 utility.waitForElement(addnewprogram);
		 this.js = (JavascriptExecutor) pdriver;
		 js.executeScript("arguments[0].click();", addnewprogram);
		
		 //addnewprogram.click();
	 }
	 
	 public String getPopupWindowTitle() {
		 return programDetails.getText();
				  
	 }
	 public void clickSavebutton() {
		// savebutton.click();
		 utility.ClickOnWebelement(savebutton);
	 }
	 
	 public String getRequiredFieldMessage(String fieldName) {
		    for (WebElement message : allErrorMessages) {
		        if (message.getText().equals(fieldName)) {
		            return message.getText();
		        }
		    }
		    return fieldName;
		}
	 
public String enterProgramName() throws FileNotFoundException, IOException {
	Map<String, List<String>> progdata = readdata.getData("Positive","Program");
	String programNamedata = progdata.get("PROGRAM_NAME").get(0);
	//programNamefield.clear();
	utility.waitForElement(programNamefield);
	programNamefield.click();
	programNamefield.sendKeys(programNamedata);
	return programNamedata;

}
public String getProgramData() throws FileNotFoundException, IOException {
	 String ProgramNameData =enterProgramName();
	 return ProgramNameData;
}
public String getProgramName() {
    return utility.getElementAttribute(programNamefield,"ng-reflect-model");
}

public String enterDescription() throws FileNotFoundException, IOException {
	
	Map<String, List<String>> descdata = readdata.getData("Positive","Program");
	String programDesc = descdata.get("PROGRAM_DESCRIPTION").get(0);
	//programDescription.clear();
	utility.waitForElement(programDescription);
	programDescription.click();
	programDescription.sendKeys(programDesc);
	return programDesc;
	
}
public String getprogramDescription() {
    return utility.getElementAttribute(programDescription,"ng-reflect-model");
}
public void selectstatusActive() {
//	//action.click(Activebutton).perform();
	//this.js = (JavascriptExecutor) pdriver;
//	 
//    js.executeScript("arguments[0].scrollIntoView(true);", Activebutton);
//	 try {
//		 Activebutton.click();
//         System.out.println("Clicked on Active status using Selenium click().");
//    } catch (Exception e) {
//         js.executeScript("arguments[0].click();", Activebutton);
//        System.out.println("Clicked on Active status using JavaScript Executor.");
//     }
// 
//	utility.waitForElement(Activebutton);
	//action.click(Activebutton);
	utility.ClickOnWebelement(Activebutton);
}

public String getActiveStatus() {
    return utility.getElementAttribute(getactivebutton,"ng-reflect-value");
}

public void selectstatusInActive() {
	Inactivebutton.click();
}
public String getInactiveStatus() {
	  return utility.getElementAttribute(getInactivebutton,"ng-reflect-value");
}

	public void selectStatusRadioButton(String status) {
	    if (status.equalsIgnoreCase("Active")) {
	    	Activebutton.click();
	    } else if (status.equalsIgnoreCase("InActive")) {
	    	Inactivebutton.click();
	    }
			
}

public String getSelectedStatus() {
	if (getactivebutton.isSelected()) {
		return "Active";
	}else if (getInactivebutton.isSelected())
	{
		return "InActive";
	}else {
	return "none selected";
}
}

public String getsuccessMessage() {
	return utility.getElementText(programsuccessful);
	
	}

public String validateSearch() {
	searchtextBar.sendKeys("teamten");
	String placeholderText = searchtextBar.getDomProperty("placeholder");
	return placeholderText;
	
}


public String searchProgram() throws FileNotFoundException, IOException {
	
	Map<String, List<String>> search = readdata.getData("Positive","Program");
	String searchprogram = search.get("PROGRAM_NAME").get(0);
	
	//action.scrollToElement(searchtextBar).doubleClick().perform();
	 utility.waitForElement(searchtextBar);
	 searchtextBar.clear();
	 searchtextBar.sendKeys(searchprogram);
	 return searchprogram;
}

public String searchDescription() throws FileNotFoundException, IOException {
	Map<String, List<String>> search = readdata.getData("Positive","Program");
	String searchDesc = search.get("PROGRAM_DESCRIPTION").get(0);
	//action.scrollToElement(searchtextBar).doubleClick().perform();
	 searchtextBar.clear();
	 utility.waitForElement(searchtextBar);
	 searchtextBar.sendKeys(searchDesc);
	 return searchDesc;
}



public void clearSearchText() {
	searchtextBar.clear();
}
public void clickCancelButton() {
	cancelButton.click();
}
	 
public void verifyAddProgramDisappeared() {
	try {
		//this is to make sure that cancel button is disappeared
		Thread.sleep(1000);
		cancelButton.isDisplayed();
	} catch (Exception e) {
		Assert.assertTrue(true, "Add program is not displayed");
		return;
	}
	Assert.assertTrue(false, "Add program is still displaying");
}

public void clickXButton() {
	utility.ClickOnWebelement(xbutton);
}
public void verifyProgramDetailsFormDisappeared() {
	try {
		//this is to make sure that cancel button is disappeared
		Thread.sleep(1000);
		xbutton.isDisplayed();
	} catch (Exception e) {
		Assert.assertTrue(true, "Add program is not displayed");
		return;
	}
	Assert.assertTrue(false, "Add program is still displaying");
}

	 
	 }

	
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 

