package com.pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.EnvironmentConstants;
import com.utilities.ExcelReader;

public class ClassAddNewPage {
	public WebDriver candriver;
	Actions action;
	 ExcelReader excel=new ExcelReader();
	WebDriverWait wait = new WebDriverWait(candriver, Duration.ofSeconds(20));
	public ClassAddNewPage(WebDriver driver) {
		candriver = driver;
		PageFactory.initElements(driver, this);
		this.action = new Actions(driver);
	}

	String search;
	String classBatchName;
	String noofClasses;
	String classDate;
	String classTopic1;
	String staffName1;
	String classDescription1;
	String classStatus;
	String classComments1;
	String classNotes;
	String classRecordings;

	@FindBy(xpath = "//button[text()='Add New Class']")
	@CacheLookup
	private WebElement addNewClassBtn;
	@FindBy(xpath = "//button[@label='Cancel']")
	@CacheLookup
	private WebElement cancelBtn;
	@FindBy(xpath = "//button[@label='Save']")
	@CacheLookup
	private WebElement saveBtn;
	@FindBy(css = ".p-dialog-header-close")
	@CacheLookup
	private WebElement crossBtn;
	@FindBy(xpath = "//label[text()='Batch Name']")
	@CacheLookup
	private WebElement batchNamePopup;
	@FindBy(xpath = "//label[text()='Class Topic ']")
	@CacheLookup
	private WebElement classTopicPopup;
	@FindBy(xpath = "//div[normalize-space()='Manage Class']")
	@CacheLookup
	private WebElement managePage;
	@FindBy(xpath = "//button[contains(@class, 'mat-menu-trigger')]")
	@CacheLookup
	private WebElement classclickbtn;
	@FindBy(xpath = "//span[text()='Class']")
	@CacheLookup
	private WebElement classBtn;

	// Mandatory Fields
	@FindBy(xpath = "//input[@placeholder='Select a Batch Name']")
	private WebElement batchNameDrpdw;
	@FindBy(xpath = "//input[@id='classTopic']")
	private WebElement classTopicTextBox;
	@FindBy(xpath = "//input[@id='classDescription']")
	private WebElement classDescriptionTextBox;
	@FindBy(xpath = "//input[@id='icon']")
	private WebElement datePicker;
	@FindBy(xpath = "//span[@class='p-button-icon pi pi-calendar']")
	private WebElement calenderBtn;
	@FindBy(xpath = "//label[normalize-space()='Staff Name']")
	private WebElement staffnameheader;
	@FindBy(className = "p-datepicker-month")
	private WebElement month;
	@FindBy(className = "pi-chevron-right")
	private WebElement nextMonth;
	@FindBy(xpath = "//*[contains(@class, 'pi-chevron-right')]")
	private WebElement nextMonthContains;
	@FindBy(xpath = "//input[@id='classNo']")
	private WebElement noOfClasses;
	@FindBy(xpath = "//input[@placeholder='Select a Staff Name']")
	private WebElement staffNameBoxt;
	@FindBy(xpath = "//label[text()='No of Classes']")
	private WebElement noOfClassesHeader;
	@FindBy(xpath = "//input[@id='classNo']")
	private WebElement noOfClassesTextBox;
	@FindBy(className = "p-radiobutton-box")
	private WebElement statusActive;
	@FindBy(xpath = "//div[@class='p-radiobutton-box p-highlight']")
	private WebElement statusInActive;
	@FindBy(xpath = "//p-dropdownitem[@class='ng-tns-c88-37 ng-star-inserted']")
	private List<WebElement> batchNameList;
	@FindBy(xpath = "//div[text()='Successful']")
	private WebElement classCreated;
	@FindBy(xpath = "//*[@id=\"batchName\"]/div/div[3]/div/ul/p-dropdownitem[1]/li")
	private WebElement BatchNameDropDown;
	@FindBy(xpath = "//span[@class='p-dropdown-trigger-icon ng-tns-c88-45 pi pi-chevron-down']")
	private WebElement BatchNameDropDown1;
	@FindBy(xpath = "//li[@role='option']")  
	 private List<WebElement> batchOptions;
	@FindBy(xpath = "//td[@ng-reflect-ng-class='[object Object]']")
	private List<WebElement> dateSelect;
	   @FindBy(xpath = "//Span[@class='p-button-icon pi pi-calendar']")
	    private WebElement calendarCloseButton;
	   @FindBy(id = "saveClass")
		private WebElement saveAddClass;

	// optional fields
	@FindBy(xpath = "//input[@id='classComments']")
	private WebElement classCommentsTextBox;
	@FindBy(xpath = "//input[@id='classNotes']")
	private WebElement notes;
	@FindBy(xpath = "//input[@id='classRecordingPath']")
	private WebElement recording;

	// required fields

	@FindBy(xpath = "//small[normalize-space()='Batch Name is required.']")
	private WebElement batchNameReq;
	@FindBy(xpath = "//small[normalize-space()='Class Topic is required.']")
	private WebElement classTopicReq;
	@FindBy(xpath = "//small[normalize-space()='Class Date is required.']")
	private WebElement classDateReq;
	@FindBy(xpath = "//small[normalize-space()='Staff Name is required.']")
	private WebElement staffNameReq;
	@FindBy(xpath = "//small[normalize-space()='No. of Classes is required.']")
	private WebElement noOfClassesReq;
	@FindBy(xpath = "//button[contains(@class,'p-paginator-first')]")
	private WebElement calenderClose;
	
	
	


	public void clickAddNewClass() {
		try {
			WebDriverWait wait = new WebDriverWait(candriver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(addNewClassBtn)).click();
			addNewClassBtn.click();

			System.out.println("It is on the classpage_add class btn");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public boolean saveDisp() {
		return saveBtn.isDisplayed();
	}

	public boolean crossBtnDisp() {
		return crossBtn.isDisplayed();
	}

	public boolean batchNameOnPopupDisp() {
		WebDriverWait wait = new WebDriverWait(candriver, Duration.ofSeconds(20));
		JavascriptExecutor js = (JavascriptExecutor) candriver;
		js.executeScript("arguments[0].click();", batchNamePopup);
		return batchNamePopup.isDisplayed();
	}

	public boolean classTopicOnPopupDisp() {
		JavascriptExecutor js = (JavascriptExecutor) candriver;
		js.executeScript("arguments[0].click();", classTopicPopup);
		return classTopicPopup.isDisplayed();
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

	public void classClick() {
		System.out.println("It is on click class btn");
		classBtn.click();
		System.out.println("It clicked class btn");
	}

	public void readclassdata() throws FileNotFoundException, IOException {
		 excel = new ExcelReader();
		Map<String, List<String>> testdata = excel.getData("Positive", "Login");
		classBatchName = testdata.get("CBATCH_NAME").get(2);
		noofClasses = testdata.get("NO_OF_CLASSES").get(2);
		classDate = testdata.get("CLASS_DATE").get(2);
		classTopic1 = testdata.get("CLASS_TOPIC").get(2);
		staffName1 = testdata.get("STAFF_NAME").get(2);
		classDescription1 = testdata.get("CLASS_DESCRIPTION").get(2);
		classStatus = testdata.get("CLASS_STATUS").get(2);
		classComments1 = testdata.get("CLASS_COMMENTS").get(2);
		classNotes = testdata.get("CLASS_NOTES").get(0);
		classRecordings = testdata.get("CLASS_RECORDINGS").get(2);
	}



	public String addingMandatoryFields(String batchName, String ClassTopic, String ClassDescription, String month,
			String date1, String date2, String StaffName, String Status) throws InterruptedException {
		batchNameDrpdw.click();
		System.out.print("Drop down selected");
		batchNameDrpdw.sendKeys(batchName);
		System.out.print("batch entered");
		classTopicTextBox.click();
		System.out.print("ClassTopic clicked");
		classTopicTextBox.sendKeys(ClassTopic);
		System.out.print("ClassTopic sent");
		classDescriptionTextBox.click();
		System.out.print("classDescription box clicked");
		classDescriptionTextBox.sendKeys(ClassDescription);
		System.out.print("classDescription sent");
		selectNoOfClasses(month, date1, date2);
		JavascriptExecutor js = (JavascriptExecutor) candriver;
		js.executeScript("arguments[0].scrollIntoView(true);", noOfClasses);
		System.out.print("Date selected");
		staffNameBoxt.click();
		System.out.print("Staffname clicked");
		staffNameBoxt.sendKeys(StaffName);
		System.out.print("staff name entered");
		if (Status.equals("Active")) {
			statusActive.click();
			System.out.print("Active selected");
		} else {
			statusInActive.click();
			System.out.print("Inactive selected");
		}
		saveBtn.click();
		System.out.print("Save Clicked ");

		return classCreated.getText();
	
}
	public void noOfClasses(String Month, String date1, String date2) {

		datePicker.click();
		do {
			nextMonth.click();
		} while (!month.getText().contains(Month));
		for (int i = 0; i < dateSelect.size(); i++) {
			List<WebElement> dates = candriver.findElements(By.xpath("//td[@ng-reflect-ng-class='[object Object]']"));
			String text = dates.get(i).getText();
			if (text.equalsIgnoreCase(date1) || text.equalsIgnoreCase(date2)) {
				dates.get(i).click();
			}
		}
		noOfClassesHeader.click();
//		try {
//			calenderClose.click();
//	    } catch (Exception e) {
//	        JavascriptExecutor js = (JavascriptExecutor) candriver;
//	        js.executeScript("arguments[0].click();", calendarCloseButton);
//	    }
	}
	
	
	public void selectNoOfClasses(String Month, String date1, String date2) {
	    WebDriverWait wait = new WebDriverWait(candriver, Duration.ofSeconds(5));

	    wait.until(ExpectedConditions.elementToBeClickable(datePicker)).click();

	    while (!month.getText().contains(Month)) {
	        nextMonth.click();
	    }

	    for (WebElement date : dateSelect) {
	        String text = date.getText();
	        if (text.equalsIgnoreCase(date1) || text.equalsIgnoreCase(date2)) {
	            wait.until(ExpectedConditions.elementToBeClickable(date)).click();
	        }
	    }

	    try {
	        wait.until(ExpectedConditions.elementToBeClickable(calendarCloseButton)).click();
	    } catch (Exception e) {
	        JavascriptExecutor js = (JavascriptExecutor) candriver;
	        js.executeScript("arguments[0].click();", calendarCloseButton);
	    }

	    wait.until(ExpectedConditions.elementToBeClickable(noOfClassesHeader)).click();
	}

	public void checkUpdatedClasses() {
	    String value = noOfClassesTextBox.getText().trim();
	    if ("2".equals(value)) {
	        System.out.println("No. of classes updated as expected.");
	    } else {
	        System.out.println("Validation failed");
	    }
	}

	public void selectOptionalFields(String comments, String Notes, String Recording) {
		JavascriptExecutor js = (JavascriptExecutor) candriver;
		js.executeScript("arguments[0].scrollIntoView(true);", statusInActive);
		classCommentsTextBox.sendKeys(comments);
		notes.sendKeys(Notes);
		recording.sendKeys(Recording);

		saveAddClass.click();
	}
	public String getBatchNameReqText() {
		return getTextFromMandatoryFields(batchNameReq);
	}

	public String getClassTopicReqText() {
		return getTextFromMandatoryFields(classTopicReq);
	}

	public String getClassDateReqText() {
		return getTextFromMandatoryFields(classDateReq);
	}

	public String getStaffNameReqText() {
		return getTextFromMandatoryFields(staffNameReq);
	}

	public String getNoOfClassesReqText() {
		return getTextFromMandatoryFields(noOfClassesReq);
	}

	private String getTextFromMandatoryFields(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) candriver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		return element.getText();
	}

	public void clickOnSave() {
		saveAddClass.click();
		
	}


		
	}



	








	
