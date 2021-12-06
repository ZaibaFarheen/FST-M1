package SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CRM_Activity8 {
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
	public void printOddNames() throws InterruptedException {
		//		Navigate to the Sales -> Accounts page.
		driver.findElement(By.xpath("//a[text()='Sales']")).click();
		driver.findElement(By.xpath("//a[text()='Accounts']")).click();
		Thread.sleep(5000);
		
		/*Find the table on the page and print the names of the first 5 odd-numbered rows
		of the table to the console.*/
		for (int i = 1; i <= 10; i++) {
			if (i % 2 != 0) {
				System.out.print(i + " ");
				WebElement oddNames =  driver.findElement(By.xpath(("(//td[@field='name']//a)["+i+"]")));
				String names = oddNames.getText();
				System.out.println(names);

			}
		}
	}
	@AfterMethod
	public void afterMethod() {
		//Close the browser
		driver.close();
	}
}