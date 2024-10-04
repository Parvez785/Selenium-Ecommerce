package com.ecommerce.test;

import java.util.concurrent.TimeUnit;

import org.bouncycastle.oer.its.ieee1609dot2.basetypes.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ecommerce.base.BaseClass;
import com.ecommerce.pages.LoginPagefactory;
import com.ecommerce.pages.MyAccount;

public class myAccountPage extends BaseClass {

	WebDriver driver;
	LoginPagefactory logins;
	MyAccount account;

	@BeforeMethod
	public void Setup() {
		driver = new ChromeDriver();
		driver.get(BaseURL);
		driver.manage().window().maximize();
		logins = new LoginPagefactory(driver);
		account = new MyAccount(driver);
	}

	// Verify that user is navigated to My Account after login
	@Test(priority = 1)
	public void Myaccount() throws InterruptedException {
		logins.GetLoginMenu();
		logins.GetLoginMenu(UserName, Password);
		Thread.sleep(1000);
		Assert.assertEquals(driver.getTitle(), "My Account");
	}

	// Verify Navigating to My Account using Footer links and then login
	@Test(priority = 2)
	public void SiteMaplogin() throws InterruptedException {
		account.FooterLoginlink();
		logins.GetLoginMenu(UserName, Password);
		Thread.sleep(1000);
		Assert.assertEquals(driver.getTitle(), "My Account");
	}

	// Verify Navigating to My Account using Sitemap on page
	@Test(priority = 3)
	public void loginUsingSiteMap() throws InterruptedException {
		account.SiteMaplinkisClicked();
		account.MyAccountLinkisClicked();
		logins.GetLoginMenu(UserName, Password);
		Thread.sleep(1000);
		Assert.assertEquals(driver.getTitle(), "My Account");

	}

	// Verify Account BreadCrumb is displayed on MyAccount Page

	@Test(priority = 4)
	public void BreadcrumbisDisplayed() throws InterruptedException {
		logins.GetLoginMenu();
		logins.GetLoginMenu(UserName, Password);
		Thread.sleep(1000);
		boolean breadCrumb = driver.findElement(By.xpath("//ul[@class='breadcrumb']//li[2]")).isDisplayed();
		Assert.assertTrue(breadCrumb, "The BreaCrumb is not displayed on My Account Page");
	}

	@AfterMethod
	public void Teardown() {
		driver.quit();
	}
}
