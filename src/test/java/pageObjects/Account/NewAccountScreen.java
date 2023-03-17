package pageObjects.Account;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.datatable.DataTable;
public class NewAccountScreen {
	public WebDriver driver;
	public NewAccountScreen (WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(driver, this);
	}
	
	By btnAccount = By.xpath("//body/form[@id='gw-root-form']/div[@id='gw-body']/div[@id='gw-west-center']/div[@id='gw-center-panel']/div[@id='gw-center-top-section']/div[@id='gw-center-tab-bar']/div[@id='TabBar']/div[1]/div[2]/div[3]/div[1]");
	By btnNewAccount = By.id("TabBar-AccountTab-AccountTab_NewAccount");
	By txtFirstname = By.name("NewAccount-NewAccountScreen-NewAccountSearchDV-GlobalPersonNameInputSet-FirstName");
	By txtLastname = By.name("NewAccount-NewAccountScreen-NewAccountSearchDV-GlobalPersonNameInputSet-LastName");	
	By btnSearch = By.cssSelector("div[id=NewAccount-NewAccountScreen-NewAccountSearchDV-SearchAndResetInputSet-SearchLinksInputSet-Search]");
	By btnCreateNewAccount = By.id("NewAccount-NewAccountScreen-NewAccountButton");
	By btnNewAccount_Person = By.id("NewAccount-NewAccountScreen-NewAccountButton-NewAccount_Person");
	
	public void clickNewAccount() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(btnAccount).click();
		driver.findElement(btnNewAccount).click();
	}
	
	public void inputEnterAccountField(DataTable accountDetails) throws InterruptedException {
		Map<String, String> details = accountDetails.asMap(String.class, String.class);
		Thread.sleep(3000);
		driver.findElement(txtFirstname).sendKeys(details.get("firstName"));
		driver.findElement(txtLastname).sendKeys(details.get("lastName"));
	}
	
	public void clickSearch() {
		driver.findElement(btnSearch).click();
	}
	
	public void clickCreateNewAccount_Person(DataTable accountDetails) throws InterruptedException {
		Thread.sleep(1000);
		CreateAccountScreen createAccountScreen = new CreateAccountScreen(driver);
		List<WebElement> listViewAccounts = driver.findElements(By.xpath("//div[@id='NewAccount-NewAccountScreen-NewAccountSearchResultsLV']//descendant::tbody//child::tr"));
		System.out.println(listViewAccounts.size());
		if(listViewAccounts.size() > 1) {
			WebElement btnAccountNumber = driver.findElement(By.cssSelector("div[id$=-AccountNumber_button]"));
			System.out.println(btnAccountNumber.getText());
			btnAccountNumber.click();
		}else {
			driver.findElement(btnCreateNewAccount).click();
			Thread.sleep(1000);
			driver.findElement(btnNewAccount_Person).click();
			createAccountScreen.inputCreateAccountScreenFields(accountDetails);
		}
	}
}
