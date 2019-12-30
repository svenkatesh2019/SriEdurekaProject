package com.edureka.MyCourses;

import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.edureka.Blogs.EdurekaHome;

import com.edureka.TestBase.BrowserBasics;

public class EnrollCourses {
	Logger logger = LogManager.getLogger(EdurekaHome.class);
	WebDriver driver ;
	public WebDriverWait wait;
	
	
	public EnrollCourses()
	{
		this.driver = BrowserBasics.driver;
		wait=new WebDriverWait(driver, 20);
	}
	
	
	@FindBy(how = How.XPATH,using = "//a[contains(text(),'My Courses')]")
	@CacheLookup
	WebElement myCourses;
	
	@FindBy(how = How.XPATH,using = "//span[contains(text(),'Selenium Cert')]")
	@CacheLookup
	WebElement ongoingMycourse;
	
	@FindBy(how = How.XPATH,using = "//span[text()='Sridevi Venkates']")
	@CacheLookup
	WebElement user;
	
	
	@FindBy(how = How.XPATH,using = "//a[text()='Log Out']")
	@CacheLookup
	WebElement logout;
	
	
	public void checkEnrolledCourses()
	{
		//checkMyCourses();
		checkPage();
		if(checkIfOngoingCourses())
			logger.info("you have enrolled in a course");
		else
			logger.info("you have not enrolled in any course'");
		logout();
	}

	private boolean checkIfOngoingCourses() {
		
		try {
	        driver.findElement(By.xpath("//span[contains(text(),'Selenium Cert')]"));
	    } catch (NoSuchElementException e) {
	        return false;
	    }
	    return true;
	}
	//this method is not used since logging in via automation, the user lands on the My courses page
	public void checkMyCourses() {
		try
		{
			myCourses.click();
			logger.info("clicked 'MyCourses' menu");
		}catch(Exception ex)
		{
			logger.info("error going to 'My courses' page");
			ex.printStackTrace();
		}
		
	}
	
	public void checkPage()
	{
		String expec = "My Classroom | Edureka";
		String actual = driver.getTitle();
		if(expec.equalsIgnoreCase(actual))
			logger.info("navigated to 'My classrom'");
		else
			logger.info("navigated to incorrect page");
	}
	public void logout()
	{
		try
		{
			user.click();
			logger.info("clicked on username");
			logout.click();
			logger.info("clicked on logout");
			driver.close();
			logger.info("log out and close the browser");
		}
		catch(Exception e)
		{
			logger.info("Error while logging out and close the browser");
			e.printStackTrace();
		}
		
	}
	

}
