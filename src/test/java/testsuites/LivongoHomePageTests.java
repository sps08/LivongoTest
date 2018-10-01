package testsuites;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.LivongoCoveragePage;
import Pages.LivongoHomePage;
import Pages.LivongoSuppliesPage;
import utils.TestBase;


public class LivongoHomePageTests extends TestBase {

	LivongoHomePage lhp;
	LivongoSuppliesPage lsp;
	LivongoCoveragePage lcp;
	
	
	@Test(priority=1, description="Verify the Join Now Button", dataProvider="SignUpPageProvider")
	public void VerifyTheSubmissionOf_LoginPage(String Fname, String Lname, String mon, String day, String year, String email, String pwd) throws InterruptedException {
		lhp =  new LivongoHomePage(driver);
		//driver.get("https://www.google.com/");
		driver.get("https://welcome.integration.livongo.com/#/?_vis_test_id=4&_vis_opt_random=0.7494647611939103&_vis_hash=cda431ef841ab55f45ed887f56cfa777&_vis_opt_preview_combination=1");
		lhp.clickJoinNowButton();
    	lhp.EnterAlltheValueonHomePage(Fname,Lname,mon, day, year,email,pwd);	
    	
	}
	
	@Test(priority=2, description="Verify the Submission of the Supplies Page", dependsOnMethods="VerifyTheSubmissionOf_LoginPage", dataProvider="SuppliesPageProvider")
	public void VerifyTheSubmissionOf_SuppliesPage(String address,String apt, String city, String state, String zip, String phone) throws InterruptedException {
		lsp =  new LivongoSuppliesPage(driver);
    	lsp.AddSupplierForm(address, apt,city,state,zip,phone);
		
	}
	
	@Test(priority=3, description="Verify the Title and Submission of the Coverage Page", dataProvider="CoveragePageProvider")
	public void VerifyTheTitleAndFill_CoveragePage(String code, String coverage, String memId, String grpId) throws InterruptedException {
		lcp =  new LivongoCoveragePage(driver);
    	lcp.FillCoverageForm(code, coverage, memId,grpId);
    	assertEquals("Livongo Health - Registration", driver.getTitle());
	}
	
	
	 @DataProvider(name="SignUpPageProvider")
	    public Object[][] getDataFromHomeDataprovider(){
	    return new Object[][] 
	    	{
	            { "LivongoTest", "Automation","12","12","1990","testAutomation@livongo.com","Test@123" }  
	        };
	    }
	 
	 @DataProvider(name="SuppliesPageProvider")
	    public Object[][] getDataFromSuppliesDataprovider(){
	    return new Object[][] 
	    	{
	            { "2233 Nowhere Place", "8", "santa clara", "C","98500", "6698008888" } 
	        };
	    }
	 
	 @DataProvider(name="CoveragePageProvider")
	    public Object[][] getDataFromCoverageDataprovider(){
	    return new Object[][] 
	    	{
	            { "liv-test", "Not Listed", "97890", "9009" } 
	        };
	    }
}
