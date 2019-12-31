package com.edureka.MyCourses;

import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
	
	
	@FindBy(how = How.XPATH,using = "//button[@class='dropdown-toggle' and contains(text(),'Courses')]")
	@CacheLookup
	WebElement myCourses;
	
	@FindBy(how = How.XPATH,using = "//span[contains(text(),'Selenium Cert')]")
	@CacheLookup
	WebElement ongoingMycourse;
	
	@FindBy(how = How.XPATH,using = "//*[@id=\"header-II\"]/section/nav/div/ul[2]/li[1]/a/span")
	@CacheLookup
	WebElement user;
	
	
	@FindBy(how = How.XPATH,using = "//a[text()='Log Out']")
	@CacheLookup
	WebElement logout;
	
	
	@FindBy(how = How.XPATH,using = "//a[text()='All Courses']")
	@CacheLookup
	WebElement allCourses;
	
	@FindBy(how = How.XPATH,using = "/html/body/section[3]/div[1]/div[1]/div/div/div[1]/div[1]/button")
	@CacheLookup
	WebElement jobrole;
	
	@FindBy(how = How.XPATH,using = "//button[contains(text(),'Other Filters')]")
	@CacheLookup
	WebElement otherFilters;
	
	@FindBy(how = How.XPATH,using = "//a[contains(text(),'My Classroom') and @href='/mycourses']")
	@CacheLookup
	WebElement myClassRoom;
	
	@FindBy(how = How.ID,using = "jobRoleSearchInpDesktop")
	@CacheLookup
	WebElement searchBox;

	@FindBy(how = How.XPATH,using = "//label[@for='_Test_Automation_Engineer_']")
	@CacheLookup
	WebElement jobroleChoice;
	
	@FindBy(how = How.XPATH,using = "//label[text()='Weekend']")
	@CacheLookup
	WebElement batchTypeChoice;
	
	@FindBy(how = How.XPATH,using = "//a[text()='Apply']")
	@CacheLookup
	WebElement applyBtn;
	
	@FindBy(how = How.XPATH,using = "//h3[contains(text(),'Selenium Cert')]")
	@CacheLookup
	WebElement seleCourse;
	
	public void checkEnrolledCourses()
	{
		checkMyCourses();
		goToMyClassroom();
		checkPage();
		if(checkIfOngoingCourses())
			logger.info("you have enrolled in a course");
		else
			logger.info("you have not enrolled in any course'");
		checkAllCourses();
		setJobRoleFilter();
		selectRoleType();
		setOtherFilters();
		setBatchType();
		scrolldownToSeleCourse();
		//logout();
	}

	private void scrolldownToSeleCourse() {
		
		try {
			seleCourse.click();
			logger.info("scrolled down to view Selenium course");
		}
		catch(Exception ex)
		{
			logger.info("error scrolling down to Selenium Course");
			ex.printStackTrace();
		}
	}

	private void goToMyClassroom() {
		try {
			myClassRoom.click();
			logger.info("clicked on 'MyClassroom' in'courses' drop-down");
		}
		catch(Exception ex)
		{
			logger.info("error clicking on 'MyClassroom' in'courses' drop-down");
			ex.printStackTrace();
		}
	}

	private void selectRoleType() {
		try
		{
			
			searchBox.sendKeys("automation");
			logger.info("entered the text 'automation' in search box");
			jobroleChoice.click();
			logger.info("selected Test Automation Engineer ");
						
		}
		catch(Exception ex)
		{
			logger.info("error selecting job role type radio button in 'Job Role' filter");
			ex.printStackTrace();
		}
		
	}

	private void setOtherFilters() {
		try
		{
			otherFilters.click();
			logger.info("clicked on 'Other Filters' ");
		}
		catch(Exception ex)
		{
			logger.info("error clicking on 'Other Filters'  Filter");
			ex.printStackTrace();
		}
	}
	private void setBatchType() {
		try {
			batchTypeChoice.click();
			logger.info("batch type 'Weekend' in 'Other Filters' drop-down selected");
			applyBtn.click();
			logger.info("'Apply' button clicked");
			
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//	        js.executeScript("arguments[0].scrollIntoView();", element);
//	        logger.info("scrolled down to view software testing icon ");
		}
		catch(Exception ex)
		{
			logger.info("error selecting batch type in 'Other Filters' drop-down");
			ex.printStackTrace();
		}
	}

	private void setJobRoleFilter() {
		
		try
		{
			jobrole.click();
			logger.info("selected 'Job Role '  Filter");

		}
		catch(Exception ex)
		{
			logger.info("error clicking on 'Job Role '  Filter");
			ex.printStackTrace();
		}
		
	}

	private void checkAllCourses() {
		try
		{
			allCourses.click();
			logger.info("clicked on 'All Courses' page");
		}
		catch(Exception e)
		{
			logger.info("error going to 'All Courses' page");
			e.printStackTrace();
		}
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
			logger.info("clicked 'Courses' drop-down");
		}catch(Exception ex)
		{
			logger.info("error going to 'Courses' drop-down");
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
