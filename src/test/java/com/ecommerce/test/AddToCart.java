package com.ecommerce.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ecommerce.base.BaseClass;
import com.ecommerce.pages.AddtocartPageObject;
import com.ecommerce.pages.LoginPagefactory;
import com.ecommerce.pages.Search;

public class AddToCart extends BaseClass {
	WebDriver driver;
	Search searchObj;
	AddtocartPageObject Obj;
	WebDriverWait wait;
	LoginPagefactory PageMethods;

	@BeforeMethod
	public void Setup() {
		driver = new ChromeDriver();
		driver.navigate().to(BaseURL);
		searchObj = new Search(driver);
		PageMethods = new LoginPagefactory(driver);
		Obj = new AddtocartPageObject(driver, wait);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}

	@Test
	public void AddProductTocartFromProductPage() throws InterruptedException {
		driver.get(ProductPage);
		searchObj.SearchInput("iMac");
		searchObj.Btnclick();
		Obj.AddTocart();
		Thread.sleep(2000);
		WebElement Message = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
		Assert.assertEquals(true, Message.getText().contains("Success: You have added iMac to your shopping cart!"));
		Obj.ShopPagelink();
		WebElement productName = driver.findElement(By.xpath("(//a[contains(text(),'iMac')])[2]"));
		Assert.assertTrue(productName.isDisplayed());
	}

	@Test
	public void AddProductTocartFromWishListPage() {
		PageMethods.GetLoginMenu();
		PageMethods.GetLoginMenu(UserName, Password);
		searchObj.SearchInput("iMac");
		searchObj.Btnclick();
		Obj.WishListbtn();
		Obj.WishListPageLink();
		Obj.AddTocartbtn();
		Obj.ShopPagelink();
		WebElement productName = driver.findElement(By.xpath("(//a[contains(text(),'iMac')])[2]"));
		Assert.assertTrue(productName.isDisplayed());
	}

	@Test
	public void AddtoCartFromRelatedSection() {
		driver.get("https://tutorialsninja.com/demo/index.php?route=product/category&path=20");
		Obj.SideMaclink();
		Obj.AddTocart2();
		Obj.ShopPagelink();
		WebElement productName = driver.findElement(By.xpath("(//a[contains(text(),'iMac')])[2]"));
		Assert.assertTrue(productName.isDisplayed());
	}

	@Test
	public void AddtoCartFromHomePage() {

		Obj.AddTocart2();
		Obj.ShopPagelink();
		WebElement productName = driver.findElement(By.xpath("(//a[contains(text(),'iMac')])[2]"));
		Assert.assertTrue(productName.isDisplayed());
	}
	
	
	

	@AfterMethod
	public void Destroy() {
		driver.quit();
	}
}
