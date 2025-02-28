package com.pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
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

import com.constants.EnvironmentConstants;
import com.driverManager.DriverFactory;
import com.utilities.CommonMethods;
import com.utilities.ExcelReader;


public class EditProgramPage {
	@CacheLookup
	public WebDriver edriver;
	private String programNamedata;
	CommonMethods utility = new CommonMethods();
	ExcelReader readdata = new ExcelReader();
	EnvironmentConstants constants = new EnvironmentConstants();
	ProgramAddPage programadd = new ProgramAddPage(DriverFactory.getDriver());
	Actions action ;
	@FindBy (css="#editProgram") public WebElement editProgButton;
	//@FindBy (xpath="//button[@id='editProgram']") private WebElement editProgButton;
	@FindBy (xpath= "//span[text()='Program Details']") private WebElement programDetails;
	//@FindBy (xpath="//span[@style='color: red !important;']") private WebElement redAsterisk;
	@FindBy(xpath="") WebElement redAsterisk;
	@FindBy (xpath="//div//div[1]//table//tbody//tr//td[2][text()]") private WebElement editedProgName;
	@FindBy (xpath ="//table//tbody//tr//td//button[@id='editProgram']") private WebElement EditButton;
	@FindBy (xpath="//table//tbody//tr//td[3][text()]") private WebElement updatedDescription;
	@FindBy (xpath= "//div[text()=' Active ']/p-radiobutton") public WebElement Activebutton;
	@FindBy (xpath= "//div[text()=' Inactive ']/p-radiobutton") public WebElement Inactivebutton;
	
	//delete
	@FindBy (css="#deleteProgram") public WebElement deleteProgButton;
	@FindBy (xpath= "//button//span[text()='Yes']") private WebElement yesbuttondelete;
	@FindBy (xpath= "//button//span[text()='No']") private WebElement Nobuttondelete;
	@FindBy (xpath="//div//span[contains(@class,'p-dialog-title')]") private WebElement deleteDialogueBox;
	@FindBy (xpath="//div[contains(@class,'p-dialog-header-icons')]") private WebElement xbutton;
	// @FindBy(xpath = "//div/p-toastitem/div/div/div")private WebElement successdelete;
	@FindBy(className="p-confirm-dialog-messag")private WebElement successdelete;
	@FindBy (xpath= "//span[text()='Showing 0 to 0 of 0 entries']") public WebElement zeroResults;
	//multiple delete 
	@FindBy(xpath = "//tr[1]/td[1]/p-tablecheckbox/div/div[2]")private WebElement checkBox1;
	@FindBy(xpath = "//tr[2]/td[1]/p-tablecheckbox/div/div[2]")private WebElement checkBox2;	
	@FindBy(xpath = "//div/div/div[3]/button[2]/span[2]")private WebElement multiDeleteYes;
	@FindBy(xpath = "//div[2]/div[1]/button/span[1]")private WebElement twoProgramDeleteButton;
	
	public EditProgramPage (WebDriver driver) {
		this.action=new Actions(driver);
		edriver =driver;
		PageFactory.initElements(driver,this);
		
	}
	
	public void editButtonInManageprogram() {

		action.doubleClick(editProgButton).perform();
	}
	public void programMenudoubleclick() throws FileNotFoundException, IOException {
		utility.waitForElement(programadd.programmenu);
           programadd.searchProgram();
		
		editButtonInManageprogram();
		
		action.click(programadd.programmenu).perform();
	}
	
	public boolean landedOnEditProgramWindow() {
		
		 return utility.isElementDisplayed(programDetails);
	}
	public boolean isRedAsteriskDisplayed() {
		 utility.assertText(redAsterisk, "*", "Mandatory field is not displayed ");
		return false;
    }
	
	public void mandetoryfieldstar() {
    	String Color=redAsterisk.getCssValue("color");
    	System.out.println("Star is present with color"+Color);
    }
//	public void openEditwindow() throws FileNotFoundException, IOException, InterruptedException {
//		
//		String searchactual =programadd.searchProgram();
//				utility.ClickOnWebelement(EditButton);--- this is not clicking
//		//action.scrollToElement(editProgButton).click();
//		System.out.println(searchactual);
//	}
	
	public String editProgramNameField() throws FileNotFoundException, IOException  {
		
		Map<String, List<String>> progdata = readdata.getData("Positive","Program");
		String programNamedata = progdata.get("EDIT_PROGRAM_NAME").get(0);
		
		programadd.programNamefield.clear();
		programadd.programNamefield.sendKeys(programNamedata);
		System.out.println(programNamedata);
		return programNamedata;

		}
	public String geteditedProgramName() throws FileNotFoundException, IOException, InterruptedException {
		programMenudoubleclick();
		programadd.clearSearchText();
		utility.waitForElement(programadd.searchtextBar);
		Map<String, List<String>> progdata = readdata.getData("Positive","Program");
		String programNamedata = progdata.get("EDIT_PROGRAM_NAME").get(0);
		programadd.searchtextBar.sendKeys(programNamedata);
		return editedProgName.getText();
		
	}
		
	public String editProgramDescription() throws FileNotFoundException, IOException  {
		Map<String, List<String>> descdata = readdata.getData("Positive","Program");
		String Descriptiondata = descdata.get("EDIT_PROGRAM_DESCRIPTION").get(0);
		programadd.programDescription.clear();
		programadd.programDescription.sendKeys(Descriptiondata);
		return Descriptiondata;
	}
	
	public String geteditedDescription() throws FileNotFoundException, IOException {
		programadd.clearSearchText();
		utility.waitForElement(programadd.searchtextBar);
		//programadd.searchtextBar.sendKeys(programadd.getProgramData());
		Map<String, List<String>> descdata = readdata.getData("Positive","Program");
		String Descriptiondata = descdata.get("EDIT_PROGRAM_DESCRIPTION").get(0);
		programadd.searchtextBar.sendKeys(Descriptiondata);
		return updatedDescription.getText();
			
	}
	 public void changeStatusOfRadioButton() {
	    	if(Activebutton.isEnabled()) {
	    		Inactivebutton.click();
	    	}
	    	else if(Inactivebutton.isEnabled()){
	    		Activebutton.click();
	    	}
	    	
	 }
	///////////////////////////////////////////////////
	//Delete Program
	public void clickDeleteButton() throws FileNotFoundException, IOException {
		programadd.clearSearchText();
		programadd.searchProgram();
		action.doubleClick(deleteProgButton).perform();
	}
	 public String deletePopupWindow() {
		return deleteDialogueBox.getText();
	 }
	 
	 
	public void deleteProgram() throws FileNotFoundException, IOException {
	
	
		programadd.clearSearchText();
		programadd.searchProgram();
		action.doubleClick(deleteProgButton).perform();
		yesbuttondelete.click();
		
	}
	public boolean programdeletePopup1() {
			   
			WebDriverWait wait = new WebDriverWait(edriver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.invisibilityOf(successdelete));
			return false;
		}
	public void gettextOfZeroResults() throws FileNotFoundException, IOException {
		programadd.clearSearchText();
		programadd.searchProgram();
		utility.getElementText(zeroResults);
	
	 }
	 public void multipleDelete_checkbox() {
		utility.ClickOnWebelement(checkBox1);	
		 
		utility.ClickOnWebelement(checkBox2);	
		
		 utility.ClickOnWebelement(twoProgramDeleteButton);			 
		
		 
	 	 }	 
	
	 public void MultipleDeleteProg() {
			System.out.println("befor cliking delete" + multiDeleteYes.getText());
			multiDeleteYes.click();
			System.out.println("after cliking delete");
	 }

}