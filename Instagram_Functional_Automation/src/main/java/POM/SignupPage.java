package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {
	
	@FindBy (xpath= ("//input[@name='emailOrPhone']"))
	WebElement MobileNumberOREmail;
	
	@FindBy (xpath=("//input[@name='fullName']"))
	WebElement FullName;
	
	@FindBy (xpath=("//input[@name='username']"))
	WebElement Username;
	
	@FindBy (xpath=("//input[@name='password']"))
	WebElement Password;
	
	@FindBy (xpath=("//button[text()='Sign up']"))
	WebElement Signup;
	
	public SignupPage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}
	
	public void MobileNumberTextBox(String h)
	{
		MobileNumberOREmail.sendKeys(h);
	}
	
	public void FullNameTextBox(String Name)
	{
		FullName.sendKeys(Name);
	}
	
	public void usernametextbox(String UserName)
	{
		Username.sendKeys(UserName);
	}
	
	public void passwordTextBox(String Userpassword)
	{
		Password.sendKeys( Userpassword);
	}
	
	public void SignupButton()
	{
		Signup.click();
	}
}
