package Appium_Project_FST;

import static org.testng.Assert.assertEquals;

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

public class Activity1 {
	AppiumDriver<MobileElement> driver = null;
	@BeforeTest
	public void calc() throws InterruptedException, IOException {
		// Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("deviceName", "TestEmulator");
		caps.setCapability("platformName", "Android");
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("appPackage", "com.google.android.apps.tasks");
		caps.setCapability("appActivity", "com.google.android.apps.tasks.ui.TaskListsActivity");
		caps.setCapability("noReset", true);

		URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
		//Open the Google Tasks app.
		driver = new AndroidDriver<MobileElement>(appServer, caps);
		System.out.println("task is open");
		Thread.sleep(5000);

	}
	@Test
	public void addTasks() throws InterruptedException {
		
			driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Create new task']").click();
			Thread.sleep(2000);
			driver.findElementByXPath("//android.widget.EditText[@text='New task']").sendKeys("Complete Activity with Google Tasks");
			Thread.sleep(2000);
			driver.findElementByXPath("//android.widget.Button[@text='Save']").click();
			Thread.sleep(2000);
			
			driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Create new task']").click();
			Thread.sleep(2000);
			driver.findElementByXPath("//android.widget.EditText[@text='New task']").sendKeys("Complete Activity with Google Keep");
			Thread.sleep(2000);
			driver.findElementByXPath("//android.widget.Button[@text='Save']").click();
			Thread.sleep(2000);
			
			driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Create new task']").click();
			Thread.sleep(2000);
			driver.findElementByXPath("//android.widget.EditText[@text='New task']").sendKeys("Complete the second Activity Google Keep");
			Thread.sleep(2000);
			driver.findElementByXPath("//android.widget.Button[@text='Save']").click();
			Thread.sleep(2000);

		
		String task1 = driver.findElementByXPath("//android.widget.FrameLayout[@content-desc='Complete Activity with Google Tasks']/android.view.ViewGroup/android.widget.TextView").getText();
		Assert.assertEquals(task1, "Complete Activity with Google Tasks");
		String task2 = driver.findElementByXPath("//android.widget.FrameLayout[@content-desc='Complete Activity with Google Keep']/android.view.ViewGroup/android.widget.TextView").getText();
		Assert.assertEquals(task2, "Complete Activity with Google Keep");
		String task3 = driver.findElementByXPath("//android.widget.FrameLayout[@content-desc='Complete the second Activity Google Keep']/android.view.ViewGroup/android.widget.TextView").getText();
		Assert.assertEquals(task3, "Complete the second Activity Google Keep");

	}
	 @AfterClass
	    public void afterClass() {
	        driver.quit();
	    }

}
