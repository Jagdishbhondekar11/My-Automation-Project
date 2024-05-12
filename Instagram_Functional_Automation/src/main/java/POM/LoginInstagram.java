package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginInstagram {
	@FindBy (xpath=("//input[@name='username']"))
	WebElement userName;
	
	@FindBy (xpath=("//input[contains(@name,'password')]"))
	WebElement Password;
	
	@FindBy (xpath=("//div[contains(text(),'Log in')]"))
	WebElement Login;
	
	public LoginInstagram(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void usernameTextBox(String userID)
	{
		userName.sendKeys(userID);
	}
	public void passwordTextBox(String userPassword)
	{
		Password.sendKeys(userPassword);
	}
	
	public void loginButton()
	{
		Login.click();
	}

}
