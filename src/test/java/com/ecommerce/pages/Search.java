package com.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Search {

	WebDriver driver;

	public Search(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder=\"Search\"]")
	private WebElement SearchField;

	@FindBy(xpath = "//span[@class=\"input-group-btn\"]//button[@type=\"button\"]")
	private WebElement Searchbtn;

	@FindBy(id = "input-search")
	private WebElement Search_CriteriaField;

	@FindBy(id = "button-search")
	private WebElement Criteriabtn;

	@FindBy(name = "category_id")
	private WebElement SelectCategory;

	@FindBy(name = "sub_category")
	private WebElement SubcategoryCheckbox;

	@FindBy(id = "list-view")
	private WebElement ListView;

	@FindBy(xpath = "//button[@onclick=\"compare.add('41');\"]")
	private WebElement Comparebtn1;

	@FindBy(linkText = "product comparison")
	private WebElement productcompareLink;
	
	
	@FindBy(id="input-sort")
	private WebElement SortInput;
	
	@FindBy(id="input-limit")
	private WebElement SortLimit;
	
	public void sortlimit(String limit) {
		Select select = new Select(SortLimit);
		select.selectByVisibleText(limit);
	}
	
	
	public void SortSelect(String opt) {
		Select sort = new Select(SortInput);
		sort.selectByVisibleText(opt);
	}
	
	

	public void ComparePageLink() {
		productcompareLink.click();
	}

	public void CompareBtn() {
		Comparebtn1.click();
	}

	public void listView() {
		ListView.click();
	}

	public void Checkboxclick() {
		SubcategoryCheckbox.click();
	}

	public void SelectCategory(String Options) {
		Select select = new Select(SelectCategory);
		select.selectByVisibleText(Options);
	}

	public void Criteriabtnclick() {
		Criteriabtn.click();
	}

	public void SearchUsingCriteriaField(String Search) {
		Search_CriteriaField.sendKeys(Search);
	}

	public void SearchInput(String Input) {
		SearchField.sendKeys(Input);
	}

	public void Btnclick() {
		Searchbtn.click();
	}

}
