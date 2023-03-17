package pageObjects.Submission.HomeSubmission;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CoveragesScreen {

	public WebDriver driver;
	public CoveragesScreen(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(driver, this);
	}
	
	By coinsurance = By.name("SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-HOPCoveragesScreen-HOPMainCoveragesPanelSet-dwellingCoveragePatternIterator-0-CoverageInputSet-CovPatternInputGroup-HOPCovACoinsurance");
	By lossRentalIncomeYes = By.id("SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-HOPCoveragesScreen-HOPMainCoveragesPanelSet-dwellingCoveragePatternIterator-3-CoverageInputSet-CovPatternInputGroup-HOPCovDLossOfRent_0");
	By lossRentalIncomeNo = By.id("SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-HOPCoveragesScreen-HOPMainCoveragesPanelSet-dwellingCoveragePatternIterator-3-CoverageInputSet-CovPatternInputGroup-HOPCovDLossOfRent_1");
	By prohibitedUse = By.name("SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-HOPCoveragesScreen-HOPMainCoveragesPanelSet-dwellingCoveragePatternIterator-3-CoverageInputSet-CovPatternInputGroup-HOPCovDProhibitedUse");


	public void selectCoinsurance(String option) throws InterruptedException {
		Thread.sleep(3000);
		Select drpCoinsurance = new Select(driver.findElement(coinsurance));
		drpCoinsurance.selectByValue(option);
		System.out.println(option);
	}
	
	public void lossRental(String option) throws InterruptedException {
		System.out.println(option);
		if(option.equals("Yes")) {
			driver.findElement(lossRentalIncomeYes).click();
		}else {
			driver.findElement(lossRentalIncomeNo).click();
		}
	}
	
	public void selectProhibitedUse(String option) throws InterruptedException {
		System.out.println(option);
		Select drpProhibitedUse = new Select(driver.findElement(prohibitedUse));
		drpProhibitedUse.selectByVisibleText(option);
		Thread.sleep(1000);
	}
}
