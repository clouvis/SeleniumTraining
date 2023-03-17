package pageObjects.Account;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.datatable.DataTable;
import pageObjects.Action;



public class CreateAccountScreen {

	public WebDriver driver;
	
	public CreateAccountScreen (WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(driver, this);
	}
	Action action = new Action(driver);
	
	By txtEmail = By.name("CreateAccount-CreateAccountScreen-CreateAccountDV-CreateAccountContactInputSet-EmailAddress1");
	By txtAddress1 = By.name("CreateAccount-CreateAccountScreen-CreateAccountDV-AddressInputSet-globalAddressContainer-GlobalAddressInputSet-AddressLine1");
	By txtCity = By.name("CreateAccount-CreateAccountScreen-CreateAccountDV-AddressInputSet-globalAddressContainer-GlobalAddressInputSet-City");
	By addressType = By.name("CreateAccount-CreateAccountScreen-CreateAccountDV-AddressType");
	By btnSearchOrganization = By.id("CreateAccount-CreateAccountScreen-CreateAccountDV-ProducerSelectionInputSet-Producer-SelectOrganization");
	By txtOrgName = By.name("OrganizationSearchPopup-OrganizationSearchPopupScreen-OrganizationSearchDV-GlobalContactNameInputSet-Name");
	By btnOrgSearch = By.id("OrganizationSearchPopup-OrganizationSearchPopupScreen-OrganizationSearchDV-SearchAndResetInputSet-SearchLinksInputSet-Search");
	By producer = By.name("CreateAccount-CreateAccountScreen-CreateAccountDV-ProducerSelectionInputSet-ProducerCode");
	By btnUpdate = By.id("CreateAccount-CreateAccountScreen-Update");
	
	public void inputCreateAccountScreenFields(DataTable accountDetails) throws InterruptedException {
		Map<String, String> details = accountDetails.asMap(String.class, String.class);
		Thread.sleep(5000);
		driver.findElement(txtEmail).sendKeys(details.get("email"));
		driver.findElement(txtAddress1).sendKeys(details.get("address1"));
		driver.findElement(txtCity).sendKeys(details.get("city"));
		driver.findElement(txtCity).sendKeys(Keys.TAB);
		Select drpAddressType = new Select(driver.findElement(addressType));
		drpAddressType.selectByValue(details.get("addressType"));
	    this.selectOrganization("Enigma Fire & Casualty");
	    Thread.sleep(3000);
	    action.pageDown(driver);
	    Select drpProducer = new Select(driver.findElement(producer));
	    drpProducer.selectByValue("ProducerCode:1");
	    driver.findElement(btnUpdate).click();
	}
	
	public void selectOrganization(String org) throws InterruptedException {
		driver.findElement(btnSearchOrganization).click();
		Thread.sleep(2000);
		driver.findElement(txtOrgName).sendKeys(org);
		driver.findElement(btnOrgSearch).click();
		Thread.sleep(5000);
		WebElement orgNameDesc = driver.findElement(By.xpath("//div[contains(text(),'Enigma Fire & Casualty')]//ancestor::td//preceding-sibling::td"));
		orgNameDesc.click();
	}
	

}
