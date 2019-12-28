package com.edureka.TestBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BrowserBasics {
	public static WebDriver driver=null;
	public static String KEY = "webdriver.chrome.driver";
	public static String VALUE = "C:\\Users\\sudv\\eclipse-workspace\\Edureka_Project\\Drivers\\chromedriver.exe";
	public String url = "https://www.edureka.co/";
	
	@BeforeSuite
	public void Init()
	{
		
		System.setProperty(KEY, VALUE);
		driver = new ChromeDriver();	
		driver.manage().window().maximize();
		
		driver.get(url);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try
		{
			driver.switchTo().alert();
			System.out.println("alert exists");
			driver.switchTo().alert().dismiss();
		}
		catch(NoAlertPresentException Ex)
		{
			System.out.println("no alert present");
		}
		
	}
	
	@AfterSuite
	public void CloseBrowser()
	{
		//driver.close();
	}


}
