package com.ecommerce.test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ecommerce.base.BaseClass;
import com.ecommerce.pages.LoginPagefactory;
import com.ecommerce.pages.WishListObject;

public class WishList extends BaseClass {
	LoginPagefactory PageMethods;
	WebDriver driver;
	WishListObject wishList;
	WebDriverWait wait;

	@BeforeTest
	public void Setup() {
		driver = new ChromeDriver();
		PageMethods = new LoginPagefactory(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wishList = new WishListObject(driver, wait);
		driver.manage().window().maximize();
		driver.get(BaseURL);
	}

	@Test
	public void AddToWishListfromRelatedPage() throws InterruptedException {
		driver.navigate().to(LoginPage);
		PageMethods.GetLoginMenu(UserName, Password);
		wishList.NavigateToAllDesktopLink();
		wishList.wishListbtnclick();
		wishList.WishlistLink();
		Thread.sleep(2000);
		WebElement text = driver.findElement(By.cssSelector("td[class='text-left'] a"));
		Assert.assertTrue(text.isDisplayed());
	}

	@Test
	public void AddtoWishListfromHome() throws InterruptedException {
		wishList.wishListbtnclick1();
		wishList.WishlistLink();
		WebElement popup = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success alert-dismissible']")));
		Assert.assertEquals(true, popup.isDisplayed());
		Thread.sleep(2000);
		WebElement text = driver.findElement(By.cssSelector("td[class='text-left'] a"));
		Assert.assertTrue(text.isDisplayed());
	}

	@Test
	public void AddToWishListfromSearch() throws InterruptedException {
		driver.navigate().to(LoginPage);
		PageMethods.GetLoginMenu(UserName, Password);
		wishList.Search("iMac");
		wishList.wishListbtnclick();
		wishList.WishlistLink();
		WebElement popup = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success alert-dismissible']")));
		Assert.assertEquals(true, popup.isDisplayed());
		Thread.sleep(2000);
		WebElement text = driver.findElement(By.cssSelector("td[class='text-left'] a"));
		Assert.assertTrue(text.isDisplayed());
	}

	@Test
	public void NavigateToWishListPage() {
		wishList.WishListLinkclick();
		PageMethods.GetLoginMenu(UserName, Password);
		Assert.assertEquals(true, driver.getTitle().contains("My Wish List"));
	}

	@Test
	public void VerifyNavigationtoWishListfromSideMenu() {
		PageMethods.GetLoginMenu();
		PageMethods.GetLoginMenu(UserName, Password);
		wishList.WishListSideMenuLink();
		Assert.assertEquals(true, driver.getTitle().contains("My Wish List"));
	}

	@Test
	public void VerifyNavigationtoWishListfromMyAccount() {
		PageMethods.GetLoginMenu();
		PageMethods.GetLoginMenu(UserName, Password);
		wishList.MyAccountLink();
		wishList.WishListSideMenuLink();
		Assert.assertEquals(true, driver.getTitle().contains("My Wish List"));

	}

	@Test
	public void VerifyNavigationtoWishListfromFootter() {
		PageMethods.GetLoginMenu();
		PageMethods.GetLoginMenu(UserName, Password);
		wishList.WishListFooterlink();
		Assert.assertEquals(true, driver.getTitle().contains("My Wish List"));
	}

	@Test
	public void removeProductFromWishList() throws InterruptedException {
		driver.navigate().to(LoginPage);
		PageMethods.GetLoginMenu(UserName, Password);
		wishList.NavigateToAllDesktopLink();
		wishList.wishListbtnclick();
		wishList.WishlistLink();
		Thread.sleep(2000);
		wishList.RemoveProduct();
		WebElement popup = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success alert-dismissible']")));
		Assert.assertEquals(true, popup.getText().contains("Success: You have modified your wish list!"));
	}

	@Test
	public void AddDuplicateProducts() throws InterruptedException {
		driver.navigate().to(LoginPage);
		PageMethods.GetLoginMenu(UserName, Password);
		wishList.NavigateToAllDesktopLink();
		for (int i = 0; i < 4; i++) {
			wishList.wishListbtnclick();
			Thread.sleep(2000);
		}
		wishList.WishlistLink();
		Thread.sleep(4000);
		List<WebElement> Table = driver.findElements(By.xpath("//tbody//tr"));
		// Check if there are more than one items in the wishlist
		if (Table.size() > 1) {
			Assert.assertTrue(true); // Assert true if more than one item
		} else {
			Assert.assertTrue(false); // Fail the test if only one or no item found
		}

	}

	@AfterMethod
	public void Destroy() {
		driver.quit();
	}

}
