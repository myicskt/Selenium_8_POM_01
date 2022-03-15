package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LearnByClass {
	WebDriver driver;

	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void loginTest() {
		// storing webElement using by class
		By USER_NAME = By.xpath("//*[@id=\"username\"]");
		By USER_PASSWORD = By.xpath("//*[@id=\"password\"]");
		By USER_LOGIN = By.xpath("/html/body/div/div/div/form/div[3]/button");
		By DASHBORD_HEARDER_ELEMENT = By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2");
		By CUSTOMER_MENU_ELEMENT = By.xpath("//*[@id=\"side-menu\"]/li[3]/a/span[1]");
		By ADD_CUSTOMER_MENU_ELEMENT = By.xpath("//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a");
		By ADD_CONTACT_HEADDER_ELEMENT =By.xpath("//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div/div[1]/h5");

		// operation
		driver.findElement(USER_NAME).sendKeys("demo@techfios.com");
		driver.findElement(USER_PASSWORD).sendKeys("abc123");
		driver.findElement(USER_LOGIN).click();
		
		Assert.assertEquals("you are on wrong page", "Dashboard",driver.findElement(DASHBORD_HEARDER_ELEMENT).getText());
		driver.findElement(CUSTOMER_MENU_ELEMENT).click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ADD_CUSTOMER_MENU_ELEMENT));

		driver.findElement(ADD_CUSTOMER_MENU_ELEMENT).click();
		Assert.assertEquals("you are on wrong page", "Add Contact",driver.findElement(ADD_CONTACT_HEADDER_ELEMENT).getText());

	
		By FULLNAME_ADDCONTACT_FIELD = By.xpath("//*[@id=\"account\"]");
		By COMPANY_ADDCONTACT_FIELD = By.xpath("//select[@id='cid']");
		
		
		driver.findElement(FULLNAME_ADDCONTACT_FIELD).sendKeys("Gobinda Chapai");
		Select sel = new Select(driver.findElement(COMPANY_ADDCONTACT_FIELD));
		sel.selectByVisibleText("Techfios");
		sel.getOptions();
	}
	
	
	
	
	
	
	
	
	// @After

	public void tearDown() {
		driver.close();
	}

}
