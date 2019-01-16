package com.inszoom.regration.helper.assertion;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.inszoom.regration.helper.logger.LoggerHelper;

public class AssertionHelper {

	private WebDriver driver;
	private static final Logger oLog = LoggerHelper.getLogger(AssertionHelper.class);

	public AssertionHelper(WebDriver driver) {
		this.driver = driver;
		oLog.debug("AssertionHelper : " + this.driver.hashCode());
	}

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
				
			}

		} catch (Exception e) {

		}
		return flag;

	}
}
