package com.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MyAccountInformation {
	WebDriver driver;
	public MyAccountInformation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText="Edit your account information")
	WebElement EditAccountlink;
	
	@FindBy(linkText="Edit Account")
  WebElement EditAccountSidebarLink;
	
	@FindBy(id="input-firstname")
	WebElement MyAccountFnameinput;
	
	@FindBy(id="input-lastname")
	WebElement MyAccountLnameinput;
	
	@FindBy(id="input-email")
	WebElement MyAccountEmaileinput;
	
	@FindBy(id="input-telephone")
	WebElement MyAccountNumberinput;
	
	@FindBy(xpath="//input[@value='Continue']")
    WebElement Continuebtn;
	
	@FindBy(xpath="//div[@class='list-group']//a[text()='Logout']")
	WebElement LogoutLink;
	
	public void clickLogoutLink() {
		LogoutLink.click();
	}
	
	public void Coninuebtnclick() {
		Continuebtn.click();
	}
	
	public void FnameClearinput() {
		MyAccountFnameinput.clear();	
	}
	
	public void LnameClearinput() {
		MyAccountLnameinput.clear();	
	}
	
	public void EmailClearinput() {
		MyAccountEmaileinput.clear();	
	}
	
	public void NumberClearinput() {
		MyAccountNumberinput.clear();	
	}
	
	
	
	public void clickContinuebtn() {
		Continuebtn.click();
	}
	
	public void FillNumber(String Text) {
		MyAccountNumberinput.sendKeys(Text);
	}
	
	
	public void FillEmail(String Text) {
		MyAccountEmaileinput.sendKeys(Text);
	}
	
	public void FillLastName(String Text) {
		MyAccountLnameinput.sendKeys(Text);
	}
	
	public void FillFirstName(String Text) {
		MyAccountFnameinput.sendKeys(Text);
	}
	
	
	public void clickSideBarlink() {
		EditAccountSidebarLink.click();
	}
	public void clickEditAccountlink() {
		EditAccountlink.click();
	}
}
