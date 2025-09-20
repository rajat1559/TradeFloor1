package Testting_Componenets;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import Govt.TradeFloor_UAT.LandingPage;

public class BaseClass {
	public WebDriver driver;
	public LandingPage lp;
	
	public void intializebrowser() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\ResourceFiles\\globalData.properties");
		prop.load(fis);
		
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",prop.getProperty("chromedriverPath"));
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.firefox.driver", prop.getProperty("firefoxxdriverPath"));
			driver = new FirefoxDriver();	
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		return driver;
	}
	
//	@BeforeTest(alwaysRun=true)
	public void setupMethod() throws IOException
	{
		intializebrowser();
		lp = new LandingPage(driver);
		lp.visitURL();
	}
	
	@AfterTest(alwaysRun=true)
	public void teardownMethod() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
