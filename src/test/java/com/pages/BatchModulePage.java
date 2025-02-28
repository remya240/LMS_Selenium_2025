package com.pages;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class BatchModulePage {
	public WebDriver pdriver;
	WebDriverWait wait;
	Actions action;
	
	public BatchModulePage(WebDriver driver)
	{
		pdriver=driver;
		PageFactory.initElements(driver, this);
		this.action=new Actions(driver);
		
		 this.pdriver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  
	        
	}
	
	@FindBy(xpath = "//span[text()='Batch']")
	   
		@CacheLookup
		private WebElement BATCH_NV;
		
		
		private String BATCH_URLL="https://feb-ui-hackathon-bbfd38d67ea9.herokuapp.com/batch";
		@FindBy(xpath = "//span[contains(text(),'LMS - Learning Management System')]")
	    private WebElement pageTitle;
		 @FindBy (xpath="//mat-toolbar[@color='primary']//span[contains(text(), 'LMS - Learning Management System')]")
	        private WebElement toolbar;
		 @FindBy(id = "programName") // Replace with actual ID or locator
		    private WebElement programNameField;
		 @FindBy (xpath="/html/body/app-root/app-batch/div/mat-card/mat-card-title/div[2]/div[1]/button")
	        private WebElement Multipledelete;
		  @FindBy(xpath = "//p-table//table/tbody/tr")
		    private List<WebElement> rows;
		  private By editIcon = By.cssSelector(".edit-icon");
            WebElement addNewBatch;
		  //Pagination frame locators
		    @FindBy(xpath = "//div[contains(@class, 'p-paginator')]")
		    private WebElement pagination;

		    @FindBy(xpath = "//span[contains(@class, 'p-paginator-current')]")
		    private WebElement currentEntriesText;

		    @FindBy(xpath = "//button[contains(@class, 'p-paginator-first')]")
		    private WebElement firstButton;

		    @FindBy(xpath = "//button[contains(@class, 'p-paginator-prev')]")
		    private WebElement prevButton;

		    @FindBy(xpath = "//button[contains(@class, 'p-paginator-next')]")
		    private WebElement nextButton;

		    @FindBy(xpath = "//button[contains(@class, 'p-paginator-last')]")
		    private WebElement lastButton;

		    @FindBy(xpath = "//button[contains(@class, 'p-paginator-page')]")
		    private List<WebElement> pageButtons;


		 @FindBy(xpath = "//div[@class='box' and contains(text(),'Manage Batch')]")
		    private WebElement manageBatchHeading;
		
		 @FindBy(xpath = "//button[@aria-disabled='false' and contains(text(),'Add New Batch')]")
		   private WebElement batchMenu1;
		 @FindBy(id = "description")
		 private WebElement descriptionField1;

		 @FindBy(id = "numberOfClasses")
		 private WebElement numberOfClassesField2;
		 @FindBy(xpath = "//button[contains(text(),'Cancel')]")
		 private WebElement cancelButton;
		 @FindBy(className = "p-dialog")
		 private WebElement batchPopupElement;

		 /*@FindBy(id = "saveButton")
		 private WebElement saveButton;*/

		 @FindBy(id = "descriptionError")
		 private WebElement descriptionError;

		 @FindBy(id = "classesError")
		 private WebElement classesError;
		 @FindBy(xpath = "/html/body/app-root/app-batch/div/mat-card/mat-card-title/div[2]/div[1]/button/span[1]")
		 private WebElement disabledDeleteIcon;
		 
		@FindBy(xpath = "//div[contains(@class, 'p-paginator-bottom')]")
		   private WebElement paginationControls;
		 @FindBy(xpath="//p-table//p-paginator/div")
		 private WebElement PaginationElement;


	
		 @FindBy(xpath = "//span[@aria-hidden='true' and contains(@class, 'pi-pencil')]")   
		 private List<WebElement> editIcons;
		 @FindBy(css = "span.p-button-icon.pi.pi-trash")
		    private List<WebElement> deleteIcons;
		 @FindBy(xpath = "//div[@role='checkbox' and contains(@class, 'p-checkbox-box')]")
		 
		    private List<WebElement> checkboxes;
		 
		 @FindBy(xpath = "//tr/th")
		    private List<WebElement> tableHeaders;
		 @FindBy(xpath = "//div[@role='checkbox' and contains(@class, 'p-checkbox-box')]")
		 private WebElement headerCheckbox;
		
		 @FindBy(xpath = "//i[contains(@class, 'p-sortable-column-icon') and contains(@class, 'pi-sort-alt')]")
		  private WebElement batchNameSortingIcon;
		
		 @FindBy(xpath = "//th[@psortablecolumn='batchDescription']")private WebElement descriptionHeader;
		    @FindBy(xpath = ".//th[contains(text(), 'Batch Description')]//i[contains(@class, 'p-sortable-column-icon')]")
		    private WebElement batchDescriptionSortingIcon;

		    @FindBy(xpath = "//th[@psortablecolumn='batchStatus']")private WebElement statusHeader;
		    @FindBy(xpath = ".//th[contains(text(), 'Batch Status')]//i[contains(@class, 'p-sortable-column-icon')]")
		    private WebElement batchStatusSortingIcon;

		    @FindBy(css = "th[psortablecolumn='batchNoOfClasses']")private WebElement NoofclassesHeader;
		    @FindBy(xpath = ".//th[contains(text(), 'No Of Classes')]//i[contains(@class, 'p-sortable-column-icon')]")
		    private WebElement noOfClassesSortingIcon;
		    
		    @FindBy(xpath = "//th[contains(text(), 'Program Name')]")private WebElement programNameHeader;
		    @FindBy(xpath = ".//th[contains(text(), 'Program Name')]//i[contains(@class, 'p-sortable-column-icon')]")
		    private WebElement programNameSortingIcon;

		    @FindBy(xpath = "//th[contains(text(), 'Edit / Delete')]")private WebElement editDeleteHeader;
		 //@FindBy(xpath = "//span[@class='mat-button-wrapper' and text()='Batch']")
		// private By batchNameField = By.id("batchName");
		@FindBy(xpath = "/html/body/app-root/app-batch/p-dialog[1]/div/div/div[2]/div[2]/input[1]")
				private WebElement batchNameField;
		  @FindBy(xpath="//span[@class='mat-button-wrapper' and text()='Batch']")
		 WebElement batchMenu;
		// @FindBy(xpath = "//button[contains(@class, 'mat-menu-item') and contains(text(), 'Add New Batch')]")
		 @FindBy(xpath = "//button[contains(text(),'Add New Batch')]")
		    WebElement addNewBatchSubMenu;
		 //@FindBy(xpath = "//div[contains(@class, 'p-dialog-content') and contains(., 'Batch Details')]")
		 //@FindBy(xpath = "//span[contains(text(), 'Batch Details')]")
		 @FindBy(xpath = "//button[contains(text(), 'Add New Batch')]")
		    WebElement batchDetailsPopup;
		 @FindBy(xpath = "//button[@role='menuitem' and text()='Add New Batch']")
		 WebElement addNewBatchOption;
		 
		 @FindBy(id = "programName")
		    WebElement programNameDropdown;

		    @FindBy(id = "batchName")
		    WebElement batchNameTextbox;

		    @FindBy(id = "batchDescription")
		    WebElement descriptionTextbox;

		    @FindBy(id = "ACTIVE")
		    WebElement activeRadioButton;

		    @FindBy(id = "INACTIVE")
		    WebElement inactiveRadioButton;

		    @FindBy(id = "batchNoOfClasses")
		    WebElement numberOfClassesTextbox;
		    private List<String> expectedHeaders = Arrays.asList(
		            "Batch Name", 
		            "Batch Description", 
		            "Batch Status", 
		            "No Of Classes", 
		            "Program Name", 
		            "Edit / Delete"
		        );

		 // Locators
		    private By popupWindow = By.id("batchDetailsPopup");
		   // private By batchNameField = By.id("batchName");
		    private By numberOfClassesField1 = By.id("noOfClasses");
		    private By descriptionField = By.id("description");
		    private By programDropdown = By.id("programDropdown");
		    private By statusRadioButton = By.name("status");
		    private By batchNamePrefix = By.id("batchNamePrefix");

		public void clickHeaderBar(String ModuleName)
		{
			switch(ModuleName) {
			case"Batch":
				System.out.println("Inside button click");
				BATCH_NV.click();
				break;
			}
				
		}
	public boolean validate_manage_page(String ModuleName) {
		boolean result=false;
		switch(ModuleName) {
		case"Batch":
			System.out.println("Inside validation of batch");
			result=pdriver.getCurrentUrl().equalsIgnoreCase(BATCH_URLL);
			break;
		}
		
		
		return result;
	
	}
	
	public String getPageTitle() {
		 return pageTitle.getText();
	}
	public boolean isManageBatchHeadingDisplayed() {
        return manageBatchHeading.isDisplayed();
    }
    public String getManageBatchHeadingText() {
        return manageBatchHeading.getText();
    }



   /* public boolean isButtonLabelVisible() {
        return buttonLabel.isDisplayed();
    }*/
	public boolean isDeleteIconDisabled() {
		return disabledDeleteIcon != null && !disabledDeleteIcon.isEnabled();
	}
	/*public boolean isPaginationEnabled() {
		 //return paginationControls.isDisplayed() && paginationControls.isEnabled();
		return PaginationElement.isDisplayed();
		
	}*/
	 public boolean isPaginationEnabled() {
	        return paginationControls.isDisplayed() && paginationControls.isEnabled();
	    }



	public boolean areEditIconsVisibleInEachRow() {
		for (WebElement icon : editIcons) {
            if (!icon.isDisplayed()) {
                return false;
            }
        }
        return true;
    }
public boolean areDeleteIconsDisplayed() {
		for (WebElement icon : deleteIcons) {
            if (!icon.isDisplayed()) {
                return false;
            }
        }
        return true;
	}

	public boolean areCheckboxesDisplayedInEachRow() {
		 if (checkboxes.isEmpty()) {
	            return false;
	        }
	        for (WebElement checkbox : checkboxes) {
	            if (!checkbox.isDisplayed()) {
	                return false;
	            }
	        }
	        return true;
	}

	//public List<String> getTableHeaderTexts() {
		// return tableHeaders.stream().map(WebElement::getText).toList();
	//}


	 public List<WebElement> getTableHeaders() {
	        return tableHeaders;
	 }

	public boolean isHeaderPresent(String headerName) {
		for (WebElement header : tableHeaders) {
            if (header.getText().trim().equalsIgnoreCase(headerName)) {
                return true;
            }
        }
        return false;
    }

	public boolean isHeaderCheckboxDisplayed() {
		// return headerCheckbox.isDisplayed();
		for (WebElement checkbox : checkboxes) {
			
            wait.until(ExpectedConditions.visibilityOf(checkbox)); // Wait for checkbox to be visible
            if (!checkbox.isDisplayed()) {
                return false; // Return false if any checkbox is not displayed
            }
        }
        return true; // All checkboxes are displayed

	}
/*public boolean areAllSortIconsVisible() {
        for (WebElement icon : sortIcons) {
            if (!icon.isDisplayed()) {
                return false;
            }
        }
        return true;
    }*/
	/*public Object getSortIconCount() {
		 return sortIcons.size();
	}*/

	public boolean isBatchPageDisplayed() {
		 return batchMenu.isDisplayed();
	}
	public boolean isSubMenuDisplayed(String submenu) {
		 return addNewBatchSubMenu.isDisplayed();
	}

	public void clickBatchMenu() {
		//WebElement batchMenu = wait.until(ExpectedConditions.elementToBeClickable(By.id("batchMenu"))); // Update locator
		
		 By.xpath("//button[text()='Add New Batch']");
		 batchMenu.click();
		//batchMenu.findElement(By.xpath("//span[@class='mat-button-wrapper' and text()='Batch']"));
		
	}

	public void clickAddNewBatch() {
		//WebElement addNewBatchButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("addNewBatch"))); // Update locator
		 
		 //addNewBatchOption.findElement(By.xpath("//*[@id=\"mat-menu-panel-4\"]/div/button"));
		 addNewBatchOption.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div/button"));
		 addNewBatchOption.click()	;
		
	}

	public boolean isBatchDetailsPopupDisplayed() {
		 return batchDetailsPopup.isDisplayed();
		 /*WebDriverWait wait = new WebDriverWait(pdriver, Duration.ofSeconds(10));
	        switch (fieldName) {
	       
	            case "Batch Name":
	                return batchNameLabel.isDisplayed();
	            case "Number of classes":
	                return numberOfClassesLabel.isDisplayed() && numberOfClassesInput.isDisplayed();
	            case "Description as text box":
	                return batchdescription.isDisplayed();
	            case "Program Name as drop down":
	                return programNameLabel.isDisplayed() && Programdropdowntrigger.isDisplayed();
	            case "Status as radio button":
	               
	             
	                wait.until(ExpectedConditions.visibilityOf(statusLabel));
	               
	                return statusLabel.isDisplayed()&& statusLabel.isEnabled();
	            case "close":
	                return closeButton.isDisplayed() && closeButton.isEnabled();
	            case "save button": // Ensure consistent naming
	                //wait.until(ExpectedConditions.visibilityOf(saveButton));
	               // return saveButton.isDisplayed() && saveButton.isEnabled();
	               
	            case "SaveButton":
	                wait.until(ExpectedConditions.visibilityOf(saveButton)); // Wait for visibility
	                return saveButton.isDisplayed() && saveButton.isEnabled();
	            case "CancelButton":
	                wait.until(ExpectedConditions.visibilityOf(cancelButton)); // Wait for visibility
	                return cancelButton.isDisplayed() && cancelButton.isEnabled();
	            default:
	                return false;
}
	   */
	       

	}
 public boolean isProgramNameDropdownDisplayed() {
		 return programNameDropdown.isDisplayed();
	}

	public boolean isBatchNameTextboxDisplayed() {
		 return batchNameTextbox.isDisplayed();
	}
	public boolean isDescriptionTextboxDisplayed() {
		 return descriptionTextbox.isDisplayed();
	}
   public boolean isActiveRadioButtonDisplayed() {
		 return activeRadioButton.isDisplayed();
	}
public boolean isInactiveRadioButtonDisplayed() {
		 return inactiveRadioButton.isDisplayed();
	}
public boolean isNumberOfClassesTextboxDisplayed() {
		 return numberOfClassesTextbox.isDisplayed();
	}
/*public boolean isDisplayed() {
	
	}
*/
/*public boolean areAllSortIconsPresent() {
		return sortIcons.size() == 6; // Assuming there are 6 headers
	}*/

	 //pagination
    
    public void clickNextPage() {
        if (isNextButtonEnabled()) {
            doubleClick(nextButton);
          //  waitForResultsToLoad(); 
        }// Ensure results load after clicking
        }

    // Method to click 'Previous' button
    public void clickPreviousPage() {
        if (isPrevButtonEnabled()) {
        	  doubleClick (prevButton);
        }
    }

    // Method to click 'First' button
    public void clickFirstPage() {
    	
          doubleClick(firstButton);
    }

    // Method to click 'Last' button
    public void clickLastPage() {
        doubleClick(lastButton);
    }

    // Method to click a specific page number
    public void clickPageNumber(int pageIndex) {
    	 doubleClick(pageButtons.get(pageIndex - 1));
    }

    // Check if 'Next' button is enabled
    public boolean isNextButtonEnabled() {
        return !nextButton.getDomAttribute("class").contains("p-disabled");
    }

    // Check if 'Previous' button is enabled
    public boolean isPrevButtonEnabled() {
        return !prevButton.getDomAttribute("class").contains("p-disabled");
    }

    // Method to get current pagination text
    public String getCurrentEntriesText() {
        return currentEntriesText.getText();
    }

    public boolean hasNextPageResults() {
        // Return true if there are results; false otherwise
        return !rows.isEmpty(); 
    }
    private void doubleClick(WebElement element) {
        Actions actions = new Actions(pdriver); // Create an Actions instance
        actions.moveToElement(element).doubleClick().perform(); // Move to the element and double-click
    }
    private void waitForResultsToLoad() {
    	wait.until(ExpectedConditions.visibilityOfAllElements(rows));
    }
    public boolean areAllSortIconsDisplayed() {
		// return sortIcons.size() == 6 && sortIcons.stream().allMatch(WebElement::isDisplayed);
		 return batchNameSortingIcon.isDisplayed() &&
	               batchDescriptionSortingIcon.isDisplayed() &&
	               noOfClassesSortingIcon.isDisplayed() &&
	               batchStatusSortingIcon.isDisplayed() &&
	               programNameSortingIcon.isDisplayed();

	}




	public boolean isToolbarTextCorrect(String expectedText) {
		return toolbar.getText().trim().equals(expectedText);
	}

public boolean isMultipleDeleteIconDisabled() {
		 WebDriverWait wait = new WebDriverWait(pdriver, Duration.ofSeconds(10));
	        try {
	            wait.until(ExpectedConditions.visibilityOf(Multipledelete));
	            return Multipledelete.isEnabled() == false; // Check if it is disabled
	        } 
	        catch (NoSuchElementException e) {
	            return false; // Handle if the button is not found
	        }
	    }

	public void classClick() {
		 WebElement batchMenu = pdriver.findElement(By.id("batchMenu")); // Replace with the actual locator
		    batchMenu.click();
		
	}

	public void clickAddNewClass() {
		  WebElement addNewBatchButton = pdriver.findElement(By.id("addNewBatchButton")); // Replace with the actual locator
		    addNewBatchButton.click();
		
	}




	public void selectProgramName(String programName) {
		 WebElement dropdown = pdriver.findElement(By.id("programDropdown")); // Replace with actual locator
		    Select select = new Select(dropdown);
		    select.selectByVisibleText(programName);
	}




	public String getBatchNamePrefix() {
		WebElement batchNameField = pdriver.findElement(By.id("batchNamePrefix")); // Replace with actual locator
	    return batchNameField.getDomAttribute("value");
	}

	public boolean isHomePageDisplayed() {
		return pdriver.getTitle().contains("LMS Portal"); // Replace with actual page title
		//return wait.until(ExpectedConditions.titleContains("LMS Portal"));
	}

	public void navigateToBatchDetailsPopup() {
		 pdriver.findElement(By.xpath("/html/body/app-root/app-header/mat-toolbar/div/button[3]/span[1]"));
				 batchMenu.click();
	     pdriver.findElement(By.xpath("//button[text()='Add New Batch']"));
	    		 addNewBatch.click();
	    }
		
	 public boolean isBatchDetailsPopupDisplayed1() {
	        return wait.until(ExpectedConditions.visibilityOfElementLocated(popupWindow)).isDisplayed();

	 }
	 // public boolean areAllFieldsEnabled() {
	        //return pdriver.findElement(batchNameField).isEnabled() &&
	               //pdriver.findElement(numberOfClassesField).isEnabled() &&
	               //pdriver.findElement(descriptionField).isEnabled() &&
	          //     pdriver.findElement(programDropdown).isEnabled() &&
	           //    pdriver.findElement(statusRadioButton).isEnabled();
	  //}
	//public boolean verifyPopupFields() {
		 //return pdriver.findElement(batchNameField).isDisplayed() &&
	               //pdriver.findElements(numberOfClassesField).isDisplayed() &&
	               //pdriver.findElements(descriptionField).isDisplayed() &&
	               //pdriver.findElement(programDropdown).isDisplayed() &&
	              // pdriver.findElement(statusRadioButton).isDisplayed();
		
	//}


	public void selectProgramName1(String programName) {
        WebElement dropdown = pdriver.findElement(programDropdown);
        Select select = new Select(dropdown);
        select.selectByVisibleText(programName);
    }

    public boolean isBatchNamePrefixedWithProgram() {
        String selectedProgram = new Select(pdriver.findElement(programDropdown)).getFirstSelectedOption().getText();
        String batchNamePrefixValue = pdriver.findElement(batchNamePrefix).getDomAttribute("value");
        return batchNamePrefixValue.startsWith(selectedProgram);
    }


    private By batchSuffixField = By.id("batchSuffix");
    private By batchSuffixErrorMessage = By.id("batchSuffixError");

	public void enterBatchSuffix(String value) {
		WebElement suffixField = pdriver.findElement(batchSuffixField);
	    suffixField.clear();
	    suffixField.sendKeys(value);
	}
		
	public String getBatchSuffixErrorMessage() {
		 WebElement errorElement = pdriver.findElement(batchSuffixErrorMessage);
		    return errorElement.isDisplayed() ? errorElement.getText() : null;
	}



	// Locator for Batch Name Prefix field
	private By batchPrefixField = By.id("batchPrefix");

	public void tryToEnterBatchPrefix(String value) {
		 WebElement prefixField = pdriver.findElement(batchPrefixField);
		    if (prefixField.isEnabled() && prefixField.isDisplayed()) {
		        prefixField.sendKeys(value);
		    }
		
		
		    
	}




	public String getBatchPrefixValue() {
		WebElement prefixField = pdriver.findElement(batchPrefixField);
	    return prefixField.getDomAttribute("value");
	}

	// Locators for mandatory fields
	private By batchNameField1= By.id("batchName");
	//private By numberOfClassesField = By.id("numClasses");
	//private By programNameDropdown = By.id("programDropdown");
	private By saveButton = By.id("saveBtn");
	private By successMessageLocator = By.id("successMessage");
	public void fillMandatoryFields(String batchName, String numberOfClasses, String programName) {
		//pdriver.findElement(batchNameField).sendKeys(batchName);
	 //pdriver.findElements(numberOfClassesField).sendKeys(numberOfClasses);
	}
	    // Select the program from the dropdown
	    
	   /* Select programDropdown = new Select(pdriver.findElement(programNameDropdown));
	    
	    programDropdown.selectByVisibleText(programName);
		
	}*/

	public void clickSaveButton()
	{
		 pdriver.findElement(saveButton).click();
		
	}

	public String getSuccessMessage() {
		 WebDriverWait wait = new WebDriverWait(pdriver, Duration.ofSeconds(10));
		    WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessageLocator));
		    return message.getText();
	}

	public void clickEditIcon() {
		  WebDriverWait wait = new WebDriverWait(pdriver, Duration.ofSeconds(10));
	        WebElement editIconElement = wait.until(ExpectedConditions.elementToBeClickable(editIcon));
	        editIconElement.click();
		
	}

	public void navigateToBatchPage() {
		  batchMenu.click();
		
	}

	public boolean isProgramNameDisabled() {
		return !programNameField.isEnabled();
	}

	//public boolean isBatchNameDisabled() {
		// WebElement batchNameElement = pdriver.findElement(batchNameField);
		    //return !batchNameElement.isEnabled();  // Negate to check if disable
	//}
	@FindBy(id = "batchMenu")
	private WebElement batchMenuButton;

	@FindBy(xpath = "//button[contains(text(),'Add New Batch')]")
	private WebElement addNewBatchButton;

	@FindBy(id = "batchName")
	private WebElement batchNameField2;

	@FindBy(id = "numberOfClasses")
	private WebElement numberOfClassesField;

	@FindBy(id = "batchDescription")
	private WebElement batchDescriptionField;

	@FindBy(id = "programDropdown")
	private WebElement programDropdownField;

	@FindBy(xpath = "//input[@value='Active']")
	private WebElement activeStatusRadioButton;

	@FindBy(xpath = "//input[@value='Inactive']")
	private WebElement inactiveStatusRadioButton;

	//@FindBy(xpath = "//button[contains(text(),'Save')]")
	//private WebElement saveButton;

	@FindBy(className = "success-message")
	private WebElement successMessageElement;
	public void navigateToBatchDetailsPage() {
		batchMenu1.click();
		addNewBatchButton.click();
		  //pdriver.findElement(By.id("batchMenu")).click();
	}

  public void enterInvalidDataInDescription(String data) {
	  descriptionField1.clear();
	    descriptionField1.sendKeys(data);
		
	}

	public void enterInvalidDataInNoOfClasses(String data) {
	       numberOfClassesField2.clear();
		    numberOfClassesField2.sendKeys(data);
	}
	public boolean isDescriptionErrorVisible() {
		 return descriptionError.isDisplayed();
	}

	public boolean isNoOfClassesErrorVisible() {
		 return classesError.isDisplayed();
	}
	public void enterBatchName(String batchName) 
	{
		batchNameField2.clear();
	    batchNameField2.sendKeys(batchName);
	}
		
	public void enterNumberOfClasses(String numberOfClasses ) {
		 numberOfClassesField.clear();
		    numberOfClassesField.sendKeys(numberOfClasses);
		
	}
	public void enterBatchDescription(String description) {
		  batchDescriptionField.clear();
		    batchDescriptionField.sendKeys(description);
		
	}

	public void selectStatus(String status) {
		 if (status.equalsIgnoreCase("Active")) {
		        activeStatusRadioButton.click();
		    } else {
		        inactiveStatusRadioButton.click();
		    }
		}
	// Get the success message
	public void clickCancelButton() {
		 cancelButton.click();
		
	}
	public Object isBatchPopupVisible() {
		 try {
		        return batchPopupElement.isDisplayed();
		    } catch (NoSuchElementException e) {
		        return false; // Pop-up is closed if the element is not found
		    }
	}
	public void navigateToHomePage() {
		 pdriver.get("https://your-lms-portal.com/home");
		
	}
	public void clickOnMenu(String menuName) {
		 if (menuName.equalsIgnoreCase("Batch")) {
		     try {   
			 batchMenu.click();}
		     catch(StaleElementReferenceException Exception) {
		    	System.out.println("I am inside staleReference Exception") ;
		    	batchMenu.findElement(By.xpath("//span[@class='mat-button-wrapper' and text()='Batch']"));
		     }
		    }
		
	}
	//public String isOnManageBatchPage(String pageName) {
		//  return manageBatchHeader.isDisplayed() && manageBatchHeader.getText().contains(pageName);
	//}
	public void clickDeleteIconOnRow(int rowIndex) {
		 WebElement deleteIcon = pdriver.findElement(By.xpath("//table//tr[" + rowIndex + "]//button[@class='delete-icon']"));
		    deleteIcon.click();
		
	}
	public boolean isBatchNameFieldPresent() {
		 return batchNameField.isDisplayed();
	}
	public boolean isNumberOfClassesFieldPresent() {
		 return batchNameField.isDisplayed();
	}
	//public boolean isDescriptionFieldPresent() {
		 //return descriptionField.isDisplayed();
	//}
	public boolean isProgramNameDropdownPresent() {
		 return programNameDropdown.isDisplayed();
	}
}
	/*public boolean isDeleteConfirmationDisplayed() {
		return deleteConfirmationDialog.isDisplayed();
	}
	public boolean isYesButtonPresent() {
		return yesButton.isDisplayed();
	}
	public boolean isNoButtonPresent() {
		return noButton.isDisplayed();
	}
	
	
	}*/
	
	
	
	
	 
	
	
	
	




	
	
	



	

	 

