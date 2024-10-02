package com.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProductDisplayPage {

	WebDriver driver;

	public ProductDisplayPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="iMac")
	WebElement Searchtext;
	
	@FindBy(xpath="(//a[@title='iMac'])[1]")
	WebElement productImg;
	
	@FindBy(xpath="//button[@title='Next (Right arrow key)']")
	WebElement nextbtn;
	
	
	@FindBy(xpath="//h1[contains(text(),'iMac')]")
	public WebElement productName;
	
	@FindBy(xpath="//a[contains(text(),'Apple')]")
	 WebElement Brand;
	
	
	@FindBy(xpath="//li[contains(text(),'Product')]")
	 WebElement ProductCode;
    
	@FindBy(xpath="//input[@id='input-quantity']")
	WebElement Quantity;
	
	@FindBy(id="input-quantity")
	WebElement productQuantity;
	
	@FindBy(id="button-cart")
	WebElement cartbtn;
	
	
	public void SetproductQuantity() {
		productQuantity.clear();
		productQuantity.sendKeys("0");
		cartbtn.click();
	}
	
	public String GetQuantity() {
		String Value= Quantity.getAttribute("value");
		return Value;
	}
	
	public void AssertProductDetails() {
		Assert.assertTrue(productName.isDisplayed());
		Assert.assertTrue(Brand.isDisplayed());
		Assert.assertTrue(ProductCode.isDisplayed());

	}
	
	public void Getproduct() {
		Searchtext.click();
	}
	
	public void ClickThumbnailImage() {
		productImg.click();
	}
	
	public void nextbtnclick() {
		for(int i=0;i<3;i++) {
			nextbtn.click();
		}
	}
}
