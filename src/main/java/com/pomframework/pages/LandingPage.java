package com.pomframework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LandingPage  {
	
	
	private WebDriver driver;
	private WebDriverWait wait;
	private Actions actions;
	//Page Elements using Page Factory
	
	@FindBy(className = "login")
	private WebElement signInLink;
	
	@FindBy(xpath = "//a[@title='Women']")
	private WebElement womenLink;
	
	@FindBy(xpath = "//a[@title='Dresses']")
	private WebElement dressesLink;
	
	@FindBy(xpath = "//a[@title='T-shirts']")
	public WebElement tShirtLink;
	
	@FindBy(xpath = "//a[@title='Blouses']")
	private WebElement blousesLink;
	
	@FindBy(xpath = "//a[@title='Casual Dresses']")
	private WebElement casualDressesLink;
	
	@FindBy(xpath = "//a[@title='Evening Dresses']")
	private WebElement eveningDressesLink;
	
	@FindBy(xpath = "//a[@title='Summer Dresses']")
	private WebElement summerDressesLink;
	
	@FindBy(xpath = "//a[@title='Faded Short Sleeve T-shirts']")
	private WebElement productName;
	
	@FindBy(xpath="//a[@title= 'Add to cart']")
	private WebElement addToCartBtn;
	
	//Intialising the page object factory
	public LandingPage(WebDriver d){
		this.driver = d;
		actions = new Actions(this.driver);
		this.wait = new WebDriverWait(this.driver,30);
		PageFactory.initElements(this.driver, this);
		
	}
	
	//page actions or behaviours
	
	
	public void navigateToTShirtsPg(){
		actions.moveToElement(womenLink).build().perform();
		tShirtLink.click();
		
	}
	
	public void navigateToBlousesPg(){
		actions.moveToElement(womenLink).perform();
		blousesLink.click();
		
	}
	
	public CartDialog addItemToCart(){
		System.out.println("The Product is" +productName.getText());
		actions.moveToElement(productName).perform();
		addToCartBtn.click();
//		System.out.println(driver.getWindowHandle());
		return new CartDialog(this.driver);
	}
//	
//	public void navigateToCasualDressesPg(){
//		actions.moveToElement(womenLink).perform();
//		casualDressesLink.click();
//		
//	}
//	
//	public void navigateToEveningDressesPg(){
//		actions.moveToElement(womenLink).perform();
//		eveningDressesLink.click();
//		
//	}
//	
//	public void navigateToESummerDressesPg(){
//		actions.moveToElement(womenLink).perform();
//		summerDressesLink.click();
//		
//	}
	
	public void clickOnSignInLink(){
		
		signInLink.click();
		
//		return new AuthenticationPage();
		
	}
	

}
