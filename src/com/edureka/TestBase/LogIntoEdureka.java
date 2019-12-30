package com.edureka.TestBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.edureka.Blogs.EdurekaHome;
import com.edureka.Blogs.EdurekaLogin;
import com.edureka.MyProfile.EdurekaMyprofile;

public class LogIntoEdureka extends BrowserBasics{
	
	public String expectedMessage = "Instructor-Led Online Training with 24X7 Lifetime Support | Edureka";
	
	
	
	@Test(priority=1)	
	public void Init()
	{
		try
		{
			EdurekaLogin eduLogin = PageFactory.initElements(driver, EdurekaLogin.class); 
			
			
		eduLogin.clickFirstLoginBtn();
		eduLogin.setPassword("Andal@16");
		eduLogin.setEmail("sud.v@hotmail.com");
		eduLogin.clickSecondLoginBtn();
		
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
	
	@Test(priority=2,enabled = false)	
	public void executeOthers()
	{
		EdurekaHome eduhome = PageFactory.initElements(driver, EdurekaHome.class); 
		eduhome.clickOnCommunity();
		eduhome.selectBlogs();
		eduhome.selectTestingBlog();
		eduhome.selectSeleniumInterview();
		eduhome.exploreBlog();
		eduhome.closeBlogs();
	}
	@Test(priority = 3,enabled=true)
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
