package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Page.LoginPage;
import Util.BrowserFactor;

public class LoginTest {
	WebDriver driver;

	// by create an object
	// by the name of class
	@Test
	public void ValidUserShouldBeAbleToLoginTest() {
		driver=BrowserFactor.init();

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName("demo@techfios.com");
		loginPage.insertPassword("abc123");
		loginPage.clickOnSignInButton();

	}
}
