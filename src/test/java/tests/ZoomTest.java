package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class ZoomTest extends BaseClass {

	WebDriverWait wait;
	

	@Test
	public void JoinMeeting() throws Exception {
		
		
		WebElement joinButton = driver.findElement(By.id("us.zoom.videomeetings:id/btnJoin"));
		WebElement launchWelcomeLayout = driver.findElement(By.id("us.zoom.videomeetings:id/zm_welcome_bottom_layout"));
		WebElement joinMeeting = driver.findElement(By.id("us.zoom.videomeetings:id/btnJoinConf"));
		WebElement meetingCodeField = driver.findElement(By.id("us.zoom.videomeetings:id/edtConfNumber"));
		final String invalidMeetingCode = "941343070";
		WebElement invalidMeetingPopup = driver.findElement(By.id("us.zoom.videomeetings:id/txtMsg"));

		wait.until(ExpectedConditions.visibilityOf(launchWelcomeLayout));

		wait.until(ExpectedConditions.visibilityOf(joinMeeting)).click();

		Assert.assertFalse(joinButton.isEnabled());

		wait.until(ExpectedConditions.visibilityOf(meetingCodeField)).sendKeys(invalidMeetingCode);

		Assert.assertTrue(joinButton.isEnabled());

		wait.until(ExpectedConditions.visibilityOf(joinButton)).click();

		wait.until(ExpectedConditions.visibilityOf(invalidMeetingPopup));

		// Click on Join meeting button from the welcome screen.
		// us.zoom.videomeetings:id/btnJoinConf
		// ● Assert that Join button will be enabled only after entering min 9 digits
		// meeting ID
		// ● Enter meeting ID: 941 343 070
		// ● Assert the invalid meeting ID pop up.

		System.out.println("Completed Verification");
	}

}
