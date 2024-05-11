package POM.module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FacebookSignupPage {
	
	@FindBy (xpath=("//a[text()='Create new account']"))
	private WebElement CreateNewAccount;
	
	@FindBy (xpath=("//input[@name='firstname']"))
	private WebElement FirstName;
	
	@FindBy(xpath=("//input[@name='lastname']"))//input[@id='u_h_d_4T']
	private WebElement Surname;
	
	@FindBy (xpath=("//input[@name='reg_email__']"))//id="u_h_g_QC"
	private WebElement MobileNumber;
	
	@FindBy (xpath=("//input[@name='reg_passwd__']"))
	private WebElement NewPassword;
	
	@FindBy (xpath=("//select[@name='birthday_day']"))
	private WebElement Day;
	
	@FindBy (xpath=("//select[@name='birthday_month']"))
	private WebElement Month;
	
	@FindBy (xpath=("//select[@name='birthday_year']"))
	private WebElement Year;
	
	@FindBy (xpath=("//label[text()='Female']"))
	private WebElement Female;
	
	@FindBy (xpath=("//label[text()='Male']"))
	private WebElement Male;
	
	@FindBy (xpath=("//label[text()='Custom']"))
	private WebElement Custom;
	
	@FindBy (xpath=("(//button[text()='Sign Up'])[1]"))
	private WebElement Signup;
	
	public FacebookSignupPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void createAccount()
	{
		CreateNewAccount.click();
	}
	
	public void userName(String name)
	{
		FirstName.sendKeys(name);
	}
	
	public void userSurname(String surname)
	{
		Surname.sendKeys(surname);
	}
	
	public void Mobile(String number)
	{
		MobileNumber.sendKeys(number);
	}
	
	public void password(String pwd)
	{
		NewPassword.sendKeys(pwd);
	}
	
	public void BirthDay()
	{
		Day.click();
		Select s = new Select(Day);
		s.selectByVisibleText("8");
	}
	public void BirthDay1()
	{
		Day.click();
		Select s = new Select(Day);
		s.selectByVisibleText("9");
	}
	
	public void BirthMonth()
	{
		Month.click();
		Select s = new Select(Month);
		s.selectByVisibleText("Sep");
	}
	public void BirthMonth1()
	{
		Month.click();
		Select s = new Select(Month);
		s.selectByVisibleText("Dec");
	}
	
	public void BirthYear()
	{
		Year.click();
		Select s = new Select(Year);
		s.selectByVisibleText("1995");
	}
	public void BirthYear1()
	{
		Year.click();
		Select s = new Select(Year);
		s.selectByVisibleText("1997");
	}
	
	public void female()
	{
		Female.click();
	}
	
	public void male()
	{
		Male.click();
	}
	
	public void custom()
	{
		Custom.click();
	}
	
	public void signupbutton()
	{
		Signup.click();
	}

}
	
