package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class Action {

	public WebDriver driver;
	public Action (WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(driver, this);
	}
	public void pageDown(WebDriver driver1) {
		driver = driver1;
		new Actions(driver).sendKeys(Keys.ARROW_DOWN).perform();
	}
	
	public void pageUp(WebDriver driver1) {
		driver = driver1;
		new Actions(driver).sendKeys(Keys.ARROW_UP).perform();
	}

	public void clickTab(WebDriver driver1) {
		driver = driver1;
		new Actions(driver).sendKeys(Keys.TAB).perform();
	}
	
	public void clickEnter(WebDriver driver1) {
		driver = driver1;
		new Actions(driver).sendKeys(Keys.ENTER).perform();
	}
}
