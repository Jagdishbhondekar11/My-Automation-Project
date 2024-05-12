package Instagram;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import POM.SignupPage;

public class Instagram_Signup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.instagram.com/accounts/emailsignup/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		SignupPage signup= new SignupPage(driver);
		signup.MobileNumberTextBox("566655222");
		signup.FullNameTextBox("Jagdish BhondekaR");
		signup.usernametextbox("Jagdish@Gmail.com");
		signup.passwordTextBox("Jagdish12345");
		signup.SignupButton();
		driver.close();
		

	}

}
