package com.edureka.TestBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class GenericMethods {
	
	public static WebDriver driver=null;
	public static String KEY = "webdriver.chrome.driver";
	public static String VALUE = "C:\\Users\\sudv\\eclipse-workspace\\Edureka_Project\\Drivers\\chromedriver.exe";
	
	
	public static void launchBrowser()
	{
		System.setProperty(KEY, VALUE);
		driver = new ChromeDriver();		
		
	}
	public static void naviagteToUrl(String url)
	{
		driver.get(url);
	}
	public static void maximizeWindow()
	{
		driver.manage().window().maximize();
	}
	public static void deleteCookies()
	{
		driver.manage().deleteAllCookies();
	}
	
	public static void implicitWait()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public static void clickFirstLoginBtn(String value)
	{
		if(alertIsPresent())
		{
		 driver.switchTo().alert().dismiss();		
		
		 System.out.println("alert dismissed?");
		}
		driver.findElement(By.xpath(value)).click();
	}
	
	public static boolean alertIsPresent()
	{
	 try
	 {
		 driver.switchTo().alert();
		 System.out.println(driver.switchTo().alert().getText());
		 return true;
	 }
	 catch(NoAlertPresentException Ex)
	 {
		 System.out.println("no alert present");
		 return false;
	 }
	}
	public static void enterUsername(String locator,String Value,String param)
	{
		switch(locator)
		{
			case "xpath":
				driver.findElement(By.xpath(Value)).sendKeys(param);
				break;
			case "id":
				driver.findElement(By.id(Value)).sendKeys(param);
				break;
			case "linkText":
				driver.findElement(By.linkText(Value)).sendKeys(param);
				break;
			case "name":
				driver.findElement(By.name(Value)).sendKeys(param);
				break;
			case "tagName":
				driver.findElement(By.tagName(Value)).sendKeys(param);
				break;
			case "partialLinkText":
				driver.findElement(By.partialLinkText(Value)).sendKeys(param);
				break;
			case "cssSelector":
				driver.findElement(By.cssSelector(Value)).sendKeys(param);
				break;
			case "className":
				driver.findElement(By.className(Value)).sendKeys(param);
				break;
			default:
				System.out.println("Invalid locaotr name");
				
		}
				
	}
	public static void enterPassword(String locator,String Value,String param)
	{
		switch(locator)
		{
			case "xpath":
				driver.findElement(By.xpath(Value)).sendKeys(param);
				break;
			case "id":
				driver.findElement(By.id(Value)).sendKeys(param);
				break;
			case "linkText":
				driver.findElement(By.linkText(Value)).sendKeys(param);
				break;
			case "name":
				driver.findElement(By.name(Value)).sendKeys(param);
				break;
			case "tagName":
				driver.findElement(By.tagName(Value)).sendKeys(param);
				break;
			case "partialLinkText":
				driver.findElement(By.partialLinkText(Value)).sendKeys(param);
				break;
			case "cssSelector":
				driver.findElement(By.cssSelector(Value)).sendKeys(param);
				break;
			case "className":
				driver.findElement(By.className(Value)).sendKeys(param);
				break;
			default:
				System.out.println("Invalid locator name");
		}
				
	}
	public static void clickSecondLoginBtn(String locator,String Value)
	{
		switch(locator)
		{
			case "xpath":
				driver.findElement(By.xpath(Value)).click();
				break;
			case "id":
				driver.findElement(By.id(Value)).click();
				break;
			case "linkText":
				driver.findElement(By.linkText(Value)).click();
				break;
			case "name":
				driver.findElement(By.name(Value)).click();
				break;
			case "tagName":
				driver.findElement(By.tagName(Value)).click();
				break;
			case "partialLinkText":
				driver.findElement(By.partialLinkText(Value)).click();
				break;
			case "cssSelector":
				driver.findElement(By.cssSelector(Value)).click();
				break;
			case "className":
				driver.findElement(By.className(Value)).click();
				break;
			default:
				System.out.println("Invalid locator name");
		}
	}
	public static void verifyTitle()
	{
		String expectedMessage = "Instructor-Led Online Training with 24X7 Lifetime Support | Edureka";
		String actualMessage = driver.getTitle();
			System.out.println("actualMessage :  " + actualMessage);		
		Assert.assertEquals(actualMessage, expectedMessage);
		
		
	}
	public static void clickBrowseCourses(String locator,String Value) throws Exception
	{
		if(locator.equals("xpath"))
			{	
//				WebElement Element = driver.findElement(By.xpath(Value));	
//				JavascriptExecutor js = (JavascriptExecutor) driver;
//	       		js.executeScript("arguments[0].scrollIntoView();", Element);
//				Element.click();
			Thread.sleep(4000);
			driver.findElement(By.xpath(Value)).click();
							 
			}
			
		else
			System.out.println("please check locator provided for Browse all courses button.Expecting xpath locator");
	}
	public static void refineSearchBox(String locator,String Value,String param) 
	{
	 try
	 {
		
		switch(locator)
		{
			case "xpath":
				
				driver.findElement(By.xpath(Value)).click();
				driver.findElement(By.xpath("//input[@class='new-search-inp']")).sendKeys(param);
				driver.findElement(By.xpath("/html/body/div[2]/div[3]/section[1]/div/span[1]/div/span[1]/form/div/div/ul/li[2]/a/span/a/span")).click();
				//click on your profile to access My WishList
				driver.findElement(By.xpath("//span[@class='webinar-profile-name']")).click();
				System.out.println("clicked my profile");
				driver.findElement(By.xpath("//a[text()='My Wishlist']")).click();
				System.out.println("clicked my wishlist");
				String expectedText="Tell us what you are looking for and we will help you find it";
				String actualText=driver.findElement(By.xpath("//p[contains(text(),'Tell us')]")).getText();
				Assert.assertEquals(actualText, expectedText);
				System.out.println("verified nothing in my wishlist");
				driver.findElement(By.xpath("//span[@class='webinar-profile-name']")).click();
				System.out.println("clicked my profile to log out");
				WebDriverWait wait = new WebDriverWait(driver, 120);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"header-II\"]/section/nav/div/ul[2]/li[2]/ul/li[12]/a"))).click();
				System.out.println("logged out");
				break;
			default:
				System.out.println("Invalid locator name");
				
		}
	 }
	 catch(Exception ex) {
		 ex.printStackTrace();	 
	 }
		
	}
	public static void closeBrowser()
	{
		driver.close();
	}
}
