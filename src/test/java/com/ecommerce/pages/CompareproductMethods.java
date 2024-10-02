package com.ecommerce.pages;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CompareproductMethods {
	WebDriver driver;
	WebDriverWait wait;
	Actions action;

	public CompareproductMethods(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		action = new Actions(driver);
		// Initialize WebDriverWait
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@FindBy(xpath = "//button[3]")
	WebElement Comparebtn;

	@FindBy(linkText = "product comparison")
	WebElement CmpPageLink;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	public WebElement PopupMessage;

	@FindBy(xpath = "//a[normalize-space()='Desktops']")
	WebElement DesktopMenu;

	@FindBy(xpath = "//a[normalize-space()='Show AllDesktops']")
	WebElement ShowsAllDesktop;
	
	
	@FindBy(id = "grid-view")
	WebElement gridview;
	
	@FindBy(xpath="//button[@data-original-title=\"Compare this Product\"][1]")
	WebElement AppleCinemabtn;
	
	@FindBy(xpath="//button[@data-original-title='Compare this Product'][1]")
	WebElement Cmpbtn1;
	
	@FindBy(xpath="//p[normalize-space()='You have not chosen any products to compare.']")
	public WebElement EmptyProductComparison;
	
	@FindBy(id="compare-total")
	public WebElement productCompareLink;
	
	@FindBy(linkText="Continue")
	WebElement ProductComparePagebtn;
	

	@FindBy(xpath="//ul[@class='breadcrumb']//li[2]/a")
	public WebElement BreadCrumb;
	
	
	@FindBy(xpath="//input[@value='Add to Cart']")
	WebElement AddToCart;
	
	@FindBy(xpath="//a[normalize-space()='Remove']")
	WebElement RmBtn;
	
	public void RemovEProduct() {
		wait.until(ExpectedConditions.elementToBeClickable(RmBtn)).click();;

	}
	
	
	public void AddtoCart() {
		wait.until(ExpectedConditions.elementToBeClickable(AddToCart)).click();;
	}
	
	
	public void ContinueBtnclick() {
		ProductComparePagebtn.click();
	}
	
	public void productCompareLink() {
		productCompareLink.click();
	}
	
	
	public void cmpbntClick() {
		Cmpbtn1.click();
	}

	public void NavigatetoAllDesktop() {
		DesktopMenu.click();
		wait.until(ExpectedConditions.visibilityOf(ShowsAllDesktop));
		ShowsAllDesktop.click();
	}
	
	public void GridView() {
		gridview.click();
	}

	public void comparePagelink() {
		CmpPageLink.click();
	}

	
	public void ComparePage() {
		boolean Str = wait.until(ExpectedConditions.visibilityOf(CmpPageLink)).isDisplayed();
		Assert.assertTrue(Str);
	}

	public void Cmpbntclick() {
		Comparebtn.click();
	}

}
