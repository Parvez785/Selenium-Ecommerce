package com.ecommerce.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ecommerce.base.BaseClass;
import com.ecommerce.pages.ForgotPasswordPageObject;
import com.ecommerce.pages.LoginPagefactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Forgotpassword extends BaseClass {
	WebDriver driver;
	LoginPagefactory login;
	ForgotPasswordPageObject forgotPassword;

	@BeforeMethod
	public void Setup() {
		driver = new FirefoxDriver();
		driver.get(BaseURL);
		login = new LoginPagefactory(driver);
		forgotPassword = new ForgotPasswordPageObject(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	// Navigate to Change Password Page from My Account Page
	@Test
	public void NavigatetoMyAccountPage() {
		login.GetLoginMenu();
		login.GetLoginMenu(UserName, Password);
		forgotPassword.clickForgotPasswordLink();
		Assert.assertEquals(driver.getTitle(), "Change Password");
	}

	// Navigating to Change Password Page from My Account Page SideBar
	@Test
	public void NavigateToChangePasswordPage() {
		login.GetLoginMenu();
		login.GetLoginMenu(UserName, Password);
		forgotPassword.clickSidebarlink();
		Assert.assertEquals(driver.getTitle(), "Change Password");
	}

	// Updating Password Using Valid 8 digit Password
	@Test
	public void UpdatePassword() throws InterruptedException {
		login.GetLoginMenu();
		login.GetLoginMenu(UserName, Password);
		forgotPassword.clickSidebarlink();
		forgotPassword.inputPassword("Parvez@785");
		forgotPassword.confirmPasswordInput("Parvez@785");
		forgotPassword.Continuebtnclick();
		Thread.sleep(1000);
		String Message = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"))
				.getText();
		Assert.assertEquals(Message, "Success: Your password has been successfully updated.");
	}
	
	//Updating Password with valid Password and invalid confirmPassword
	@Test
	public void InvalidconfirmPassword() {
		login.GetLoginMenu();
		login.GetLoginMenu(UserName, "Parvez@784");
		forgotPassword.clickForgotPasswordLink();
		forgotPassword.inputPassword("Parvez@785");
		forgotPassword.confirmPasswordInput("Parvez@784");
		forgotPassword.Continuebtnclick();
		String Message= driver.findElement(By.xpath("//div[@class='text-danger']")).getText();
		Assert.assertTrue(Message.equals("Password confirmation does not match password!"));
	}
	
	//Verify Back button is navigating Back to My account
	@Test
	public void IncompletePassword() {
		login.GetLoginMenu();
		login.GetLoginMenu(UserName, "Parvez@784");
		forgotPassword.clickForgotPasswordLink();
		forgotPassword.ClickBackbtn();
		Assert.assertTrue(driver.getTitle().equals("My Account"));
	}
	
	@AfterMethod
	public void Destroy() {
		driver.quit();
	}

}
