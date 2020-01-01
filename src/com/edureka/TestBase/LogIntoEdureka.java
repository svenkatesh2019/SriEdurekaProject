package com.edureka.TestBase;


import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.edureka.Blogs.EdurekaHome;
import com.edureka.Blogs.EdurekaLogin;
import com.edureka.MyCourses.EnrollCourses;
import com.edureka.MyProfile.EdurekaMyprofile;

public class LogIntoEdureka extends BrowserBasics{
	
	public String expectedMessage = "Instructor-Led Online Training with 24X7 Lifetime Support | Edureka";
	public boolean loginfail;
	
	
	@Test(priority=1)	
	public void Init()
	{
		try
		{
			EdurekaLogin eduLogin = PageFactory.initElements(driver, EdurekaLogin.class); 
			
			
			eduLogin.clickFirstLoginBtn();
			
			
			eduLogin.setPassword("Edureka1234");
			eduLogin.setEmail("sud.v@hotmail.com");
			eduLogin.clickSecondLoginBtn();
		}
		
		catch(Exception ex)
		
		{
			ex.printStackTrace();
		}
		
	}
	
	@Test(priority=4,enabled = true)	
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
	@Test(priority = 2,enabled=true)
	public void selectMyprofile() throws Exception
	{
		EdurekaMyprofile myProfile =  PageFactory.initElements(driver, EdurekaMyprofile.class); 
		myProfile.clickEdureka();
		myProfile.clickMyprofile();
		myProfile.navigateToDetailspage();
		myProfile.updateProfileDetails();
		myProfile.ProfessionalDetails();
	}
	
	@Test(priority = 3,enabled=true)
	public void checkForMycourses()
	{
		EnrollCourses enroll = PageFactory.initElements(driver, EnrollCourses.class); 
		enroll.checkEnrolledCourses();
	}

}
