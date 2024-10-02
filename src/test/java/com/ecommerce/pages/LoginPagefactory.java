package com.ecommerce.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPagefactory {
	WebDriver driver;

	public LoginPagefactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@title='My Account']")
	WebElement Logindropdown;
	@FindBy(linkText = "Login")
	WebElement LoginLink;

	@FindBy(id = "input-email")
	WebElement EmailInput;

	@FindBy(id = "input-password")
	WebElement PasswordInput;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement LoginBtn;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement ErrorMessage;

	@FindBy(linkText = "Forgotten Password")
	WebElement ForgotPasswordLink;

	@FindBy(linkText = "Logout")
	WebElement Logout;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement ContinueBtn;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement sucessMessage;

	@FindBy(linkText = "Order History")
	WebElement OrderHistory;

	@FindBy(linkText = "Edit Account")
	WebElement EditAccount;

	@FindBy(linkText = "Password")
	WebElement PasswordLink;

	@FindBy(linkText = "Address Book")
	WebElement AddressBook;

	@FindBy(linkText = "Wish List")
	WebElement WishList;

	@FindBy(linkText = "Downloads")
	WebElement Downloads;

	@FindBy(linkText = "Recurring payments")
	WebElement reccurPayements;

	public void GetLoginMenu() {
		Logindropdown.click();
		LoginLink.click();
	}

	public void Logout() {
		Logindropdown.click();
		Logout.click();
	}

	public void GetLoginMenu(String Email, String Password) {
		EmailInput.sendKeys(Email);
		PasswordInput.sendKeys(Password);
		LoginBtn.click();
	}

	public void GetLoginMenuwithKeys(String Email, String Password) {
		EmailInput.sendKeys(Email);
		EmailInput.sendKeys(Keys.TAB);
		PasswordInput.sendKeys(Password);
		EmailInput.sendKeys(Keys.TAB);
		LoginBtn.sendKeys(Keys.ENTER);
	}

	public void ForgotPasswordLink() {
		ForgotPasswordLink.click();

	}

	public void reccurPayements() {
		reccurPayements.click();
	}

	public void Password() {
		PasswordLink.click();
	}

	public void WishList() {
		WishList.click();
	}

	public void Downloads() {
		Downloads.click();
	}

	public void EditAccount() {
		EditAccount.click();
	}

	public void GetMyAccountPage() {
		OrderHistory.click();
	}

	public void ResestPassword(String args1) {
		EmailInput.sendKeys(args1);
		ContinueBtn.click();
		Boolean Message = sucessMessage.getText()
				.equals("An email with a confirmation link has been sent your email address.");
		Assert.assertTrue(Message);
	}

}
