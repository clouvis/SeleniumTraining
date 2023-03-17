package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pageObjects.LoginScreen;
import pageObjects.SearchScreen;
import pageObjects.Account.NewAccountScreen;
import pageObjects.Submission.NewSubmission;
import scenarios.Homeowners;

public class SubmissionSteps extends SetupClass{

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
	
	@Given("I login to PC as username {string} and password {string}")
	public void i_login_to_pc_as_username_and_password(String user, String pass) throws InterruptedException{
		LoginScreen loginScreen = new LoginScreen(driver);
		loginScreen.login(user, pass);
		Thread.sleep(3000);
	}

	@Given("I create an account with the following details:")
	public void i_create_an_account_with_the_following_details(DataTable accountInformation) throws InterruptedException {
	    NewAccountScreen newAccountScreen = new NewAccountScreen(driver);
	    newAccountScreen.clickNewAccount();
	    newAccountScreen.inputEnterAccountField(accountInformation);
	    newAccountScreen.clickSearch();
	    newAccountScreen.clickCreateNewAccount_Person(accountInformation);
	    
	}
	
	@When("I create a {string} submission with the following details:")
	public void i_create_a_submission_with_the_following_details(String lob, DataTable policyInformation) throws InterruptedException, IOException, ParseException{
		NewSubmission newSubmission = new NewSubmission(driver);
		newSubmission.clickNewSubmission();
		newSubmission.selectLOB(lob);
		Thread.sleep(3000);
		Homeowners homeowners = new Homeowners(driver);
		homeowners.createHomeownersPolicy(policyInformation);
	}

	@When("I search for the previously created policy")
	public void i_search_for_the_previously_created_policy() throws InterruptedException {
		SearchScreen searchScreen = new SearchScreen(driver); 
		Thread.sleep(1000);
		String policyNum = driver.findElement(By.xpath("//div[@id='JobComplete-JobWizardInfoBar-PolicyNumber']//child::div[@class='gw-label gw-infoValue']")).getText();
		searchScreen.searchByPolicyNumber(policyNum);
	}

	@Then("the status of the policy should be {string}")
	public void the_status_of_the_policy_should_be(String expectedStatus) throws InterruptedException {
		SearchScreen searchScreen = new SearchScreen(driver);
		searchScreen.verifyPolicyStatus(expectedStatus);
		driver.close();
	}

}
