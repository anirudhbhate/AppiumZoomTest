package tests;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ZoomTest extends BaseClass {

	WebDriverWait wait;
	

	@Test
	public void JoinMeeting() throws Exception {
		
		
		final String invalidMeetingCode = "941343070";
		
		WebElement joinMeeting = driver.findElement(By.id("us.zoom.videomeetings:id/btnJoinConf"));
		
		joinMeeting.click();
		
		WebElement joinButton = driver.findElement(By.id("us.zoom.videomeetings:id/btnJoin"));
		
		Assert.assertFalse(joinButton.isEnabled());

		WebElement meetingIDField = driver.findElement(By.id("us.zoom.videomeetings:id/edtConfNumber"));
		
		meetingIDField.sendKeys(invalidMeetingCode);
		
		Assert.assertTrue(joinButton.isEnabled());
		
		joinButton.click();
		
		WebElement invalidMeetingPopup = driver.findElement(By.id("us.zoom.videomeetings:id/txtMsg"));
		
		Assert.assertTrue(invalidMeetingPopup.isDisplayed());

	}

}
