package Test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import POM.module.FacebookSignupPage;

public class FacebookSignup_Page_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		FacebookSignupPage signup= new FacebookSignupPage(driver);
		
		signup.createAccount();
		signup.userName("Jagdish");
		signup.userSurname("Bhondekar");
		signup.Mobile("8668385808");
		signup.password("Jagdish12345");
		signup.BirthDay();
		signup.BirthMonth();
		signup.BirthYear();
		signup.male();
		signup.signupbutton();
		driver.close();
	

	}

}
