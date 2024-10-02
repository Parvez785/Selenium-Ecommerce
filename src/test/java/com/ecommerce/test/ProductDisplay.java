package com.ecommerce.test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ecommerce.base.BaseClass;
import com.ecommerce.pages.ProductDisplayPage;
import com.ecommerce.pages.Search;

public class ProductDisplay extends BaseClass {
	WebDriver driver;
	Search searchObj;
	ProductDisplayPage DisplayObj;

	@BeforeMethod
	public void Setup() {
		driver = new ChromeDriver();
		searchObj = new Search(driver);
		DisplayObj = new ProductDisplayPage(driver);
		driver.get(ProductPage);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void verifyImageThumbnails() throws InterruptedException {
		searchObj.SearchInput("iMac");
		searchObj.Btnclick();
		DisplayObj.Getproduct();
		DisplayObj.ClickThumbnailImage();
		DisplayObj.nextbtnclick();
	}

	@Test
	public void ProductDetails() {
		searchObj.SearchInput("iMac");
		searchObj.Btnclick();
		DisplayObj.Getproduct();
		DisplayObj.AssertProductDetails();
	}

	@Test
	public void verifyproductquantity() {
		searchObj.SearchInput("iMac");
		searchObj.Btnclick();
		DisplayObj.Getproduct();
		Assert.assertTrue(DisplayObj.GetQuantity().equals("1"));
	}

	@Test
	public void verifyNegativeQuantity() throws InterruptedException {
		searchObj.SearchInput("iMac");
		searchObj.Btnclick();
		DisplayObj.Getproduct();
		DisplayObj.SetproductQuantity();
		Thread.sleep(2000);
	}

	@AfterMethod
	public void Destroy() {
		driver.quit();
	}

}
