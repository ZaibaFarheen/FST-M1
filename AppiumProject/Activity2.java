package Appium_Project_FST;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity2 {
	AppiumDriver<MobileElement> driver = null;
	@BeforeTest
	public void calc() throws InterruptedException, IOException {
		// Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("deviceName", "TestEmulator");
		caps.setCapability("platformName", "Android");
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("appPackage", "com.google.android.keep");
		caps.setCapability("appActivity", "com.google.android.keep.activities.BrowseActivity");
		caps.setCapability("noReset", true);

		URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
		//Open the Google Tasks app.
		driver = new AndroidDriver<MobileElement>(appServer, caps);
		System.out.println("keep is open");
		Thread.sleep(5000);

	}
	@Test
	public void addNotes() throws InterruptedException {
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc='New text note']").click();
		Thread.sleep(1000);
		driver.findElementById("com.google.android.keep:id/editable_title").click();
		driver.findElementById("com.google.android.keep:id/editable_title").sendKeys("Minutes of Meeting");
		Thread.sleep(1000);
		driver.findElementById("com.google.android.keep:id/edit_note_text").click();
		driver.findElementById("com.google.android.keep:id/edit_note_text").sendKeys("Execution Report needs to be sent");
		Thread.sleep(1000);
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Open navigation drawer']").click();
		Thread.sleep(5000);
		String notes = driver.findElementByXPath("//androidx.cardview.widget.CardView[@content-desc='Minutes of Meeting. Execution Report needs to be sent. ']/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView[1]").getText();
		System.out.println(notes);
		Assert.assertEquals(notes, "Minutes of Meeting");
	}
	
	@AfterClass
    public void afterClass() {
        driver.quit();
    }
}
