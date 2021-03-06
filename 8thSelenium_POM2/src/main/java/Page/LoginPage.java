package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	WebDriver driver;
//it is going to hold driver for page 
	public LoginPage(WebDriver driver) {
		this.driver = driver;

	}

//
	@FindBy(how = How.XPATH, using = "//input[@id='username']")
	WebElement USERNAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='password']")
	WebElement USERPASSWORD_ELEMENT;
	@FindBy(how = How.XPATH, using = "//button[@name='login']")
	WebElement LOGIN_ELEMENT;

//singlie method
	public void insertUserName(String userName) {
		USERNAME_ELEMENT.sendKeys(userName);

	}

	public void insertPassword(String password) {
		USERPASSWORD_ELEMENT.sendKeys(password);
	}

	public void clickOnSignInButton() {
		LOGIN_ELEMENT.click();
	}

	// mltipal method
	public void loginTest(String userName, String password) {
		USERNAME_ELEMENT.sendKeys(userName);
		USERPASSWORD_ELEMENT.sendKeys(password);
		LOGIN_ELEMENT.click();

	}
}
