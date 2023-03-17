package pageObjects.Submission;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class NewSubmission {

	public WebDriver driver;
	public NewSubmission(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(driver, this);
	}
	
	By btnActionMenuActions = By.xpath("//div[@id='AccountFile-AccountFileMenuActions']");
	By btnNewSubmission = By.xpath("//div[@id='AccountFile-AccountFileMenuActions-AccountFileMenuActions_Create-AccountFileMenuActions_NewSubmission']");
	
	public void clickNewSubmission() throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(btnActionMenuActions).click();
		driver.findElement(btnNewSubmission).click();
	}
	
	public void selectLOB(String lob) throws InterruptedException {
		Thread.sleep(3000);
		switch(lob) {
			case "Homeowners":
				Thread.sleep(500);
				WebElement selectHome = driver.findElement(By.xpath("//div[@id='NewSubmission-NewSubmissionScreen-ProductOffersDV-ProductSelectionLV-3-addSubmission']"));
				selectHome.click();
		}
	}
}
