package SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CRM_Activity6 {
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		//Open a browser
		driver = new FirefoxDriver();
		//Navigate to ‘http://alchemy.hguy.co/crm’.
		driver.get("https://alchemy.hguy.co/crm/");
		//Find and select the username and password fields
		WebElement userName = driver.findElement(By.id("user_name"));
		WebElement password = driver.findElement(By.id("username_password"));

		//Enter login credentials into the respective fields
		userName.sendKeys("admin");
		password.sendKeys("pa$$w0rd");

		//Click login
		driver.findElement(By.id("bigbutton")).click();
	}
	@Test
	public void elementExists() {
		//		Ensure that the “Activities” menu item exists.
		boolean activities =  driver.findElement(By.id("grouptab_3")).isDisplayed();
		Assert.assertEquals(activities,true);
		System.out.println(activities);
	}
	@AfterMethod
	public void afterMethod() {
		//Close the browser
		driver.close();
	}

}
