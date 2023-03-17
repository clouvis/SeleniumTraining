package pageObjects.Submission;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class JobCompleteScreen {

	public WebDriver driver;
	public JobCompleteScreen(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(driver, this);
	}
	
	public void getPolicyNumber() throws InterruptedException {
		Thread.sleep(500);
//		String accountNum = driver.findElement(By.xpath("//div[@id='JobComplete-JobWizardInfoBar-PolicyNumber']//child::div[@class='gw-label gw-infoValue']")).getText();
		
	}
}
