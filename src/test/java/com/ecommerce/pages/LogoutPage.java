package com.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {

	WebDriver driver;

	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Continue")
	WebElement Continuebtn;

	@FindBy(linkText = "Logout")
	WebElement LogoutLink;

	public void continuebtnclick() {
		Continuebtn.click();
	}
	
	public void LogoutLinkclick() {
		LogoutLink.click();
	}

}
