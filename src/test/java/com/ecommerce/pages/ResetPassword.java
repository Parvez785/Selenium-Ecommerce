package com.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPassword {

	WebDriver driver;

	public ResetPassword(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Forgotten Password")
	private WebElement ForgotLink;

	@FindBy(id = "input-email")
	private WebElement inputField;

	@FindBy(xpath = "//input[@value=\"Continue\"]")
	private WebElement btn;
	
	@FindBy(xpath = "//input[@value=\"Login\"]")
	private WebElement btnLogin;
	
@FindBy(id="input-password")
private WebElement PaswordInput;
	
	

	public void ForgotLink() {
		ForgotLink.click();
	}

	public void PassEmail(String Email) {
		inputField.sendKeys(Email);
		btn.click();
	}

	public void Login(String Email,String Password) {
		inputField.sendKeys(Email);
		PaswordInput.sendKeys(Password);
		btnLogin.click();
		
	}
	
	
}
