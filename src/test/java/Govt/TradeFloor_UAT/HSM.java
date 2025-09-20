package Govt.TradeFloor_UAT;

import org.testng.annotations.Test;

import Testting_Componenets.BaseClass;

public class HSM extends BaseClass{

	@Test
	public void createAuction_HSM() throws InterruptedException
	{
		lp.Login();
		DashboardPage db = lp.open_Enterprisepannel();
		Sell_AuctionsPage sa = db.open_sell_Auction_Page();
		sa.clone_HSM_auction();
		sa.fill_Details(); 	
	}
}
