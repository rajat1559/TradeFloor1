package Govt.TradeFloor_UAT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractFiles.AbstractClass;

public class Sell_AuctionsPage extends AbstractClass{

	public WebDriver driver;
	
	@FindBy(css="input[type='search']")
	private WebElement searchBox;
	
	@FindBy(xpath="//tr[@class='odd']//td[text()='PSS-381198']")
	private WebElement searchedRresultPSS;
	
	@FindBy(xpath="//tr[@class='odd']//td[text()='HSM-381275']")
	private WebElement searchedRresultHSM;
	
	@FindBy(xpath="//tr[@class='odd']//td[2]")
	private WebElement auctionDetails;
	
	@FindBy(xpath="//div[@class='heading_actions']//a[text()='Clone Auction']")
	private WebElement clone;
	
	@FindBy(css="button[class='js-modal-confirm-cancel md-btn md-btn-flat']")
	private WebElement cancelClone;

	@FindBy(css="button[class='js-modal-confirm md-btn-flat-primary md-btn md-btn-flat")
	private WebElement acceptClone;
	
	@FindBy(css="div[ng-if='sellArr.engine==3']")
	private WebElement inView;
	
	@FindBy(css="#uk_dp_1")
	private WebElement datePicker;

	@FindBy(css=".uk-datepicker-table tbody [class='uk-active']")
	private WebElement todayDate;
	
	@FindBy(css=".uk-datepicker-table tbody [class='']")
	private WebElement futureDate;
	
	private By eitherDate = By.xpath("//table[@class='uk-datepicker-table']//tbody//a[@class='uk-active'] | //table[@class='uk-datepicker-table']//tbody//a[@class='']");
	
	@FindBy(css="div[aria-expanded='true']")
	private WebElement timepickerdropdown;
	
	@FindBy(css="div[aria-expanded='true'] ul li")
	private WebElement timePicker;
	
	@FindBy(css="input[name='starttime']")
	private WebElement r1Start;
	
	@FindBy(css="input[name='endtime']")
	private WebElement r1End;

	@FindBy(css="input[name='round2start']")
	private WebElement r2Start;
	
	@FindBy(css="input[name='round2end']")
	private WebElement r2End;
	
	@FindBy(css="#weighttype2 + ins[class='iCheck-helper']")
	private WebElement grossWeight;
	
	@FindBy(css="button[type='submit']")
	private WebElement publishAuction;
	
	
	public Sell_AuctionsPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void clone_PSS_auction() throws InterruptedException
	{
		Thread.sleep(1000);
		searchBox.sendKeys("PSS-381198");
		Thread.sleep(6000);
		waitForWebElementToAppear(searchedRresultPSS);
		auctionDetails.click();
		clone.click();
		acceptClone.click();
	}
	
	public void clone_HSM_auction() throws InterruptedException
	{
		Thread.sleep(1000);
		searchBox.sendKeys("HSM-381275");
		Thread.sleep(6000);
		waitForWebElementToAppear(searchedRresultHSM);
		auctionDetails.click();
		clone.click();
		acceptClone.click();
	}
	
	
	public void fill_Details() throws InterruptedException
	{
		Thread.sleep(2000);
		Actions aa = new Actions(driver);
		aa.scrollToElement(datePicker).perform();
		datePicker.click();
		Thread.sleep(2000);
//		waitForWebElementToAppear(futureDate);
//		LocalDate today = LocalDate.now();
//		String currentDate = today.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
//		String minDateValue = datePicker.getAttribute("data-uk-datepicker");
//		String[] part = minDateValue.split("minDate:'");
//		String minDate = part[1].split("'")[0];
//		if(minDate.equals(currentDate))
//			todayDate.click();
//		else
//			futureDate.click();
		
		driver.findElement(eitherDate).click();
		aa.scrollToElement(inView).perform();
		r1Start.click();
		waitForWebElementToAppear(timepickerdropdown);
		Thread.sleep(200);
		timePicker.click();
		r1End.click();
		waitForWebElementToAppear(timepickerdropdown);
		Thread.sleep(200);
		timePicker.click();
		r2Start.click();
		waitForWebElementToAppear(timepickerdropdown);
		Thread.sleep(200);
		timePicker.click();
		r2End.click();
		waitForWebElementToAppear(timepickerdropdown);
		Thread.sleep(200);
		timePicker.click();
		aa.scrollToElement(publishAuction).perform();
		Thread.sleep(1000);
		grossWeight.click();
		System.out.println(grossWeight.isEnabled());
		publishAuction.click();
	}


}
