package com.edureka.Blogs;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EdurekaLogin {
	public WebDriver driver ;
	public WebDriverWait wait;
	Logger logger = LogManager.getLogger(EdurekaHome.class);
	
	public EdurekaLogin(WebDriver driver)
	{
		this.driver = driver;
		wait=new WebDriverWait(driver, 20);
	}
	//first login button in edureka page
	@FindBy(how = How.XPATH,using = "//a[text()='Log In']")
	@CacheLookup
	WebElement firstLogin;
	
	//window opens displaying username password fields and second login button
	//locate email field
	@FindBy(how = How.XPATH,using = "//*[@id=\"si_popup_email\"]")
	WebElement emailtxtbox;
	
	//locate password field
	@FindBy(how = How.XPATH,using = "//*[@id=\"si_popup_passwd\"]")
	@CacheLookup
	WebElement passwordTxtbox;
	
	//locate big Login button
	@FindBy(how = How.XPATH,using = "//button[text()='Login']")
	@CacheLookup
	WebElement nextLoginBtn;
	
	public void clickFirstLoginBtn()
	{
		firstLogin.click();
		System.out.println("first login btn clicked");
	}
	public void setEmail(String email) throws InterruptedException
	{
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger.info(email);
		System.out.println(email);
		WebElement emailElement = wait.until(ExpectedConditions.visibilityOf(emailtxtbox));
			
		emailElement.sendKeys(email);
				
		
	}
	public void setPassword(String pwd) throws Exception
	{
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger.info(pwd);
		System.out.println(pwd);
		WebElement pwdElement = wait.until(ExpectedConditions.visibilityOf(passwordTxtbox));
		pwdElement.sendKeys(pwd);
		
	}
	public void clickSecondLoginBtn() throws InterruptedException
	{
		nextLoginBtn.click();
		
		
	}
}
