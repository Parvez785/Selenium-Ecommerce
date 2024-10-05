package com.ecommerce.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ecommerce.base.BaseClass;
import com.ecommerce.pages.LoginPagefactory;
import com.ecommerce.pages.MyAccount;
import com.ecommerce.pages.MyAccountInformation;

public class Myaccountinformation extends BaseClass {
	WebDriver driver;

	LoginPagefactory login;
	MyAccountInformation info;

	@BeforeMethod
	public void Setup() {
		driver = new FirefoxDriver();
		driver.get(BaseURL);
		driver.manage().window().maximize();
		login = new LoginPagefactory(driver);
		info = new MyAccountInformation(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	// Navigating to My Account information page after login
	@Test
	public void NavigateToAccountinformation() {
		login.GetLoginMenu();
		login.GetLoginMenu(UserName, Password);
		info.clickEditAccountlink();
		Assert.assertEquals(driver.getTitle(), "My Account Information");

	}

	// Navigating to My Account information page by Side Menu link
	@Test
	public void NavigateToAccountinformationfromSideLink() {
		login.GetLoginMenu();
		login.GetLoginMenu(UserName, Password);
		info.clickSideBarlink();
		Assert.assertEquals(driver.getTitle(), "My Account Information");
	}

	// Verify login after Updating Details in My Account information
	@Test
	public void updateDetails() throws InterruptedException {
		login.GetLoginMenu();
		login.GetLoginMenu("test+786@gmail.com", Password);
		info.clickSideBarlink();
		info.FnameClearinput();
		info.FillFirstName("test");
		info.LnameClearinput();
		info.FillLastName("QA");
		info.EmailClearinput();
		info.FillEmail("test+786@gmail.com");
		info.NumberClearinput();
		info.FillNumber("2012012016");
		info.clickContinuebtn();
		Thread.sleep(2000);
		String Message = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"))
				.getText();
		Assert.assertTrue(Message.equals("Success: Your account has been successfully updated."));
		info.clickLogoutLink();
		login.GetLoginMenu();
		login.GetLoginMenu("test+786@gmail.com", Password);
		Thread.sleep(1000);
		Assert.assertEquals(driver.getTitle(), "My Account");

	}

	@Test
	// Updating user details with empty input to verify validation
	public void EmptyInfoOfUser() throws InterruptedException {
		login.GetLoginMenu();
		login.GetLoginMenu("test+786@gmail.com", Password);
		info.clickEditAccountlink();
		info.FnameClearinput();
		info.LnameClearinput();
		info.EmailClearinput();
		info.NumberClearinput();
		info.clickContinuebtn();
		Thread.sleep(1000);
		WebElement ErrorFname = driver
				.findElement(By.xpath("//div[text()='First Name must be between 1 and 32 characters!']"));
		Assert.assertTrue(ErrorFname.isDisplayed());
		WebElement ErrorLname = driver
				.findElement(By.xpath("//div[text()='Last Name must be between 1 and 32 characters!']"));
		Assert.assertTrue(ErrorLname.isDisplayed());
		WebElement ErrorEmail = driver
				.findElement(By.xpath("//div[contains(text(),'E-Mail Address does not appear to be valid!')]"));
		Assert.assertTrue(ErrorEmail.isDisplayed());

		WebElement ErrorNumber = driver
				.findElement(By.xpath("//div[contains(text(),'Telephone must be between 3 and 32 characters!')]"));
		Assert.assertTrue(ErrorNumber.isDisplayed());
	}

	@Test
	// Verifying Email input with invalid email format
	public void invalidinput() {
		login.GetLoginMenu();
		login.GetLoginMenu("test+786@gmail.com", Password);
		info.clickSideBarlink();
		info.FnameClearinput();
		info.FillFirstName("test");
		info.LnameClearinput();
		info.FillLastName("QA");
		info.EmailClearinput();
		info.FillEmail("test786@gmail");
		info.NumberClearinput();
		info.FillNumber("2012012016");
		info.clickContinuebtn();
		WebElement ErrorEmail = driver
				.findElement(By.xpath("//div[contains(text(),'E-Mail Address does not appear to be valid!')]"));
		Assert.assertTrue(ErrorEmail.isDisplayed());
	}
	//Verify Back button on My Account information Page redirects to My Account
	@Test
	public void NavigateBack() {
		login.GetLoginMenu();
		login.GetLoginMenu("test+786@gmail.com", Password);
		info.clickSideBarlink();
		info.clickBackbutton();
		Assert.assertEquals(driver.getTitle(), "My Account");
	}

	@AfterTest
	public void destroy() {
		driver.quit();
	}
}
