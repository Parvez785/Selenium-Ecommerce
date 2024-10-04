package com.ecommerce.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
	WebDriver driver;
	WebDriverWait wait;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[text()='Checkout']")
	WebElement Checkoutbtn;
	
	@FindBy(xpath="//a[@title='Checkout']")
	WebElement CheckoutLink;
	
	@FindBy(xpath="//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")
	WebElement CheckoutMenubtn;
	
	@FindBy(xpath="(//a//strong)[2]")
	WebElement Cartlink;
	
	
	
	public void ClickMenubtn() {
		CheckoutMenubtn.click();
	}
	public void Clickcartlink() {
		Cartlink.click();
	}
	
	
	public void Checkoutbtnclick() {
		Checkoutbtn.click();	}
	
	public void NavigateToCheckouts() {
		CheckoutLink.click();
	}
	
	
	
	
}
