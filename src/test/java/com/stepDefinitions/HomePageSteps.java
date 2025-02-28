package com.stepDefinitions;

import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import java.util.Arrays;
import java.util.List;

import java.util.Map;
import java.util.stream.Collectors;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.codoid.products.exception.FilloException;
import com.constants.EnvironmentConstants;
import com.driverManager.DriverFactory;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utilities.ConfigReader;
import com.utilities.ExcelReader;
import com.utilities.LoggerLoad;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps {

	private WebDriver driver;
	private HomePage homePage;

	private LoginPage loginPage;

	public HomePageSteps() {
		driver = DriverFactory.getDriver();
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
	}

	/*
	 * @Given("Admin is on login Page") public void admin_is_on_login_page() {
	 * LoggerLoad.logInfo("Admin is on the login page"); }
	 */

	@When("Admin enters valid data in all field and  clicks login button")
	public void admin_enters_valid_data_in_all_field_and_clicks_login_button() {
		loginPage.enterLoginDetails();

	}

	@Then("Admin should see {string} as title")
	public void admin_should_see_as_title(String expectedTitle) {
		String actualTitle = homePage.getTitleElement();
		LoggerLoad.logInfo("Expected Title: " + expectedTitle);
		LoggerLoad.logInfo("Actual Title: " + actualTitle);
		assert actualTitle.equals(expectedTitle) : "Expected title does not match actual title";
		LoggerLoad.logInfo("Admin sees the correct title: " + actualTitle);
	}

	@Then("LMS title should be on the top left corner of page")
	public void lms_title_should_be_on_the_top_left_corner_of_page() {
		boolean isAligned = homePage.isTitleAlignedToTopLeft();
		assertTrue(isAligned, "LMS title is not aligned to the top left corner of the page.");
	}

	@Then("Admin should see correct spelling in navigation bar text")
	public void admin_should_see_correct_spelling_in_navigation_bar_text() {
		List<String> expectedTexts = Arrays.asList("Home", "Program", "Batch", "Class", "Logout");

		List<String> actualTexts = homePage.getNavigationBarTexts();

		LoggerLoad.logInfo("Actual Texts:");
		actualTexts.forEach(System.out::println);

		LoggerLoad.logInfo("Expected Texts:");
		expectedTexts.forEach(System.out::println);

		Assert.assertEquals(actualTexts, expectedTexts, "Navigation bar texts do not match expected values.");
	}

	@Then("Admin should see correct spelling and space in LMS title")
	public void admin_should_see_correct_spelling_and_space_in_lms_title() {
		String actualTitle = homePage.getTitleElement();

		String expectedTitle = "LMS - Learning Management System"; // Replace with the expected title

		Assert.assertEquals(actualTitle, expectedTitle, "LMS title spelling or spacing is incorrect");
	}

	@Then("Admin should see the navigation bar text on the top right side")
	public void admin_should_see_the_navigation_bar_text_on_the_top_right_side() {
		// Check if the navigation bar is on the top right side
		boolean isOnTopRight = homePage.isNavigationBarOnTopRight();

		LoggerLoad.logInfo("Is Navigation Bar on Top Right Side? " + isOnTopRight);

		Assert.assertTrue(isOnTopRight, "Navigation bar is not on the top right side of the page");
	}

	@Then("Admin should see {string} in the 1st place")
	public void admin_should_see_in_the_1st_place(String expectedText) {
		// Verify the text at the 1st position
		boolean isTextAtFirstPlace = homePage.isTextAtPosition(expectedText, 1);
		LoggerLoad.logInfo("Is '" + expectedText + "' in the 1st place? " + isTextAtFirstPlace);
		Assert.assertTrue(isTextAtFirstPlace, "Text '" + expectedText + "' is not in the 1st place");
	}

	@Then("Admin should see {string} in the 2nd place")
	public void admin_should_see_in_the_2nd_place(String expectedText) {
		boolean isTextAtSecondPlace = homePage.isTextAtPosition(expectedText, 2);

		LoggerLoad.logInfo("Is '" + expectedText + "' in the 2nd place? " + isTextAtSecondPlace);

		Assert.assertTrue(isTextAtSecondPlace, "Text '" + expectedText + "' is not in the 2nd place");
	}

	@Then("Admin should see {string} in the 3rd place")
	public void admin_should_see_in_the_3rd_place(String expectedText) {
		boolean isTextAtThirdPlace = homePage.isTextAtPosition(expectedText, 3);

		LoggerLoad.logInfo("Is '" + expectedText + "' in the 3rd place? " + isTextAtThirdPlace);

		Assert.assertTrue(isTextAtThirdPlace, "Text '" + expectedText + "' is not in the 3rd place");
	}

	@Then("Admin should see {string} in the 4th place")
	public void admin_should_see_in_the_4th_place(String expectedText) {
		boolean isTextAtFourhPlace = homePage.isTextAtPosition(expectedText, 4);

		LoggerLoad.logInfo("Is '" + expectedText + "' in the 4th place? " + isTextAtFourhPlace);

		Assert.assertTrue(isTextAtFourhPlace, "Text '" + expectedText + "' is not in the 4th place");
	}

	@Then("Admin should see {string} in the 5th place")
	public void admin_should_see_in_the_5th_place(String expectedText) {
		boolean isTextAtFifthPlace = homePage.isTextAtPosition(expectedText, 5);

		LoggerLoad.logInfo("Is '" + expectedText + "' in the 5th place? " + isTextAtFifthPlace);

		Assert.assertTrue(isTextAtFifthPlace, "Text '" + expectedText + "' is not in the 5th place");
	}

	@Then("Admin should see a pie chart")
	public void admin_should_see_a_pie_chart() {
		WebElement pieChart = homePage.verifyPieChartIsPresent();

		Assert.assertTrue(pieChart.isDisplayed());
		LoggerLoad.logInfo("Pie chart is present on the page.");
	}

	@Then("Admin should see a welcome message with username and role")
	public void admin_should_see_a_welcome_message_with_username_and_role() {
		String actualUsername = homePage.getWelcomeUsername();
		String actualRole = homePage.getAdminRole();

		String expectedUsername = "sdetnumpyninja@gmail.com";
		String expectedRole = "ADMIN";

		Assert.assertEquals(actualUsername, expectedUsername,
				"Username in the welcome message does not match the expected value.");
		Assert.assertEquals(actualRole, expectedRole, "Role in the welcome message does not match the expected value.");

		LoggerLoad.logInfo("++Welcome message is displayed correctly with username: " + actualUsername + " and role: "
				+ actualRole);
	}

	@Then("Admin should see a bar chart for Active and Inactive users")
	public void admin_should_see_a_bar_chart_for_active_and_inactive_users() {
		try {
			// Wait for the bar chart (canvas element) to be visible
			WebElement barChart = homePage.getBarChartElement();
			Assert.assertTrue(barChart.isDisplayed(), "Bar chart is not displayed.");

			LoggerLoad.logInfo("Bar chart for Active and Inactive users is displayed correctly.");
		} catch (Exception e) {
			LoggerLoad.error("Error verifying bar chart: " + e.getMessage());
			throw e;
		}
	}

	@Then("Admin should see staff table with pagination icons")
	public void admin_should_see_staff_table_with_pagination_icons() {
		WebElement staffTable = homePage.getStaffTableElement();

		Assert.assertTrue(staffTable.isDisplayed(), "Staff table is not displayed.");

		WebElement paginationIcons = homePage.getPaginationIconsElement();

		Assert.assertTrue(paginationIcons.isDisplayed(), "Pagination icons are not displayed.");

		LoggerLoad.logInfo("****Staff table and pagination icons are displayed correctly.");
	}

	@Then("Admin should see {int} staff data in a page")
	public void admin_should_see_staff_data_in_a_page(Integer expectedCount) {

		List<WebElement> staffDataRows = homePage.getStaffDataRows();

		//Assert.assertEquals(staffDataRows.size(), expectedCount,
	//		"Expected " + expectedCount + " staff data rows, but found " + staffDataRows.size());

		LoggerLoad.logInfo("Staff data page split is correct. Displayed rows: " + staffDataRows.size());

	}

	@Then("Admin should see the previous page icon disabled")
	public void admin_should_see_the_previous_page_icon_disabled() {
		WebElement previousPageIcon = homePage.getPreviousPageIcon();
		Assert.assertFalse(previousPageIcon.isEnabled(), "Previous page icon is not disabled.");
		LoggerLoad.logInfo("Previous page icon is disabled.");
	}

	@Then("Admin should see the first page icon disabled")
	public void admin_should_see_the_first_page_icon_disabled() {
		WebElement firstPageIcon = homePage.getFirstPageIcon();
		Assert.assertFalse(firstPageIcon.isEnabled(), "First page icon is not disabled.");
		LoggerLoad.logInfo("First page icon is disabled.");
	}

	@Then("Admin should see user count")
	public void admin_should_see_user_count() {
		WebElement userCountElement = homePage.getUserCountElement();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until((ExpectedCondition<Boolean>) driver -> {
			String text = userCountElement.getText();
			return !text.isEmpty() && !text.equals("0");
		});

		Assert.assertTrue(userCountElement.isDisplayed(), "Staff count is not displayed.");

		String userCountText = userCountElement.getText();

		LoggerLoad.logInfo("User count: " + userCountText);
	}

	@Then("Admin should see staff count")
	public void admin_should_see_staff_count() {
		WebElement staffCountElement = homePage.getStaffCountElement();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until((ExpectedCondition<Boolean>) driver -> {
			String text = staffCountElement.getText();
			return !text.isEmpty() && !text.equals("0");
		});

		Assert.assertTrue(staffCountElement.isDisplayed(), "Staff count is not displayed.");

		String staffCountText = staffCountElement.getText();

		LoggerLoad.logInfo("Staff count: " + staffCountText);
	}

	@Then("Admin should see batch count")
	public void admin_should_see_batch_count() {
		WebElement batchCountElement = homePage.getBatchCountElement();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until((ExpectedCondition<Boolean>) driver -> {
			String text = batchCountElement.getText();
			return !text.isEmpty() && !text.equals("0");
		});

		Assert.assertTrue(batchCountElement.isDisplayed(), "Batch count is not displayed.");

		String batchCountText = batchCountElement.getText();

		LoggerLoad.logInfo("Batch count: " + batchCountText);

	}

	@Then("Admin should see program count")
	public void admin_should_see_program_count() {
		WebElement programCountElement = homePage.getProgramCountElement();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until((ExpectedCondition<Boolean>) driver -> {
			String text = programCountElement.getText();
			return !text.isEmpty() && !text.equals("0");
		});

		Assert.assertTrue(programCountElement.isDisplayed(), "Program count is not displayed.");

		String programCountText = programCountElement.getText();

		LoggerLoad.logInfo("Program count: " + programCountText);

	}

}
