package SeleniumProject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CRM_Activity7 {
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
	public void endRowInfo() throws InterruptedException {
		driver.findElement(By.xpath("//a[text()='Sales']")).click();
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		Thread.sleep(5000);
		
		/*In the table, find the Additional information icon at the end of the row of the lead
		information. Click it.*/
		driver.findElement(By.xpath("(//span[@title='Additional Details'])[last()]")).click();
		Thread.sleep(4000);

		//		Read the popup and print the phone number displayed in it.
		String mobileNo = driver.findElement(By.xpath("(//span[@class='phone'])[1]")).getText();
		System.out.println(mobileNo);

	}
	@AfterMethod
	public void afterMethod() {
		//Close the browser
		driver.close();
	}

}
