package com.edureka.Blogs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EdurekaLogin {
	public WebDriver driver ;
	
	public EdurekaLogin(WebDriver driver)
	{
		this.driver = driver;
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
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		emailtxtbox.sendKeys(email);
		//driver.findElement(By.xpath("//*[@id=\"si_popup_email\"]")).sendKeys(email);
		Thread.sleep(3000);
		
	}
	public void setPassword(String pwd) throws Exception
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		passwordTxtbox.sendKeys(pwd);
		Thread.sleep(3000);
	}
	public void clickSecondLoginBtn() throws InterruptedException
	{
		nextLoginBtn.click();
		Thread.sleep(3000);
		
	}
}
