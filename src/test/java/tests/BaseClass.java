package tests;

import java.net.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {

	
	AndroidDriver driver;

	@BeforeTest
	public void setup() throws Exception {

		try {

			DesiredCapabilities caps = new DesiredCapabilities();

			caps.setCapability(CapabilityType.PLATFORM_NAME, "Android");
			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4 API 29");
			caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
			caps.setCapability("appPackage", "us.zoom.videomeetings");
			caps.setCapability("appActivity", "com.zipow.videobox.LauncherActivity");
			caps.setCapability("app", "/Users/anirudhb/eclipse-workspace/AppiumZoomTest/src/test/resources/apps/Zoom.apk");
			caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

			URL url = new URL("http://0.0.0.0:4723/wd/hub");
			
			driver = new AndroidDriver(url,caps);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		} catch (Exception exp) {
			System.out.println("Reason for the exception is : " + exp.getCause());
			System.out.println("Message is : " + exp.getMessage());
			exp.printStackTrace();
		}

	}
	

	@AfterTest
	public void teardown() throws Exception {

		driver.quit();
	}

}
