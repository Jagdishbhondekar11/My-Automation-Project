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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import POM.SignupPage;

public class SignupPage_Test {
	WebDriver driver;
	
	@Parameters("Browser")
	@BeforeTest
	public void LaunchBrowser(String BrowserName)
	{
		System.out.println("BeforeClass");
	    if(BrowserName.equals("Chrome"))
	    {
	    	driver= new ChromeDriver();
	    }
	    else
	    {
	    	driver= new FirefoxDriver();
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
		driver.get("https://www.instagram.com/accounts/emailsignup/");
	}
	
	@Test
	public void VerifytheLoginFunctionalityWithValidUsernamePassword()
	{
		System.out.println("Test1");
		SignupPage  Signup= new SignupPage (driver);
		Signup.MobileNumberTextBox("8668385808");
		Signup.FullNameTextBox("Jagdish Bhondekar");
		Signup.usernametextbox("jagdish123");
		Signup.passwordTextBox("Bhondekar1234");
		Signup.SignupButton();
	}
	
	@Test
	public void VerifySignupWithValid()
	{
		System.out.println("Test1");
		SignupPage  Signup= new SignupPage (driver);
		Signup.MobileNumberTextBox("jagdish@gmail.com");
		Signup.FullNameTextBox("Jagdish Bhondekar");
		Signup.usernametextbox("jagdish123");
		Signup.passwordTextBox("Bhondekar1234");
		Signup.SignupButton();
	}
	
	@Test
	public void VerifySignupWithInvalid()
	{
		System.out.println("Test1");
		SignupPage  Signup= new SignupPage (driver);
		Signup.MobileNumberTextBox("9423242992");
		Signup.FullNameTextBox("Jaimala Bhondekar");
		Signup.usernametextbox("jaimala123");
		Signup.passwordTextBox("Bhondekar");
		Signup.SignupButton();
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
	public void CloseBrowser()
	{
		System.out.println("After Class");;
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
	}

}
