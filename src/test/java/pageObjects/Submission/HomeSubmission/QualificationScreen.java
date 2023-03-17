package pageObjects.Submission.HomeSubmission;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


import pageObjects.Action;

public class QualificationScreen {

	public WebDriver driver;
	public QualificationScreen(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(driver, this);
	}
	Action action = new Action(driver);
	
	By policyType = By.name("SubmissionWizard-SubmissionWizard_PreQualificationScreen-CoveragePartSelectionDV-HOPCoveragePartType");
	By coverageForm = By.name("SubmissionWizard-SubmissionWizard_PreQualificationScreen-CoveragePartSelectionDV-HOPCoverageForm");
	By occupiesDwelling = By.name("SubmissionWizard-SubmissionWizard_PreQualificationScreen-PreQualQuestionSetsDV-QuestionSetsDV-0-QuestionSetLV-2-QuestionModalInput-ChoiceSelectInput");
	By occupyFullTimeYes = By.id("SubmissionWizard-SubmissionWizard_PreQualificationScreen-PreQualQuestionSetsDV-QuestionSetsDV-0-QuestionSetLV-3-QuestionModalInput-BooleanRadioInput_0");
	By occupyFullTimeNo = By.id("SubmissionWizard-SubmissionWizard_PreQualificationScreen-PreQualQuestionSetsDV-QuestionSetsDV-0-QuestionSetLV-3-QuestionModalInput-BooleanRadioInput_1");
	
	public void selectPolicyType(String type) throws InterruptedException {
		Select drpPolicyType = new Select(driver.findElement(policyType));
		drpPolicyType.selectByVisibleText(type);
		Thread.sleep(2000);
	}
	
	public void selectCoverageForm(String covForm) throws InterruptedException {
		Select drpCoverageForm = new Select(driver.findElement(coverageForm));
		drpCoverageForm.selectByVisibleText(covForm);
		Thread.sleep(2000);
	}
	
	public void selectOccupant(String occupant) throws InterruptedException {
		Select drpOccupiesDwelling = new Select(driver.findElement(occupiesDwelling));
		drpOccupiesDwelling.selectByVisibleText(occupant);
		Thread.sleep(2000);
	}
	
	public void occupyFullTime(String option) throws InterruptedException {
		Thread.sleep(1000);
		System.out.println(option);
		if(option.equals("Yes")) {
			driver.findElement(occupyFullTimeYes).click();
		}else {
			driver.findElement(occupyFullTimeNo).click();
		}
	}
}
