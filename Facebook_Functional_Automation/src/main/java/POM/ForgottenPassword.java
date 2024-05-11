package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgottenPassword {
	@FindBy (xpath=("//input[@id='email']"))
	private WebElement userName;
	
	@FindBy (xpath=("//a[normalize-space()='Forgotten password?']"))
	private WebElement ForgottenPassword;
	
	@FindBy (xpath=("//input[@id='identify_email']"))
	private WebElement FindYourAccount;

	@FindBy (xpath=("//button[@id='did_submit']"))
	private WebElement Search;
	
	@FindBy (xpath=("//input[@id='pass']"))
	private WebElement Password;
	
	@FindBy (xpath=("//button[@name='login']"))
	private WebElement loginButton;
	
	@FindBy (xpath=("//a[text()='Create new account']"))
	private WebElement createNewAccountbutton;
	
	public ForgottenPassword (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void sendUserName(String userID)
	{
		userName.sendKeys(userID);
	}
	public void sendPassword(String userPassword)
	{
		Password.sendKeys(userPassword);
	}
	public void clickOnLoginButton() 
	{
		loginButton.click();
	}
	
	public void forgottenPassword()
	{
		ForgottenPassword.click();
	}
	
	public void findyourAccount(String account)
	{
		FindYourAccount.sendKeys(account);
	}
	
	public void search()
	{
		Search.click();
	}

}
