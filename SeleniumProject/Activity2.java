package SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity2 {
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		//Open a browser
		driver = new FirefoxDriver();
		//Navigate to ‘http://alchemy.hguy.co/crm’.
		driver.get("https://alchemy.hguy.co/crm/");
	}
	@Test
	public void getURL() {

		//		Get the url of the header image.
		WebElement imgUrl = driver.findElement(By.xpath("//img[@alt='SuiteCRM']"));

		//		Print the url to the console.
		System.out.println("Src attribute is: "+ imgUrl.getAttribute("src"));
	}
	@AfterMethod
	public void afterMethod() {
		//Close the browser
		driver.close();
	}
}
