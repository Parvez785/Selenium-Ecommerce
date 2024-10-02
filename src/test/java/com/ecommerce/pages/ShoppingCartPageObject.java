package com.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ShoppingCartPageObject {

	WebDriver driver;

	public ShoppingCartPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[normalize-space()='shopping cart']")
	WebElement ShoppingCartlink;
	
	@FindBy(xpath="//li//a[@title=\"Shopping Cart\"]")
	WebElement ShoppingCartHeaderLink;
	
	@FindBy(xpath="//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")
	WebElement CartHeaderbtn;
	
	@FindBy(xpath="//ul[@class='dropdown-menu pull-right']")
	WebElement CartPop_up;
	
	
	@FindBy(xpath="//button[@data-original-title=\"Update\"]")
	WebElement updatebtn;
	
	@FindBy(xpath="//input[@value=\"1\"]")
	WebElement inputfield;
	
	@FindBy(xpath="//button[@data-original-title=\"Remove\"]")
	WebElement Removebtn;
	
	@FindBy(xpath="//input[@id='input-coupon']")
	WebElement CouponInput;
	
	@FindBy(id="button-coupon")
	WebElement CouponBtn;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement CouponErrorAlert;
	
	@FindBy(xpath="//a[normalize-space()='Use Coupon Code']")
	WebElement CouponCodeToggle;
	
	@FindBy(xpath="//button[normalize-space()='×']")
	WebElement ErrorPopupclose;
	
	@FindBy(id="input-country")
	WebElement SelectCountry;
	
	
	@FindBy(id="input-zone")
	WebElement SelectRegion;
	
	@FindBy(id="input-postcode")
	WebElement SelectPostalCode;
	
	@FindBy(xpath="//a[normalize-space()='Estimate Shipping & Taxes']")
	WebElement ShippingToogle;
	
	@FindBy(id="button-quote")
	WebElement Quotebtn;
	
	@FindBy(id="button-shipping")
	WebElement Shippingbtn;
	
	@FindBy(xpath="//button[normalize-space()='Cancel']")
	WebElement Cancelbtn;
	
	
	public void Cancelbtnclick() {
		Cancelbtn.click();
	}
	
	public void Shippingbtnclick() {
		Shippingbtn.click();
	}
	
	public void Quotebtnclick() {
		Quotebtn.click();
	}
	
	public void ShippingToogleClick() {
		ShippingToogle.click();
	}
	
	
	public void SelectPostCode(String PostCode) {
		SelectPostalCode.sendKeys(PostCode);
	}
	
	public void SelectRegion(String Region) {
		Select select= new Select(SelectRegion);
		select.selectByVisibleText(Region);
	}
	
	
	public void SelectCountryOption(String Country) {
		Select select= new Select(SelectCountry);
		select.selectByVisibleText(Country);
	}
	
	
	
	
	public void CouponToggle() {
		CouponCodeToggle.click();
	}
	
	public void ErrorPopupClosebtnclick() {
		ErrorPopupclose.click();
	}
	
	
	
	public void CouponBtnclick() {
		CouponBtn.click();
	}
	
	
	
	public void AddCouponCode(String Code) {
		CouponInput.sendKeys(Code);
	}
	
	public void Removeproduct() {
		Removebtn.click();
	}
	

	public void updateProductQuantity(String value) {
		inputfield.clear();
		inputfield.sendKeys(value);
	}
	
	public void updatebtn() {
		updatebtn.click();
		
	}
	
	public void CartHeaderbtn() {
		CartHeaderbtn.click();
	}
	
	
	
	public void ShopingCartHeaderLink() {
		ShoppingCartHeaderLink.click();
	}
	
	public void ShoppingCartLink() {
		ShoppingCartlink.click();
	}
	
}
