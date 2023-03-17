package pageObjects;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class SearchScreen {
	
	public WebDriver driver;
	public SearchScreen (WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(driver, this);
	}
	
	By btnSearchTabBar = By.xpath("//body/form[@id='gw-root-form']/div[@id='gw-body']/div[@id='gw-west-center']/div[@id='gw-center-panel']/div[@id='gw-center-top-section']/div[@id='gw-center-tab-bar']/div[@id='TabBar']/div[1]/div[5]/div[3]/div[1]");
	By btnAccount = By.id("TabBar-SearchTab-Search_AccountSearch");
	By txtAccountNumber = By.name("AccountSearch-AccountSearchScreen-AccountSearchDV-AccountNumber");
	By btnSearch = By.id("AccountSearch-AccountSearchScreen-AccountSearchDV-SearchAndResetInputSet-SearchLinksInputSet-Search");
	By listViewSearchResults = By.id("AccountSearch-AccountSearchScreen-AccountSearchResultsLV");
	By btnPolicies = By.id("TabBar-SearchTab-Search_PolicySearch");
	By txtPolicyNumber = By.name("PolicySearch-PolicySearchScreen-DatabasePolicySearchPanelSet-PolicySearchDV-PolicyNumberCriterion");
	
	
	public void clickSearchByAccount() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(btnSearchTabBar).click();
		driver.findElement(btnAccount).click();
	}
	
	public void searchByAccount(String accountNum) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(txtAccountNumber).sendKeys(accountNum);
		Thread.sleep(3000);
		driver.findElement(btnSearch).click();
		Thread.sleep(3000);
		String accountNumberCell = driver.findElement(By.cssSelector("div.gw-ActionValueWidget[id$=-AccountNumber_button]")).getText();
		System.out.println(accountNumberCell);
		Assert.assertTrue(accountNumberCell.equals(accountNum));
		driver.quit();
	}
	
	public void searchByPolicyNumber(String policyNumber) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(btnSearchTabBar).click();
		driver.findElement(btnPolicies).click();
		Thread.sleep(500);
		driver.findElement(txtPolicyNumber).sendKeys(policyNumber);
		driver.findElement(txtPolicyNumber).sendKeys(Keys.ENTER);
	}
	
	public void verifyPolicyStatus(String expectedStatus) throws InterruptedException {
		Thread.sleep(3000);
		String policyStatus = driver.findElement(By.cssSelector("td[id$=-PolicyPeriodStatus_Cell] div[class='gw-value-readonly-wrapper']")).getText();
		System.out.println(policyStatus);
		Assert.assertEquals(expectedStatus, policyStatus);
	}

}
