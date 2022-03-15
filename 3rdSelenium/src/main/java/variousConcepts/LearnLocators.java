package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnLocators {
	WebDriver driver;

	@Before
	public void lunchBrowser() {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://objectspy.space/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

//using link text and partial link text
	// @Test
	public void testLocators() {
		driver.findElement(By.linkText("OS-API Product FrontEnd")).click();
		driver.navigate().back();
		driver.findElement(By.linkText("TF-API Product Backend")).click();
		driver.findElement(By.partialLinkText("Product")).click();
	}

//using css selector
	@Test
	public void cssthSelector2() {
		//1. 	TagName#Value		Note:(#) represents(Id) 
		//2.	TageName.Value		Note:(.)represents(Class)
		//3.	Tag Name[attribute= ‘value]
		//4.	TageName.class[attribute = ‘value’]

		driver.findElement(By.cssSelector("input#sex-1")).click(); //TagName#Value		Note:(#) represents(Id)
		driver.findElement(By.cssSelector("input[id='exp-1']")).click(); // Tag Name[attribute= ‘value]
		

	}

	//@Test
	// relative xpath
	public void xpathSelector() {

		driver.findElement(By.xpath("//strong[text()='Link Test : Page Change']")).click();
		driver.navigate().back();
		driver.findElement(By.xpath("//input[@type='text' and @name='firstname' ]")).sendKeys("Gobinda");
		driver.findElement(By.xpath("//input[@type='text' and @name='lastname' ]")).sendKeys("chapai");
		driver.findElement(By.xpath("//input[@name='Password' ]")).sendKeys("gc123");
		driver.findElement(By.xpath("//input[@type='radio' and @name='sex']")).click();
		driver.findElement(By.xpath("//input[@type='radio' and @name='exp' and @value='3']")).click();
		driver.findElement(By.xpath("//input[@type='date' and@ id='datepicker']")).sendKeys("01/02/2021");
		driver.findElement(By.xpath("//input[@type='date' and@ id='datepicker']")).sendKeys("01/02/2021");
	}

	//@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(1000);
		driver.close();

	}

}
