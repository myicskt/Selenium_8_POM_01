package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LearnDropdown {
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
		//storing webElement
		WebElement USER_NAME = driver.findElement(By.xpath("//*[@id=\"username\"]"));
		WebElement USER_PASSWORD = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		WebElement USER_LOGIN = driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/button"));
		//operation
		USER_NAME.sendKeys("demo@techfios.com");
		USER_PASSWORD.sendKeys("abc123");
		USER_LOGIN.click();
		WebElement DASHBORD_HEARDER_ELEMENT = driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2"));
		Assert.assertEquals("you are on wrong page", "Dashboard", DASHBORD_HEARDER_ELEMENT.getText());
		
		WebElement CUSTOMER_MENU_ELEMENT = driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[3]/a/span[1]"));
		WebElement ADD_CUSTOMER_MENU_ELEMENT = driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a"));
		
		CUSTOMER_MENU_ELEMENT.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.visibilityOf(ADD_CUSTOMER_MENU_ELEMENT));
		ADD_CUSTOMER_MENU_ELEMENT.click();
		WebElement ADD_CONTACT_HEADDER_ELEMENT = driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div/div[1]/h5"));
		Assert.assertEquals("you are on wrong page", "Add Contact", ADD_CONTACT_HEADDER_ELEMENT.getText());
		
	}
	//@After
	
	public void tearDown() {
		driver.close();
	}

}
