package com.pages;

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;



public class ProgramPage {

	
	boolean result =false;
	WebDriver pdriver;
	public ProgramPage(WebDriver driver) {
	pdriver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	@FindBy(xpath="//*[@id=\"program\"]")
	@CacheLookup
	private WebElement PROGRAM_NV;
	
	
	@FindBy(xpath="//span[text()='Logout']")
	@CacheLookup
	private WebElement PG_LOGOUT;
	
	@FindBy(xpath = "//span[text()=' LMS - Learning Management System ']")
	@CacheLookup
	private WebElement LMS_HEADING;
	
	@FindBy(xpath = "//span[@class='mat-button-wrapper']")
	@CacheLookup
	private List<WebElement> MENU_HEADERS;

	
	@FindBy(xpath = "//button[text()='Add New Program']")
	@CacheLookup
	private WebElement ADD_NEW_PROGRAM;
	
	@FindBy(xpath = "//div[text()=' Manage Program']")
	private WebElement MANAGE_PGM_HEADERS;
	
	@FindBy(xpath = "//tr/th")
	@CacheLookup
	private List<WebElement> PG_COL_HEADERS;
	
	@FindBy(xpath="//button[@icon='pi pi-trash' and @disabled]")
	@CacheLookup
	private WebElement TOP_LEFT_DELETE;
	
	@FindBy(xpath="//input[@id='filterGlobal' and @placeholder='Search...']")
	@CacheLookup
	private WebElement SEARCHBAR;
	
	
	@FindBy(xpath = "//thead[@class='p-datatable-thead']")
	private WebElement DATA_HEADER;
	
	@FindBy(xpath = "(//div[@class='p-checkbox p-component'])[1]")
	private WebElement HEADERCHECK;
	
	@FindBy(xpath = "//div[@class='p-checkbox p-component']")
	private List<WebElement> ALL_CHECKBOXES;
	
	@FindBy(xpath = "//i[@class='p-sortable-column-icon pi pi-fw pi-sort-alt']")
	private List<WebElement> SORT_ICONS;
	
	@FindBy(xpath = "//div[@class='action']")
	private List<WebElement> EDIT_DEL_ICONS;
	
	@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-left']")
	private WebElement PREV_PAGE_MOVE;
	
	
	@FindBy(xpath = "//span[@class='p-paginator-current ng-star-inserted']")
	private WebElement PAGINATOR;
	
	@FindBy(xpath = "//button[@class='p-paginator-first p-paginator-element p-link p-disabled p-ripple ng-star-inserted']")
	private WebElement PRE_SET_PAGE_MOVE;

	@FindBy(xpath = "//button[@class='p-paginator-last p-paginator-element p-link p-ripple ng-star-inserted']")
	private WebElement NEXT_SET_PAGES;

	@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-right']")
	private WebElement NEXT_PAGE_MOVE;
	
	@FindBy(xpath = "//div[@class='p-d-flex p-ai-center p-jc-between ng-star-inserted']")
	private WebElement PROGRAM_FOOTER;
	
	private String PROGRAM_URLL="https://feb-ui-hackathon-bbfd38d67ea9.herokuapp.com/program";
	
	public void clickNavigationBar(String ModuleName)
	{
		System.out.println(" I am in Program Page factory for when  - click Program Btn in navigation");
		switch(ModuleName) {
		case"Program":
			PROGRAM_NV.click();
			break;
		}
			
	}
	
	public void clickProgrammenu() {PROGRAM_NV.click();}
	
	public boolean validate_navbar_pagenav(String ModuleName)
	{
		
		System.out.println(" I am in Program Page factory for then  - validte Program page navigation ");
		boolean result=false;
		switch(ModuleName) {
		case"Program":
			result=pdriver.getCurrentUrl().equalsIgnoreCase(PROGRAM_URLL);
			break;
		}
		
		
		return result;
	}

	public boolean validateAppName(String string) throws FileNotFoundException, IOException
	{
		LoginPage login = new LoginPage(pdriver);
	
		switch(string) {
		case"LMS - Learning Management System":
			login.readlogindata();
			result=LMS_HEADING.getText().contains(login.APP_TITLE);
			break;
		case"Manage Program":
			result=MANAGE_PGM_HEADERS.getText().equals(string);
			break;
		
		}
		return result;
	}

public boolean validateLogoutDisplayed()
{
	result=PG_LOGOUT.getText().contains("Logout");
	return result;
}


//validate Menubar header names " Home,Program,Batch,Class"
public boolean validateMenuHeaderNames(String expectedOrder) {

	System.out.println("I am inside validate menu headers page");

    // List to store actual header names
    List<String> actualOrder = new ArrayList<>();

    // Add menu headers to actualOrder list
    for (int i = 0; i < MENU_HEADERS.size() - 1; i++) {
        actualOrder.add(MENU_HEADERS.get(i).getText());
    }

    // Print actual order for debugging
    System.out.println("Actualorder: " + actualOrder);

    // Split the expectedOrder string into a list of expected menu headers
    String[] expectedOrderArray = expectedOrder.split(" ");
    List<String> expectedOrderList = Arrays.asList(expectedOrderArray);

    // Print expected order for debugging
    System.out.println("Expected: " + expectedOrderList);

    // Check if the actualOrder matches the expectedOrder list
    boolean result = actualOrder.equals(expectedOrderList);
    
    // Print result for debugging
    System.out.println("Result: " + result);
    
    return result;
}


//Admin should see sub menu in menu bar as "Add New Program"
	public boolean AddNewProgram(String string) {
		System.out.println("I am inside sould see submenu");
		PROGRAM_NV.click();
		System.out.println("Add new program text "+ADD_NEW_PROGRAM.getText());
		System.out.println("given string "+string);
		
		result= ADD_NEW_PROGRAM.getText().equalsIgnoreCase(string);
return result;
	}
	
	
	//sorting
	
	
	
	public void ProgramDescriptionSortClick() throws InterruptedException
	{Actions actions= new Actions(pdriver);
		actions.moveToLocation(100, 200).click().perform(); 	
		  Thread.sleep(2000);
		  List<WebElement> rows = pdriver.findElements(By.xpath("//table/tbody/tr"));	
		  
		  pdriver.findElement(By.xpath("//th[contains(text(),'Program Description ')]")).click();
	}
	
	public void ProgramNameSortClick() throws InterruptedException {
		System.out.println("I am inside Program Name sort click");
		Actions actions= new Actions(pdriver); 
		actions.moveToLocation(100, 200).click().perform(); 	
		  Thread.sleep(2000);
		  List<WebElement> rows = pdriver.findElements(By.xpath("//table/tbody/tr"));		 
		  pdriver.findElement(By.xpath("//th[contains(text(),'Program Name')]")).click();		
	}
	
	
	public void ProgramStatusSortClick() throws InterruptedException
	{
		System.out.println("I am inside Program Status sort click");
		Actions actions= new Actions(pdriver);
		  actions.moveToLocation(100, 200).click().perform(); 	
		  Thread.sleep(2000);
		  List<WebElement> rows = pdriver.findElements(By.xpath("//table/tbody/tr"));		 
		  pdriver.findElement(By.xpath("//th[contains(text(),'Program Status')]")).click();
	}
	
	public boolean verifyingProgrameNameSorting(String ASCorDES) {
		
		
		System.out.println("I am inside Program Name sort operation");
		List<WebElement> rows = pdriver.findElements(By.xpath("//table/tbody/tr"));
		
		for (WebElement row : rows) {
           // System.out.println("Row: " + row.getText());
        }
		
		List<String> actualData = new ArrayList<>();
		
		for (WebElement row : rows) {			
			actualData.add(row.findElement(By.xpath("//tbody/tr/td[2]")).getText()); 
		}		
		
		List<String> Ascendingdata = new ArrayList<>(actualData);		
		
		switch (ASCorDES.trim()) { 
		
        case "Ascending order":        	
            Collections.sort(Ascendingdata); // Sort in ascending order
            break;

        case "Descending order":
            Collections.sort(Ascendingdata, Collections.reverseOrder()); // Sort in descending order
            pdriver.findElement(By.xpath("//th[contains(text(),'Program Name')]")).click(); // Click to sort
            break;

        default:
            System.out.println("Invalid sort option: " + ASCorDES);
            return false; // Invalid sorting option
    }

    // Step 4: Verify the sorted order
    if (actualData.equals(Ascendingdata)) {    	
      
        return true; // Sorting is verified
    } else {
     
        return false; // Sorting verification failed
    }	
		
	}
	
	
public boolean verifyingProgramDescriptionSorting(String ASCorDES) {
		
		List<WebElement> rows = pdriver.findElements(By.xpath("//table/tbody/tr"));	
		
		for (WebElement row : rows) {
            //System.out.println("Row: " + row.getText());
        }
		List<String> actualData = new ArrayList<>();
		
		for (WebElement row : rows) {			
			actualData.add(row.findElement(By.xpath("//tbody/tr/td[3]")).getText()); 
		}			
		
		List<String> Ascendingdata = new ArrayList<>(actualData);		
		
		switch (ASCorDES) { 
        case "Ascending order":        	
            Collections.sort(Ascendingdata); // Sort in ascending order
            break;

        case "Descending order":
            Collections.sort(Ascendingdata, Collections.reverseOrder()); // Sort in descending order
            pdriver.findElement(By.xpath("//th[contains(text(),'Program Description ')]")).click(); // Click to sort
            break;

        default:
            System.out.println("Invalid sort option: " + ASCorDES);
            return false; // Invalid sorting option
    }

    // Step 4: Verify the sorted order
    if (actualData.equals(Ascendingdata)) {
               
        return true; // Sorting is verified
    } else {
     
        return false; // Sorting verification failed
    }	
		
	}


public boolean verifyingProgramStatusSorting(String ASCorDES) {
	
	List<WebElement> rows = pdriver.findElements(By.xpath("//table/tbody/tr"));	
	
	for (WebElement row : rows) {
        System.out.println("Row: " + row.getText());
    }
	List<String> actualData = new ArrayList<>();
	
	for (WebElement row : rows) {			
		actualData.add(row.findElement(By.xpath("//tbody/tr/td[4]")).getText()); 
	}			
	
	List<String> Ascendingdata = new ArrayList<>(actualData);		
	
	switch (ASCorDES) { 
    case "Ascending order":        	
        Collections.sort(Ascendingdata); // Sort in ascending order
        break;

    case "Descending order":
        Collections.sort(Ascendingdata, Collections.reverseOrder()); // Sort in descending order
        pdriver.findElement(By.xpath("//th[contains(text(),'Program Status ')]")).click(); // Click to sort
        break;

    default:
        System.out.println("Invalid sort option: " + ASCorDES);
        return false; // Invalid sorting option
}

// Step 4: Verify the sorted order
if (actualData.equals(Ascendingdata)) {
           
    return true; // Sorting is verified
} else {
 
    return false; // Sorting verification failed
}	
	


}



//Admin should able to see Program name, description, and status for each
	public boolean validateColheaders() {

		System.out.println("Ientered inside Column header page");
		List<String> actualColheaders = new ArrayList<>();

		for (int i = 1; i < PG_COL_HEADERS.size() - 1; i++) {
			actualColheaders.add(PG_COL_HEADERS.get(i).getText());
		}
		
return result;
	}
	// Admin should see a Delete button in left top is disabled
		public boolean validatDelDisabled() {
			boolean DeleteIconEnability = TOP_LEFT_DELETE.isEnabled();
			
			if (DeleteIconEnability == false) {
				 result=true;
		 System.out.println("DeleteIcon is disabled. Return: " + DeleteIconEnability);}
		
			return result;
		}

	
		
		@SuppressWarnings("deprecation") // getAtrribute method is valid in selenium version 4.28,but deprecation warning occured because of IDE issue
		public boolean validatesearchBar(String string) {
			
			System.out.println(" I entered verify search program page");
			System.out.println(" text from webelement "+SEARCHBAR.getText());
			System.out.println("Feature text "+string);
			
			String placeholderValue = SEARCHBAR.getAttribute("placeholder");
			result =placeholderValue .contains(string);
           return result;
		}

		// Admin should see data table with column header on the Manage Program Page as
		// Program Name, Program Description, Program Status, Edit/Delete
		public boolean validateDataTableHead() {
			boolean DatatableHeaddisplayed = DATA_HEADER.isDisplayed();
			if (DatatableHeaddisplayed = true) {
				System.out.println("DatatableHeaddisplayed is visible. Return: " + DatatableHeaddisplayed);
			} else {
				System.out.println("DatatableHeaddisplayed is not visible. Return: " + DatatableHeaddisplayed);
			}
			return DatatableHeaddisplayed;
		}
		// Admin should see checkbox default state as unchecked beside Program Name
		// column header as

		public boolean validateheaderCheckBoxUnchecked() {
			try {
				return !HEADERCHECK.isSelected();
			} catch (Exception e) {
				return false;
			}

		}

		// Admin should see check box default state as unchecked on the left side in all
		// rows against program name
		public boolean validateAllCheckBoxesUnchecked() {
			try {
				for (int i = 1; i < ALL_CHECKBOXES.size(); i++) {
					if (ALL_CHECKBOXES.get(i).isSelected())
						return false;
				}
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		
		// Admin should see the sort arrow icon beside to each column header except Edit
		// and Delete

		public boolean validateSortIcons() {
			try {

				for (int i = 0; i < SORT_ICONS.size(); i++) {
					if (SORT_ICONS.get(i).isDisplayed())
						return true;
				}

			} catch (Exception e) {
				return false;
			}
			return false;
		}
		
		// Admin should see the Edit and Delete buttons on each row of the data table

		public boolean validateEditDelIcons() {
			try {

				for (int i = 0; i < EDIT_DEL_ICONS.size(); i++) {
					if (EDIT_DEL_ICONS.get(i).isDisplayed())
						return true;
				}

			} catch (Exception e) {
				return false;
			}
			return false;
		}
		
		
		
		public boolean validatePaginationTextandIcons() throws InterruptedException {
			String text = "";

			Thread.sleep(1000);
			boolean areIconsPresent = PREV_PAGE_MOVE.isDisplayed() && PRE_SET_PAGE_MOVE.isDisplayed()
					&& NEXT_PAGE_MOVE.isDisplayed() && NEXT_SET_PAGES.isDisplayed();
			try {
				if (areIconsPresent) {
					String textValidation = PAGINATOR.getText();
					Pattern pattern = Pattern.compile("\\d+");
					Matcher matcher = pattern.matcher(textValidation);
					List<Integer> numericValues = new ArrayList<Integer>();
					while (matcher.find()) {
						int numericValue;
						numericValue = Integer.parseInt(matcher.group());
						numericValues.add(numericValue);
					}
					text = String.format("Showing %d to %d of %d entries", numericValues.get(0), numericValues.get(1),
							numericValues.get(2));
					// log.info(text);
					result=text.equals(textValidation);
				
				}
			} catch (Exception e) {
				// log.error("Pagination Icons are not displayed" + e);
			}
			return result;
		}
		
		
		// "Admin should see the footer as ""In total there are z programs"".
		// z- Total number of records"
		

		public boolean getTotalProgramCountFromFooter(String string) {
		    boolean result = false; // Default result
		    try {
		        System.out.println("I entered footer count page:");
		        
		        // Get the text from the footer
		        String footerText = PROGRAM_FOOTER.getText().trim();
		        
		        // Print the footer text for debugging
		        System.out.println("Footer text: " + footerText);
		        
		        // Using regex to extract the number from the string
		        String regex = "\\d+"; // Regex to match digits
		        Pattern pattern = Pattern.compile(regex);
		        Matcher matcher = pattern.matcher(footerText);
		        
		        String totalProgramCount = "";
		        
		        // If a match is found, extract the number
		        if (matcher.find()) {
		            totalProgramCount = matcher.group();
		        }
		        
		        // Print the total program count
		        System.out.println("Total Program Count: " + totalProgramCount);

		        // Check if both the string and the total program count are in the footer text
		        
		        result = footerText.contains(totalProgramCount);
		    } catch (NumberFormatException e) {
		        System.out.println("Error parsing total program count.");
		        result = false;
		    }
		    
		    return result;
		}

	
}
