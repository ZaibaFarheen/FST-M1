package TestNGActivities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;

public class Activity2 {
	WebDriver driver;

	@Test
	public void TC1() {
		Assert.assertEquals(driver.getTitle(), "Target Practice ");
	}

	@Test
	public void TC2() {
		WebElement blackbtn = driver.findElement(By.xpath("//button[@class='ui black button']"));

		Assert.assertTrue(blackbtn.isDisplayed(),"Black button is found");
	}

	@Test(enabled = false)
	public void TC3()  {
		System.out.println("Test Skipped");
	}

	@Test
	public void TC4() throws SkipException {
		
		throw new SkipException("Method Skipped");
				
	}

	@BeforeClass
	public void beforeClass() {
		driver=new FirefoxDriver();
//		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(" https://www.training-support.net/selenium/target-practice");
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
