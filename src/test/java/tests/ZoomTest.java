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
		
		// Setting up test data for meeting code and expected error message
		String invalidMeetingCode = "941343070";
		String expectedText = "Invalid meeting ID. Please check and try again.";
		
		// Find the Join Meeting Button and click it 
		WebElement joinMeeting = driver.findElement(By.id("us.zoom.videomeetings:id/btnJoinConf"));
		joinMeeting.click();
		
		// Find the join button and ensure it is disabled without a meeting code 
		WebElement joinButton = driver.findElement(By.id("us.zoom.videomeetings:id/btnJoin"));
		Assert.assertFalse(joinButton.isEnabled());

		// Add the invalid Meeting code into the code field 
		WebElement meetingIDField = driver.findElement(By.id("us.zoom.videomeetings:id/edtConfNumber"));
		meetingIDField.sendKeys(invalidMeetingCode);
		
		// Ensure the join meeting button is enabled once 9 digits are added and click it
		Assert.assertTrue(joinButton.isEnabled());
		joinButton.click();
		
		// Verify once the invalid meeting popup appears, that the text states that the code is indeed invalid 
		WebElement invalidMeetingPopup = driver.findElement(By.id("us.zoom.videomeetings:id/txtMsg"));
		Assert.assertTrue(invalidMeetingPopup.isDisplayed());
		String popupMsgText = invalidMeetingPopup.getText();
		
		boolean isTextPresent = popupMsgText.contains(expectedText);
		Assert.assertTrue(isTextPresent);

	}

}
