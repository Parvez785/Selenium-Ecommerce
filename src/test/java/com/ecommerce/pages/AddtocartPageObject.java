package com.ecommerce.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddtocartPageObject {
	WebDriver driver;
	WebDriverWait wait;

	public AddtocartPageObject(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// Initialize WebDriverWait
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@FindBy(xpath = "//*[@id=\"content\"]/div[3]/div/div/div[2]/div[2]/button[1]")
	WebElement AddTocartbtn;

	@FindBy(xpath = "//*[@id=\"content\"]/div[3]/div/div/div[2]/div[2]/button[2]")
	WebElement WishListbtn;

	@FindBy(linkText = "wish list")
	WebElement WishListPageLink;

	@FindBy(linkText = "//div[@class=\"alert alert-success alert-dismissible\"]/a[2]")
	WebElement ShoppingCartLink;
	
	@FindBy(xpath="//div[@class=\"alert alert-success alert-dismissible\"]/a[normalize-space()=\"wish list\"]")
	WebElement WishListAddTocartbtn;
	
    @FindBy(linkText="-Mac (1)")
    WebElement SideMaclink;

    @FindBy(xpath="//div[@class=\"button-group\"]//button[1]")
    WebElement Addtocartbtn2;
    
    
    public void SideMaclink() {
		wait.until(ExpectedConditions.elementToBeClickable(SideMaclink)).click();

	}
    
    
	public void AddTocart() {
		AddTocartbtn.click();

	}
	
	public void AddTocart2() {
		Addtocartbtn2.click();

	}

	public void WishListbtn() {
		WishListbtn.click();
	}

	public void ShopPagelink() {
		wait.until(ExpectedConditions.elementToBeClickable(ShoppingCartLink)).click();
	}

	public void WishListPageLink() {
		wait.until(ExpectedConditions.elementToBeClickable(WishListPageLink)).click();

	}
	
	public void AddTocartbtn() {
		wait.until(ExpectedConditions.elementToBeClickable(WishListAddTocartbtn)).click();
	}

}
