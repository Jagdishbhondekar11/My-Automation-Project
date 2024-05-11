package TestNG;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.Base;
import POM.module.FacebookSignupPage;

public class FacebookSignupPage_Test extends Base {
	WebDriver driver;
	private FacebookSignupPage signup;
	@Parameters ("Browser")
	@BeforeTest
	public void LaunchBrowser(String BrowserName)
	{
		if(BrowserName.equals("Chrome"))
		{
		 //driver = Base.openChromeBrowser();
			driver = openChromeBrowser();
		}
		if(BrowserName.equals("Firefox"))
		{
			//driver = Base.openFirefoxBrowser();
			driver =openFirefoxBrowser();
		}
		if(BrowserName.equals("Edge"))
		{
			//driver = Base.openEdgeBrowser();
			driver =openEdgeBrowser();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	
	}
	@BeforeClass
	public void IntializePOMclasses()
	{
		System.out.println("Before Class");
		FacebookSignupPage signup= new FacebookSignupPage(driver);
	}
	@BeforeMethod
	public void SignupButton()
	{
		System.out.println("Before Method");
		driver.get("https://www.facebook.com/");
		signup.createAccount();
	}
	
	@Test
	public void VerifySignupPageforMale()
	{
		System.out.println("Test1");
		signup.userName("Jagdish");
		signup.userSurname ("Bhondekar");
		signup.Mobile("8668385808");
		signup.password("Jagdish123@rani");
		signup.BirthDay();
		signup.BirthMonth();
		signup.BirthYear();
		signup.male();
		//signup.signupbutton();
		
	}
	@Test
	public void VerifySignupforFemale()
	{
		System.out.println("Test 2");
		signup.userName("Jaimala");
		signup.userSurname("Bhondekar");
		signup.Mobile("9423242992");
		signup.password("Jaimala1234@rani");
		signup.BirthDay1();
		signup.BirthMonth1();
		signup.BirthYear1();
		signup.female();
		//signup.signupbutton();	
	}
	@AfterMethod
	public void TakeScreenShots() throws IOException
	{
		System.out.println("After Method");
		for(int i=0;i<1;i++)
		{
			Date d = new Date();
			SimpleDateFormat dateformat = new SimpleDateFormat("dd_MM_yyy_HH_mm_ss");
			String formatedatetime = dateformat.format(d);
			TakesScreenshot ts=(TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File Destination= new File("./photo/"+i+" "+formatedatetime+"Facebook.png");
			FileUtils.copyFile(source, Destination);	
		}
	}
	@AfterClass
	public void afterClass()
	{
		System.out.println("After Class");
		FacebookSignupPage signup= null;
	}
	@AfterTest
	public void CloseBrowser()
	{
		System.out.println("After Test");
		driver.quit();
		driver=null;
		System.gc(); //Garbage collector
	}
	
}
