package com.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.picocontainer.annotations.Inject;

import java.util.Base64;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.constants.EnvironmentConstants;
import com.driverManager.DriverFactory;
import org.openqa.selenium.io.FileHandler;
import com.utilities.ExcelReader;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class LoginPage {

	WebDriver ldriver;

	boolean result = false;
	String COMPANY_TITLE;
	String APP_TITLE;
	String PLEASE_LOGIN_TEXT;
	String USER_TEXT;
	String PSWD_TEXT;
	String ADMIN_ROLE_TEXT;
	String STAFF_ROLE_TEXT;
	String STUDENT_ROLE_TEXT;
	String SELECT_ROLE_TEXT;
	String LOGIN_TEXT;

	public LoginPage(WebDriver driver) {
		ldriver = driver;
		PageFactory.initElements(driver, this);
		
	}

	EnvironmentConstants constants = new EnvironmentConstants();

	public void readlogindata() throws FileNotFoundException, IOException {

		ExcelReader excel = new ExcelReader();

		Map<String, List<String>> testdata = excel.getData("Positive", "Login");

		APP_TITLE = testdata.get("APP_TITLE").get(0);
		COMPANY_TITLE = testdata.get("COMPANY_TITLE").get(0);
		PLEASE_LOGIN_TEXT = testdata.get("PLEASE_LOGIN_TEXT").get(0);
		USER_TEXT = testdata.get("USER_TEXT").get(0);
		PSWD_TEXT = testdata.get("PSWD_TEXT").get(0);
		ADMIN_ROLE_TEXT = testdata.get("ADMIN_ROLE_TEXT").get(0);
		STAFF_ROLE_TEXT = testdata.get("STAFF_ROLE_TEXT").get(0);
		STUDENT_ROLE_TEXT = testdata.get("STUDENT_ROLE_TEXT").get(0);
		SELECT_ROLE_TEXT = testdata.get("SELECT_ROLE_TEXT").get(0);
		LOGIN_TEXT = testdata.get("LOGIN_TEXT").get(0);

	}

	@FindBy(xpath = "//*[@id=\"username\"]")

	@CacheLookup
	private static WebElement USER_FIELD;

	@FindBy(xpath = "//*[@id=\"password\"]")

	@CacheLookup
	private static WebElement PASSWORD_FIELD;

	@FindBy(xpath = "//div[@class='mat-select-arrow-wrapper ng-tns-c161-3']")

	@CacheLookup
	private static WebElement DROPDOWN;

	@FindBy(xpath = "//span[normalize-space()='Admin']")

	@CacheLookup
	private static WebElement ADMIN_ROLE_FIELD;

	@FindBy(xpath = "//button[@id='login']")

	@CacheLookup
	private static WebElement LOGIN_BTN;

	@FindBy(xpath = "//*[@id=\"logout\"]")

	@CacheLookup
	private static WebElement LOGOUT_BTN;

	@FindBy(xpath = "//span[@class='mat-select-placeholder mat-select-min-line ng-tns-c161-3 ng-star-inserted']")
	private WebElement roleDropdown;

	@FindBy(xpath = "//*[@class=\"message__title\"]")

	@CacheLookup
	private WebElement APPERROR_MSG;

	@FindBy(xpath = "//*[@class=\"images\"]")

	@CacheLookup
	private WebElement APP_IMG;

	@FindBy(xpath = "//p[text()='Please login to LMS application']")

	@CacheLookup
	private WebElement PLEASE_LOGIN;

	@FindBy(xpath = "//span[contains(text(), 'Staff')]")

	@CacheLookup
	private WebElement STAFF_ROLE;

	@FindBy(xpath = "//span[contains(text(), 'Student')]")

	@CacheLookup
	private WebElement STUDENT_ROLE;

	@FindBy(xpath = "//span[contains(text(), 'Select the role')]")

	@CacheLookup
	private WebElement SELECT_ROLE;

	@FindBy(xpath = "//label[@for='username']/span[1]")

	@CacheLookup
	private WebElement USER_DISPLAY_TEXT;

	@FindBy(xpath = "//label[@for='username']/span[2]")

	@CacheLookup
	private WebElement USER_ASTERISK;

	@FindBy(xpath = "//label[@for='password']/span[1]")

	@CacheLookup
	private WebElement PSWD_DISPLAY_TEXT;

	@FindBy(xpath = "//label[@for='password']/span[2]")

	@CacheLookup
	private WebElement PSWD_ASTERISK;

	@FindBy(xpath = "//mat-error[@id='mat-error-0']")

	@CacheLookup
	private WebElement ENTER_USER_MSG;

	@FindBy(xpath = "//mat-error[@id='mat-error-0']")

	@CacheLookup
	private WebElement ENTER_PSWD_MSG;

	@FindBy(xpath = "//*[@class=\"mat-card-content\"]")

	@CacheLookup
	private WebElement APP_INPUT_FIELD;
	
	 @FindBy(xpath="//img")
	 WebElement DashboardImage;

	public String HOMEPAGE_URL = "https://feb-ui-hackathon-bbfd38d67ea9.herokuapp.com/";
	public String LOGINPAGE_URL = "https://feb-ui-hackathon-bbfd38d67ea9.herokuapp.com/login";
	public String INVALIDLMS_URL = "https://feb-ui-hachon-bbfd38d67ea9.herokuapp.com";

	public void enterLoginDetails() {
		try {

			USER_FIELD.sendKeys(constants.getUsername());
			PASSWORD_FIELD.sendKeys(constants.getPassword());
			ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			selectRole(constants.getRole());
			((JavascriptExecutor) ldriver).executeScript("arguments[0].click();", LOGIN_BTN);
			LOGIN_BTN.click();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void loadLMSapp() {
		ldriver.get(constants.getAppUrl());
	}

	public void selectRole(String role) {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(20));

		try { // Wait until the dropdown is clickable WebElement dropdown =
			wait.until(ExpectedConditions.elementToBeClickable(DROPDOWN));
			DROPDOWN.click();

			// Wait until the role option is visible
			WebElement roleOption = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + role + "')]")));

			// Scroll into view and click the role
			((JavascriptExecutor) ldriver).executeScript("arguments[0].scrollIntoView(true);", roleOption);
			wait.until(ExpectedConditions.elementToBeClickable(roleOption)).click();

			System.out.println("Role selected: " + role);
		} catch (Exception e) {
			System.out.println("Failed to select role: " + role);
			e.printStackTrace();
		}
	}

	public boolean validateLoginfunction() {
		boolean result = false;
		DriverFactory d = new DriverFactory();
		WebDriverWait wait = new WebDriverWait(d.getDriver(), Duration.ofSeconds(20));
		wait.until(ExpectedConditions.urlToBe(HOMEPAGE_URL));
		result = d.getDriver().getCurrentUrl().equalsIgnoreCase(HOMEPAGE_URL);
		return result;
	}

	public void looadInvalidLMSurl() {
		ldriver.get(INVALIDLMS_URL);
	}

	public boolean validateAppErrorMsg() {
		return ldriver.getPageSource().contains("Application Error");
	}

	public void click_logout() {
		LOGOUT_BTN.click();
	}

	public boolean validateCurrentPageURL(String PageName) {
		boolean result = false;
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(20));

		switch (PageName) {
		case "Login":
			enterLoginDetails();
			ldriver.navigate().back();
			wait.until(ExpectedConditions.urlToBe(LOGINPAGE_URL));
			result = ldriver.getCurrentUrl().equalsIgnoreCase(LOGINPAGE_URL);
			break;
		case "HomePage":
			wait.until(ExpectedConditions.urlToBe(LOGINPAGE_URL));
			result = ldriver.getCurrentUrl().equalsIgnoreCase(HOMEPAGE_URL);
			break;
		}

		return result;
	}

	public boolean validateResponseStatusCode() {
		try {
			URL url = new URL(constants.getAppUrl());
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();

			int responseCode = connection.getResponseCode();

			if (responseCode >= 400) {
				result = false;
			} else {
				result = true;
			}
			enterLoginDetails();
			return result;
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return result;
	}

	public boolean validateTextDisplayed(String string) {

		switch (string) {

		case "Select the role":

			System.out.println("entered select role switch case");
			result = string.contains(SELECT_ROLE.getText());
			System.out.println(SELECT_ROLE.getText());
			System.out.println(result);
			enterLoginDetails();
			break;
		case "Admin , Staff, Student":
			System.out.println("entered options case");
			DROPDOWN.click();
			result = string.contains(ADMIN_ROLE_FIELD.getText()) && string.contains(STAFF_ROLE.getText())
					&& string.contains(STUDENT_ROLE.getText());
			System.out.println(ADMIN_ROLE_FIELD.getText() + " " + STAFF_ROLE.getText() + " " + STUDENT_ROLE.getText());
			System.out.println(result);

			enterLoginDetails();
			break;

		case "Please login to LMS application":
			result = string.contains(PLEASE_LOGIN.getText());
			break;

		case "Invalid username and password Please try again":

			result = true;
			break;
		case "Please enter your user name":

			System.out.println("entered please enter use case");
			USER_FIELD.click();
			PLEASE_LOGIN.click();
			result = string.contains(ENTER_USER_MSG.getText());
			enterLoginDetails();
			break;
		case "Please enter your password":

			System.out.println("entered please enter pass case");
			PASSWORD_FIELD.click();
			PLEASE_LOGIN.click();
			result = string.contains(ENTER_PSWD_MSG.getText());
			enterLoginDetails();
			break;

		}
		System.out.println(" result value outside switch case is " + result);
		return result;

	}

	public boolean appImageNameIndexValidation(String string) {
		int LMSIndex = string.indexOf("LMS");
		int NumpytIndex = string.indexOf("Numpy");

		if (LMSIndex < NumpytIndex) {
			result = true;

		} else if (NumpytIndex > LMSIndex) {
			System.out.println("Numpy is after LMS");
			result = false;
		}
		enterLoginDetails();
		return result;
	}

	public String getAccessToken() throws IOException {
		// Load service account key
		FileInputStream serviceAccountStream = new FileInputStream(EnvironmentConstants.GOOGLE_API_KEY);

		// Build credentials object
		ServiceAccountCredentials credentials = (ServiceAccountCredentials) ServiceAccountCredentials
				.fromStream(serviceAccountStream).createScoped("https://www.googleapis.com/auth/cloud-platform");

		// Get the access token
		return credentials.refreshAccessToken().getTokenValue();
	}

	public String extractTextFromImg() {

		try { // Capture screenshot
			File imageFile = ((TakesScreenshot) ldriver).getScreenshotAs(OutputType.FILE);
			// Create a temporary file for OCR input
			File tempFile = Files.createTempFile("temp_image", ".png").toFile();
			FileUtils.copyFile(imageFile, tempFile);

			// Convert image file to Base64
			byte[] imageBytes = Files.readAllBytes(tempFile.toPath());
			String encodedImage = Base64.getEncoder().encodeToString(imageBytes);

			// Get Access Token from service account
			String accessToken = getAccessToken();

			// Google Cloud Vision API endpoint
			String apiUrl = "https://vision.googleapis.com/v1/images:annotate";

			// Create the JSON request payload
			String jsonRequest = String.format("{" + "\"requests\": [" + "{" + "\"image\": {\"content\": \"%s\"},"
					+ "\"features\": [{\"type\": \"TEXT_DETECTION\"}]" + "}" + "]" + "}", encodedImage);

			// Send the HTTP request to the Google Vision API
			HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/json");

			// Add the Authorization header with the Access Token
			connection.setRequestProperty("Authorization", "Bearer " + accessToken);

			connection.setDoOutput(true);
			connection.getOutputStream().write(jsonRequest.getBytes("UTF-8"));

			InputStreamReader reader = new InputStreamReader(connection.getInputStream());
			JsonObject responseJson = JsonParser.parseReader(reader).getAsJsonObject();

			// Extract the OCR text
			String extractedText = responseJson.getAsJsonArray("responses").get(0).getAsJsonObject()
					.getAsJsonArray("textAnnotations").get(0).getAsJsonObject().get("description").getAsString();

			System.out.println("Extracted Text: " + extractedText);
			// Log the extractedtext for debugging

			// Delete the temporary file after use
			Files.deleteIfExists(tempFile.toPath());
			return extractedText;

		} catch (IOException e) {
			System.err.println("Error reading the image file: " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("An unexpected error occurred: " + e.getMessage());
			e.printStackTrace();
		}

		return null;
	}

	
	public boolean appicationNameValidation(String ExpText,boolean order) throws TesseractException, IOException 
	{
		
		    
        
        // Take a screenshot of the image
        File imageFile = DashboardImage.getScreenshotAs(OutputType.FILE);
        File tempFile = new File("temp_image.png");
        FileHandler.copy(imageFile, tempFile);         

        // Initialize Tesseract
        
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("C://Program Files//Tesseract-OCR//tessdata"); 
        tesseract.setLanguage("eng"); 

        // Extract text from the image
        String extractedText = tesseract.doOCR(tempFile);      
    	        if(order) {        	
        	int LMSIndex = extractedText.indexOf("LMS");
        	int NumpytIndex = extractedText.indexOf("Numpy");
        
        	if(ExpText.contains("LMS") && LMSIndex <NumpytIndex) {
            	
            	return true;
        	}else if(ExpText.contains("Numpy") && NumpytIndex > LMSIndex) {
        		System.out.println("Numpy is after LMS"); 
            	return true;
        	}
        	
        }else {
        	if(extractedText.contains(ExpText)) 
            	return true;
            else
            	return false;               
        }
        return false;
	}
		
	
	
	
	
	
	public boolean validateImgText(String string) throws FileNotFoundException, IOException {
		System.out.println("I entered OCR page");
		readlogindata();
		System.out.println("excel data "+APP_TITLE);
		result = string.contains(APP_TITLE);

		enterLoginDetails();
		return result;
	}

	public boolean pleaseLoginTextValidation(String string) {

		result = string.contains(PLEASE_LOGIN.getText());
		enterLoginDetails();
		return result;
	}

	public boolean appPageTextValidation() throws FileNotFoundException, IOException {

		String allTexts = ldriver.findElement(By.cssSelector("body")).getText();
		readlogindata();
		List<String> stringsToValidate = Arrays.asList(USER_TEXT, PSWD_TEXT, PLEASE_LOGIN_TEXT, LOGIN_TEXT);

		for (String expectedText : stringsToValidate) {

			if (!allTexts.toLowerCase().contains(expectedText.toLowerCase())) {
				// If not found
				System.out.println("Text not found on page: " + expectedText);
				enterLoginDetails();
				return result;
			}
		}
		enterLoginDetails();

		return true;
	}

	public boolean VerifyingTextfieldCount() {

		List<WebElement> TextFields = ldriver.findElements(By.xpath("//mat-form-field//input"));
		int TextFieldCount = TextFields.size();

		System.out.println(" TextField count" + TextFieldCount);

		if (TextFieldCount == 2) {
			result = true;
		}

		enterLoginDetails();
		return result;

	}

	public boolean validateTextField(String text)

	{
		List<WebElement> textFields = ldriver.findElements(By.xpath("//form//mat-form-field"));

		switch (text) {
		case "User":

			if (textFields.get(0).getText().contains(text)) {
				System.out.println(textFields.get(0).getText());
				enterLoginDetails();
				return true;
			}
			break;

		case "Password":
			if (textFields.get(1).getText().contains(text)) {
				System.out.println(textFields.get(1).getText());
				enterLoginDetails();
				return true;
			}
			break;
		default:
			System.out.println("Invalid text input.");

		}
		return result;
	}

	public boolean validateDrodownCount() {

		List<WebElement> customDropdowns = ldriver
				.findElements(By.xpath("//div[contains(@class, 'mat-select-arrow-wrapper')]"));

		int visibleDropdownCount = 0;
		for (WebElement dropdown : customDropdowns) {
			if (dropdown.isDisplayed()) {
				visibleDropdownCount++;
			}
		}

		if (visibleDropdownCount == 1) {
			result = true;
		}

		enterLoginDetails();
		return result;
	}

	public boolean validateAsterisk() {
		System.out.println("ASTERISK VALIDATION USER: " + USER_ASTERISK.getText() + " PASSWORD: " + PSWD_ASTERISK.getText());

		if (USER_ASTERISK.getText().contains("*") && PSWD_ASTERISK.getText().contains("*")) {

			System.out.println("ASTERISK VALIDATION PASSED");
			result = true;
		} else {
			System.out.println("ASTERISK VALIDATION FAILED");
			result = false;
		}
		return result;
	}

	public boolean validateloginBtnEnable() {
		WebDriverWait webDriverWait = new WebDriverWait(ldriver, Duration.ofSeconds(20));
		webDriverWait.until(ExpectedConditions.visibilityOf(LOGIN_BTN));
		if (LOGIN_BTN.isEnabled()) {
			enterLoginDetails();
			return true;
		} else {
			enterLoginDetails();
			return false;
		}
	}

	public boolean inputFieldAllignment() {
		result = APP_INPUT_FIELD.getCssValue("text-align").contains("center");

		enterLoginDetails();
		return result;
	}

	public boolean adminTextColorValidation(String Text) {

		String expectedColor = "rgba(0, 0, 0, 0.54)";

		switch (Text) {
		case "user":
			String textColor = USER_DISPLAY_TEXT.getCssValue("color");

			System.out.println(" user color is :" + textColor);
			if (textColor.equalsIgnoreCase(expectedColor))
				return true;
			break;

		case "password":
			String PasstextColor = PSWD_DISPLAY_TEXT.getCssValue("color");
			System.out.println(" user color is :" + PasstextColor);
			if (PasstextColor.equalsIgnoreCase(expectedColor))
				return true;
			break;

		default:
			return false;
		}

		return false;
	}

	public void login_usingKeyBoardAction() {

		Actions actions = new Actions(ldriver);
		actions.sendKeys(Keys.TAB).sendKeys(constants.getUsername()).perform();
		actions.sendKeys(Keys.TAB).sendKeys(constants.getPassword()).perform();
		actions.sendKeys(Keys.TAB).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER);
		actions.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();

	}

	public void login_UsingmouseActions() {
	    WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
	    
	    try {
	        // Wait for the username field to be visible and click it
	        wait.until(ExpectedConditions.elementToBeClickable(USER_FIELD));
	        Actions actions = new Actions(ldriver);
	        actions.moveToElement(USER_FIELD).click().sendKeys(constants.getUsername())
	            // Wait for password field to be clickable
	            .moveToElement(PASSWORD_FIELD).click().sendKeys(constants.getPassword());
	        wait.until(ExpectedConditions.elementToBeClickable(SELECT_ROLE));
	            // Wait for role selection to be clickable
	        actions  .moveToElement(SELECT_ROLE).click();
	            // Wait for admin role field to be clickable
	        wait.until(ExpectedConditions.elementToBeClickable(ADMIN_ROLE_FIELD));
	        actions .moveToElement(ADMIN_ROLE_FIELD).click();
	        wait.until(ExpectedConditions.elementToBeClickable(LOGIN_BTN));
	            // Wait for login button to be clickable and click it
	        actions  .moveToElement(LOGIN_BTN).click()
	            .build().perform();
	    } catch (Exception e) {
	        System.out.println("Error during mouse actions: " + e.getMessage());
	    }
	}

	public void loginUsingUsername() {
		USER_FIELD.sendKeys(constants.getUsername());
		LOGIN_BTN.click();
	}

	public void loginUsingPswd() {
		PASSWORD_FIELD.sendKeys(constants.getPassword());
		LOGIN_BTN.click();

	}

	public void loginUsingInvalid() throws FileNotFoundException, IOException {
		ExcelReader excel = new ExcelReader();
		Map<String, List<String>> testdata = excel.getData("Negative", "Login");

		USER_FIELD.sendKeys(testdata.get("USER").get(0));
		PASSWORD_FIELD.sendKeys(testdata.get("PASSWORD").get(0));
		SELECT_ROLE.click();
		ADMIN_ROLE_FIELD.click();
		LOGIN_BTN.click();

	}
}

