package com.pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.EnvironmentConstants;
import com.driverManager.DriverFactory;
import com.utilities.CommonMethods;
import com.utilities.ExcelReader;

public class ProgramPaginationPage {
	public WebDriver pdriver;
	private WebDriverWait wait;
	private Actions action;
	JavascriptExecutor js;
	CommonMethods utility = new CommonMethods();
	EditProgramPage editprogram =new EditProgramPage(DriverFactory.getDriver());
	
	@FindBy(xpath ="//span[@class='p-paginator-icon pi pi-angle-right']") public WebElement nextlinkButton;
	@FindBy(xpath ="//span[@class='p-paginator-icon pi pi-angle-double-right']") 
	public WebElement doubleArrowRightButton;
	@FindBy(xpath ="//span[@class='p-paginator-icon pi pi-angle-left']") public WebElement previousLinkButton;
	@FindBy(xpath ="//button[@class='p-paginator-next p-paginator-element p-link p-ripple p-disabled']")
	public WebElement disabledNextBtn;
	@FindBy(xpath ="//button[@class='p-paginator-last p-paginator-element p-link p-ripple ng-star-inserted p-disabled']")
  	public WebElement disableDoublarrowrightBtn;
	@FindBy(xpath ="//span[@class='p-paginator-icon pi pi-angle-double-left']")
  	public WebElement doublearrowleftbutton;
	@FindBy(xpath="//button[@class='p-paginator-page p-paginator-element p-link p-ripple ng-star-inserted p-highlight']")
	public WebElement activePage;
	@FindBy(xpath ="//button[@class='p-paginator-first p-paginator-element p-link p-ripple ng-star-inserted p-disabled']")
  	public WebElement disabledoublearrowleftbutton;
	@FindBy (xpath="//button[text()='1']") public WebElement firstlink;
	@FindBy (xpath= "//button[@id='dashboard']")public WebElement homepage;
	
	 @CacheLookup
		ExcelReader readdata = new ExcelReader();
		EnvironmentConstants constants = new EnvironmentConstants();
		public ProgramPaginationPage(WebDriver driver) {
		pdriver=driver;
			PageFactory.initElements(driver, this);
			this.action=new Actions(driver);
			
		}
		
		public void clickOnNextPagelink() throws InterruptedException {
			 utility.waitForElement(nextlinkButton);
			 JavascriptExecutor js = (JavascriptExecutor) pdriver;
			 js.executeScript("arguments[0].click();",nextlinkButton);
		     }
		public boolean ValidateNextLinkEnabled() {
			System.out.println(doubleArrowRightButton.isEnabled());
		    return doubleArrowRightButton.isEnabled();
		}
		
		public boolean[] nextandlastlinksdisabled() throws InterruptedException {
			 utility.waitForElement(disableDoublarrowrightBtn);
			 System.out.println(disableDoublarrowrightBtn.isEnabled());
			 
			 utility.waitForElement(disabledNextBtn);
			 System.out.println(disabledNextBtn.isEnabled());
			 return new boolean[] {disableDoublarrowrightBtn.isEnabled(), disabledNextBtn.isEnabled()};
		} 
		

		public void clicklastpagelink() throws InterruptedException {
			utility.waitForElement(doubleArrowRightButton);
			 JavascriptExecutor js = (JavascriptExecutor) pdriver;
			 
			 js.executeScript("arguments[0].click();",doubleArrowRightButton);
			 Thread.sleep(1000);
		}
			
		public void clickPreviousLink() {
			utility.waitForElement(previousLinkButton);
			 JavascriptExecutor js = (JavascriptExecutor) pdriver;
			 js.executeScript("arguments[0].click();",previousLinkButton);
		     }
		public boolean[] enabledactivepageAndPreviousLink() throws InterruptedException {
			
			utility.waitForElement(activePage);
			  activePage.getText().equals("Last Page Number");
			
			 utility.waitForElement(previousLinkButton);
			 System.out.println(previousLinkButton.isEnabled());
			 return new boolean[] { activePage.isEnabled(), previousLinkButton.isEnabled()};
		} 
		public void clickOnFirstPageLink() {
			utility.waitForElement(firstlink);
			 JavascriptExecutor js = (JavascriptExecutor) pdriver;
			 js.executeScript("arguments[0].click();",firstlink);
		     }
		public boolean[] previouslinksdisabled() throws InterruptedException {
			 utility.waitForElement(disabledoublearrowleftbutton);
			 System.out.println(disabledoublearrowleftbutton.isEnabled());
			 
			 utility.waitForElement(firstlink);
			 System.out.println(firstlink.isEnabled());
			 return new boolean[] {disabledoublearrowleftbutton.isEnabled(), firstlink.isEnabled()};
		} 
		public String getNoEntriesPagination()  {
			utility.waitForElement(homepage);
			 JavascriptExecutor js = (JavascriptExecutor) pdriver;
			 js.executeScript("arguments[0].click();",homepage);
			 return utility.getElementText(editprogram.zeroResults);
			 
		     }


		
}
