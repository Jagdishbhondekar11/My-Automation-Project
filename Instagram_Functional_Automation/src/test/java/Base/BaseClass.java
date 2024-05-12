package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	
	public static  WebDriver openChromeBrowser()
	{
		WebDriver driver = new ChromeDriver();
		return null;
	}
	public static WebDriver openFireFoxBrowser()
	{
		WebDriver driver = new FirefoxDriver();
		return null;
	}
	public static WebDriver openEdgeBrowser()
	{
		WebDriver driver = new EdgeDriver();
		return null;
	}

}
