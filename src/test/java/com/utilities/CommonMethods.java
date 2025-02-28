package com.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.driverManager.DriverFactory;

public class CommonMethods {
	public WebDriver driver = DriverFactory.getDriver();
	WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
	
	
	public void waitForElement(WebElement element) {
		webDriverWait.until(ExpectedConditions.visibilityOf(element));
	}
	public boolean isElementDisplayed(WebElement element) {
		boolean flag = false;
		try {

			WebElement ele = new WebDriverWait(driver, Duration.ofSeconds(30))
					.until(ExpectedConditions.visibilityOf(element));

			if (ele.isDisplayed()) {
				flag = true;
			}

			else {
				throw new Exception("Element is not displayed");
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return flag;
	}
	public boolean ClickOnWebelement(WebElement element) {
		try {
			WebElement element_tobe_click = new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.elementToBeClickable(element));

			if (element_tobe_click.isEnabled() && element_tobe_click.isDisplayed()) {
				try {
					element_tobe_click.click();
					return true;
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
			} else {
				throw new Exception(element + " Element is not enabled or clickable or displayed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public String getattribute(WebElement element, String name) {

		String attributeValue = element.getDomProperty(name);
		System.out.println("Element's" + name + "atrribute value is: " + attributeValue);
		return attributeValue;
	}
	
	public String getElementAttribute(WebElement element,String attribute) {
		WebElement textElement = new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOf(element));
		return textElement.getDomProperty(attribute);
	}
	
	public void assertText(WebElement element, String expected,String msg) {
		Assert.assertTrue(getElementText(element).equals(expected),msg);
	}
	public String getElementText(WebElement ele) {
		WebElement textElement = new WebDriverWait(driver, Duration.ofSeconds(30))
				.until(ExpectedConditions.visibilityOf(ele));
		return textElement.getText();
	}
	
	

}
