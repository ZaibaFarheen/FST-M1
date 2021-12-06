package SeleniumProject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1 {
	WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod() {
		//Open a browser
		driver = new FirefoxDriver();
		//Navigate to ‘http://alchemy.hguy.co/crm’.
		driver.get("https://alchemy.hguy.co/crm/");
	}
	@Test
	public void getTitle() {


		//		Get the title of the website.
		String title = driver.getTitle();

		//		Make sure it matches “SuiteCRM” exactly.
		//		 If it matches, close the browser.
		if(title.equals("SuiteCRM")) {
			driver.close();
		}
	}

}