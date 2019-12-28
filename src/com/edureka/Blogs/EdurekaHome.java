package com.edureka.Blogs;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.edureka.TestBase.BrowserBasics;


public class EdurekaHome {
	
	Logger logger = LogManager.getLogger(EdurekaHome.class);
	
	WebDriver driver;
	WebDriverWait wait;
	public EdurekaHome()
	{
		this.driver = BrowserBasics.driver;
		wait=new WebDriverWait(driver, 20);
	}
	
	@FindBy(how = How.XPATH,using = "//*[@id=\"dropdownMenu4\"]")
	@CacheLookup
	WebElement community;
	
	@FindBy(how = How.XPATH,using = "//*[@id=\"navbar\"]/ul/li[4]/div/ul/li[2]/a")
	@CacheLookup
	WebElement bloglink;
	
	@FindBy(how = How.XPATH,using = "//h3[text()='Software Testing']")
	@CacheLookup
	WebElement testingLink;
	
	public void clickOnCommunity()
	{
	
		community.click();
		logger.info("Click on community menu");
		
	}
	public void selectBlogs()
	{
		
		bloglink.click();
		logger.info("Click on Blogs menu");
		
	}
	public void selectTestingBlog()
	{
		
		//navigateToNewWindow();
		logger.info("going to check if this is a alert");
		try
		{
			//WebDriverWait wait = new WebDriverWait(driver, 5);
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			alert.dismiss();
//			driver.switchTo().alert();
//			logger.info("alert exists");
//			driver.switchTo().alert().dismiss();
		}
		catch(NoAlertPresentException Ex)
		{
			logger.info("no alert ");
		}
		
		
		//testingLink.click();
		ScrollDown();
		logger.info("software testing icon clicked");
		System.out.println("software testing icon clicked");
	}
	
	public void navigateToNewWindow()
	{
		String winHandleBefore = driver.getWindowHandle();
		driver.switchTo().window(winHandleBefore);
		System.out.println("switching to child window");
		logger.info("switching to child window");
		
	}
	
	public void ScrollDown()
	{
		logger.info("waiting for page to load");
//		try {
//		String winHandleBefor = driver.getWindowHandle();
//		driver.switchTo().window(winHandleBefor);
//		driver.findElement(By.xpath("//button[text()='No thanks']")).click();
//		}
//		catch(Exception e)
//		{
//			logger.info("exception encountered while switching to window");
//		}
//		try {
//			driver.switchTo().frame(0);
//			logger.info("switching to iframe");
//			driver.findElement(By.xpath("//*[@id=\"wzrk-cancel\"]")).click();
//			logger.info("closing iframe");
//		}
//		catch (Exception e) {
//			System.out.println("exception encountered while switching to framw " 
//					+ e.getStackTrace());
//		} 
		
		
		WebElement Element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//h3[text()='Software Testing']")));
			
		//WebElement Element = driver.findElement(By.xpath("//h3[text()='Software Testing']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", Element);
        Element.click();
        
	}
	
	
	
}
