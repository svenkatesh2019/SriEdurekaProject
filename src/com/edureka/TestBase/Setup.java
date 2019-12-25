package com.edureka.TestBase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.edureka.Utility.ReadMyExcelFile;


public class Setup {
	
	
//	public static WebDriver driver=null;
//	String url = "http://facebook.com/";
//	String KEY = "webdriver.chrome.driver";
//	String VALUE = "C:\\Users\\sudv\\eclipse-workspace\\Frameworks\\Drivers\\chromedriver.exe";
	
	//this method can be removed
//	@BeforeMethod
//	public void InitialConditions()
//	{
//		System.setProperty(KEY, VALUE);
//		driver = new ChromeDriver();	
//	}
	
	@Test
	public void login() throws Exception
	{
		String[][]  data = ReadMyExcelFile.getData("ExcelData.xlsx", "keyword");
		
		for(int i = 1;i<data.length;i++)
		{
			switch(data[i][3])
			{
			case "launchBrowser":
				GenericMethods.launchBrowser();
				break;
			case "naviagteToUrl":
				GenericMethods.naviagteToUrl(data[i][6]);
				break;
			case "maximizeWindow":
				GenericMethods.maximizeWindow();
				break;
			case "deleteCookies":
				GenericMethods.deleteCookies();
				break;
			case "implicitWait":
				GenericMethods.implicitWait();
				break;
			case "clickFirstLoginBtn":
				GenericMethods.clickFirstLoginBtn(data[i][5]);
				break;
			case "enterUsername":
				GenericMethods.enterUsername(data[i][4], data[i][5], data[i][6]);
				break;
			case "enterPassword":
				GenericMethods.enterPassword(data[i][4], data[i][5], data[i][6]);
				break;
			case "clickSecondLoginBtn":
				GenericMethods.clickSecondLoginBtn(data[i][4], data[i][5]);
				break;
			case "verifyTitle":
				GenericMethods.verifyTitle();
				break;
			case "clickBrowseCourses":
				GenericMethods.clickBrowseCourses(data[i][4], data[i][5]);
				break;
			case "refineSearchBox":
				GenericMethods.refineSearchBox(data[i][4], data[i][5], data[i][6]);
				break;
			
			}
				
		}
		
		
	}
	
	//this method can be removed
//	@AfterMethod
//	public void PostConditions()
//	{
//		driver.close();
//	}

}
