package com.pomframework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartDialog {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private Actions actions;
	
	public CartDialog(WebDriver d){
		this.driver=d;
		this.wait= new WebDriverWait(this.driver,30);
		this.actions = new Actions(this.driver);
		PageFactory.initElements(this.driver,this);
	}
	
	@FindBy(xpath ="//a[@title='Proceed to checkout']")
	private WebElement proceedToCheckOutBtn;
	
	
	public void proceedToCheckout(){
//		driver.switchTo().activeElement();
		System.out.println(driver.getWindowHandle());
		driver.switchTo().defaultContent();
		System.out.println(driver.getWindowHandle());
		proceedToCheckOutBtn.click();
	}

}
