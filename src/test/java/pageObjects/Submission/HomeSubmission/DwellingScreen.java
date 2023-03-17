package pageObjects.Submission.HomeSubmission;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DwellingScreen {
	
	public WebDriver driver;
	public DwellingScreen(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(driver, this);
	}
	
	By fireProtectionClass = By.name("SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-HOPDwellingScreen-HOPDwellingPanelSet-HOPDwellingCV-HOPDwellingDetailsDV-HOPDwellingProtectionInputSet-ProtectionClass");

	
	public void selectFireProtection(String option) throws InterruptedException {
		Select drpFireProtection = new Select(driver.findElement(fireProtectionClass));
		drpFireProtection.selectByVisibleText(option);
		Thread.sleep(2000);
	}
}
