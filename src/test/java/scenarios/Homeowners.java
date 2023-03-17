package scenarios;

import java.io.IOException;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.datatable.DataTable;
import pageObjects.Action;
import pageObjects.Submission.HomeSubmission.CoveragesScreen;
import pageObjects.Submission.HomeSubmission.DwellingConstruction;
import pageObjects.Submission.HomeSubmission.DwellingScreen;
import pageObjects.Submission.HomeSubmission.QualificationScreen;


public class Homeowners{

	public WebDriver driver;
	public Homeowners(WebDriver rdriver) {
		PageFactory.initElements(driver, this);
		driver = rdriver;
	}
	Action action = new Action(driver);
	By btnNext = By.id("SubmissionWizard-Next");
	By btnQuote = By.id("SubmissionWizard-SubmissionWizard_PolicyReviewScreen-JobWizardToolbarButtonSet-QuoteTypeToolbarButtonSet-Quote");
	By btnBindOptions = By.id("SubmissionWizard-SubmissionWizard_PaymentScreen-JobWizardBillingToolbarButtonSet-BindOptions");
	By btnBindAndIssue = By.id("SubmissionWizard-SubmissionWizard_PaymentScreen-JobWizardBillingToolbarButtonSet-BindOptions-BindAndIssue");
	
	public void createHomeownersPolicy(DataTable policyDetails) throws InterruptedException, IOException, ParseException {
		Map<String, String> details = policyDetails.asMap(String.class, String.class);
		QualificationScreen qualificationScreen = new QualificationScreen(driver);
		DwellingScreen dwellingScreen = new DwellingScreen(driver);
		DwellingConstruction dwellingConstruction= new DwellingConstruction(driver);
		CoveragesScreen coveragesScreen = new CoveragesScreen(driver);
		Thread.sleep(3000);
		qualificationScreen.selectPolicyType(details.get("policyType"));
		qualificationScreen.selectCoverageForm(details.get("coverageForm"));
		qualificationScreen.selectOccupant(details.get("occupant"));
		System.out.println(details.get("occupyFullTime"));
		qualificationScreen.occupyFullTime(details.get("occupyFullTime"));
		this.clickNext(2);
		Thread.sleep(500);
		dwellingScreen.selectFireProtection(details.get("fireProtection"));
		this.clickNext(1);
		dwellingConstruction.inputYearBuilt(details.get("inputYearBuilt"));
		dwellingConstruction.selectConstruction(details.get("construction"));
		dwellingConstruction.inputNumOfStories(details.get("numOfStories"));
		dwellingConstruction.selectGarage(details.get("garage"));
		dwellingConstruction.selectFoundation(details.get("foundation"));
		dwellingConstruction.selectRoof(details.get("roof"));
		dwellingConstruction.selectPrimaryHeating(details.get("primaryHeating"));
		dwellingConstruction.selectSecondaryHeating(details.get("secondaryHeating"));
		dwellingConstruction.selectPlumbing(details.get("plumbing"));
		dwellingConstruction.selectWiring(details.get("wiring"));
		dwellingConstruction.selectElectricalSystem(details.get("electricalSystem"));
		this.clickNext(1);
		coveragesScreen.selectCoinsurance(details.get("coinsurance"));
		coveragesScreen.lossRental(details.get("lossRental"));
		coveragesScreen.selectProhibitedUse(details.get("prohibitedUse"));
		this.clickNext(3);
		this.clickQuote();
		this.clickNext(2);
		this.clickBindAndIssue();	
	}
	
	public void clickNext(int iteration) throws InterruptedException {
		for(int i=0; i<iteration; i++) {
			Thread.sleep(500);
			driver.findElement(btnNext).click();
			Thread.sleep(2000);
		}
	}
	
	public void clickQuote() throws InterruptedException {
		driver.findElement(btnQuote).click();
		Thread.sleep(2000);
	}
	
	public void clickBindAndIssue() throws InterruptedException {
		driver.findElement(btnBindOptions).click();
		driver.findElement(btnBindAndIssue).click();
		driver.switchTo().alert().accept();
	}
}

