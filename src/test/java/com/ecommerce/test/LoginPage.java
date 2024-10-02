package com.ecommerce.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ecommerce.base.BaseClass;
import com.ecommerce.pages.LoginPagefactory;

public class LoginPage extends BaseClass {

	WebDriver driver;
	LoginPagefactory PageMethods;

	@BeforeMethod
	public void LoginSetup()  {
		driver = new ChromeDriver();
		driver.navigate().to(BaseURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		PageMethods = new LoginPagefactory(driver);
	}

	@Test(priority = 1)
	public void LoginWithcredentials() throws InterruptedException {
		Thread.sleep(2000);
		PageMethods.GetLoginMenu();
		PageMethods.GetLoginMenu(UserName, Password);
		String Title = driver.getTitle();
		Assert.assertEquals(Title, "My Account");
	}

	@Test(enabled=false)
	public void LoginWithKeyboardkeys() {
		PageMethods.GetLoginMenu();
		PageMethods.GetLoginMenuwithKeys(UserName, Password);
		String Title = driver.getTitle();
		Assert.assertEquals(Title, "My Account");
	}

	@Test(timeOut=1000)
	public void LoginWithInvalidcredentials() {

		PageMethods.GetLoginMenu();
		PageMethods.GetLoginMenu(InvalidUSerName, InvalidPassword);
		WebElement ErrorMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
		String Message = ErrorMessage.getText();
		Assert.assertEquals(Message, "Warning: No match for E-Mail Address and/or Password.");
	}

	@Test(priority = 4)
	public void LoginWithInvalidEmail() {

		PageMethods.GetLoginMenu();
		PageMethods.GetLoginMenu(InvalidUSerName, Password);
		WebElement ErrorMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
		String Message = ErrorMessage.getText();
		Assert.assertEquals(Message, "Warning: No match for E-Mail Address and/or Password.");
	}

	@Test(priority = 5)
	public void LoginWithInvalidPassword() {

		PageMethods.GetLoginMenu();
		PageMethods.GetLoginMenu(UserName, InvalidPassword);
		WebElement ErrorMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
		String Message = ErrorMessage.getText();
		Assert.assertEquals(Message, "Warning: No match for E-Mail Address and/or Password.");
	}

	@Test(priority = 6)
	public void ForgotLink() {

		PageMethods.GetLoginMenu();
		PageMethods.ForgotPasswordLink();
		String PageTitle = driver.getTitle();
		Assert.assertEquals(PageTitle, "Forgot Your Password?");
	}

	@Test(priority = 7)
	public void LoginAndLogout() {

		PageMethods.GetLoginMenu();
		PageMethods.GetLoginMenuwithKeys(UserName, Password);
		PageMethods.Logout();
		String Title = driver.getTitle();
		Assert.assertEquals(Title, "Account Logout");
	}

	@Test(priority = 8)
	public void PasswordResetandLogin() {

		PageMethods.GetLoginMenu();
		PageMethods.ForgotPasswordLink();
		PageMethods.ResestPassword(UserName);
	}

	@Test(priority = 9)
	public void verifyNavigationFromLoginPageToEditAccount() {

		PageMethods.GetLoginMenu();
		PageMethods.GetLoginMenuwithKeys(UserName, Password);
		PageMethods.EditAccount();
		Assert.assertTrue(driver.getTitle().contains("My Account Information"));
	}

	@Test(priority = 10)
	public void verifyNavigationFromLoginPageToDownloads() {

		PageMethods.GetLoginMenu();
		PageMethods.GetLoginMenuwithKeys(UserName, Password);
		PageMethods.Downloads();
		Assert.assertTrue(driver.getTitle().contains("Account Downloads"));
	}

	@Test(priority = 11)
	public void verifyNavigationFromLoginPageToWishList() {

		PageMethods.GetLoginMenu();
		PageMethods.GetLoginMenuwithKeys(UserName, Password);
		PageMethods.WishList();
		Assert.assertTrue(driver.getTitle().contains("My Wish List"));
	}

	@Test(priority = 12)
	public void verifyNavigationFromLoginPageToPassword() {

		PageMethods.GetLoginMenu();
		PageMethods.GetLoginMenuwithKeys(UserName, Password);
		PageMethods.Password();
		Assert.assertTrue(driver.getTitle().contains("Change Password2"));
	}

	@Test(priority = 13)
	public void verifyNavigationFromLoginPageToRecurringPayments() {

		PageMethods.GetLoginMenu();
		PageMethods.GetLoginMenuwithKeys(UserName, Password);
		PageMethods.reccurPayements();
		Assert.assertTrue(driver.getTitle().contains("Recurring Payments"));
	}

	@AfterMethod
	public void Destroy() {
		driver.quit();
	}
}
