package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnkeybordEvent {
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
		
		//using action instated of click 
		//USER_LOGIN.click();
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();// Runtime compilation
		//for MacBook book user 
		//action.sendKeys(Keys.RETURN).build().perform();
		
		
}
}
