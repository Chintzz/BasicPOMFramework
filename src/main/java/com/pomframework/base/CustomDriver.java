package com.pomframework.base;

import java.io.File;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CustomDriver implements WebDriver{
	
	private WebDriver driver;
	private final String browserName;
	private final int timeout =30;
	private final String chromeDriverPath = "src/test/resources/lib/chromedriver.exe";
	private final String geckoDriverPath = "src/test/resources/lib/geckodriver.exe";
	
	
	public CustomDriver(String browserName){
		this.browserName=browserName;
		this.driver=createDriver(browserName);
		
	}
	
	private WebDriver createDriver(String browserName){
		if(browserName.toLowerCase().equals("firefox")){
			return fireFoxDriver();
		}
		
		if(browserName.toLowerCase().equals("chrome")){
			return chromeDriver();
		}
		
		throw new RuntimeException ("invalid browser name");
	}
	
	private WebDriver chromeDriver(){
		if(!new File(this.chromeDriverPath).exists()){
			throw new RuntimeException("chromedriver.exe doesn't exists");
		}
		
		try{
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			return new ChromeDriver();
		}catch (Exception e){
			throw new RuntimeException("couldn't create chrome driver");
		}
	}
	
	private WebDriver fireFoxDriver(){
		if(!new File(geckoDriverPath).exists()){
			throw new RuntimeException("geckoDriver.exe doesn't exists");
		}
		
		try{
			System.setProperty("webdriver.gecko.driver", geckoDriverPath);
			return new FirefoxDriver();
		}catch (Exception e){
			throw new RuntimeException("couldn't create Firefox driver");
		}
	}

	 @Override 
	   public String toString() { 
	      return this.browserName; 
	   } 

	   public WebDriver driver() { 
	      return this.driver; 
	   }  

	   public void close() { 
	      driver().close();   
	   }  

	   public WebElement findElement(By locator) { 
	      return driver().findElement(locator); 
	   }  

	   public List findElements(By arg0) { 
	      return driver().findElements(arg0); 
	   }  

	   public void get(String arg0) { 
	      driver().get(arg0); 
	   }  

	   public String getCurrentUrl() { 
	      return driver().getCurrentUrl(); 
	   }  

	   public String getPageSource() { 
	      return driver().getPageSource(); 
	   }  

	   public String getTitle() { 
	      return driver().getTitle(); 
	   }  

	   public String getWindowHandle() { 
	      return driver().getWindowHandle(); 
	   }  

	   public Set getWindowHandles() { 
	     return driver().getWindowHandles(); 
	   }  

	   public Options manage() { 
	      return driver().manage(); 
	   }  

	   public Navigation navigate() { 
	      return driver().navigate(); 
	   }  

	   public void quit() { 
	     driver().quit(); 
	   }  

	   public TargetLocator switchTo() { 
	      return driver().switchTo(); 
	   }  

	  


}
