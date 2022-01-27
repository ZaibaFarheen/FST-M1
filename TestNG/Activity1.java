package TestNGActivities;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Activity1 {
	WebDriver driver;

	@Test
	public void f() {
		driver.get("https://www.training-support.net/selenium");
		System.out.println(driver.getTitle());
		Assert.assertEquals("Training Support - Selenium", driver.getTitle());
		// Find the clickable link on the page and click it
		driver.findElement(By.id("about-link")).click();

		// Print title of new page
		System.out.println("New page title is: " + driver.getTitle());

		Assert.assertEquals(driver.getTitle(), "About Training Support");
	}

	@BeforeMethod
	public void beforeMethod() {
//	  driver=new ChromeDriver();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();

	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

}
