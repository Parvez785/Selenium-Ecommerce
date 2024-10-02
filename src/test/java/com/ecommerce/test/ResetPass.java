package com.ecommerce.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ecommerce.base.BaseClass;
import com.ecommerce.pages.ResetPassword;

public class ResetPass extends BaseClass {

	public WebDriver driver;
	WebDriverWait wait;
	ResetPassword Rmethod;

	@BeforeMethod
	public void Setup() throws MalformedURLException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(LoginPage);
		Rmethod = new ResetPassword(driver);
		 wait= new WebDriverWait(driver, Duration.ofSeconds(5));
	}

	@Test
	public void ResetPassword() {

		Rmethod.ForgotLink();
		Rmethod.PassEmail(UserName);
		WebElement Message = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success alert-dismissible']")));
		String GetMessage = Message.getText();
		Assert.assertTrue(GetMessage.equals("An email with a confirmation link has been sent your email address."));
	}

	@Test
	public void LoginBeforeResetPassword() {
		Rmethod.Login(UserName, Password);
		String Title = driver.getTitle();
		Assert.assertTrue(Title.equals("My Account"));
	}

	@Test(priority=1)
	public void ResetPasswordwithincorrectEmail() {
		Rmethod.ForgotLink();
		Rmethod.PassEmail(InvalidUSerName);
		WebElement Message = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-danger alert-dismissible']")));
		String GetMessage = Message.getText();
		System.out.println(GetMessage);
		Assert.assertTrue(
				GetMessage.equals("Warning: The E-Mail Address was not found in our records, please try again!"));
	}

	@AfterMethod
	public void Destroy() {
		driver.quit();
	}
}
