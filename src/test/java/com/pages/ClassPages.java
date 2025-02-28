package com.pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.utilities.LoggerLoad;

public class ClassPages {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//span[text()='Class']")
    private WebElement classButton;

    @FindBy(xpath = "//div[contains(@class, 'box') and contains(text(), 'Manage Class')]")
    private WebElement manageClassheader;

    @FindBy(xpath = "//button[@class='p-button-danger p-button p-component p-button-icon-only']//span[@class='p-button-icon pi pi-trash']")
    private WebElement commonDeleteButton;

    @FindBy(xpath = "//div[@class='p-dialog-header ng-tns-c118-11 ng-star-inserted']")
    private WebElement confirmAlert;

    @FindBy(xpath = "//span[normalize-space()='Yes']")
    private WebElement yesButton;

    @FindBy(xpath = "//table[@role='grid']")
    private WebElement dataTable;

    @FindBy(xpath = "//span[@class='p-button-icon p-button-icon-left pi pi-times']")
    private WebElement noButton; 
    
    
    
    
    public ClassPages(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void clickClass() {
        LoggerLoad.logInfo("Clicking the Class Navigation bar...");

        // Wait for the overlay to disappear
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath("//div[contains(@class, 'cdk-overlay-backdrop')]")));
            LoggerLoad.logInfo("Overlay disappeared.");
        } catch (Exception e) {
            LoggerLoad.error("Overlay did not disappear: " + e.getMessage());
        }

        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", classButton);
            LoggerLoad.logInfo("Class Navigation bar clicked using JavaScript.");
        } catch (Exception e) {
            LoggerLoad.error("Failed to click Class Navigation bar: " + e.getMessage());
            throw new RuntimeException("Failed to click Class Navigation bar: " + e.getMessage());
        }
    }
    public boolean isDeleteButtonEnabled() {
        try {
            return commonDeleteButton.isEnabled();
        } catch (Exception e) {
            LoggerLoad.error("Failed to check if delete button is enabled: " + e.getMessage());
            return false; 
        }
    }

    public void selectClassCheckbox(String className, int maxPagesToCheck) {
        LoggerLoad.logInfo("Selecting checkbox for class: " + className);
        closeOverlayIfPresent();

        for (int page = 1; page <= maxPagesToCheck; page++) {
            LoggerLoad.logInfo("Checking page " + page + " for class: " + className);

            try {
                String checkboxXPath = "//td[normalize-space()='" + className + "']/preceding-sibling::td//p-tablecheckbox//div[contains(@class,'p-checkbox-box')]";
                WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(checkboxXPath)));
                
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
                
                LoggerLoad.logInfo("Checkbox for class '" + className + "' selected on page " + page + ".");
                return;  // Exit if checkbox is found and clicked
            } catch (Exception e) {
                LoggerLoad.logInfo("Class " + className + " not found on page " + page + ".");
            }

            // Navigate to the next page
            if (page < maxPagesToCheck) {
                try {
                    // Scroll to pagination controls
                    WebElement paginationSection = driver.findElement(By.xpath("//div[contains(@class, 'p-paginator-bottom')]"));
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", paginationSection);

                    // Click the next page button
                    WebElement nextPageButton = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[contains(@class, 'p-paginator-page') and text()='" + (page + 1) + "']")));
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", nextPageButton);

                    // Wait for table update
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@role='grid']//tr[1]")));
                } catch (Exception e) {
                    LoggerLoad.error("Error navigating to the next page: " + e.getMessage());
                    throw new RuntimeException("Error navigating to the next page: " + e.getMessage());
                }
            }
        }

        LoggerLoad.logInfo("Class " + className + " not found within " + maxPagesToCheck + " pages.");
        throw new RuntimeException("Class " + className + " not found.");
    }
    public void clickDeleteButton() {
        LoggerLoad.logInfo("Clicking the delete button...");
        closeOverlayIfPresent();
        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(commonDeleteButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", deleteButton);
    }

    public void clickYesButton() {
        LoggerLoad.logInfo("Clicking the Yes button...");
        WebElement yesBtn = wait.until(ExpectedConditions.elementToBeClickable(yesButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", yesBtn);
    }

    public WebElement getConfirmAlert() {
        LoggerLoad.logInfo("Getting the Confirm Deletion alert...");
        return wait.until(ExpectedConditions.visibilityOf(confirmAlert));
    }

    public boolean isManageClassPageDisplayed() {
        LoggerLoad.logInfo("Checking if Manage Class page is displayed...");
        try {
            // Log current URL and page title for debugging
            LoggerLoad.logInfo("Current URL: " + driver.getCurrentUrl());
            LoggerLoad.logInfo("Page Title: " + driver.getTitle());

            // Wait for the page to load completely
            wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));

            // Wait for the element to be present in the DOM
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'box') and contains(text(), 'Manage Class')]")));

            // Wait for the element to be visible
            return wait.until(ExpectedConditions.visibilityOf(manageClassheader)).isDisplayed();
        } catch (TimeoutException e) {
            LoggerLoad.error("Manage Class page is not displayed: " + e.getMessage());
            return false;
        }
    }
    
    
    
    
    
    

    public boolean isClassPresentInTable(String className) {
        LoggerLoad.logInfo("Checking if class " + className + " is present in the data table...");
        try {
            WebElement classRow = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//td[text()='" + className + "']")));
            return classRow.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    private void closeOverlayIfPresent() {
        LoggerLoad.logInfo("Closing overlay if present...");
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, 'cdk-overlay-backdrop')]")));
        } catch (Exception e) {
            LoggerLoad.logInfo("No overlay found or overlay already closed.");
        }
    }
    
    
    
    public void clickNoButton() {
        LoggerLoad.logInfo("Clicking the No button...");
        WebElement noBtn = wait.until(ExpectedConditions.elementToBeClickable(noButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", noBtn);
    }    
}
