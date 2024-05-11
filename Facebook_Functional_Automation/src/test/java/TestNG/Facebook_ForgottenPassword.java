package TestNG;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.Base;
import POM.ForgottenPassword;
import utils.Utility;

public class Facebook_ForgottenPassword extends Base{
	private WebDriver driver;
	private ForgottenPassword password;
	@Parameters("Browser")
	@BeforeTest
	public void launchBrowser(String browsername)
	{
		System.out.println("Before Test	");
		System.out.println(browsername);
		if(browsername.equals("Chrome"))
		{
			//driver= Base.openChromeBrowser();
			driver= openChromeBrowser();
		}
		if(browsername.equals("Firefox"))
		{
			//driver = Base.openFirefoxBrowser();
			driver = openFirefoxBrowser();
		}
		if(browsername.equals("Edge"))
		{
			//driver = Base.openEdgeBrowser();
			driver = openEdgeBrowser();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	}
	@BeforeClass
	public void InitalizePOMclasses()
	{
		System.out.println("Before Class");
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
//     	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		//ForgottenPassword password = new ForgottenPassword(driver);	
	}
	
	@BeforeMethod
	public void launchForgootenPassword() throws EncryptedDocumentException, IOException
	{
		//System.out.println("Before Method");
		//driver.get("https://www.facebook.com/");
		String userID =Utility.getDataFromExcelSheet("LoginTestData", 2, 1);
		password.sendUserName(userID);
		String sendpassword =Utility.getDataFromExcelSheet("LoginTestData", 2, 2);
		password.sendPassword(sendpassword);
		password.forgottenPassword();	
	}
	
	@Test (priority=1)
	public void VerifyPasswordWithValidEmail()
	{
		//System.out.println("Test1");
		password.findyourAccount("Jagdishbhondekar88@gmail.com");
		password.search();
	}
	
	@Test (priority=2)
	public void VerifyPasswordWithinvalidEmail()
	{
		System.out.println("Test2");
		password.findyourAccount("fhjggjgjjg");
		password.search();
	}
	@Test (priority=3)
	public void VerifyPasswordWithValidEmail1()
	{
		System.out.println("Test3");
		password.findyourAccount("Jagdishbhondekar1@gmail.com");
		password.search();
	}
	
	@Test (priority=4)
	public void VerifyPasswordWithinvalidEmail1()
	{
		System.out.println("Test4");
		password.findyourAccount("jagdish");
		password.search();
	}
	
		
	@AfterMethod
	public void capturescreenshotFailedTest(ITestResult result) throws IOException
	{
		System.out.println("After Method");
		if(ITestResult.FAILURE== result.getStatus())
		{
			Utility.captureScreenShot("123");
		}
		System.out.println("Take Screen shot for Failed Test Cases");
	}
	
	@AfterClass
	public void afterClass()
	{
		System.out.println("After Class");
		ForgottenPassword password = null;
		
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
