package tests;

import java.net.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {

	
	AndroidDriver driver;

	@BeforeTest
	public void setup() throws Exception {

		try {

			DesiredCapabilities caps = new DesiredCapabilities();
			
			// Update the below desired capabilities to the emulator you want to run the test on 

			caps.setCapability(CapabilityType.PLATFORM_NAME, "Android");
			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4 API 29");
			caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
			// Add the Zoom apk to your resources/app folder in this project or update the path to where the apk is located 
			caps.setCapability("app", "<Add apk path here>");
			caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

			// Update the URL below to match your Appium configuration 
			
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
