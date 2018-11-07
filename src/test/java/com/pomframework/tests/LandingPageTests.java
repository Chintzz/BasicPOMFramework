package com.pomframework.tests;


import org.testng.annotations.Test;
import com.pomframework.pages.CartDialog;
import com.pomframework.pages.LandingPage;

public class LandingPageTests extends BaseTest{

	
	
//	@Test
//	public void validateNavigationToAuthentiationPg(){
//		
//		LandingPage landingPgObj = openSite();
//		landingPgObj.clickOnSignInLink();
//		
////		Assert.assertEquals(authenticationPgObj.checkPageTitle(), "Login - My Store", "The page title doesn't match the expected value");
//		
//		
//	}
	
//	@Test
//	public void validateNavigationToTShirtPg(){
//		LandingPage2 landingPgObj = openSite();
//		landingPgObj.navigateToTShirtsPg();
//	}
	
	@Test
	public void validateAddItemToCart(){
		LandingPage landingPgObj = openSite();
		CartDialog cartDialogObj =landingPgObj.addItemToCart();
		cartDialogObj.proceedToCheckout();
	}
		
	}


