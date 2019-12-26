package com.edureka.Blogs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EdurekaMyprofile {
	Logger logger = LogManager.getLogger(EdurekaHome.class);
	WebDriver driver;
	public void EdurekaHome(WebDriver driver)
	{
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH,using = "//span[@class='webinar-profile-name']")
	@CacheLookup
	WebElement profileName;
		
	
	@FindBy(how = How.XPATH,using = "//a[text()='My Profile']")
	@CacheLookup
	WebElement profile;
	
	public void clickEdureka()
	{
		profileName.click();
		logger.info("clicked on my profile name  ");
	}
	public void clickMyprofile()
	{
		profile.click();
		logger.info("selected My Profile");
		
	}
	public void updateProfessionalDetails()
	{
		
	}
	public void careerInterests()
	{
		
	}
	public void otherDetails()
	{
		
	}
}
