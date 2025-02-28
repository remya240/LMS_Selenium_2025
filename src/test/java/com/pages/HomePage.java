package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.utilities.LoggerLoad;
import org.openqa.selenium.Point;
import org.openqa.selenium.Dimension;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HomePage {
	private WebDriver driver;
	private WebDriverWait wait;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement usernamefield;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordfield;

	@FindBy(xpath = "//span[@class='mat-select-placeholder mat-select-min-line ng-tns-c161-3 ng-star-inserted']")
	private WebElement roleDropdown;

	@FindBy(xpath = "//span[@class='mat-button-wrapper']")
	private WebElement Loginbutton;

	@FindBy(xpath = "//span[contains(text(),'LMS')]")
	private WebElement titleElement;

	@FindBy(xpath = "//mat-toolbar[@class='mat-toolbar mat-primary mat-toolbar-single-row ng-star-inserted']//div[contains(@class,'ng-star-inserted')]")
	private List<WebElement> navigationBarElements;

	@FindBy(xpath = "//app-doughnutchart")
	private WebElement piechart;
	@FindBy(xpath = "//strong[normalize-space()='Welcome sdetnumpyninja@gmail.com']")
	private WebElement welcomeUsernameElement;

	@FindBy(xpath = "//div[normalize-space()='ADMIN']")
	private WebElement adminRoleElement;

	@FindBy(xpath = "//mat-card-content[@class='mat-card-content']//canvas[@class='chartjs-render-monitor']")
	private WebElement barChartElement;

	@FindBy(xpath = "//figure[@class='mat-figure']//div//app-staffdata")
	private WebElement staffTableElement;

	@FindBy(xpath = "//div[@class='mat-paginator-range-actions']")
	private WebElement paginationIconsElement;

	@FindBy(xpath = "//mat-table[@role='grid']//mat-row")
	private List<WebElement> staffDataRows;

	@FindBy(xpath = "//button[@aria-label='Previous page']")
	private WebElement previousPageIcon;

	@FindBy(xpath = "//button[@aria-label='First page']")
	private WebElement firstPageIcon;

	@FindBy(xpath = "(//div[@class='container']//div[@class='top'])[1]")
	private WebElement userCount;

	@FindBy(xpath = "(//div[@class='container']//div[@class='top'])[2]")
	private WebElement staffCount;

	@FindBy(xpath = "(//div[@class='container']//div[@class='top'])[3]")
	private WebElement batchesCount;

	@FindBy(xpath = "(//div[@class='container']//div[@class='top'])[4]")
	private WebElement programCount;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public boolean isTitleAlignedToTopLeft() {
		try {
			wait.until(ExpectedConditions.visibilityOf(titleElement));
			Point location = titleElement.getLocation();
			Dimension windowSize = driver.manage().window().getSize();

			LoggerLoad.logInfo("Title Location: (" + location.getX() + ", " + location.getY() + ")");
			LoggerLoad.logInfo("Window Size: (" + windowSize.getWidth() + ", " + windowSize.getHeight() + ")");
			double xTolerance = 0.15; // 15% of window width
			double yTolerance = 0.10; // 10% of window height

			// Check if the title is within the tolerance range of the top-left corner
			boolean isAligned = location.getX() <= windowSize.getWidth() * xTolerance
					&& location.getY() <= windowSize.getHeight() * yTolerance;

			LoggerLoad.logInfo("Is Title Aligned to Top-Left Corner? " + isAligned);
			return isAligned;
		} catch (Exception e) {
			LoggerLoad.error("Error checking title alignment: " + e.getMessage());
			return false;
		}
	}

	public List<String> getNavigationBarTexts() {
		wait.until(ExpectedConditions.visibilityOfAllElements(navigationBarElements));

		String concatenatedText = navigationBarElements.get(0).getText();

		List<String> texts = Arrays.asList(concatenatedText.split("\n")); // Use "\n" or " " depending on the separator

		// Trim each item to remove extra whitespace
		texts = texts.stream().map(String::trim).collect(Collectors.toList());

		// Print extracted texts for debugging
		System.out.println("Extracted Navigation Bar Texts: " + String.join(", ", texts));
		return texts;
	}

	public String getTitleElement() {
		return titleElement.getText();
	}

	// Method to check if the navigation bar is on the top right side
	public boolean isNavigationBarOnTopRight() {
		Point navBarLocation = getNavigationBarLocation();
		Dimension navBarSize = getNavigationBarSize();

		Dimension windowSize = driver.manage().window().getSize();

		// Check if the navigation bar is on the top right side
		boolean isOnTopRight = navBarLocation.getX() + navBarSize.getWidth() >= windowSize.getWidth() * 0.8 &&

				navBarLocation.getY() <= windowSize.getHeight() * 0.2;

		return isOnTopRight;
	}

	public Point getNavigationBarLocation() {
		if (!navigationBarElements.isEmpty()) {
			return navigationBarElements.get(0).getLocation();
		} else {
			throw new RuntimeException("Navigation bar elements list is empty");
		}
	}

	// Method to get the size of the first navigation bar element
	public Dimension getNavigationBarSize() {
		if (!navigationBarElements.isEmpty()) {
			return navigationBarElements.get(0).getSize();
		} else {
			throw new RuntimeException("Navigation bar elements list is empty");
		}
	}

	public boolean isTextAtPosition(String text, int position) {
		List<String> texts = getNavigationBarTexts();

		LoggerLoad.logInfo("Navigation Bar Texts: " + texts);

		// Check if the position is valid
		if (position < 1 || position > texts.size()) {
			LoggerLoad.error("Invalid position: " + position + ". Navigation bar has " + texts.size() + " elements.");
			return false;
		}

		String actualText = texts.get(position - 1);

		LoggerLoad.logInfo("Expected Text (Position " + position + "): " + text);
		LoggerLoad.logInfo("Actual Text (Position " + position + "): " + actualText);

		return actualText.equals(text);
	}

	public WebElement verifyPieChartIsPresent() {
		return piechart;
	}

	public String getWelcomeUsername() {
		return welcomeUsernameElement.getText().replace("Welcome ", "").trim();
	}

	public String getAdminRole() {
		return adminRoleElement.getText().trim();
	}

	public WebElement waitForBarChart() {
		return wait.until(ExpectedConditions.visibilityOf(barChartElement));
	}

	public WebElement getBarChartElement() {
		return barChartElement;
	}

	public WebElement getStaffTableElement() {
		return staffTableElement;
	}

	public WebElement getPaginationIconsElement() {
		return paginationIconsElement;
	}

	public List<WebElement> getStaffDataRows() {
		return staffDataRows;
	}

	public WebElement getPreviousPageIcon() {
		return previousPageIcon;
	}

	public WebElement getFirstPageIcon() {
		return firstPageIcon;
	}

	public WebElement getUserCountElement() {
		return userCount;
	}

	public WebElement getStaffCountElement() {
		return staffCount;
	}

	public WebElement getBatchCountElement() {
		return batchesCount;
	}

	public WebElement getProgramCountElement() {
		return programCount;
	}

}
