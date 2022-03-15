package windowHandle;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnwindowHandle {
	WebDriver driver;

	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.yahoo.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testWindowHandle() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"ybar-sbq\"]")).sendKeys("Selenium");
		driver.findElement(By.xpath("//*[@id=\"ybar-search\"]")).click();

		// it is the dynamic web element so be sure it works every time
		driver.findElement(By.xpath("//*[@id=\"web\"]/ol/li[4]/div/div[1]/h3/a")).click();

		// set of string title window
		Set<String> handles = driver.getWindowHandles();
		System.out.println(handles);
		for (String i : handles) {
			driver.switchTo().window(i);
			System.out.println(i);
		}
		// after driver switch to new driver
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//*[@id=\"main_navbar\"]/ul/li[3]/a/span")).click();
	}

}
