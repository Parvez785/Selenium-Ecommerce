package com.ecommerce.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ecommerce.base.BaseClass;
import com.ecommerce.pages.LoginPagefactory;
import com.ecommerce.pages.Search;

public class SearchTest extends BaseClass {
	WebDriver driver;
	WebDriverWait wait;
	LoginPagefactory Login;
	Search search;

	@BeforeMethod
	public void Setup() throws MalformedURLException {
	/*	DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName("chrome");
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);*/
		driver= new ChromeDriver();
		Login = new LoginPagefactory(driver);
		search = new Search(driver);
		driver.get(ProductPage);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@Test
	public void SearchWithExistingproductName() {
		search.SearchInput("MacBook");
		search.Btnclick();
		WebElement Result = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"caption\"]//a")));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(true, Result.getText().contains("MacBook"));
	}

	@Test
	public void SearchWithNonExistingproductName() {
		search.SearchInput("Ipad");
		search.Btnclick();
		WebElement Result = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//p[contains(text(),\"There is no product that matches the search criteria.\")]")));
		Assert.assertTrue(Result.getText().equals("There is no product that matches the search criteria."));
	}

	@Test
	public void SearchwithoutproductName() {
		search.SearchInput("");
		search.Btnclick();
		WebElement Result = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//p[contains(text(),\"There is no product that matches the search criteria.\")]")));
		Assert.assertTrue(Result.getText().equals("There is no product that matches the search criteria."));

	}

	@Test
	public void SearchAfterLogin() {
		Login.GetLoginMenu();
		Login.GetLoginMenu("ps693909@gmail.com", "Parvez@786");
		search.SearchInput("MacBook");
		search.Btnclick();
		WebElement Result = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"caption\"]//a")));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(true, Result.getText().contains("MacBook"));

	}

	@Test
	public void SearchMultipeProducts() {
		Login.GetLoginMenu();
		Login.GetLoginMenu("ps693909@gmail.com", "Parvez@786");
		search.SearchInput("Mac");
		search.Btnclick();
		List<WebElement> Caption = driver.findElements(By.className("caption"));
		Assert.assertTrue(Caption.size() > 1, "Search did not return Multipe Items");
	}

	@Test

	public void SearchusingSearchCriteriaField() {
		search.SearchUsingCriteriaField("MacBook");
		WebElement Result = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"caption\"]//a")));
		Assert.assertEquals(true, Result.getText().contains("MacBook"));
	}

	@Test
	public void SearchUsingSubcategory() {
		search.SearchUsingCriteriaField("iMac");
		search.SelectCategory("Desktops");
		search.Checkboxclick();
		search.Criteriabtnclick();
		WebElement Result = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"caption\"]//a")));
		Assert.assertEquals(true, Result.getText().contains("iMac"));
	}

	@Test
	public void ListViewforProducts() throws InterruptedException {
		search.SearchUsingCriteriaField("Mac");
		search.SelectCategory("Desktops");
		search.Checkboxclick();
		search.Criteriabtnclick();
		search.listView();
		Thread.sleep(2000);
	}

	@Test
	public void CheckProdctAddedtoComparison() throws InterruptedException {
		search.SearchUsingCriteriaField("Mac");
		search.Criteriabtnclick();
		search.CompareBtn();
		Thread.sleep(2000);
		search.ComparePageLink();
		Assert.assertTrue(driver.getTitle().contains("Product Comparison"));
	}

	@Test
	public void SortProductsByAscOrder() throws InterruptedException {
		search.SearchUsingCriteriaField("Mac");
		search.Criteriabtnclick();
		search.CompareBtn();
		search.SortSelect("Name (A - Z)");
		Thread.sleep(1000);
	}

	@Test
	public void SortProductsByDescOrder() throws InterruptedException {
		search.SearchUsingCriteriaField("Mac");
		search.Criteriabtnclick();
		search.CompareBtn();
		search.SortSelect("Name (Z - A)");
	}

	@Test
	public void SortProductsByLowPrice() throws InterruptedException {
		search.SearchUsingCriteriaField("Mac");
		search.Criteriabtnclick();
		search.CompareBtn();
		search.SortSelect("Price (Low > High)");
	}

	@Test
	public void SortProductsByHighPrice() throws InterruptedException {
		search.SearchUsingCriteriaField("Mac");
		search.Criteriabtnclick();
		search.CompareBtn();
		search.SortSelect("Price (High > Low)");
	}

	@Test
	public void SortProductsByHighRating() throws InterruptedException {
		search.SearchUsingCriteriaField("Mac");
		search.Criteriabtnclick();
		search.CompareBtn();
		search.SortSelect("Rating (Highest)");
	}

	@Test
	public void SortProductsByLowRating() throws InterruptedException {
		search.SearchUsingCriteriaField("Mac");
		search.Criteriabtnclick();
		search.CompareBtn();
		search.SortSelect("Rating (Lowest)");
	}

	@Test
	public void SortProductsByModelAtoZ() throws InterruptedException {
		search.SearchUsingCriteriaField("Mac");
		search.Criteriabtnclick();
		search.CompareBtn();
		search.SortSelect("Model (A - Z)");
	}

	@Test
	public void SortProductsByModelZtoA() throws InterruptedException {
		search.SearchUsingCriteriaField("Mac");
		search.Criteriabtnclick();
		search.CompareBtn();
		search.SortSelect("Model (Z - A)");
	}

	@Test
	public void NoOFResult25() {
		search.SearchUsingCriteriaField("Mac");
		search.Criteriabtnclick();
		search.CompareBtn();
		search.sortlimit("25");
	}

	@Test
	public void NoOFResult50() {
		search.SearchUsingCriteriaField("Mac");
		search.Criteriabtnclick();
		search.CompareBtn();
		search.sortlimit("50");
	}

	@Test
	public void NoOFResult75() {
		search.SearchUsingCriteriaField("Mac");
		search.Criteriabtnclick();
		search.CompareBtn();
		search.sortlimit("75");
	}

	@Test
	public void NoOFResult100() {
		search.SearchUsingCriteriaField("Mac");
		search.Criteriabtnclick();
		search.CompareBtn();
		search.sortlimit("100");
	}

	@AfterMethod
	public void destroy() {
		driver.quit();
	}
}
