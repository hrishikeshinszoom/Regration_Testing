package com.inszoom.regration.helper.assertion;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.inszoom.regration.helper.logger.LoggerHelper;

public class AssertionHelper {

	private static final Logger oLog = LoggerHelper.getLogger(AssertionHelper.class);

	public synchronized boolean verifyElementPresent(WebElement element) {
		boolean isDisplayed = false;
		try {

			isDisplayed = element.isDisplayed();
			oLog.info(element.getText() + "is displayed");
		} catch (Exception e) {
			oLog.error("element is not found" + e);
		}

		return isDisplayed;
	}

	public synchronized boolean verifyElementNotPresent(WebElement element) {
		boolean isDisplayed = false;
		try {

			element.isDisplayed();
			oLog.info(element.getText() + "is displayed");

		} catch (Exception e) {
			oLog.error("element not found" + e);

			isDisplayed = true;
		}
		return isDisplayed;
	}

	public synchronized boolean verifyTextEquals(WebElement element, String expectedText) {
		boolean flag = false;
		try {

			String actualText = element.getText();
			if (actualText.equals(expectedText)) {
				oLog.info("actual text is: " + actualText + "expected text is :" + expectedText);
				return flag = true;
			} else {
				oLog.error("actual text is: " + actualText + "expected text is: " + expectedText);
				return flag;
			}

		} catch (Exception e) {
			oLog.error("actual text is: " + element.getText() + "expected text is: " + expectedText);
			oLog.info("text is not matching" + e);
			return flag;
		}

	}

	public static void verifyText(String A1, String A2) {
		Assert.assertEquals(A1, A2);
	}

	public static void makeTrue(String message) {
		Assert.assertTrue(true, message);
	}

	public static void makeTrue() {
		Assert.assertTrue(true);
	}

	public static void makeFalse(String message) {
		Assert.assertTrue(false, message);
	}

	public static void makeFalse() {
		Assert.assertTrue(false);
	}
}
