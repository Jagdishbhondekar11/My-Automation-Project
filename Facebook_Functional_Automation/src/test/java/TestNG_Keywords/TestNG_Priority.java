package TestNG_Keywords;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POM.ForgottenPassword;

public class TestNG_Priority {

	WebDriver driver;
	@BeforeClass
	public void launchBrowser()
	{
		System.out.println("Before Class");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@BeforeMethod
	public void launchForgootenPassword()
	{
		System.out.println("Before Method");
		driver.get("https://www.facebook.com/");
        ForgottenPassword password = new ForgottenPassword(driver);
		password.sendUserName("Jagdish");
		password.sendPassword("jagdish123");
		password.forgottenPassword();	
	}
	
	@Test (priority=1)
	public void VerifyPasswordWithValidEmail()
	{
		System.out.println("Test1");
		ForgottenPassword password = new ForgottenPassword(driver);
		password.findyourAccount("Jagdishbhondekar88@gmail.com");
		password.search();
	}
	
	@Test (priority=2)
	public void VerifyPasswordWithinvalidEmail()
	{
		System.out.println("Test2");
		ForgottenPassword password = new ForgottenPassword(driver);
		password.findyourAccount("Jagdishbhondekar@gmail.com");
		password.search();
	}
	@Test (priority=3)
	public void VerifyPasswordWithValidEmail1()
	{
		System.out.println("Test3");
		ForgottenPassword password = new ForgottenPassword(driver);
		password.findyourAccount("Jagdishbhondekar1@gmail.com");
		password.search();
	}
	
	@Test (priority=4)
	public void VerifyPasswordWithinvalidEmail1()
	{
		System.out.println("Test4");
		ForgottenPassword password = new ForgottenPassword(driver);
		password.findyourAccount("jagdish@gmail.com");
		password.search();
	}
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("After Method");
		
	}
	
	@AfterClass
	public void CloseBrowser()
	{
		System.out.println("After Class");
		driver.close();
	}
}
