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

	public synchronized boolean verifyElementIfPresent(WebElement element) {
		boolean isDisplayed = false;
		try {

			isDisplayed = element.isDisplayed();
			oLog.info(element.getText() + "is displayed");
		} catch (Exception e) {
			oLog.error("element is not found" + e);
		}

		return isDisplayed;
	}
	
	
}
