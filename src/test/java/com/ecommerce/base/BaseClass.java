package com.ecommerce.base;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;

import com.google.common.io.Files;

public class BaseClass {
//Baseclass containing All Pages URL and Logins
;
	protected String BaseURL = "https://tutorialsninja.com/demo/index.php";
	protected String ProductPage = BaseURL + "?route=product/search";
	protected String LoginPage = BaseURL + "?route=account/login";
	protected String HomePage = BaseURL + "?route=common/home";
	// Logins
	protected String UserName = "test+786@gmail.com";
	protected String Password = "Parvez@786";
	protected String InvalidUSerName = "test@gmail.com";
	protected String InvalidPassword = "Ba7hvQN@Z@S7Y";

	
}
