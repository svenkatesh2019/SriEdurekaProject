package com.edureka.Blogs;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class EdurekaHome {

	Logger logger = LogManager.getLogger(EdurekaHome.class);
	WebDriver driver;
	public EdurekaHome(WebDriver driver)
	{
		this.driver = driver;
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
		
	}
	public void selectBlogs()
	{
		bloglink.click();
		
	}
	public void selectTestingBlog()
	{
		System.out.println("Going to find the testing icon web element");
		navigateToNewWindow();
		
		try
		{
			driver.switchTo().alert();
			System.out.println("alert exists");
			driver.switchTo().alert().dismiss();
		}
		catch(NoAlertPresentException Ex)
		{
			System.out.println("no alert present");
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
		
//		String MainWindow=driver.getWindowHandle();
//		 Set<String> s1=driver.getWindowHandles();		
//	        Iterator<String> i1=s1.iterator();
//	        while(i1.hasNext())	
//	        {
//	        	System.out.println("switching to child window");
//	        	String ChildWindow=i1.next();		
//        		
//	            if(!MainWindow.equalsIgnoreCase(ChildWindow))	            
//	            	driver.switchTo().window(ChildWindow);	                                                                                                           
//                                 			
//	            
//	        }
	}
	
	public void ScrollDown()
	{
//		String winHandleBefor = driver.getWindowHandle();
//		driver.switchTo().window(winHandleBefor);
//		driver.findElement(By.xpath("//button[text()='No thanks']")).click();
		try {
			driver.switchTo().frame(0);
			logger.info("switching to iframe");
			driver.findElement(By.xpath("//*[@id=\"wzrk-cancel\"]")).click();
			logger.info("closing iframe");
		}
		catch (Exception e) {
			System.out.println("Unable to locate frame with id " + 0
					+ e.getStackTrace());
		} 
			
	
		WebElement Element = driver.findElement(By.xpath("//h3[text()='Software Testing']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", Element);
        Element.click();
        
	}
	
	
	
}
