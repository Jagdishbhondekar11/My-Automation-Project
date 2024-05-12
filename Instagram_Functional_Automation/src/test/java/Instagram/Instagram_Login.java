package Instagram;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import POM.LoginAndSiignupPage;

public class Instagram_Login {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.instagram.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		LoginAndSiignupPage login= new LoginAndSiignupPage(driver);
		login.usernameTextBox("JagdishBhondekar@124");
		login.passwordTextBox("ILOVEYOU");
		login.loginButton();
		driver.close();
		

	}

}
