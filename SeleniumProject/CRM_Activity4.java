package SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CRM_Activity4 {
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		//Open a browser
		driver = new FirefoxDriver();
		//Navigate to ‘http://alchemy.hguy.co/crm’.
		driver.get("https://alchemy.hguy.co/crm/");
	}
	@Test
	public void homePage() {

		//		Find and select the username and password fields
		WebElement userName = driver.findElement(By.id("user_name"));
		WebElement password = driver.findElement(By.id("username_password"));

		//		Enter login credentials into the respective fields
		userName.sendKeys("admin");
		password.sendKeys("pa$$w0rd");

		//		Click login
		driver.findElement(By.id("bigbutton")).click();

		//      Verify that the homepage has opened.
		boolean homePage = driver.findElement(By.xpath("(//h2[@class='recent_h3'])[1]")).isDisplayed();
		Assert.assertEquals(homePage,true);
	}

	@AfterMethod
	public void afterMethod() {
		//Close the browser
		driver.close();
	}
}
