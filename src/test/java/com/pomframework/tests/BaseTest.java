package com.pomframework.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.pomframework.pages.LandingPage;

public class BaseTest {
	
	
	public WebDriver driver;
//	private Properties prop;
	private final String baseURL = "http://automationpractice.com/index.php";
	private final String chromeDriverPath = "src/test/resources/lib/chromedriver.exe";
	
	
	public BaseTest(){
//		try {
//		prop = new Properties();
//		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/config.properties");
//		
//			prop.load(fis);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String browser = prop.getProperty("browser");
//		this.driver = new CustomDriver(browser);
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		this.driver = new ChromeDriver();
	}
	
	@BeforeTest
	public void setup(){
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}

	public LandingPage openSite(){
		driver.get(baseURL);
		return new LandingPage(this.driver);
	}
}
