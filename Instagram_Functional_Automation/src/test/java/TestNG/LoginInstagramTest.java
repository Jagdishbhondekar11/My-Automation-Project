package TestNG;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;

import Base.BaseClass;
import POM.LoginInstagram;
import utils.TestUtil;

public class LoginInstagramTest extends BaseClass {
    private WebDriver driver;
    private LoginInstagram login;
	
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
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("BeforeClass"); 
		LoginInstagram login= new LoginInstagram(driver);
	}
	
	@BeforeMethod
	public void URl()
	{
		System.out.println("BeforeMethod");
		driver.get("https://www.instagram.com/");
	}
	@DataProvider
	public Object[][] getLoginData() throws EncryptedDocumentException, IOException 
	{
		Object data [][]=TestUtil.getTestData("LoginTestData.xlsx");
		return data;
	}
	@Test (dataProvider ="LoginTestData.xlsx")
	public void LoginValid(String username , String password)
	{
		System.out.println("Test1");
		
		login.usernameTextBox(username);
		login.passwordTextBox(password);
	}
	
	@Test (dataProvider ="LoginTestData.xlsx")
	public void LoginInvalid(String username , String password)
	{
		System.out.println("Test2");
		
		login.usernameTextBox(username);
		login.passwordTextBox(password);
	}
	
	@AfterMethod
	public void afterMethod() throws IOException
	{
		System.out.println("After Method");
//		for(int i=0;i<1;i++)
//		{
//		Date d=new Date();
//		SimpleDateFormat dateformat = new SimpleDateFormat("dd_MM_yyy_HH_mm_ss");
//		String formatedatetime = dateformat.format(d);
//		TakesScreenshot ts= (TakesScreenshot) driver;
//		File source = ts.getScreenshotAs(OutputType.FILE);
//		File Destination=new File("./photo/"+i+" "+formatedatetime+"Instagram.png");
//		FileUtils.copyFile(source, Destination);
//		}
	}
	
	@AfterClass
	public void afterClass()
	{
		System.out.println("After Class");
		LoginInstagram login= null;
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
