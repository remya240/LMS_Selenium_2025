package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
     
	WebDriver ldriver;
	
	public LogoutPage(WebDriver driver) {
		ldriver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	LoginPage loginpage= new LoginPage(ldriver);
	
	
	public void clickLogout()
	{
		
		loginpage.click_logout();
	}
	
	public boolean logoutvalidation()
	{
		
		String curntURL=ldriver.getCurrentUrl();
		if(curntURL.equalsIgnoreCase(loginpage.LOGINPAGE_URL))
		return true;
		else
			return false;
	}
}
