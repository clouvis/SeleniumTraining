package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pageObjects.LoginScreen;
import pageObjects.SearchScreen;
import pageObjects.Account.NewAccountScreen;


public class AccountSteps extends SetupClass{

	@Before
	public void setup() throws IOException {
		//reading properties file
		configProp = new Properties();
		FileInputStream configPropFile = new FileInputStream("config.properties");
		configProp.load(configPropFile);
		String br = configProp.getProperty("browser");
		if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromepath")); 
			driver= new ChromeDriver();
		}
		else {
			System.setProperty("webdriver.edge.driver", configProp.getProperty("msedgepath")); 
			driver= new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get("http://localhost:8180/pc/PolicyCenter.do");
	}

	
	@Given("I login to PolicyCenter as username {string} and password {string}")
	public void i_login_to_policy_center_as_username_and_password(String user, String pass) throws InterruptedException{
		LoginScreen loginScreen = new LoginScreen(driver);
		loginScreen.login(user, pass);
		Thread.sleep(3000);
	}

	@When("I create a personal account with the following details:")
	public void i_create_a_personal_account_with_the_following_details(DataTable accountInformation) throws InterruptedException {
	    NewAccountScreen newAccountScreen = new NewAccountScreen(driver);
	    newAccountScreen.clickNewAccount();
	    newAccountScreen.inputEnterAccountField(accountInformation);
	    newAccountScreen.clickSearch();
	    newAccountScreen.clickCreateNewAccount_Person(accountInformation);
	}

	@Then("a previously created account should be displayed upon searching")
	public void a_previously_created_account_should_be_displayed_upon_searching() throws InterruptedException {
		SearchScreen searchScreen = new SearchScreen(driver);
		Thread.sleep(3000);
		String accountNum = driver.findElement(By.xpath("//body/form[@id='gw-root-form']/div[@id='gw-body']/div[@id='gw-west-center']/div[@id='gw-center-panel']/div[@id='gw-center-bottom-section']/div[@id='AccountFile_Summary-0']/div[@id='AccountFile_Summary-AccountSummaryDashboard']/div[@id='AccountFile_Summary-AccountSummaryDashboard-0']/div[@id='AccountFile_Summary-AccountSummaryDashboard-AccountDetailsDetailViewTile']/div[@id='AccountFile_Summary-AccountSummaryDashboard-AccountDetailsDetailViewTile-AccountDetailsDetailViewTile_DV']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]")).getText();
		System.out.println(accountNum);
		searchScreen.clickSearchByAccount();
		searchScreen.searchByAccount(accountNum);
		Thread.sleep(3000);
	}
	
}
