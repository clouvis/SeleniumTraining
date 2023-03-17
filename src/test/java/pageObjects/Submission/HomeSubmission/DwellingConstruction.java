package pageObjects.Submission.HomeSubmission;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DwellingConstruction {

	public WebDriver driver;
	public DwellingConstruction(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(driver, this);
	}
	
	By txtyearBuilt = By.name("SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-HOPDwellingConstructionScreen-HOPDwellingConstructionPanelSet-HOPDwellingConstructionDetailsDV-YearBuilt");
	By txtnumStories = By.name("SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-HOPDwellingConstructionScreen-HOPDwellingConstructionPanelSet-HOPDwellingConstructionDetailsDV-NumberOfStories");
	By constructionType = By.name("SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-HOPDwellingConstructionScreen-HOPDwellingConstructionPanelSet-HOPDwellingConstructionDetailsDV-ConstructionType");
	By garageType = By.name("SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-HOPDwellingConstructionScreen-HOPDwellingConstructionPanelSet-HOPDwellingConstructionDetailsDV-GarageType");
	By foundationType = By.name("SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-HOPDwellingConstructionScreen-HOPDwellingConstructionPanelSet-HOPDwellingConstructionDetailsDV-FoundationType");
	By roofType = By.name("SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-HOPDwellingConstructionScreen-HOPDwellingConstructionPanelSet-HOPDwellingConstructionDetailsDV-RoofType");
	By primaryHeatingType = By.name("SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-HOPDwellingConstructionScreen-HOPDwellingConstructionPanelSet-HOPDwellingConstructionDetailsDV-PrimaryHeatingType");
	By secondaryHeatingType = By.name("SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-HOPDwellingConstructionScreen-HOPDwellingConstructionPanelSet-HOPDwellingConstructionDetailsDV-SecondaryHeatingType");
	By plumbingType = By.name("SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-HOPDwellingConstructionScreen-HOPDwellingConstructionPanelSet-HOPDwellingConstructionDetailsDV-PlumbingType");
	By wiringType = By.name("SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-HOPDwellingConstructionScreen-HOPDwellingConstructionPanelSet-HOPDwellingConstructionDetailsDV-WiringType");
	By breakerType = By.name("SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-HOPDwellingConstructionScreen-HOPDwellingConstructionPanelSet-HOPDwellingConstructionDetailsDV-BreakerType");
	
	public void inputYearBuilt(String inputValue) {
		driver.findElement(txtyearBuilt).sendKeys(inputValue);
	}

	public void inputNumOfStories(String inputValue) {
		driver.findElement(txtnumStories).sendKeys(inputValue);
	}
	
	public void selectConstruction(String option) throws InterruptedException {
		Select drpConstruction = new Select(driver.findElement(constructionType));
		drpConstruction.selectByVisibleText(option);
		Thread.sleep(1000);
	}
	
	public void selectGarage(String option) throws InterruptedException {
		Select drpGarage = new Select(driver.findElement(garageType));
		drpGarage.selectByVisibleText(option);
		Thread.sleep(1000);
	}
	
	public void selectFoundation(String option) throws InterruptedException {
		Select drpFoundation = new Select(driver.findElement(foundationType));
		drpFoundation.selectByVisibleText(option);
		Thread.sleep(1000);
	}
	
	public void selectRoof(String option) throws InterruptedException {
		Select drpRoof= new Select(driver.findElement(roofType));
		drpRoof.selectByVisibleText(option);
		Thread.sleep(1000);
	}
	
	public void selectPrimaryHeating(String option) throws InterruptedException {
		Select drpPrimaryHeating = new Select(driver.findElement(primaryHeatingType));
		drpPrimaryHeating.selectByVisibleText(option);
		Thread.sleep(1000);
	}
	
	public void selectSecondaryHeating(String option) throws InterruptedException {
		Select drpSecondaryHeating = new Select(driver.findElement(secondaryHeatingType));
		drpSecondaryHeating.selectByVisibleText(option);
		Thread.sleep(1000);
	}
	
	public void selectPlumbing(String option) throws InterruptedException {
		Select drpPlumbing = new Select(driver.findElement(plumbingType));
		drpPlumbing.selectByVisibleText(option);
		Thread.sleep(1000);
	}
	
	public void selectWiring(String option) throws InterruptedException {
		Select drpWiring = new Select(driver.findElement(wiringType));
		drpWiring.selectByVisibleText(option);
		Thread.sleep(1000);
	}
	
	public void selectElectricalSystem(String option) throws InterruptedException {
		Select drpElectricalSystem = new Select(driver.findElement(breakerType));
		drpElectricalSystem.selectByVisibleText(option);
		Thread.sleep(1000);
	}
	
	
}
