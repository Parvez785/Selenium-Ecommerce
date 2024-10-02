package com.ecommerce.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ecommerce.base.BaseClass;
import com.ecommerce.pages.AddtocartPageObject;
import com.ecommerce.pages.CheckoutPage;
import com.ecommerce.pages.Search;
import com.ecommerce.pages.ShoppingCartPageObject;

public class Checkoutpages extends BaseClass {

	WebDriver driver;
	CheckoutPage Objects;
	Search searchObj;
	AddtocartPageObject Obj;
	WebDriverWait wait;
	ShoppingCartPageObject ShoppingCart;

	
	@BeforeMethod
	public void Setup() {
		driver = new ChromeDriver();
		driver.get(BaseURL);
		Objects = new CheckoutPage(driver);
		 searchObj = new Search(driver);
		 ShoppingCart= new ShoppingCartPageObject(driver);
		 Obj = new AddtocartPageObject(driver, wait);
		driver.manage().window().maximize();
	}

	@Test
	public void NavigatetoCheckout() {
		Objects.NavigateToCheckouts();
		String EmptyMsg = driver
				.findElement(By.xpath("//div[@id='content']//p[contains(text(),'Your shopping cart is empty!')]"))
				.getText();
		Assert.assertTrue(EmptyMsg.contains("Your shopping cart is empty!"));
	}
	@Test
	public void NavigateToCheckoutPage() throws InterruptedException {
		searchObj.SearchInput("iMac");
		searchObj.Btnclick();
		Obj.AddTocart();
		Thread.sleep(1000);
		ShoppingCart.ShoppingCartLink();
		
	}

	@AfterMethod
	public void Destroy() {
		driver.quit();
	}
	
	
}
