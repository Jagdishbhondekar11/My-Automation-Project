package Test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import POM.ForgottenPassword;

public class ForgottenPassword_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		ForgottenPassword password = new ForgottenPassword(driver);
		
		password.sendUserName("Jagdish");
		password.sendPassword("jagdish123");
		password.forgottenPassword();
		password.findyourAccount("Jagdishbhondekar88@gmail.com");
		password.search();
		driver.close();
		

	}

}
