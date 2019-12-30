package com.edureka.MyProfile;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.edureka.TestBase.BrowserBasics;

public class EdurekaMyprofile {
	
	Logger logger = LogManager.getLogger(EdurekaMyprofile.class);
	WebDriver driver;
	WebDriverWait wait;
	
	public EdurekaMyprofile()
	{
		this.driver = BrowserBasics.driver;
		wait=new WebDriverWait(driver, 20);
	}

	
	@FindBy(how = How.XPATH,using = "//span[@class='user_name']")
	@CacheLookup
	WebElement profileName;
		
	
	@FindBy(how = How.XPATH,using = "//a[text()='My Profile']")
	@CacheLookup
	WebElement profile;
	
	@FindBy(how = How.XPATH,using = "//i[@class='icon-pr-edit']")
	@CacheLookup
	WebElement EditButton;
	
	@FindBy(how = How.XPATH,using = "//input[@formcontrolname='currentrole']")
	@CacheLookup
	WebElement currentRole;
	
	@FindBy(how = How.XPATH,using = "//select[@formcontrolname='experience']")
	@CacheLookup
	WebElement experience;
	
	@FindBy(how = How.XPATH,using = "//span[@class='changes-saved']")
	@CacheLookup
	WebElement changesSavedMsg;
	
	@FindBy(how = How.XPATH,using = "//button[@class='btn btn-default pull-right verify-continue-btn']")
	@CacheLookup
	WebElement continueBtn;
	
	@FindBy(how = How.XPATH,using = "//a[text()='Skip ']")
	@CacheLookup
	WebElement skipButton;
	
	@FindBy(how = How.NAME,using = "companyName")
	@CacheLookup
	WebElement companyName;
	
	@FindBy(how = How.NAME,using = "currentjob")
	@CacheLookup
	WebElement jobLevel;
	
	@FindBy(how = How.NAME,using = "currentIndustry")
	@CacheLookup
	WebElement industry;
	
	@FindBy(how = How.NAME,using = "linkedinLink")
	@CacheLookup
	WebElement linkedinProfile;
	
	@FindBy(how = How.NAME,using = "userSkill")
	@CacheLookup
	WebElement skills;
	

	@FindBy(how = How.XPATH,using = "//button[@type='submit']")
	@CacheLookup
	WebElement nextBtn;
	
	@FindBy(how = How.XPATH,using = "//input[@type='file']")
	@CacheLookup
	WebElement fileIcon;
	
	@FindBy(how = How.XPATH,using = "//button[text()='Next']")
	@CacheLookup
	WebElement nextpageBtn;
	
	@FindBy(how = How.NAME,using = "lastDrawnSalaryUS")
	@CacheLookup
	WebElement expectedCTC;
	
	@FindBy(how = How.XPATH,using = "//input[@name='preferredlocation' and @value='true']")
	@CacheLookup
	WebElement relocateChoice;
	
	@FindBy(how = How.NAME,using = "preferredCity")
	@CacheLookup
	WebElement cityName;
	
	@FindBy(how = How.XPATH,using = "//button[text()='Save' and @class='btn pull-right onboarding-primary-button']")
	@CacheLookup
	WebElement save;
	
	
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
	public void navigateToDetailspage()
	{
		EditButton.click();
		logger.info("clicked 'Edit profile' button");
	}
	public void updateProfileDetails() throws InterruptedException
	{
		try {
			
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[contains(text(),'Ensure that your mobile number')]")));
			logger.info("elements  found ");
			
			currentRole.clear();
			logger.info("cleared textbox ");
			Actions a=new Actions(driver); 
			a.click(currentRole).keyDown(Keys.SHIFT).sendKeys("automation tester").build().perform();
			
			
			logger.info("located current role textbox and entered role ");	
			Select dropdown = new Select(experience);
			
			dropdown.selectByVisibleText("0-2 years");
			logger.info("updated experience to 0-2 years ");
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='changes-saved']")));
			logger.info("changes saved message dispayed ");
			continueBtn.click();
			logger.info("continue button clicked ");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='changes-saved']")));
			continueBtn.click();
			logger.info("continue button clicked --again ");
			
			skipButton.click();
			logger.info("skip button clicked  ");			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public void ProfessionalDetails()
	{
		try
		{
			selectCompany();
			selectcurrentJob();
			selectCurrentIndustry();
			setLinkedInProfile();
			setSkillSet();
			//UploadResume();
			navigateToNextPage();
			setExpectedCTC();
			setWillingToRelocate();
			setPreferredCity();
			skipCareerInterests();
			clickSaveOnLastPage();
			
			
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
				
	}
	private void clickSaveOnLastPage() {
		try {
			save.click();
			logger.info("clicked on Save button on the last page");
		}
		catch(Exception ex)
		{
			logger.info("error while clicking Save button on the last page");
			ex.printStackTrace();
		}
			
		
	}
	private void setPreferredCity() {
		try
		{
			cityName.clear();
			cityName.sendKeys("NORWAY");
			logger.info("updated 'preferred city' textbox ");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='changes-saved']")));
		}
		catch(Exception ex)
		{
			logger.info("error while updating Willingto reclocate radio button in career interests page");
			ex.printStackTrace();
		}
			
		
	}
	private void setWillingToRelocate() {
		try
		{
			relocateChoice.click();
			logger.info("updated 'willing to relcate' radio button ");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='changes-saved']")));
		}
		catch(Exception ex)
		{
			logger.info("error while updating Willingto reclocate radio button in career interests page");
			ex.printStackTrace();
		}
				
		
	}
	private void setExpectedCTC() {
		try {
			Select selectSalary = new Select(expectedCTC);
			
			selectSalary.selectByValue("$100K-$125k");
			
			logger.info("updated expected CTC ");
			
		}
		catch(Exception ex)
		{
			logger.info("error while updating expectedCTC drop down in career interests page");
			ex.printStackTrace();
		}
		
	}
	public void selectCompany()
	{
		try
		{
			companyName.clear();
			companyName.sendKeys("DUMMY INC");
			logger.info("updated current company name  ");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='changes-saved']")));
			logger.info("changes saved message dispayed ");
		}
				catch(Exception ex)
				{
					logger.info("error while updating current company name in professional details page");
					ex.printStackTrace();
				}
	}
	
	public void selectcurrentJob()
	{
		try {
		Select joblevel_dropdown = new Select(jobLevel);
		
		joblevel_dropdown.selectByVisibleText("Senior Management");
		
		logger.info("updated current job level");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='changes-saved']")));
		}
		catch(Exception ex)
		{
			logger.info("error while updating current job level drop-down in professional details page");
			ex.printStackTrace();
		}
	}
	
	public void selectCurrentIndustry()
	{
		try {
		Select selectindustry = new Select(industry);
	
		selectindustry.selectByValue("Banking / Financial Services / Broking");
		
		logger.info("updated current idustry sector");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='changes-saved']")));
		}catch(Exception ex)
		{
			logger.info("error while updating Industry drop-down in professional details page");
			ex.printStackTrace();
		}
		
	}
	public void setLinkedInProfile()
	{
		try {
		linkedinProfile.clear();
		linkedinProfile.sendKeys("https://www.linkedin.com/in/sridevivenkatesh/");
		logger.info("updated linkedin profile ");
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='changes-saved']")));
		}
		catch(Exception ex)
		{
			logger.info("error while updating LinkedIn textbox in professional details page");
			ex.printStackTrace();
		}
	}
	public void setSkillSet()
	{
		try
		{
		skills.clear();
		skills.sendKeys("ETL, Testing,Selenium webdriver ");
		logger.info("updated skill set");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='changes-saved']")));
		}
		catch(Exception ex)
		{
			logger.info("error while updating skill set");
			ex.printStackTrace();
		}
	}
	public void navigateToNextPage()
	{
		try
		{
			if(framePopsUp())
			{
				driver.switchTo().frame("wiz-iframe-intent");
				logger.info("switched to iframe");
				driver.findElement(By.xpath("//a[contains(text(),'Ok, got')]")).click();
				logger.info("clicked OK got it button");
			}
				nextBtn.click();
				logger.info("clicked Next button");
		}
		catch(Exception ex)
		{
			logger.info("error while navigating to next page after updating professional details");
			ex.printStackTrace();
		}
		//driver.switchTo().defaultContent();
	}
	
	private boolean framePopsUp() {
		boolean framePopsup=true;
		try {
			driver.switchTo().frame(0);
			driver.switchTo().defaultContent();
			logger.info("returned to parent frame---frame exists and need to close the frame first");
			
			
		}catch(Exception ex)
		{
			logger.info("frame does not exist");
			ex.printStackTrace();
			framePopsup = false;
		}
		
		return framePopsup;
	}
	public void UploadResume()
	{
		try
		{
//			Actions action = new Actions(driver);
//			action.doubleClick(fileIcon).perform();
			fileIcon.click();
			logger.info("clicked resume button");						
			Runtime.getRuntime().exec("C:\\Users\\sudv\\Documents\\Edureka Project\\resume.exe");
			logger.info("ran autoit to attach resume");
			
		}
		catch(Exception e)
		{
			logger.info("did not attach the file ");
			e.printStackTrace();
		
		}
	}
	
	public void skipCareerInterests()
	{
		try {
			
			
			wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(nextpageBtn));
			nextpageBtn.click();
			logger.info("clicked 'Next' button in Career interests page");
		}
		catch(Exception e)
		{
			logger.info("error ------ skipping career interests page");
			e.printStackTrace();
		
		}
	}
	
	
	//this method is **NOT** used
	public boolean retryingFindClick() {
	    boolean result = false;
	    int attempts = 0;
	    while(attempts < 10) {
	        try {
	            nextpageBtn.click();
	            result = true;
	            logger.info("clicked the correct element");
	            break;
	        } catch(StaleElementReferenceException e) {
	        	logger.info("error while skipping career interests page");
				e.printStackTrace();
	        }
	        attempts++;
	    }
	    return result;
	}
	
	
	
	
	
}
