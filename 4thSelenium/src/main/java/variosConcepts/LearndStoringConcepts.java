package variosConcepts;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LearndStoringConcepts {
	WebDriver driver;


	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void storingElementUsingWebElement() {
		// Storing element using WebElement
		// WebElement NEME_ELEMENT = driver.findElement(By.xpath(" "));
		WebElement USERNAME_ELEMENT = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement USERPASSWORD_ELEMENT = driver.findElement(By.xpath("//input[@id='password']"));
		WebElement LOGIN_ELEMENT = driver.findElement(By.xpath("//button[@name='login']"));
		
		USERNAME_ELEMENT.clear();
		USERPASSWORD_ELEMENT.clear();
		USERNAME_ELEMENT.sendKeys("demo@techfios.com");
		USERPASSWORD_ELEMENT.sendKeys("abc123");
		LOGIN_ELEMENT.click();
		By DASHBOARD_HEADER_FIELD = By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2");
		boolean pageTitleDisplayStatus;
		
		try {
			WebElement DASHBOARD_HEADER_ELEMENT = driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2"));
			pageTitleDisplayStatus = true;
		}catch(Exception e) {
			pageTitleDisplayStatus = false;
			e.printStackTrace();
		}
		
		/*WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(DASHBOARD_HEADER_FIELD));*/
		
		Assert.assertTrue("Wrong Page!!!", pageTitleDisplayStatus);
//		Assert.assertTrue("Wrong Page!!!", driver.findElement(DASHBOARD_HEADER_FIELD).isDisplayed());

	}

	// @Test
	public void storingWebelementBy() {
		// By Name_Locator = by.xpath(" ");
		By USERNAME_FIELD = By.xpath("//input[@id='username']");
		By USERPASSWORD_FIELD = By.xpath("//input[@id='password']");
		By LOGIN_FIELD = By.xpath("//button[@name='login']");

		driver.findElement(USERNAME_FIELD).sendKeys("demo@techfios.com");
		driver.findElement(USERPASSWORD_FIELD).sendKeys("abc123");
		driver.findElement(LOGIN_FIELD).click();
	}

	@After
	public void tearDown() {
		driver.close();
	}
}
