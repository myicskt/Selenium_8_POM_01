package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DashboardPage {
	WebDriver driver;
	//it is going to hold driver for page 
		public DashboardPage(WebDriver driver) {
			this.driver = driver;
		}
		

		@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[2]/div/h2")
		WebElement DASHBOARD_HEADER_ELEMENT;
	public void verifyDashboardPage() {
		Assert.assertEquals(0, 0, null);;
		Assert.assertEquals(DASHBOARD_HEADER_ELEMENT.getText(), "Dashboard", "Wrong Page");
	}
	
	

}
