package com.edureka.TestBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.edureka.Blogs.EdurekaHome;
import com.edureka.Blogs.EdurekaLogin;
import com.edureka.Blogs.EdurekaMyprofile;

public class LogIntoEdureka extends BrowserBasics{
	
	public String expectedMessage = "Instructor-Led Online Training with 24X7 Lifetime Support | Edureka";
	
	
	
	@Test(priority=1)	
	public void Init()
	{
		try
		{
			EdurekaLogin eduLogin = PageFactory.initElements(driver, EdurekaLogin.class); 
			
			
		eduLogin.clickFirstLoginBtn();
		
//		eduLogin.setPassword("edureka123");
//		eduLogin.setEmail("seleniumtester2019@outlook.com");
		eduLogin.setPassword("Andal@16");
		eduLogin.setEmail("sud.v@hotmail.com");
		eduLogin.clickSecondLoginBtn();
		
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
	
	@Test(enabled = false)	
	public void executeOthers()
	{
		EdurekaHome eduhome = PageFactory.initElements(driver, EdurekaHome.class); 
		Assert.assertEquals(driver.getTitle(), expectedMessage);
		
		eduhome.clickOnCommunity();
		System.out.println("community link clicked 2");
		eduhome.selectBlogs();
		System.out.println("blogs link clicked 2");
		eduhome.selectTestingBlog();
	}
	@Test(priority=2,enabled=true)
	public void selectMyprofile() throws Exception
	{
		EdurekaMyprofile myProfile =  PageFactory.initElements(driver, EdurekaMyprofile.class); 
		myProfile.clickEdureka();
		myProfile.clickMyprofile();
		myProfile.navigateToDetailspage();
		myProfile.updateProfileDetails();
		myProfile.ProfessionalDetails();
	}

}
