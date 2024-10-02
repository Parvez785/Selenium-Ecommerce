package com.ecommerce.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ecommerce.base.BaseClass;
import com.ecommerce.pages.LoginPagefactory;
import com.ecommerce.pages.LogoutPage;

public class LogoutPageTestCases extends BaseClass {
	WebDriver driver;
	LoginPagefactory PageMethods;
	LogoutPage LogoutMethods;

	@BeforeMethod
	public void Setup() throws MalformedURLException {
		driver = new ChromeDriver();
		PageMethods = new LoginPagefactory(driver);
		LogoutMethods = new LogoutPage(driver);
		driver.navigate().to(BaseURL);
		driver.manage().window().maximize();
	}

	@Test
	public void Logout_functionality1() throws InterruptedException {
		PageMethods.GetLoginMenu();
		PageMethods.GetLoginMenuwithKeys(UserName, Password);
		PageMethods.Logout();
		LogoutMethods.continuebtnclick();
		Thread.sleep(2000);
		String Title = driver.getTitle();
		Assert.assertEquals(Title, "Your Store");

	}

	@Test
	public void Logout_functionalityBySideMenu() {
		PageMethods.GetLoginMenu();
		PageMethods.GetLoginMenuwithKeys(UserName, Password);
		LogoutMethods.LogoutLinkclick();
		LogoutMethods.continuebtnclick();
		String Title = driver.getTitle();
		Assert.assertEquals(Title, "Your Store");
	}

	@Test
	public void Logout_functionAndNavigateBack() throws InterruptedException {
		PageMethods.GetLoginMenu();
		PageMethods.GetLoginMenuwithKeys(UserName, Password);
		LogoutMethods.LogoutLinkclick();
		PageMethods.Logout();
		LogoutMethods.continuebtnclick();
		driver.navigate().back();
		String Title = driver.getTitle();
		Thread.sleep(2000);
		Assert.assertEquals(Title, "Account Logout");
	}

	@Test
	public void CheckLogoutAndLogin() {
		PageMethods.GetLoginMenu();
		PageMethods.GetLoginMenuwithKeys(UserName, Password);
		LogoutMethods.LogoutLinkclick();
		PageMethods.GetLoginMenu();
		PageMethods.GetLoginMenuwithKeys(UserName, Password);
		String Title = driver.getTitle();
		Assert.assertEquals(Title, "My Account");
	}

	@AfterMethod
	public void closesetup() {
		driver.quit();

	}

}
