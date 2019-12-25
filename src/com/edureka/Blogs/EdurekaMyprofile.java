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
	
	@FindBy(how = How.XPATH,using = "//*[@id=\"header-II\"]/section/nav/div/ul[2]/li[2]/a/span")
	@CacheLookup
	WebElement edurekaBtn;
		
	
	@FindBy(how = How.XPATH,using = "//a[text()='My Profile']")
	@CacheLookup
	WebElement profile;
	
	public void clickEdureka()
	{
		edurekaBtn.click();
	}
	public void clickMyprofile()
	{
		
	}
	public void updateProfessionalDetails()
	{
		profile.click();
	}
	public void careerInterests()
	{
		
	}
	public void otherDetails()
	{
		
	}
}
