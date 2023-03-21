package tests;

import java.net.*;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {

	private AppiumDriver driver;

	@BeforeTest
	public void setup() {

		try {

			DesiredCapabilities caps = new DesiredCapabilities();

			caps.setCapability(CapabilityType.PLATFORM_NAME, "Android");
			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4 API 30");
			caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
			caps.setCapability("appPackage", "us.zoom.videomeetings");
			caps.setCapability("appActivity", "com.zipow.videobox.LauncherActivity");
			caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

			URL url = new URL("http://0.0.0.0:4723/wd/hub");

			driver = new AppiumDriver(url, caps);

		} catch (Exception exp) {
			System.out.println("Reason for the exception is : " + exp.getCause());
			System.out.println("Message is : " + exp.getMessage());
			exp.printStackTrace();
		}

	}

	@Test
	public void sampleTest() {
		System.out.println("I have initialised the app successfuly");
	}

	@AfterTest
	public void teardown() {

	}

}
