package SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CRM_Activity3 {
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		//Open a browser
		driver = new FirefoxDriver();
		//Navigate to ‘http://alchemy.hguy.co/crm’.
		driver.get("https://alchemy.hguy.co/crm/");
	}
	@Test
	public void getText() {

		//		Get the first copyright text in the footer.
		String a = driver.findElement(By.id("admin_options")).getText();

		//		Print the text to the console.
		System.out.println(a);

	}
	@AfterMethod
	public void afterMethod() {
		//Close the browser
		driver.close();
	}
}
