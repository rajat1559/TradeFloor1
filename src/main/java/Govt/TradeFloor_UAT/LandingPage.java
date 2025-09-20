package Govt.TradeFloor_UAT;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractFiles.AbstractClass;

public class LandingPage extends AbstractClass{
	
	@FindBy(css="span[class='btn2']")
	private WebElement login;
	
	@FindBy(css="input[placeholder='Enter your mobile no. here']")
	private WebElement  mobileField;
	
	@FindBy(css="label[class='btn2 m-top-40 disableBtn']")
	private WebElement  sendOTP_disabled;
	
	@FindBy(css="label[class='btn2 m-top-40']")
	private WebElement sendOTP; 
	
	@FindBy(css="div[class='otp-input-form m-bottom-25'] :nth-child(2)")
	private WebElement  OTPfield1;
	
//	@FindBy(css="div[class='otp-input-form m-bottom-25'] :nth-child(3)")
//	WebElement  OTPfield2;
	
//	@FindBy(css="div[class='otp-input-form m-bottom-25'] :nth-child(4)")
//	WebElement  OTPfield3;
	
//	@FindBy(css="div[class='otp-input-form m-bottom-25'] :nth-child(5)")
//	WebElement  OTPfield4;
	
	@FindBy(css="label[class='btn2 disableBtn ng-star-inserted']")
	private WebElement  login_Disabled;
	
	@FindBy(xpath="//span[text()='Resend OTP via SMS']")
	private WebElement  resendOTP;
	
	@FindBy(css="label[class='btn2 ng-star-inserted']")
	private WebElement fLogin;
	
	
//	HomePAGE: 
	@FindBy(css=".module-icon16")
	private WebElement  profileIcon;
	
	@FindBy(xpath="//span[normalize-space(text())='Go to Enterprise Panel']")
	private WebElement  goToEnterprisePannel;

	@FindBy(css="span[title='SugarBazaar']")
	WebElement  sugarDashboard;
//	@FindBy(css="")
//	WebElement  
//	@FindBy(css="")
//	WebElement  
//	@FindBy(css="")
//	WebElement  
//	@FindBy(css="")
//	WebElement  
//	@FindBy(css="")
//	WebElement  
//	@FindBy(css="")
//	WebElement  
//	@FindBy(css="")
//	WebElement  

	public WebDriver driver;
	public DashboardPage db;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	public void visitURL()
	{
		driver.get("https://tradeuat.agribazaar.com/");
	}
	
	public void Login() throws InterruptedException
	{
		login.click();
		System.out.println("Send OTP button Status: "+ sendOTP_disabled.isEnabled());
		mobileField.sendKeys("5718117745");
		sendOTP.click();
		System.out.println("Login Button Status: "+ login_Disabled.isEnabled());
		OTPfield1.sendKeys("3815");
		fLogin.click();
	}
	
	public DashboardPage open_Enterprisepannel()
	{
		waitForWebElementToAppear(sugarDashboard);
		profileIcon.click();
		goToEnterprisePannel.click();
		for(String handle : driver.getWindowHandles())
			{
			driver.switchTo().window(handle);
			if(driver.getTitle().equals("Agribazaar Admin - Dashboard"))
				break;
			}
		db = new DashboardPage(driver);
		return db;
	}
}
