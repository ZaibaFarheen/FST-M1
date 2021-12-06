/*This is a simple activity that shows the boilerplate of every selenium script.
Create a Class with a main() method
Create a WebDriver instance, named driver, with the FirefoxDriver().
Open a browser with https://www.training-support.net
Close the browser with driver.close()*/
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {
	public static void main(String[] args) {
		//Create a new instance of the Firefox driver
		WebDriver driver = new FirefoxDriver();

		//Open the browser
		driver.get("https://www.training-support.net");

		//Perform testing and assertions
		// ...
		System.out.println("done");

		//Close the browser
		driver.close();
	}
}

