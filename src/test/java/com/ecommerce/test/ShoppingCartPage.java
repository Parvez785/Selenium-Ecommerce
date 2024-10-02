package com.ecommerce.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ecommerce.base.BaseClass;
import com.ecommerce.pages.AddtocartPageObject;
import com.ecommerce.pages.LoginPagefactory;
import com.ecommerce.pages.Search;
import com.ecommerce.pages.ShoppingCartPageObject;

public class ShoppingCartPage extends BaseClass {
	WebDriver driver;
	Search searchObj;
	WebDriverWait wait;
	AddtocartPageObject Obj;
	LoginPagefactory PageMethods;
	ShoppingCartPageObject ShoppingCart;

	@BeforeMethod
	public void Setup() {
		driver = new ChromeDriver();
		driver.navigate().to(BaseURL);
		searchObj = new Search(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		ShoppingCart = new ShoppingCartPageObject(driver);
		Obj = new AddtocartPageObject(driver, wait);
		PageMethods = new LoginPagefactory(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}

	@Test
	public void VerifyNavigatingtoCartPage() throws InterruptedException {
		searchObj.SearchInput("iMac");
		searchObj.Btnclick();
		Obj.AddTocart();
		Thread.sleep(1000);
		ShoppingCart.ShoppingCartLink();
		Assert.assertTrue(driver.getTitle().contains("Shopping Cart"));
	}

	@Test
	public void verifyNavigationfromHeader() {
		searchObj.SearchInput("iMac");
		searchObj.Btnclick();
		Obj.AddTocart();
		ShoppingCart.ShopingCartHeaderLink();
		Assert.assertTrue(driver.getTitle().contains("Shopping Cart"));
	}

	@Test
	public void verifyShoppingCartwithoutProducts() throws InterruptedException {
		searchObj.SearchInput("iMac");
		searchObj.Btnclick();
		ShoppingCart.CartHeaderbtn();
		Thread.sleep(2000);
		String CartText = driver.findElement(By.xpath("//ul[@class='dropdown-menu pull-right']")).getText();
		Assert.assertEquals(true, CartText.equals("Your shopping cart is empty!"));
	}

	@Test
	public void verifyShoppingCartPagefromCartbtn() throws InterruptedException {
		searchObj.SearchInput("iMac");
		searchObj.Btnclick();
		Obj.AddTocart();
		ShoppingCart.CartHeaderbtn();
		WebElement cartbtn = driver.findElement(By.xpath("//a//Strong[contains(text(),\"View Cart\")]"));
		wait.until(ExpectedConditions.elementToBeClickable(cartbtn)).click();
		Assert.assertTrue(driver.getTitle().contains("Shopping Cart"));
	}

	@Test
	public void updatequantityoncartPage() throws InterruptedException {
		searchObj.SearchInput("iMac");
		searchObj.Btnclick();
		Obj.AddTocart();
		ShoppingCart.ShopingCartHeaderLink();
		ShoppingCart.updateProductQuantity("2");
		ShoppingCart.updatebtn();
		String Mesage = wait
				.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//div[@class='alert alert-success alert-dismissible']")))
				.getText();
		System.out.println(Mesage);
		Assert.assertTrue(Mesage.contains("Success: You have modified your shopping cart!"));
	}

	@Test
	public void updatequantityoncartPagewithinvalidValue() throws InterruptedException {
		searchObj.SearchInput("iMac");
		searchObj.Btnclick();
		Obj.AddTocart();
		ShoppingCart.ShopingCartHeaderLink();
		ShoppingCart.updateProductQuantity("Parvez");
		ShoppingCart.updatebtn();
		Assert.assertFalse(true);
	}

	@Test
	public void removeProductfromCart() {
		searchObj.SearchInput("iMac");
		searchObj.Btnclick();
		Obj.AddTocart();
		ShoppingCart.ShoppingCartLink();
		ShoppingCart.Removeproduct();
		String Message = driver
				.findElement(By.xpath("//div[@id='content']//p[contains(text(),'Your shopping cart is empty!')]"))
				.getText();
		Assert.assertEquals(true, Message.contains("Your shopping cart is empty!"));
		driver.findElement(By.xpath("//a[normalize-space()='Continue']")).click();
	}

	@Test
	public void ValidCouponCodeOnProduct() throws InterruptedException {
		searchObj.SearchInput("iMac");
		searchObj.Btnclick();
		Obj.AddTocart();
		Thread.sleep(2000);
		ShoppingCart.ShoppingCartLink();
		ShoppingCart.CouponToggle();
		ShoppingCart.AddCouponCode("Test");
		ShoppingCart.CouponBtnclick();
		String Message = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		Assert.assertEquals(true, Message.contains("Coupon Code Applied Sucesfully"));
	}

	@Test
	public void InvalidCouponCodeOnProduct() throws InterruptedException {
		searchObj.SearchInput("iMac");
		searchObj.Btnclick();
		Obj.AddTocart();
		Thread.sleep(1000);
		ShoppingCart.ShoppingCartLink();
		ShoppingCart.CouponToggle();
		ShoppingCart.AddCouponCode("Test");
		ShoppingCart.CouponBtnclick();
		String Message = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		Assert.assertEquals(true,
				Message.contains(" Warning: Coupon is either invalid, expired or reached its usage limit!"));
	}

	@Test
	public void EmptyCouponCodeonProduct() throws InterruptedException {
		searchObj.SearchInput("iMac");
		searchObj.Btnclick();
		Obj.AddTocart();
		Thread.sleep(1000);
		ShoppingCart.ShoppingCartLink();
		ShoppingCart.CouponToggle();
		ShoppingCart.AddCouponCode("");
		ShoppingCart.CouponBtnclick();
		String Message = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		Assert.assertEquals(true, Message.contains("Warning: Please enter a coupon code!"));
	}

	@Test
	public void RemoveErrorPopup() {
		searchObj.SearchInput("iMac");
		searchObj.Btnclick();
		Obj.AddTocart();
		ShoppingCart.ShoppingCartLink();
		ShoppingCart.CouponToggle();
		ShoppingCart.AddCouponCode("");
		ShoppingCart.CouponBtnclick();
		ShoppingCart.ErrorPopupClosebtnclick();
	}

	@Test
	public void ShippingEstsimate() {
		searchObj.SearchInput("iMac");
		searchObj.Btnclick();
		Obj.AddTocart();
		ShoppingCart.ShopingCartHeaderLink();
		ShoppingCart.ShippingToogleClick();
		ShoppingCart.SelectCountryOption("India");
		ShoppingCart.SelectRegion("Maharashtra");
		ShoppingCart.SelectPostCode("411046");
		ShoppingCart.Quotebtnclick();
		wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//input[@name='shipping_method']")))).click();
		ShoppingCart.Shippingbtnclick();
		WebElement Popup = wait.until(ExpectedConditions
				.visibilityOfElementLocated((By.xpath("//div[@class='alert alert-success alert-dismissible']"))));
		String Message = Popup.getText();

		Assert.assertTrue(Message.equals("Success: Your shipping estimate has been applied!"));
	}

	@Test
	public void CancelShiipingEstimate() {
		searchObj.SearchInput("iMac");
		searchObj.Btnclick();
		Obj.AddTocart();
		ShoppingCart.ShopingCartHeaderLink();
		ShoppingCart.ShippingToogleClick();
		ShoppingCart.SelectCountryOption("India");
		ShoppingCart.SelectRegion("Maharashtra");
		ShoppingCart.SelectPostCode("411046");
		ShoppingCart.Quotebtnclick();
		ShoppingCart.Cancelbtnclick();
	}

	@AfterMethod
	public void Destroy() {
		driver.quit();
	}

}
