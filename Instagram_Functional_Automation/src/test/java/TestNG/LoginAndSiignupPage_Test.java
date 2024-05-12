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

import POM.LoginAndSiignupPage;
public class LoginAndSiignupPage_Test {
	WebDriver driver;
	
	@Parameters ("Browser")
	@BeforeTest
	public void LaunchBrowser(String BrowserName)
	{
		System.out.println("BeforeTest");
	    if(BrowserName.equals("Chrome"))
	    {
	    	driver= new ChromeDriver();
	    }
	    if(BrowserName.equals("Firefox"))
	    {
	    	driver= new FirefoxDriver();
	    }
	    if(BrowserName.equals("Edge"))
	    {
	    	driver= new EdgeDriver();
	    }
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("BeforeClass");    
	}
	
	@BeforeMethod
	public void URl()
	{
		System.out.println("BeforeMethod");
		driver.get("https://www.instagram.com/");
	}
	
	@Test
	public void VerifytheLoginFunctionalityWithValidUsernamePassword()
	{
		System.out.println("Test1");
		LoginAndSiignupPage login= new LoginAndSiignupPage(driver);
		login.usernameTextBox("JagdishBhondekar@gmail.com");
		login.passwordTextBox("ILOVEYOU");
	}
	
	@Test
	public void VerifytheLoginFunctionalityWithInvalidUsernamePassword()
	{
		System.out.println("Test2");
		LoginAndSiignupPage login= new LoginAndSiignupPage(driver);
		login.usernameTextBox("JagdishBhondekar@12456");
		login.passwordTextBox("nhjk");
	}
	
	
	
	@AfterMethod
	public void afterMethod() throws IOException
	{
		System.out.println("After Method");
		for(int i=0;i<1;i++)
		{
		Date d=new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat("dd_MM_yyy_HH_mm_ss");
		String formatedatetime = dateformat.format(d);
		TakesScreenshot ts= (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File Destination=new File("./photo/"+i+" "+formatedatetime+"Instagram.png");
		FileUtils.copyFile(source, Destination);
		}
	}
	
	@AfterClass
	public void afterClass()
	{
		System.out.println("After Class");
	}
	
	@AfterTest
	public void CloseBrowser()
	{
		driver.quit();
	}
	
	
}
