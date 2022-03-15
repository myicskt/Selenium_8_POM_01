package Test;
//https://github.com/myicskt/Selenium_8_POM_01.git
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Page.DashboardPage;
import Page.LoginPage;
import Util.BrowserFactor;

public class LoginTest {
	WebDriver driver;

	// by create an object
	// by the name of class
	@Test
	public void ValidUserShouldBeAbleToLoginTest() {
		driver=BrowserFactor.init();
//create object with Selenium PageFactory it send driver along to the page
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName("demo@techfios.com");
		loginPage.insertPassword("abc123");
		loginPage.clickOnSignInButton();
		
		DashboardPage dashboard = PageFactory.initElements(driver, DashboardPage.class);
		dashboard.verifyDashboardPage();
		
		
		BrowserFactor.tearDown();

	}
}
