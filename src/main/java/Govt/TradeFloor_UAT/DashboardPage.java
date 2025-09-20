package Govt.TradeFloor_UAT;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractFiles.AbstractClass;

public class DashboardPage extends AbstractClass{
	
	public WebDriver driver;
	public Sell_AuctionsPage sa;

	@FindBy(css=".menu_section")
	private WebElement SidePannel;
	
	@FindBy(css=".scroll-y div[class='scroll-bar']")
	private WebElement Scroller;
	
	
	@FindBy(xpath="//span[text()='User Search']")
	private WebElement  BelowAuctionMenu;
	
	@FindBy(xpath="//span[text()='Auctions']")
	private WebElement Auctions;
	
	@FindBy(xpath="//a[text()='Sell Auctions']")
	private WebElement Sell_Auctions;
	
	public DashboardPage(WebDriver driver) {
		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}

	public Sell_AuctionsPage open_sell_Auction_Page() throws InterruptedException
	{
		Thread.sleep(3000);
		Actions a = new Actions(driver);
//		a.moveToElement(SidePannel).perform();
		a.scrollToElement(BelowAuctionMenu).perform();
		Auctions.click();
		Sell_Auctions.click();
		sa = new Sell_AuctionsPage(driver);
		return sa;
	}
	
	
	

}
