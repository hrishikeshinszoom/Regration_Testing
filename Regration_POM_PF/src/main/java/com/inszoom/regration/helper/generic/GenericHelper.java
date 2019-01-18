package com.inszoom.regration.helper.generic;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.inszoom.regration.helper.logger.LoggerHelper;

public class GenericHelper {

	private WebDriver driver;
	private static final Logger oLog = LoggerHelper.getLogger(GenericHelper.class);

	public GenericHelper(WebDriver driver) {
		this.driver = driver;
		oLog.debug("GenericHelper : " + this.driver.hashCode());
	}

	public String readValueFromElement(WebElement element) {

		if (null == element) {
			oLog.info("webElement is null");
			return null;
		}

		boolean displayed = false;

		try {
			displayed = isDisplayed(element);
		} catch (Exception e) {
			oLog.error(e);
			Reporter.log(e.fillInStackTrace().toString());

			return null;
		}

		if (!displayed) {
			return null;
		}
		String text = element.getText();
		oLog.info("element value is: " + text);
		return text;
	}

	private boolean isDisplayed(WebElement element) {
		try {
			element.isDisplayed();
			oLog.info("element is diaplayed: " + element);
			return true;
		} catch (Exception e) {
			oLog.info(e);
			Reporter.log(e.getStackTrace().toString());
			return false;
		}

	}

	protected boolean isNotDispalyed(WebElement element) {
		try {
			element.isDisplayed();
			oLog.info("element is dispalyed: " + element);
			return false;
		} catch (Exception e) {
			oLog.info(e);
			Reporter.log(e.getStackTrace().toString());
			return true;
		}
	}

	protected String getDisplayText(WebElement element) {
		if (null == element) {
			return null;
		}
		if (!isDisplayed(element)) {
			return null;
		}

		return element.getText();
	}

	public static synchronized String getElementText(WebElement element) {
		if (null == element) {
			oLog.info("Web element is null");
			return null;
		}

		String elementText = null;

		try {

		} catch (Exception e) {
			oLog.info("element not found" + e);
			Reporter.log(e.getStackTrace().toString());
		}

		return elementText;
	}
}
