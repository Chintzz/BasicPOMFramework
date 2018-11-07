package com.pomframework.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class TestBase {
	
	protected  static WebDriver driver;	
	
	protected static  Properties properties;
	
	protected  static Actions actions;
	
	public TestBase(){
		try{
			properties = new Properties();
			
			FileInputStream fileInpStreamObject = new FileInputStream(System.getProperty("user.dir")+"/config.properties");
			
			properties.load(fileInpStreamObject);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	public static void initialise(){
		
		String browser= properties.getProperty("browser");
		if(browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/resources/lib/chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browser.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/BasicPOMFramework/src/test/resources/lib/chromedriver.exe");
			driver = new FirefoxDriver();
		}
		
		
		
		actions =new Actions(driver);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(properties.getProperty("baseURL"));
		
		
	}

}
