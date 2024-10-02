package com.ecommerce.base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("Test Started: " + result.getMethod().getMethodName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// Optional: Handle test success if needed
		System.out.println("Test Passed: " + result.getMethod().getMethodName());

	}

	@Override
	public void onTestFailure(ITestResult result) {
	    WebDriver driver = null;

	    String testName = result.getName();
	    try {
	        // Accessing the driver instance using reflection
	        driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());

	        // Ensure the driver is not null
	        if (driver != null) {
	            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	            String destFilePath = System.getProperty("user.dir") + "\\Screenshot\\" + testName + ".png";
	            try {
	                FileUtils.copyFile(screenshotFile, new File(destFilePath));
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        } else {
	            System.out.println("Driver is null. Cannot take screenshot.");
	        }
	    } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
	        e.printStackTrace();
	    }
	}


	@Override
	public void onTestSkipped(ITestResult result) {
		// Optional: Handle test skipped if needed
		System.out.println("Test Skipped: " + result.getMethod().getMethodName());

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// Optional: Handle partial success if needed
		System.out.println("Test Failed but within success percentage: " + result.getMethod().getMethodName());

	}

	@Override
	public void onStart(ITestContext context) {
		// Optional: Initialization before test start
		System.out.println("Test Suite Started: " + context.getName());

	}

	@Override
	public void onFinish(ITestContext context) {
		// Optional: Cleanup after all tests
		System.out.println("Test Suite Finished: " + context.getName());

	}
}
