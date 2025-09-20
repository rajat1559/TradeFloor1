package Step_Defination;

import java.io.IOException;

import Govt.TradeFloor_UAT.DashboardPage;
import Govt.TradeFloor_UAT.Sell_AuctionsPage;
import Testting_Componenets.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class StepDefination extends BaseClass{
	public DashboardPage db;
	public Sell_AuctionsPage sa;
	
	@Given("I landed on Enterprise pannel")
	public void I_landed_on_Enterprise_pannel() throws InterruptedException, IOException {
		setupMethod();
	}
	
	@Given("user logged in with mobile number")
	public void user_logged_in_with_mobile_number() throws InterruptedException
	{
		lp.Login();
	}
	
	
	@When("user open enterprise pannel")
	public void user_open_enterprise_pannel()
	{
		db = lp.open_Enterprisepannel();
	}
	
	@When("open sell auction page")
	public void open_sell_auction() throws InterruptedException
	{
		Sell_AuctionsPage sa = db.open_sell_Auction_Page();
	}
	
	
	
	
	
	
}

