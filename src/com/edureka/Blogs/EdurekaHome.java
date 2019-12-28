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
	
	@FindBy(how = How.XPATH,using = "//button[contains(text(),'Community')]")
	@CacheLookup
	WebElement community;
	
	@FindBy(how = How.XPATH,using = "//a[text()='Blog']")
	@CacheLookup
	WebElement bloglink;
	
	@FindBy(how = How.XPATH,using = "//h3[text()='Software Testing']")
	@CacheLookup
	WebElement testingLink;
	
	public void clickOnCommunity()
	{
	 try {
		 logger.info("Click on community menu");
		community.click();
		
	 }
	 catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public void selectBlogs()
	{
		try {
		bloglink.click();
		logger.info("Click on Blogs menu");
		}
		 catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public void selectSeleniumInterview()
	{
		try {
			WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//a[contains(text(),'Top Selenium')]")));
	        ele.click();
	        logger.info("clicked on the selenium interview Qs icon  ");
			}
	       
		catch(Exception e)
		{
			logger.info("exception encountered while navigating to testing blogs page");
		}
	}
	
	public void exploreBlog()
	{
		try
		{
			WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Questions on ')]"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView();", element);
	        logger.info("scrolled down the selenium interview questions Blog ");
		}
	       
		catch(Exception e)
		{
			logger.info("exception encountered while scrolling down the selenium interview questions Blog");
		}
		
	}
	
	public void closeBlogs()
	{
		driver.close();
		logger.info("closed blogs");
	}
	public void selectTestingBlog()
	{
		try {
			closeWindowPopup();
			ScrollDown();
			String strExpected= "Software Testing Blogs | Learn About Software Testing - Edureka";
			String strActual = driver.getTitle();
			if (strExpected.equals(strActual))
			{
				logger.info("navigated to the Testing blogs page");
			}
			else
			{
				logger.info("error navigating to Testing blogs page");
			}
		}
		catch(Exception e)
		{
			logger.info("exception encountered while navigating to testing blogs page");
		}
	}
	
	public void closeWindowPopup()
	{
		try {
			String winHandleBefor = driver.getWindowHandle();
			driver.switchTo().window(winHandleBefor);
			logger.info("switched to pop up window");
			driver.findElement(By.xpath("//button[text()='No thanks']")).click();
			logger.info("clicked 'No thanks button in pop up window");
			}
			catch(Exception e)
			{
				logger.info("exception encountered while switching to pop up window");
			}
		
	}
	
	public void ScrollDown()
	{	
		try
		{
		WebElement element =driver.findElement(By.xpath("//h3[text()='Software Testing']"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView();", element);
//        logger.info("scrolled down to view software testing icon ");
        element.click();
        logger.info("clicked on the Testing object ");
		}
		catch(Exception e)
		{
			logger.info("exception encountered while clicking Testing object");
		}
        
        
	}
	
	
	
}
