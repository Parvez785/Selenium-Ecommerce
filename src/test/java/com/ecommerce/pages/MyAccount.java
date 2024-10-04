package com.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount {

	WebDriver driver;
	
	public MyAccount(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//ul[@class='list-unstyled']//li//a[text()='My Account']")
     WebElement FooterLoginlink;
	
	@FindBy(linkText="Site Map")
	WebElement SiteMaplink;
	
	
	@FindBy(xpath="(//a[normalize-space()='My Account'])[2]")
	WebElement MyAccountlink;
	
	
	public void MyAccountLinkisClicked() {
		MyAccountlink.click();
	}
	
	public void SiteMaplinkisClicked() {
		SiteMaplink.click();
	}
	
	public void FooterLoginlink() {
		FooterLoginlink.click();
	}
}
