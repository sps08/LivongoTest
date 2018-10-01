package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import ObjectRepositories.LocatorsRepo;
import utils.GenericHelpers;

public class LivongoSuppliesPage {
	
	public WebDriver driver;
	GenericHelpers gh;
	
	public LivongoSuppliesPage(WebDriver dr){
		this.driver=dr;
		gh = new GenericHelpers(driver);
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(how= How.ID , using = LocatorsRepo.Supplies_StreetAddress)
	private WebElement txtaddress1;
	@FindBy(how= How.ID , using = LocatorsRepo.Supplies_StreetAddress2)
	private WebElement txtapt;
	@FindBy(how= How.ID , using = LocatorsRepo.Supplies_City)
	private WebElement txtCity;
	@FindBy(how= How.NAME , using = LocatorsRepo.Supplies_State)
	private WebElement ddState;
	@FindBy(how= How.ID , using = LocatorsRepo.Supplies_ZipCode)
	private WebElement txtZipcode;
	
	@FindBy(how= How.ID , using = LocatorsRepo.Supplies_Phone)
	private WebElement txtMobile;
	
	@FindBy(how= How.CLASS_NAME , using = LocatorsRepo.Supplies_CoverageButton)
	private WebElement btnCoverage;

	public void AddSupplierForm(String address, String apt, String city, String state, String zipcode, String mobnum) throws InterruptedException {
		
		EnterAddressSuppliers(address,apt);
		EnterCity(city);
		SelectState(state);
		EnterZipCode(zipcode);
		EnterMobileDetails(mobnum);
		Thread.sleep(1000);
		btnCoverage.click();
	}

	private void EnterAddressSuppliers(String address, String apt) {
		txtaddress1.sendKeys(address);
		txtapt.sendKeys(apt);
	}
	private void EnterCity(String city) {
		txtCity.sendKeys(city);
	}
	private void SelectState(String state) {
		ddState.sendKeys(state);
	}
	
	private void EnterZipCode(String zipcode) {
		txtZipcode.sendKeys(zipcode);
	}
	private void EnterMobileDetails(String mobilenum) {
		txtMobile.sendKeys(mobilenum);
	}
	

}
