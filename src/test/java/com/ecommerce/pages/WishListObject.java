package com.ecommerce.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WishListObject {
	WebDriver driver;
	WebDriverWait wait;

	public WishListObject(WebDriver driver,WebDriverWait wait) {
		this.driver = driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='dropdown-toggle'][normalize-space()='Desktops']")
	WebElement DesktopMenuLink;
	
	@FindBy(xpath="//*[@id=\"menu\"]/div[2]/ul/li[1]/div/a")
	WebElement AllDesktopLink;
	
	@FindBy(linkText="-Mac (1)")
	WebElement MackLink;
	
	@FindBy(xpath="//button[contains(@data-original-title,\"Add to Wish List\")]")
	WebElement WishListbtn;
	
	@FindBy(xpath="//button[contains(@data-original-title,\"Add to Wish List\")][1]")
	WebElement WishListHome1;
	
	@FindBy(xpath="//a[normalize-space()='wish list']")
	WebElement WishListlink;
	
	@FindBy(xpath="//input[@name=\"search\"]")
	WebElement SearchBar;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	WebElement Searchbtn;
	
	@FindBy(id="wishlist-total")
	WebElement WishListHeaderLink;
	
	@FindBy(xpath="//a[@class=\"list-group-item\"][normalize-space()='Wish List']")
    WebElement WishListSideMenuLink;	
	
	@FindBy(xpath="//a[@class=\"list-group-item\"][normalize-space()='My Account']")
	WebElement MyAccountLink;
	
	@FindBy(xpath="//ul[@class='list-unstyled']//a[normalize-space()='Wish List']")
	WebElement WishListFooterlink;
	
	@FindBy(xpath="//a[@data-original-title='Remove']")
	WebElement RemoveBtn;
	
	
	public void RemoveProduct() {
		RemoveBtn.click();
	}
	
	public void WishListFooterlink() {
		WishListFooterlink.click();
	}
	
	
	public void MyAccountLink() {
		MyAccountLink.click();
	}
	
	public void WishListSideMenuLink() {
		WishListSideMenuLink.click();
	}
	
	public void WishListLinkclick() {
		WishListHeaderLink.click();
	}
	
	public void NavigateToAllDesktopLink() throws InterruptedException {
		DesktopMenuLink.click();
		Thread.sleep(1000);
		AllDesktopLink.click();
		MackLink.click();
	}
	
	public void wishListbtnclick() {
		WishListbtn.click();
	}
	
	public void wishListbtnclick1() {
		WishListHome1.click();
	}
	
	public void WishlistLink() {
		wait.until(ExpectedConditions.elementToBeClickable(WishListlink)).click();
	}
	public void Search(String Search) {
		SearchBar.sendKeys(Search);
		Searchbtn.click();
	}
	
}
