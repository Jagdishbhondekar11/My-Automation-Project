package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginOrSignupPage {
	
	@FindBy (xpath=("//input[@id='email']"))
	private WebElement userName;
	
	@FindBy (xpath=("//input[@id='email']"))
	private WebElement password;
	
	@FindBy (xpath=("//button[@name='login']"))
	private WebElement loginButton;
	
	@FindBy (xpath=("//a[text()='Create new account']"))
	private WebElement createNewAccountbutton;
	
	public LoginOrSignupPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void sendUserName(String userID)
	{
		userName.sendKeys(userID);
	}
	public void sendPassword(String userPassword)
	{
		password.sendKeys(userPassword);
	}
	public void clickOnLoginButton() 
	{
		loginButton.click();
	}

}
