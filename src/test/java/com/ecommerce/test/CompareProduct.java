package com.ecommerce.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ecommerce.base.BaseClass;
import com.ecommerce.pages.CompareproductMethods;
import com.ecommerce.pages.Search;

public class CompareProduct extends BaseClass {
	WebDriver driver;
	WebDriverWait wait;
	Search search;
	CompareproductMethods cmpObj;

	@BeforeMethod
	public void Setup() {
		driver = new ChromeDriver();
		search = new Search(driver);
		cmpObj = new CompareproductMethods(driver, wait);
		driver.get(ProductPage);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@Test
	public void DisplayProductonComparePage() {
		search.SearchInput("iMac");
		search.Btnclick();
		cmpObj.Cmpbntclick();
		cmpObj.ComparePage();
	}

	@Test
	public void DisplayproductusingGridView() throws InterruptedException {
		search.SearchInput("iMac");
		search.Btnclick();
		cmpObj.Cmpbntclick();
		boolean Message = wait.until(ExpectedConditions.visibilityOf(cmpObj.PopupMessage)).isDisplayed();
		Assert.assertTrue(Message);
		cmpObj.comparePagelink();
		Thread.sleep(2000);
		Assert.assertTrue(driver.getTitle().contains("Product Comparison"));
	}

	@Test
	public void AddproductusingListView() throws InterruptedException {
		cmpObj.NavigatetoAllDesktop();
		search.SearchInput("iMac");
		search.Btnclick();
		cmpObj.GridView();
		cmpObj.Cmpbntclick();
		cmpObj.ComparePage();
		boolean Message = wait.until(ExpectedConditions.visibilityOf(cmpObj.PopupMessage)).isDisplayed();
		Assert.assertTrue(Message);
		cmpObj.comparePagelink();
		Thread.sleep(2000);
		Assert.assertTrue(driver.getTitle().contains("Product Comparison"));
	}

	@Test
	public void AddProductCompareFromFeaturedSection() {
		driver.navigate().to(HomePage);
		cmpObj.cmpbntClick();
		boolean Message = wait.until(ExpectedConditions.visibilityOf(cmpObj.PopupMessage)).isDisplayed();
		Assert.assertTrue(Message);
		cmpObj.comparePagelink();
	}

	@Test
	public void NavigatetoProductComparePagefromSearch() {
		search.SearchInput("iMac");
		search.Btnclick();
		cmpObj.Cmpbntclick();
		Assert.assertTrue(driver.getTitle().contains("Product Comparison"));
	}

	@Test
	public void NavigatetoProductComparePagewithoutProduct() {
		cmpObj.NavigatetoAllDesktop();
		cmpObj.productCompareLink();
		Assert.assertTrue(cmpObj.EmptyProductComparison.isDisplayed());
	}

	@Test
	public void NavigatetoProductComparePageAndNavigateBack() {
		cmpObj.NavigatetoAllDesktop();
		cmpObj.productCompareLink();
		cmpObj.ContinueBtnclick();
		Assert.assertTrue(
				driver.getCurrentUrl().contains("https://tutorialsninja.com/demo/index.php?route=common/home"));
	}

	@Test
	public void ProductCompareBreadcrumb() throws InterruptedException {
		search.SearchInput("iMac");
		search.Btnclick();
		cmpObj.Cmpbntclick();
		Thread.sleep(2000);
		Assert.assertTrue(cmpObj.BreadCrumb.isDisplayed());// Asserting That breadCrumb is visible
	}

	@Test
	public void ProductsDisplayedAfteromparison() throws InterruptedException {
		search.SearchInput("iMac");
		search.Btnclick();
		cmpObj.Cmpbntclick();
		Thread.sleep(2000);
		cmpObj.comparePagelink();
		WebElement text = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[normalize-space()='iMac']")));
		Assert.assertTrue(text.getText().contains("iMac"));
	}

	@Test
	public void AddProductToCart() throws InterruptedException {
		search.SearchInput("iMac");
		search.Btnclick();
		cmpObj.Cmpbntclick();
		Thread.sleep(2000);
		cmpObj.comparePagelink();
		cmpObj.AddtoCart();
		WebElement alerts = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success alert-dismissible']")));
		Assert.assertTrue(alerts.getText().contains("Success: You have added iMac to your shopping cart!"));
	}

	@Test
	public void RemoveProductFRomCart() throws InterruptedException {
		search.SearchInput("iMac");
		search.Btnclick();
		cmpObj.Cmpbntclick();
		Thread.sleep(2000);
		cmpObj.comparePagelink();
		cmpObj.RemovEProduct();
		WebElement alerts = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success alert-dismissible']")));
		Assert.assertTrue(alerts.getText().contains("Success: You have modified your product comparison!"));
	}

	@AfterMethod
	public void Destroy() {
		driver.quit();
	}

}
