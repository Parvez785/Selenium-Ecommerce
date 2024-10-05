package com.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPageObject {
	WebDriver driver;
	public ForgotPasswordPageObject(WebDriver driver){
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="#input-password")
	WebElement NewPasswordInput;
	
	@FindBy(css="#input-confirm")
	WebElement ConfirmPasswordInput;
	
	@FindBy(linkText="Change your password")
	WebElement ForgotPasswordLink;
		
	@FindBy(xpath="//a[normalize-space()='Password']")
	WebElement PasswordSideLink;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement Continuebtn;
	
	@FindBy(xpath="//a[normalize-space()='Back']")
	WebElement Backbtn;
	
	public void ClickBackbtn() {
		Backbtn.click();
	}
	
	public void Continuebtnclick() {
		Continuebtn.click();
	}
	
	public void clickSidebarlink() {
		PasswordSideLink.click();
	}
	
	public void clickForgotPasswordLink() {
		ForgotPasswordLink.click();
	}
	
	public void inputPassword(String Password) {
		NewPasswordInput.sendKeys(Password);
	}
	
	public void confirmPasswordInput(String confirmPassword) {
		ConfirmPasswordInput.sendKeys(confirmPassword );
	}
	
	
}
