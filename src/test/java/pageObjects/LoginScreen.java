package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginScreen {

	public WebDriver driver;
	public LoginScreen (WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(driver, this);
	}
	
	By txtUsername = By.name("Login-LoginScreen-LoginDV-username");
	By txtPassword = By.name("Login-LoginScreen-LoginDV-password");
	By btnLogin = By.id("Login-LoginScreen-LoginDV-submit");
	
	public void login(String username, String password) {
		System.out.println("Hello");
		driver.findElement(txtUsername).sendKeys(username);
		driver.findElement(txtPassword).sendKeys(password);
		driver.findElement(btnLogin).click();
	}
}
